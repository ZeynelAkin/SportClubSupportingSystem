package com.example.bz.sportclubsupportingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewAccount extends AppCompatActivity{

    Button Save; //Yeni kayıttaki save butonunu tanımladık.

    EditText name,surname,age,userName,password,password2;
    //RadioButton male,female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);

        allId();

        Save.setOnClickListener(new View.OnClickListener() { //Save butonuna basılınca ıkıncı sayfaya yonlendırecek
            @Override
            public void onClick(View v) {

                MySQLiteClass db = new MySQLiteClass(NewAccount.this); //Bu sınıfta bir veritabanı nesnesi oluşturuldu

                if (password.getText().toString().equals(password2.getText().toString())) {
                    if (name.getText().toString().equals("") || surname.getText().toString().equals("") || age.getText().toString().equals("") || userName.getText().toString().equals("") || password.getText().toString().equals("") || password2.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Please, fill every blank.", Toast.LENGTH_SHORT).show();
                    }
                    else if (db.CompareUN(userName.getText().toString()))//Aynı kullanıcı adı onceden kullanıldıysa
                    {
                        Toast.makeText(getApplicationContext(), "This username was already used. Please try the other one.", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        db.addData(name.getText().toString(), surname.getText().toString(), age.getText().toString(), userName.getText().toString(), password.getText().toString()); //olusturdugumuz nesneyle metodu cagırdık. veritabanına verılerı ekler

                        Intent Saved = new Intent(NewAccount.this, First.class);
                        startActivity(Saved);
                    }
                } else// if(password.getText().toString()!=password2.getText().toString())
                {
                    Toast.makeText(getApplicationContext(), "passwords do not match", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    public void allId()
    {
        /**/name=(EditText)findViewById(R.id.editText3);
        surname=(EditText)findViewById(R.id.editText4);
        age=(EditText)findViewById(R.id.editText10);
        userName=(EditText)findViewById(R.id.editText7);
        password=(EditText)findViewById(R.id.editText8);
        password2=(EditText)findViewById(R.id.editText9);
        //male=(RadioButton)findViewById(R.id.radioButton7);
        //female=(RadioButton)findViewById(R.id.radioButton8);

        Save = (Button) findViewById(R.id.buttonSave); //Save butonunun id sini Save nesnesine atadım
    }
}
