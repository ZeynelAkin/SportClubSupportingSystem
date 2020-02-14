package com.example.bz.sportclubsupportingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Second extends AppCompatActivity {

    Button secondExit,lists; //ikinci sayfa için çıkış butonunu tanımladık
    TextView nameText;

    MySQLiteClass db=new MySQLiteClass(Second.this);

    Intent second;
    String username;
    String password;
    String name;
    Integer accountId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        secondExit=(Button)findViewById(R.id.buttonExit);
        lists=(Button)findViewById(R.id.listId);
        nameText=(TextView) findViewById(R.id.nameText);

        name();

        secondExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Logout1=new Intent(Second.this, First.class);
                startActivity(Logout1);
            }
        });

        lists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accountId =db.Id(username);

                Intent Lists=new Intent(Second.this,ListMembers.class);
                Lists.putExtra("accountId", accountId);
                startActivity(Lists);
            }
        });
    }

    //giriş yapanın ismini textView'a atama
    public void name(){
        second=getIntent();
        username=second.getStringExtra("userName");
        password=second.getStringExtra("password");
        name=db.name(username,password);
        nameText.setText("Hi "+name+",");
    }


  public void OnClickGoTennis(View V)
  {
      Intent Tennis = new Intent(Second.this, com.example.bz.sportclubsupportingsystem.Tennis.class); //Sayfalar arası geçiş nesnesi oluşturuyoruz
      Tennis.putExtra("usernameTennis",username);
      Tennis.putExtra("facilityName","Tennis");
      startActivity(Tennis); //Oluşturduğum Tennis nesnesini aktifleştirdim
    //activity_second sayfasında Tennis textView'una onClick özelliğiyle bu metodu atadık.
  }

  public void OnClickGoFootball(View V)
  {
      Intent Football =new Intent(Second.this, com.example.bz.sportclubsupportingsystem.Football.class);
      startActivity(Football);
  }

  public void OnClickGoVolleyball(View V)
  {
      Intent Volleyball = new Intent(Second.this, com.example.bz.sportclubsupportingsystem.Volleyball.class);
      startActivity(Volleyball);
  }

  public void OnClickGoDancing (View V)
  {
      Intent Dancing=new Intent(Second.this, com.example.bz.sportclubsupportingsystem.Dancing.class);
      startActivity(Dancing);
  }

  public void OnClickGoAerobic (View V)
  {
      Intent Aerobic=new Intent(Second.this,Aerobic.class);
      startActivity(Aerobic);
  }

  public void OnClickGoZumba(View V)
  {
      Intent Zumba=new Intent(Second.this,Zumba.class);
      startActivity(Zumba);
  }

}