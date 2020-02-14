package com.example.bz.sportclubsupportingsystem;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Tennis extends AppCompatActivity {

    TextView title;

    static RadioButton rb1,rb2,rb3,rb4,rb5,rb6,rb7,rb8,rb9,rb10,rb11,rb12,rb13,rb14,rb15,rb16,rb17,rb18,rb19,rb20,rb21,rb22,rb23,rb24,rb25,rb26,rb27,rb28,rb29,rb30;
    static RadioButton[] RButtonD=new RadioButton[30];

   static RadioGroup rg1;
    Button bSave;

    //radıo buttonların secılıp secılmeme durumu. basta hıcbırı secılı degıl
    static boolean bl1=false,bl2=false,bl3=false,bl4=false,bl5=false,bl6=false,bl7=false,bl8=false,bl9=false,bl10=false,bl11=false,bl12=false,bl13=false,bl14=false,bl15=false,bl16=false,bl17=false,bl18=false,bl19=false,bl20=false,bl21=false,bl22=false,bl23=false,bl24=false,bl25=false,bl26=false,bl27=false,bl28=false,bl29=false,bl30=false;
    //static boolean bl1,bl2,b3,bl3,bl4,bl5,bl6,bl7,bl8,bl9,bl10,bl11,bl12,bl13,bl14,bl15,bl16,bl17,bl18,bl19,bl20,bl21,bl22,bl23,bl24,bl25,bl26,bl27,bl28,bl29,bl30;
    static boolean[] blD={bl1,bl2,bl3,bl4,bl5,bl6,bl7,bl8,bl9,bl10,bl11,bl12,bl13,bl14,bl15,bl16,bl17,bl18,bl19,bl20,bl21,bl22,bl23,bl24,bl25,bl26,bl27,bl28,bl29,bl30};

    //basta radıo buttonların hepsı secılebılır
    static boolean bbl1=true,bbl2=true,bbl3=true,bbl4=true,bbl5=true,bbl6=true,bbl7=true,bbl8=true,bbl9=true,bbl10=true,bbl11=true,bbl12=true,bbl13=true,bbl14=true,bbl15=true,bbl16=true,bbl17=true,bbl18=true,bbl19=true,bbl20=true,bbl21=true,bbl22=true,bbl23=true,bbl24=true,bbl25=true,bbl26=true,bbl27=true,bbl28=true,bbl29=true,bbl30=true;
    //static boolean bbl1,bbl2,bb3,bbl3,bbl4,bbl5,bbl6,bbl7,bbl8,bbl9,bbl10,bbl11,bbl12,bbl13,bbl14,bbl15,bbl16,bbl17,bbl18,bbl19,bbl20,bbl21,bbl22,bbl23,bbl24,bbl25,bbl26,bbl27,bbl28,bbl29,bbl30;
    static boolean[] bblD={bbl1,bbl2,bbl3,bbl4,bbl5,bbl6,bbl7,bbl8,bbl9,bbl10,bbl11,bbl12,bbl13,bbl14,bbl15,bbl16,bbl17,bbl18,bbl19,bbl20,bbl21,bbl22,bbl23,bbl24,bbl25,bbl26,bbl27,bbl28,bbl29,bbl30};

    MySQLiteClass mySQLiteClass=new MySQLiteClass(com.example.bz.sportclubsupportingsystem.Tennis.this);

    Intent Tennis;
    String username;
    Integer id; //giriş yapan kullanıcının id si

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tennis);

        all();
        idAl();

        title.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        //RadioButtonlara basılabılır mi? basta hepsı basılabılır,buton ıle degıstırıldıyse uygulama daha sonra acılınca, son durumdan devam edecek
        for(int i = 0; i<RButtonD.length; i++){
                RButtonD[i].setEnabled(bblD[i]);
        }

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //hangi butona basıldı
                for (int i = 0; i < RButtonD.length; i++) {
                    blD[i] = RButtonD[i].isChecked();
                    if (blD[i]) ////radıo butonu ve butonu pasıflestırır
                    {
                        RButtonD[i].setEnabled(false);
                        bSave.setEnabled(false);

                        bblD[i] = false;//sayfaya tekrar gelınce pasıf olanların pasıflerın devam etsın dıye

                        String hour=RButtonD[i].getText().toString();
                        String day=null;

                            if(0<=i && i<6){
                                day="Monday";
                            }else if (i<=6 & i<12){
                                day="Tuesday";
                            }else if (i<=12 & i<18){
                                day="Wednesday";
                            }else if (i<=18 & i<24){
                                day="Thursday";
                            }else if (i<=24 & i<30){
                                day="Friday";
                            }
                        //Veritabanına rezervasyon kaydı
                        mySQLiteClass.fac_res("Tennis",day,hour,i,id);

                        i = 30;
                    }
                }

            }});

    }

    public void idAl(){
        Tennis=getIntent();
        username=Tennis.getStringExtra("usernameTennis");
        id=mySQLiteClass.Id(username);
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

        //butonları dızıye atadık
        RButtonD[0]=rb1;
        RButtonD[1]=rb2;
        RButtonD[2]=rb3;
        RButtonD[3]=rb4;
        RButtonD[4]=rb5;
        RButtonD[5]=rb6;
        RButtonD[6]=rb7;
        RButtonD[7]=rb8;
        RButtonD[8]=rb9;
        RButtonD[9]=rb10;
        RButtonD[10]=rb11;
        RButtonD[11]=rb12;
        RButtonD[12]=rb13;
        RButtonD[13]=rb14;
        RButtonD[14]=rb15;
        RButtonD[15]=rb16;
        RButtonD[16]=rb17;
        RButtonD[17]=rb18;
        RButtonD[18]=rb19;
        RButtonD[19]=rb20;
        RButtonD[20]=rb21;
        RButtonD[21]=rb22;
        RButtonD[22]=rb23;
        RButtonD[23]=rb24;
        RButtonD[24]=rb25;
        RButtonD[25]=rb26;
        RButtonD[26]=rb27;
        RButtonD[27]=rb28;
        RButtonD[28]=rb29;
        RButtonD[29]=rb30;

        rg1=(RadioGroup)findViewById(R.id.radioGroup1);

        bSave=(Button)findViewById(R.id.buttonTennis);

        title=(TextView)findViewById(R.id.tennisTitle);

    }
}