package r.orderapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

import r.orderapplication.dinnerRest.DinnerClient;
import r.orderapplication.dinnerRest.DinnerEntities;
import r.orderapplication.dinnerRest.DinnerEntity;
import r.orderapplication.dinnerRest.DinnerStatusListener;
import r.orderapplication.orderRest.OrderClient;

import static r.orderapplication.Appetizer.fragView;
import static r.orderapplication.Main_course.fragView_MainCourse;


public class TabActivity extends AppCompatActivity implements DinnerStatusListener{


    TextView textView;
    TableLayout tableLayout;
    public TableRow tableRow;
    TableLayout tableLayout_mCourse;

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    Button button;
    OrderClient orderClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        DinnerClient dc = new DinnerClient("http://10.250.110.133:8080/AntonsHemsida/webresources/");
        dc.setStatusListener(this);
        dc.fetchDinnerList();

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new Appetizer(), "Förrätt");
        viewPagerAdapter.addFragments(new Main_course(), "Huvudrätt");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(Color.WHITE, Color.WHITE);
        tabLayout.setSelectedTabIndicatorHeight(10);

        //appetizer.setText("heeeeeej");
        //fragment.setSettings();
        button = (Button) findViewById(R.id.showOrder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TabActivity.this, ShowOrderActivity.class));
            }
        });

    }

    @Override
    public void dinnerListRecived(DinnerEntities de) {
        List<DinnerEntity> dinnerList = de.dinnerEntity;
        System.out.println(dinnerList.size());
        tableLayout = (TableLayout) fragView.findViewById(R.id.tableLay_appetizer);
        DataBaseConverter dbc = new DataBaseConverter(dinnerList);

        /*Hämtar och skapar tabell från Databasen för förrätter*/
        List<DinnerEntity> appetList = dbc.getAppetizerList();
        for (int i = 0; i < appetList.size(); i++) {

            TableRow tableRow = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            tableRow.setLayoutParams(lp);

            TextView appetName = new TextView(this);
            appetName.setText(appetList.get(i).getName().toString());

            TextView appetPrice = new TextView(this);
            appetPrice.setText(appetList.get(i).getPrice().toString());

            tableRow.addView(appetName);
            tableRow.addView(appetPrice);

            tableLayout.addView(tableRow);
        }
        List<DinnerEntity> mainCourseList = dbc.getMainCourseList();
        tableLayout_mCourse = (TableLayout) fragView_MainCourse.findViewById(R.id.tableLay_mainCourse);
        for (int i = 0; i < mainCourseList.size(); i++) {

            TableRow tableRow = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            tableRow.setLayoutParams(lp);

            TextView mainC_Name = new TextView(this);
            mainC_Name.setText(mainCourseList.get(i).getName().toString());

            TextView mainC_Price = new TextView(this);
            mainC_Price.setText(mainCourseList.get(i).getPrice().toString());

            tableRow.addView(mainC_Name);
            tableRow.addView(mainC_Price);

            tableLayout_mCourse.addView(tableRow);
        }
    }

    @Override
    public void dinnerUpdated() {

    }
}