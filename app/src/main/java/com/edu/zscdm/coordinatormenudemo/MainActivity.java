package com.edu.zscdm.coordinatormenudemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView mHeadIv;
    private CoordinatorMenu mCoordinatorMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHeadIv = (ImageView) findViewById(R.id.iv_head);
        mCoordinatorMenu = (CoordinatorMenu) findViewById(R.id.menu);

        mCoordinatorMenu.setMainViewListener(new CoordinatorMenu.MainViewListener() {
            @Override
            public void onMainViewClick() {
                if (mCoordinatorMenu.isOpened()) {
                    mCoordinatorMenu.closeMenu();
                }
            }
        });

        mHeadIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCoordinatorMenu.isOpened()) {
                    mCoordinatorMenu.closeMenu();
                } else {
                    mCoordinatorMenu.openMenu();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mCoordinatorMenu.isOpened()) {
            mCoordinatorMenu.closeMenu();
        } else {
            super.onBackPressed();
        }
    }
}
