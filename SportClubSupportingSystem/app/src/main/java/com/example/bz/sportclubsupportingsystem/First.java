package com.example.bz.sportclubsupportingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class First extends AppCompatActivity {

    Button ToSecond; //butonu ikinci sayfaya yonlendırmek ıcın once nesne olusturduk. bu nesneye id ile butonu atıcaz.
    Button NewAccount; //yeni hesap açmak içi butona nesne olusturduk

    EditText userEDTX;
    EditText pwEDTX;

    String unB="busraozturk";
    String pwB="123B";

    String unZ="zeynelakin";
    String pwZ="123Z";

    MySQLiteClass db=new MySQLiteClass(First.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {  //Program açıldığı gibi onCreate metodu çalışır.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        /**/ToSecond= (Button) findViewById(R.id.button3); //Log In'in id sini ToSecond nesnesine atadık.
        NewAccount=(Button) findViewById(R.id.button4); //Yenı hesap butonunun id sini NewAccount nesnesine atadık.
        userEDTX=(EditText) findViewById(R.id.userName);
        pwEDTX=(EditText)findViewById(R.id.password);

        //Butona basıldıgında çalışacak kodlar. setOnClickListener yapınca xml'de OnClick olusturmadık.
        ToSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((userEDTX.getText().toString().equals(unB)&&pwEDTX.getText().toString().equals(pwB))||(userEDTX.getText().toString().equals(unZ)&&pwEDTX.getText().toString().equals(pwZ)))
                {
                    Intent LogIn= new Intent(First.this, Second.class);
                    startActivity(LogIn);
                }
                else if(db.LogOK(userEDTX.getText().toString(),pwEDTX.getText().toString())){
                    Intent LogIn=new Intent(First.this, Second.class);
                    //EditText'lerin içeriğini de diğer sayfaya yolladık
                    LogIn.putExtra("userName",userEDTX.getText().toString());
                    LogIn.putExtra("password",pwEDTX.getText().toString());
                    startActivity(LogIn);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please,check your password and username.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //NewAccount butonuna basıldıgında yenı hesap olustur sayfasına yonlendırecek.
        NewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CreateAccount= new Intent(First.this, com.example.bz.sportclubsupportingsystem.NewAccount.class);
                startActivity(CreateAccount);
            }
        });
    }



}
