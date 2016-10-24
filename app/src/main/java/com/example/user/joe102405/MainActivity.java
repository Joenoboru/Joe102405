package com.example.user.joe102405;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    CheckBox chk;
    RadioGroup rb;
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //checkbox
        pb =(ProgressBar) findViewById(R.id.progressBar);
        chk = (CheckBox)findViewById(R.id.checkBox);
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("MYLOG", "chk:" + isChecked);
            }
        });
        // chk.isChecked() 可以偵測chk是否有被勾選 有傳true 無傳false

        //radiogroup
        rb = (RadioGroup)findViewById(R.id.radioGroup);
        rb.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButton4)
                {
                    Log.d("MYLOG","Slect 4");
                }
                else if(checkedId == R.id.radioButton5)
                {
                    Log.d("MYLOG","Slect 5");
                }
            }
        });
    }

            //按button顯示3秒鐘的progressbar後 隱藏
            public void click1(View v)
            {
                pb.setVisibility(View.VISIBLE);
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                pb.setVisibility(View.INVISIBLE);
                            }
                        });
                    }
                }.start();

            }
}
