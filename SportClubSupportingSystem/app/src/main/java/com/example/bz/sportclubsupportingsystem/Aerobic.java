package com.example.bz.sportclubsupportingsystem;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Aerobic extends AppCompatActivity {

    TextView title;



    Button btnAerobic;

    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10;

    RadioButton rbMon1,rbMon2,rbTue1,rbTue2,rbWed1,rbWed2,rbThu1,rbThu2,rbFri1,rbFri2;

   static int tvs1=15,tvs2=15,tvs3=15,tvs4=15,tvs5=15,tvs6=15,tvs7=15,tvs8=15,tvs9=15,tvs10=15; //TextViewSet1 anlamında

    boolean blMon1=false,blMon2=false,blTue1=false,blTue2=false,blWed1=false,blWed2=false,blThu1=false,blThu2=false,blFri1=false,blFri2=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aerobic);

        all();

        title.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        tv1.setText("Available Quota : "+tvs1+"/15");
        tv2.setText("Available Quota : "+tvs2+"/15");
        tv3.setText("Available Quota : "+tvs3+"/15");
        tv4.setText("Available Quota : "+tvs4+"/15");
        tv5.setText("Available Quota : "+tvs5+"/15");
        tv6.setText("Available Quota : "+tvs6+"/15");
        tv7.setText("Available Quota : "+tvs7+"/15");
        tv8.setText("Available Quota : "+tvs8+"/15");
        tv9.setText("Available Quota : "+tvs9+"/15");
        tv10.setText("Available Quota : "+tvs10+"/15");

        btnAerobic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                blFri1=rbFri1.isChecked();
                blFri2=rbFri2.isChecked();
                blMon1=rbMon1.isChecked();
                blMon2=rbMon2.isChecked();
                blTue1=rbTue1.isChecked();
                blTue2=rbTue2.isChecked();
                blWed1=rbWed1.isChecked();
                blWed2=rbWed2.isChecked();
                blThu1=rbThu1.isChecked();
                blThu2=rbThu2.isChecked();

                if(blMon1)
                {
                    if(tvs1!=0) {
                        tvs1 = tvs1 - 1;
                        tv1.setText("Available Quota : " + tvs1 + "/15");
                        btnAerobic.setEnabled(false);
                    }else
                    {
                        Toast.makeText(getApplicationContext(),"there is no vacancy", Toast.LENGTH_SHORT).show();
                    }
                    }else if(blMon2)
                {
                    if(tvs2!=0) {
                        tvs2 = tvs2 - 1;
                        tv2.setText("Available Quota : " + tvs2 + "/15");
                        btnAerobic.setEnabled(false);
                    }else
                    {
                        Toast.makeText(getApplicationContext(),"there is no vacancy", Toast.LENGTH_SHORT).show();
                    }
                }else if(blTue1)
                {
                    if(tvs3!=0) {
                        tvs3 = tvs3 - 1;
                        tv3.setText("Available Quota : " + tvs3 + "/15");
                        btnAerobic.setEnabled(false);
                    }else
                    {
                        Toast.makeText(getApplicationContext(),"there is no vacancy", Toast.LENGTH_SHORT).show();
                    }
                }else if(blTue2)
                {
                    if(tvs4!=0) {
                        tvs4 = tvs4 - 1;
                        tv4.setText("Available Quota : " + tvs4 + "/15");
                        btnAerobic.setEnabled(false);
                    }else
                    {
                        Toast.makeText(getApplicationContext(),"there is no vacancy", Toast.LENGTH_SHORT).show();
                    }
                }if(blWed1)
                {
                    if(tvs5!=0) {
                        tvs5 = tvs5 - 1;
                        tv5.setText("Available Quota : " + tvs5 + "/15");
                        btnAerobic.setEnabled(false);
                    }else
                    {
                        Toast.makeText(getApplicationContext(),"there is no vacancy", Toast.LENGTH_SHORT).show();
                    }
                }else if(blWed2)
                {
                    if(tvs6!=0) {
                        tvs6 = tvs6 - 1;
                        tv6.setText("Available Quota : " + tvs6 + "/15");
                        btnAerobic.setEnabled(false);
                    }else
                    {
                        Toast.makeText(getApplicationContext(),"there is no vacancy", Toast.LENGTH_SHORT).show();
                    }
                }if(blThu1)
                {
                    if(tvs7!=0) {
                        tvs7 = tvs7 - 1;
                        tv7.setText("Available Quota : " + tvs7 + "/15");
                        btnAerobic.setEnabled(false);
                    }else
                    {
                        Toast.makeText(getApplicationContext(),"there is no vacancy", Toast.LENGTH_SHORT).show();
                    }
                }else if(blThu2)
                {
                    if(tvs8!=0) {
                        tvs8 = tvs8 - 1;
                        tv8.setText("Available Quota : " + tvs8 + "/15");
                        btnAerobic.setEnabled(false);
                    }else
                    {
                        Toast.makeText(getApplicationContext(),"there is no vacancy", Toast.LENGTH_SHORT).show();
                    }
                }if(blFri1)
                {
                    if(tvs9!=0) {
                        tvs9 = tvs9 - 1;
                        tv9.setText("Available Quota : " + tvs9 + "/15");
                        btnAerobic.setEnabled(false);
                    }else
                    {
                        Toast.makeText(getApplicationContext(),"there is no vacancy", Toast.LENGTH_SHORT).show();
                    }
                }else if(blFri2)
                {
                    if(tvs10!=0) {
                        tvs10 = tvs10 - 1;
                        tv10.setText("Available Quota : " + tvs10 + "/15");
                        btnAerobic.setEnabled(false);

                    }else
                    {
                        Toast.makeText(getApplicationContext(),"there is no vacancy", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }

    public void all()
    {
        title=(TextView)findViewById(R.id.aerobicTitle);

        rbMon1=(RadioButton)findViewById(R.id.rbMon1);
        rbMon2=(RadioButton)findViewById(R.id.rbMon2);
        rbTue1=(RadioButton)findViewById(R.id.rbTue1);
        rbTue2=(RadioButton)findViewById(R.id.rbTue2);
        rbWed1=(RadioButton)findViewById(R.id.rbWed1);
        rbWed2=(RadioButton)findViewById(R.id.rbWed2);
        rbThu1=(RadioButton)findViewById(R.id.rbThu1);
        rbThu2=(RadioButton)findViewById(R.id.rbThu2);
        rbFri1=(RadioButton)findViewById(R.id.rbFri1);
        rbFri2=(RadioButton)findViewById(R.id.rbFri2);

        btnAerobic=(Button)findViewById(R.id.buttonAerobic);

        tv1=(TextView)findViewById(R.id.textView6);
        tv2=(TextView)findViewById(R.id.textView7);
        tv3=(TextView)findViewById(R.id.textView8);
        tv4=(TextView)findViewById(R.id.textView9);
        tv5=(TextView)findViewById(R.id.textView10);
        tv6=(TextView)findViewById(R.id.textView11);
        tv7=(TextView)findViewById(R.id.textView12);
        tv8=(TextView)findViewById(R.id.textView13);
        tv9=(TextView)findViewById(R.id.textView14);
        tv10=(TextView)findViewById(R.id.textView15);
    }
}
