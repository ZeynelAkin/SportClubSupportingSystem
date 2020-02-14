package com.example.bz.sportclubsupportingsystem;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Volleyball extends AppCompatActivity {

    TextView title;
    static RadioButton rb1,rb2,rb3,rb4,rb5,rb6,rb7,rb8,rb9,rb10,rb11,rb12,rb13,rb14,rb15,rb16,rb17,rb18,rb19,rb20,rb21,rb22,rb23,rb24,rb25,rb26,rb27,rb28,rb29,rb30;
    static RadioGroup rg1;
    Button bSave;

    static boolean bl1=false,bl2=false,b3=false,bl3=false,bl4=false,bl5=false,bl6=false,bl7=false,bl8=false,bl9=false,bl10=false,bl11=false,bl12=false,bl13=false,bl14=false,bl15=false,bl16=false,bl17=false,bl18=false,bl19=false,bl20=false,bl21=false,bl22=false,bl23=false,bl24=false,bl25=false,bl26=false,bl27=false,bl28=false,bl29=false,bl30=false;

    static boolean bbl1=true,bbl2=true,bb3=true,bbl3=true,bbl4=true,bbl5=true,bbl6=true,bbl7=true,bbl8=true,bbl9=true,bbl10=true,bbl11=true,bbl12=true,bbl13=true,bbl14=true,bbl15=true,bbl16=true,bbl17=true,bbl18=true,bbl19=true,bbl20=true,bbl21=true,bbl22=true,bbl23=true,bbl24=true,bbl25=true,bbl26=true,bbl27=true,bbl28=true,bbl29=true,bbl30=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volleyball);
        
        all();

        title.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        rb1.setEnabled(bbl1);
        rb2.setEnabled(bbl2);
        rb3.setEnabled(bbl3);
        rb4.setEnabled(bbl4);
        rb5.setEnabled(bbl5);
        rb6.setEnabled(bbl6);
        rb7.setEnabled(bbl7);
        rb8.setEnabled(bbl8);
        rb9.setEnabled(bbl9);
        rb10.setEnabled(bbl10);
        rb11.setEnabled(bbl11);
        rb12.setEnabled(bbl12);
        rb13.setEnabled(bbl13);
        rb14.setEnabled(bbl14);
        rb15.setEnabled(bbl15);
        rb16.setEnabled(bbl16);
        rb17.setEnabled(bbl17);
        rb18.setEnabled(bbl18);
        rb19.setEnabled(bbl19);
        rb20.setEnabled(bbl20);
        rb21.setEnabled(bbl21);
        rb22.setEnabled(bbl22);
        rb23.setEnabled(bbl23);
        rb24.setEnabled(bbl24);
        rb25.setEnabled(bbl25);
        rb26.setEnabled(bbl26);
        rb27.setEnabled(bbl27);
        rb28.setEnabled(bbl28);
        rb29.setEnabled(bbl29);
        rb30.setEnabled(bbl30);


        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bl1=rb1.isChecked();
                bl2=rb2.isChecked();
                bl3=rb3.isChecked();
                bl4=rb4.isChecked();
                bl5=rb5.isChecked();
                bl6=rb6.isChecked();
                bl7=rb7.isChecked();
                bl8=rb8.isChecked();
                bl9=rb9.isChecked();
                bl10=rb10.isChecked();
                bl11=rb11.isChecked();
                bl12=rb12.isChecked();
                bl13=rb13.isChecked();
                bl14=rb14.isChecked();
                bl15=rb15.isChecked();
                bl16=rb16.isChecked();
                bl17=rb17.isChecked();
                bl18=rb18.isChecked();
                bl19=rb19.isChecked();
                bl20=rb20.isChecked();
                bl21=rb21.isChecked();
                bl22=rb22.isChecked();
                bl23=rb23.isChecked();
                bl24=rb24.isChecked();
                bl25=rb25.isChecked();
                bl26=rb26.isChecked();
                bl27=rb27.isChecked();
                bl28=rb28.isChecked();
                bl29=rb29.isChecked();
                bl30=rb30.isChecked();

                if(bl1)
                {
                    rb1.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl1=false;
                }else if(bl2)
                {
                    rb2.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl2=false;
                }else if(bl3)
                {
                    rb3.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl3=false;
                }else if(bl4)
                {
                    rb4.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl4=false;
                }else if(bl5)
                {
                    rb5.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl5=false;
                }else if(bl6)
                {
                    rb6.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl6=false;
                }else if(bl7)
                {
                    rb7.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl7=false;
                }else if(bl8)
                {
                    rb8.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl8=false;
                }else if(bl9)
                {
                    rb9.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl9=false;
                }else if(bl10)
                {
                    rb10.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl10=false;
                }else if(bl11)
                {
                    rb11.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl11=false;
                }else if(bl12)
                {
                    rb12.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl12=false;
                }else if(bl13)
                {
                    rb13.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl13=false;
                }else if(bl14)
                {
                    rb14.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl14=false;
                }else if(bl15)
                {
                    rb15.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl15=false;
                }else if(bl16)
                {
                    rb16.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl16=false;
                }else if(bl17)
                {
                    rb17.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl17=false;
                }else if(bl18)
                {
                    rb18.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl18=false;
                }else if(bl19)
                {
                    rb19.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl19=false;
                }else if(bl20)
                {
                    rb20.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl20=false;
                }else if(bl21)
                {
                    rb21.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl21=false;
                }else if(bl22)
                {
                    rb23.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl23=false;
                }else if(bl24)
                {
                    rb24.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl24=false;
                }else if(bl25)
                {
                    rb25.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl25=false;
                }else if(bl26)
                {
                    rb26.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl26=false;
                }else if(bl27)
                {
                    rb27.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl27=false;
                }else if(bl28)
                {
                    rb28.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl28=false;
                }else if(bl29)
                {
                    rb29.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl29=false;
                }else if(bl30)
                {
                    rb30.setEnabled(false);
                    bSave.setEnabled(false);

                    bbl30=false;
                }
            }
        });

    }

    
    public void all()
    {
        rb1=(RadioButton)findViewById(R.id.radioButton1);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        rb5=(RadioButton)findViewById(R.id.radioButton5);
        rb6=(RadioButton)findViewById(R.id.radioButton6);
        rb7=(RadioButton)findViewById(R.id.radioButton7);
        rb8=(RadioButton)findViewById(R.id.radioButton8);
        rb9=(RadioButton)findViewById(R.id.radioButton9);
        rb10=(RadioButton)findViewById(R.id.radioButton10);
        rb11=(RadioButton)findViewById(R.id.radioButton11);
        rb12=(RadioButton)findViewById(R.id.radioButton12);
        rb13=(RadioButton)findViewById(R.id.radioButton13);
        rb14=(RadioButton)findViewById(R.id.radioButton14);
        rb15=(RadioButton)findViewById(R.id.radioButton15);
        rb16=(RadioButton)findViewById(R.id.radioButton16);
        rb17=(RadioButton)findViewById(R.id.radioButton17);
        rb18=(RadioButton)findViewById(R.id.radioButton18);
        rb19=(RadioButton)findViewById(R.id.radioButton19);
        rb20=(RadioButton)findViewById(R.id.radioButton20);
        rb21=(RadioButton)findViewById(R.id.radioButton21);
        rb22=(RadioButton)findViewById(R.id.radioButton22);
        rb23=(RadioButton)findViewById(R.id.radioButton23);
        rb24=(RadioButton)findViewById(R.id.radioButton24);
        rb25=(RadioButton)findViewById(R.id.radioButton25);
        rb26=(RadioButton)findViewById(R.id.radioButton26);
        rb27=(RadioButton)findViewById(R.id.radioButton27);
        rb28=(RadioButton)findViewById(R.id.radioButton28);
        rb29=(RadioButton)findViewById(R.id.radioButton29);
        rb30=(RadioButton)findViewById(R.id.radioButton30);
        
        rg1=(RadioGroup)findViewById(R.id.radioGroup1);

        bSave=(Button)findViewById(R.id.buttonVolleyball);

        title=(TextView)findViewById(R.id.volleyballTitle);
        
    }
    
}
