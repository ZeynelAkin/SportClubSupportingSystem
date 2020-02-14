package com.example.bz.sportclubsupportingsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bz on 10.06.2018.
 */

public class MySQLiteClass extends SQLiteOpenHelper {

    private static final int database_VERSION = 1;
    private static final String database_NAME = "SportClubDatabase";
    //Table names
    private static final String table_NewAccount = "NewAccount";
    private static final String table_Facility = "Facility";
    //NewAccount table's column
    private static final String account_NAME = "name";
    private static final String account_SURNAME = "surname";
    private static final String account_AGE = "age";
    private static final String account_USERNAME = "userName";
    private static final String account_PASSWORD = "password";
    private static final String account_id = "id";
    //Facility table's column
    private static final String fac_fk = "id";
    private static final String fac_id = "fac_id";
    private static final String fac_name = "nameF";
    private static final String fac_days = "days";
    private static final String fac_hours = "hours";
    private static final String fac_index = "indx";

    private static final String CREATE_NewAccount_TABLE = "CREATE TABLE IF NOT EXISTS "
            + table_NewAccount+ " ("
            + account_NAME+ " TEXT NOT NULL, "
            + account_SURNAME+ " INTEGER NOT NULL, "
            + account_AGE+ " INTEGER NOT NULL, "
            + account_USERNAME+ " INTEGER NOT NULL, "
            + account_PASSWORD+ " INTEGER NOT NULL, "
            + account_id+ " INTEGER PRIMARY KEY AUTOINCREMENT )";


    private static final String CREATE_Facility_TABLE = "CREATE TABLE IF NOT EXISTS "
            + table_Facility+ " ("
            + fac_id+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + fac_name+ " TEXT, "
            + fac_days+ " TEXT, "
            + fac_hours+ " TEXT, "
            + fac_index+ " INTEGER, "
            + fac_fk+ " INTEGER NOT NULL)";

    public MySQLiteClass(Context context) //sadece context bilgisini gircez, diğer değerleri o bize döncek
    {
        super(context, database_NAME, null, database_VERSION);
        //super(context, new File(Environment.getExternalStorageDirectory(),database_NAME).toString(),null, database_VERSION); //sd kartı hafıza olarak kullanmak ıstıyorsak
        //super(context,String.valueOf(context.getDatabasePath(database_NAME)) , null, database_VERSION); //ınternel hafızayı kullanmak ıstıyorsak telefonda

    }

    @Override
    public void onCreate(SQLiteDatabase db) //veritabanı açıldıgında cagrılan ılk metot. Burada genellıkle tablo olusturma ıslemlerını yapıyoruz.
    {
        String CREATE_NewAccount_TABLE_=CREATE_NewAccount_TABLE;
        db.execSQL(CREATE_NewAccount_TABLE_);
        String CREATE_Facility_TABLE_=CREATE_Facility_TABLE;
        db.execSQL(CREATE_Facility_TABLE_);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) //Buraya herhangı bır sey yapılmadıgında uyguama acılıp kapatıldıgında ıcınde verıler aynı sekılde kalır. Genelde güncelleme oldugunda buranın calıstırılması ıstenır.
    // Aşagıdakı kodlar aracılıgıyla, tabloyu sılıyor ve tekrar onCreate metoduna gıderek tabloyu tekrar olusturuyor.
            //onUpgrade metodunun calısıp calısmamasına Version'un 1 (yukarıda atandı) olup olmamasıyla karar verılır.
    {
        //db.execSQL("DROP TABLE IF EXISTS "+table_NewAccount);// Eger tablo (table_NewAccount tablosu) varsa sil.
        //db.execSQL("DROP TABLE IF EXISTS "+table_Facility);
        //this.onCreate(db); //tekrar onCreate metoduna gidiyoruz.
        super.onDowngrade(db,oldVersion,newVersion);

    }

    public void addData(String name, String surname, String age, String username, String password) //Add Data Codes. NewAccount tan nesne olusturduk,buraya atamak ıcın
    {
        //Veri eklemek için bunu acmamız gerekıyor. Tablomuzun yapısında degısıklık yapacagız. (eger bılgılerı getırmek ıstersek okuma modunda acıyoruz.)
        SQLiteDatabase dbEkle= this.getWritableDatabase();
        //ekleme,silme ve güncelleme işlemlerı ıcın ContentValues sınıfını kullanmamız gerekıyor.
        ContentValues degerler=new ContentValues();

        //kaç tane alanımız varsa aynı ıslemı uyguluyoruz
        degerler.put(account_NAME,name.trim());
        degerler.put(account_SURNAME,surname.trim());
        degerler.put(account_AGE,age.trim());
        degerler.put(account_USERNAME,username.trim());
        degerler.put(account_PASSWORD,password.trim());

        //verılerı eklıyoruz
        dbEkle.insert(table_NewAccount,null,degerler);

        //ekleme işlemımız bıttı. database'ımızı kapatıyoruz
        dbEkle.close();
    }

    //Facility rezervasyon ekleme
    public void fac_res(String name, String day, String hour, Integer index, Integer fk){
        SQLiteDatabase dbEkle=this.getWritableDatabase();
        ContentValues degerler=new ContentValues();

        degerler.put(fac_name,name.trim());
        degerler.put(fac_days,day.trim());
        degerler.put(fac_hours,hour.trim());
        degerler.put(fac_index,index);
        degerler.put(fac_fk,fk);

        dbEkle.insert(table_Facility,null,degerler);
        dbEkle.close();
    }

    //Tüm kayıtları satır satır ListView'a ekler
    public List<String> ListMember()
    {
        List<String> members = new ArrayList<String>();

        SQLiteDatabase db=this.getWritableDatabase();
        String[] columns={account_id,account_NAME,account_SURNAME,account_AGE,account_USERNAME,account_PASSWORD};
        Cursor cursor=db.query(table_NewAccount,columns,null,null,null,null,null);

        while (cursor.moveToNext())//cursor will go to next row
        {
            members.add(cursor.getInt(0) + " - " + cursor.getString(1) + " - " + cursor.getString(2) + " - " + cursor.getInt(3) + " - " + cursor.getString(4) + " - " + cursor.getInt(5)); //sayılar, tabloyu olustururkenkı alan indeksleri. verilerimizi alıp list'imize aktardık (listView a degıl henuz).
        }

        return members;
    }

    public List<String> ListReservation(Integer AccId){
        List<String> reservations=new ArrayList<String>();

        SQLiteDatabase sdb=this.getWritableDatabase();
        String[] colums={fac_id,fac_name,fac_days,fac_hours,fac_index,fac_fk};

        //String query="SELECT * FROM "+table_Facility;
        //String query="Select "+table_NewAccount+"."+account_id+","+table_NewAccount+"."+account_USERNAME+","+table_Facility+"."+fac_name+" FROM "+table_NewAccount+","+table_Facility+" WHERE "+table_Facility+"."+fac_fk+"=?";
        String query="SELECT "+table_NewAccount+"."+account_id+", "+account_USERNAME+", "+fac_name+" FROM "+table_NewAccount+" INNER JOIN "+table_Facility+" ON "+table_Facility+"."+fac_fk+"="+AccId;
        //"SELECT tblWorkers.SomeFieldYouWant, tblWorkers.SomeOtherFieldYouWant, ... , tblTitles.Title FROM tblWorkers LEFT JOIN tblTitles ON tblWorkers.TitleID = tblTitles.id");

        //Cursor cursor=sdb.query(table_NewAccount, new String[]{"NewAccount.id", "NewAccount.userName", "Facility.name"},"id", new String[]{fac_fk.toString()},null,null,null);
        Cursor cursor= sdb.rawQuery(query,null);

        while (cursor.moveToNext()){
            reservations.add(cursor.getInt(0)+" - "+cursor.getString(1)+" - "+cursor.getString(2)+" - "+cursor.getString(3)+" - "+cursor.getInt(4)+" - "+cursor.getInt(5));
        }

        return  reservations;
    }
    //****************************************************
    //****************************************************

    //kayıtta girilen username veri tabanında onceden kayıtlı mıydı
    public boolean CompareUN(String userName){
        boolean used;

        SQLiteDatabase sdb=this.getReadableDatabase();
        Cursor cursor=sdb.rawQuery("Select userName from NewAccount where userName=?",new String[]{userName});
        if (cursor.getCount()==1)
        {
            used=true;
        }
        else
            used=false;

        return used;
    }

    //giriş yapılabılmesı ıcın üyelik olup olmadıgı kontrol edılıyor
    public boolean LogOK(String userName, String password){
        boolean ok;

        SQLiteDatabase sdb=this.getReadableDatabase();
        Cursor cursor=sdb.rawQuery("Select "+account_USERNAME+","+account_PASSWORD+" from "+table_NewAccount+" where "+account_USERNAME+" =? and "+account_PASSWORD+"=?",new String[]{userName,password});
        if (cursor.getCount()==1)
        {
            ok=true;
        }else
            ok=false;

        return ok;
    }

    //Giris yapanın ismini çekme
    public String name(String userName, String password){
        Cursor cursor=null;
        String name="";
        try {
            String query="Select "+account_NAME+" from "+table_NewAccount+" where "+account_USERNAME+" = '"+userName+"' and "+account_PASSWORD+"= '"+password+"'";
            SQLiteDatabase sdb=this.getReadableDatabase();

            cursor=sdb.rawQuery(query,null);
            if(cursor.getCount()==1){
                cursor.moveToFirst();
                name=cursor.getString(cursor.getColumnIndex(account_NAME));
            }
            return name;
        }finally {
            cursor.close();
        }
    }
    //Giris yapanın id sini cekme
    public Integer Id(String userName){
        Cursor cursor=null;
        Integer id=null;
        try {
            String query="Select "+account_id+" from "+table_NewAccount+" where "+account_USERNAME+" = '"+userName+"'";
            SQLiteDatabase sdb=this.getReadableDatabase();

            cursor=sdb.rawQuery(query,null);
            if(cursor.getCount()==1){
                cursor.moveToFirst();
                id=cursor.getInt(cursor.getColumnIndex(account_id));
            }
            return id;
        }finally {
            cursor.close();
        }
    }

    public void deleteData(long id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        //Datas will delete according to id number.
        db.delete(table_NewAccount,account_id + "=" + id,null);
        db.close();
    }

    /*public List<String> ListMember1() //ListView Codes
    {
        List<String> members = new ArrayList<String>();

        SQLiteDatabase db=this.getWritableDatabase();
        String[] columns={account_USERNAME};
        Cursor cursor=db.query(table_NewAccount,columns,null,null,null,null,null);

        while (cursor.moveToNext())//cursor will go to next row
        {
            members.add(cursor.getInt(0) + " - " + cursor.getString(1) + " - " + cursor.getString(2) + " - " + cursor.getInt(3) + " - " + cursor.getString(4) + " - " + cursor.getInt(5)); //sayılar, tabloyu olustururkenkı alan indeksleri. verilerimizi alıp list'imize aktardık (listView a degıl henuz).
        }

        return members;
    }*/

}
