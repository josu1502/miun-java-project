package r.orderapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import r.orderapplication.dinnerRest.DinnerClient;
import r.orderapplication.dinnerRest.DinnerEntities;
import r.orderapplication.dinnerRest.DinnerEntity;
import r.orderapplication.dinnerRest.DinnerStatusListener;
import r.orderapplication.orderRest.OrderEntity;

import static r.orderapplication.Appetizer.fragView;
import static r.orderapplication.Main_course.fragView_MainCourse;


public class TabActivity extends AppCompatActivity implements DinnerStatusListener{

    public static List<TextView> listAppetAmount = new ArrayList<>();
    public static List<TextView> listMaincAmount = new ArrayList<>();
    TextView textView;
    TableLayout tableLayout;
    public TableRow tableRow;
    TableLayout tableLayout_mCourse;

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    Button button;
    public static DinnerClient dc;
    public static DataBaseConverter dbc;
    private Toolbar tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
<<<<<<< HEAD
        dc = new DinnerClient("http://10.250.118.155:8080/AntonsHemsida/webresources/");
=======
        tb = (Toolbar)findViewById(R.id.toolBar);
        dc = new DinnerClient("http://10.250.121.121:8080/AntonsHemsida/webresources/");
>>>>>>> e02b988f4ab9ab9e5e072d4fb81c43cb10cf2b88
        dc.setStatusListener(this);
        dc.fetchDinnerList();

        tb = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(tb);

        if(tb != null){
            setSupportActionBar(tb);
            tb.setLogo(R.mipmap.ic_launcher);
        }

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new Appetizer(), "Förrätt");
        viewPagerAdapter.addFragments(new Main_course(), "Varmrätt");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(Color.WHITE, Color.WHITE);
        tabLayout.setSelectedTabIndicatorHeight(10);
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);

        //appetizer.setText("heeeeeej");
        //fragment.setSettings();
        button = (Button) findViewById(R.id.showOrder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TabActivity.this, ShowOrderActivity.class));
            }
        });
     onKeyDown(0,null);
    }

   public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            startActivity(new Intent(TabActivity.this, MainActivity.class));
            System.exit(0);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void dinnerListRecived(DinnerEntities de) {
        List<DinnerEntity> dinnerList = de.dinnerEntity;
        System.out.println(dinnerList.size());
        tableLayout = (TableLayout) fragView.findViewById(R.id.tableLay_appetizer);
        dbc = new DataBaseConverter(dinnerList);

        /*Hämtar och skapar tabell från Databasen för förrätter*/
        List<DinnerEntity> appetList = dbc.getAppetizerList();
        List<OrderEntity> appetOrderList = dbc.getOrderAppetList();
        for (int i = 0; i < appetList.size(); i++) {

            TableRow tableRow = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            tableRow.setLayoutParams(lp);

            final TextView appetName = new TextView(this);
            appetName.setText(appetList.get(i).getName().toString());
            appetName.setTextSize(18);

            TextView appetPrice = new TextView(this);
            appetPrice.setText(appetList.get(i).getPrice().toString() + ":-");
            appetPrice.setTextSize(18);

            tableRow.addView(appetName);
            tableRow.addView(appetPrice);

            ImageButton btnMinus = new ImageButton(this);
            btnMinus.setImageResource(R.mipmap.asremove);
            tableRow.addView(btnMinus);
            btnMinus.getBackground().setAlpha(0);
            //btnMinus.setTextColor(Color.RED);
            //btnMinus.setTextSize(32);

            TextView count = new TextView(this);
            count.setText(appetOrderList.get(i).getAmount().toString());
            listAppetAmount.add(count);
            tableRow.addView(count);
            count.setTextSize(18);
            //count.setGravity(Gravity.CENTER);

            DecreaseAppetAmount doa = new DecreaseAppetAmount(appetOrderList.get(i), i);
            btnMinus.setOnClickListener(doa);

            ImageButton btnPlus = new ImageButton(this);
            btnPlus.setImageResource(R.mipmap.asadd);
            IncreaseAppetAmount ioa = new IncreaseAppetAmount(appetOrderList.get(i),i);
            btnPlus.setOnClickListener(ioa);
            tableRow.addView(btnPlus);
            btnPlus.getBackground().setAlpha(0);
            tableRow.setGravity(Gravity.CENTER);

            tableLayout.addView(tableRow);
        }
        List<DinnerEntity> mainCourseList = dbc.getMainCourseList();
        List<OrderEntity> mainC_Orderlist = dbc.getOrderMainList();
        tableLayout_mCourse = (TableLayout) fragView_MainCourse.findViewById(R.id.tableLay_mainCourse);
        for (int i = 0; i < mainCourseList.size(); i++) {

            TableRow tableRow = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            tableRow.setLayoutParams(lp);

            TextView mainC_Name = new TextView(this);
            mainC_Name.setText(mainCourseList.get(i).getName().toString());
            mainC_Name.setTextSize(18);

            TextView mainC_Price = new TextView(this);
            mainC_Price.setText(mainCourseList.get(i).getPrice().toString() + ":-");
            mainC_Price.setTextSize(18);

            tableRow.addView(mainC_Name);
            tableRow.addView(mainC_Price);

            ImageButton btnMinus = new ImageButton(this);
            btnMinus.setImageResource(R.mipmap.asremove);
            DecreaseMainAmount dma = new DecreaseMainAmount(mainC_Orderlist.get(i), i);
            btnMinus.setOnClickListener(dma);
            tableRow.addView(btnMinus);
            btnMinus.getBackground().setAlpha(0);

            TextView count = new TextView(this);
            count.setText(mainC_Orderlist.get(i).getAmount().toString());
            listMaincAmount.add(count);
            tableRow.addView(count);
            count.setTextSize(18);
            count.setGravity(Gravity.CENTER);

            ImageButton btnPlus = new ImageButton(this);
            btnPlus.setImageResource(R.mipmap.asadd);
            IncreaseMainAmount ima = new IncreaseMainAmount(mainC_Orderlist.get(i), i);
            btnPlus.setOnClickListener(ima);

            tableRow.addView(btnPlus);
            btnPlus.getBackground().setAlpha(0);
            tableRow.setGravity(Gravity.CENTER);

            tableLayout_mCourse.addView(tableRow);
        }
    }

    @Override
    public void dinnerUpdated() {

    }

    private class DecreaseAppetAmount implements View.OnClickListener {
        private OrderEntity orderEntity;
        private Integer textViewPosition;
        public DecreaseAppetAmount(OrderEntity oe, Integer index) {
            this.orderEntity = oe;
            this.textViewPosition = index;
        }

        @Override
        public void onClick(View view) {
            if(orderEntity.getAmount() > 0)
            {
                orderEntity.setAmount(orderEntity.getAmount() - 1);
                listAppetAmount.get(textViewPosition).setText(orderEntity.getAmount().toString());
            }
        }
    }

    private class IncreaseAppetAmount implements View.OnClickListener{

        private OrderEntity orderEntity;
        private Integer textViewPosition;
        public IncreaseAppetAmount(OrderEntity oe, Integer index){this.orderEntity = oe; this.textViewPosition = index;}

        @Override
        public void onClick(View view) {
            if(orderEntity.getAmount() >= 0){

                orderEntity.setAmount(orderEntity.getAmount() + 1);
                listAppetAmount.get(textViewPosition).setText(orderEntity.getAmount().toString());
            }
        }
    }

    private class DecreaseMainAmount implements View.OnClickListener {
        private OrderEntity orderEntity;
        private Integer textViewPosition;
        public DecreaseMainAmount(OrderEntity oe, int index) {
                this.orderEntity = oe;
                this.textViewPosition = index;
            }
            @Override
            public void onClick(View view) {
                if(orderEntity.getAmount() > 0)
                {
                    orderEntity.setAmount(orderEntity.getAmount() - 1);
                    listMaincAmount.get(textViewPosition).setText(orderEntity.getAmount().toString());

                }
            }
        }

    private class IncreaseMainAmount implements View.OnClickListener {
        private OrderEntity orderEntity;
        private Integer textViewPosition;
        public IncreaseMainAmount(OrderEntity oe, int index) {
            this.orderEntity = oe;
            this.textViewPosition = index;
        }
        @Override
        public void onClick(View view) {
            if(orderEntity.getAmount() >= 0)
            {
                orderEntity.setAmount(orderEntity.getAmount() + 1);
                listMaincAmount.get(textViewPosition).setText(orderEntity.getAmount().toString());

            }
        }
    }
}