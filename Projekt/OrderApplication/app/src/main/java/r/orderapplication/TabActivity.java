package r.orderapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import r.orderapplication.orderRest.OrderClient;
import r.orderapplication.orderRest.OrderEntities;
import r.orderapplication.orderRest.OrderStatusListener;

public class TabActivity extends AppCompatActivity {

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

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new Appetizer(), "Förrätt");
        viewPagerAdapter.addFragments(new Main_course(), "Huvudrätt");
        viewPagerAdapter.addFragments(new Dessert(), "Efterrätt");
        viewPagerAdapter.addFragments(new Order(), "Ordrar");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(Color.WHITE, Color.WHITE);

        //appetizer.setText("heeeeeej");
        //fragment.setSettings();
        button = (Button)findViewById(R.id.showOrder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TabActivity.this, ShowOrderActivity.class));
            }
        });
    }
}
