package in.co.ecil.hisaab_admin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Rishav
 * on 17/7/17.
 */

public class HisaabActivity extends AppCompatActivity implements View.OnClickListener
{
    private Handler mHandler;
    private LinearLayout naveen,sandeep,saurabh,rishav;
    private HisaabController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mHandler = new Handler();
        naveen = (LinearLayout) findViewById(R.id.naveen);
        sandeep = (LinearLayout) findViewById(R.id.sandeep);
        saurabh = (LinearLayout) findViewById(R.id.saurabh);
        rishav = (LinearLayout) findViewById(R.id.rishav);

        naveen.setOnClickListener(this);
        sandeep.setOnClickListener(this);
        saurabh.setOnClickListener(this);
        rishav.setOnClickListener(this);

        controller = HisaabController.instance();

    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.naveen:
                HisaabController.instance().setCurrentroommateByIndex(IndexOf.Naveen);
                break;

            case R.id.sandeep:
                HisaabController.instance().setCurrentroommateByIndex(IndexOf.Sandeep);
                break;

            case R.id.saurabh:
                HisaabController.instance().setCurrentroommateByIndex(IndexOf.Saurabh);
                break;

            case R.id.rishav:
                HisaabController.instance().setCurrentroommateByIndex(IndexOf.Rishav);
                break;
        }
        mHandler.post(new Runnable()
        {
            @Override
            public void run()
            {
                startActivity(new Intent().setClass(HisaabActivity.this, AddBill.class).setData(getIntent().getData()));
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });

    }
}
