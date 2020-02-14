package com.example.bz.sportclubsupportingsystem;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListMembers extends AppCompatActivity {

    ListView membersList;
    ListView reservationList;

    Intent listIntent;
    Integer accountId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_members);

        allId();

       MySQLiteClass db=new MySQLiteClass(ListMembers.this);
       /*  List<String> mMembers= db.ListMember();
        registerForContextMenu(membersList);//uzun bastığında satırı sececek
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(ListMembers.this, android.R.layout.simple_list_item_1,android.R.id.text1,mMembers); //Listeyi adapter'a attık
        membersList.setAdapter(adapter); //ListView a verileri yukledık*/

        /*listIntent=getIntent();
        accountId=listIntent.getIntExtra("accountId",0);*/
        List<String> reservations=db.ListReservation(accountId); //Listeye eklendı
        //List<String> reservations=db.ListReservation(); //Listeye eklendı
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(ListMembers.this, android.R.layout.simple_list_item_1,android.R.id.text1,reservations); //Listeyi adapter'a attık
        reservationList.setAdapter(adapter2);//ListView'a verileri yukledık

        membersList.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
            {
                if(v.getId() == R.id.memberListId)
                {
                    AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                    menu.setHeaderTitle(membersList.getItemAtPosition(info.position).toString()); //headerımızı secıcı metnın kendı metnı olarak ayarladık
                    menu.add(0, 0, 0, "Delete");//bızım ıcın ıkıncı 0 onemlı. 0 dan baslaması anlamına gelıyor
                    menu.add(0, 1, 0, "Edit");
                }
            }

        });


       /* reservationList.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                if(v.getId()==R.id.resListId){

                }
            }
        });*/


    }



    //ListView dan (aynı zamanda verıtabanından) silme işlemi
    public boolean onContextItemSelected(MenuItem item)
    {
        boolean donus;
        switch(item.getItemId())
        {
            case 0:
                AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
                final String selected=membersList.getItemAtPosition(info.position).toString();
                AlertDialog.Builder builder= new AlertDialog.Builder(this);
                builder.setTitle("Delete Data");
                builder.setMessage("\"" + selected + "\" Are you sure you want to delete this member?");

                builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        String[] array=selected.split("-");
                        long id= Long.parseLong(array[0].trim());
                        MySQLiteClass db=new MySQLiteClass(ListMembers.this);
                        db.deleteData(id);
                        //db.ListMember();
                    }
                });

                builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {

                    }
                });

                AlertDialog dialog=builder.create();
                dialog.show();
                donus=true;
                break;

                default:
                    donus=false;
                    break;
        }
        return donus;
    }

    public void allId()
    {
        /**/membersList=(ListView) findViewById(R.id.memberListId);
        reservationList=(ListView) findViewById(R.id.resListId);
    }
}
