package id.sch.bdg.smkn4.pwpb.biodataapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "DataBiodata";
    private static final String TABLE_NAME = "tbl_user";
    private static final String KEY_NO = "num";
    private static final String KEY_NAME = "name";
    private static final String KEY_DATEBIRTH = "date";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_ADDRESS = "adress";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTable = "Create Table " + TABLE_NAME + " (" + KEY_NO + " INTEGER PRIMARY KEY, "
                + KEY_NAME + " TEXT, " + KEY_DATEBIRTH + " TEXT, " + KEY_GENDER + " TEXT, " + KEY_ADDRESS + " TEXT" + ")";
        db.execSQL(createUserTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = ("drop table if exists " + TABLE_NAME);
        db.execSQL(sql);
        onCreate(db);
    }

    public void insert(Student student){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NO, student.getNo());
        values.put(KEY_NAME, student.getName());
        values.put(KEY_DATEBIRTH, student.getTgl_lahir());
        String gender = "none";
        values.put(KEY_GENDER, student.getJenkel());
        values.put(KEY_ADDRESS, student.getAlamat());
        db.insert(TABLE_NAME,null,values);
    }

    public List<Student> selectUserData(){
        ArrayList<Student> userList = new ArrayList<Student>();
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {KEY_NO,KEY_NAME,KEY_DATEBIRTH,KEY_GENDER,KEY_ADDRESS};
        Cursor c = db.query(TABLE_NAME,columns,null,null,null,null,null);
        while (c.moveToNext()){
            int no = c.getInt(0);
            String name = c.getString(1);
            String date = c.getString(2);
            String gender = c.getString(3);
            String jenkel = "none";
            if (gender.equals("L") || gender.equals("l")) {
                jenkel = "Laki - Laki";
            } else if (gender.equals("P") || gender.equals("p")) {
                jenkel = "Perempuan";
            }
            String address = c.getString(4);
            Student student = new Student();
            student.setNo(no);
            student.setName(name);
            student.setTgl_lahir(date);
            student.setJenkel(jenkel);
            student.setAlamat(address);
            userList.add(student);
        }
        return userList;
    }

    public void delete(String name){
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = KEY_NAME + "='" + name + "'";
        db.delete(TABLE_NAME, whereClause,null);
    }

    public void update(Student student){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, student.getName());
        values.put(KEY_DATEBIRTH, student.getTgl_lahir());
        String gender = "none";
        if (student.getJenkel().equals("Laki - Laki")) {
            gender = "L";
        } else if (student.getJenkel().equals("Perempuan")) {
            gender = "P";
        }
        values.put(KEY_GENDER, gender);
        values.put(KEY_ADDRESS, student.getAlamat());
        String whereClause = KEY_NO + "='" + student.getNo() + "'";
        db.update(TABLE_NAME, values, whereClause,null);
    }
}
