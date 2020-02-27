package cn.zhoujianfeng.baidumap;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class Users {

    private static MySql mySql;

    public Users(Context context){
        mySql = new MySql(context);
    }

    public List<User> query(String name){
        SQLiteDatabase db = mySql.getWritableDatabase();
        Cursor cursor = null;
        List<User> list = new ArrayList<User>();
        if(name.isEmpty()){
            cursor = db.query("user",null,null,null,null,null,null);
        }else {
            cursor = db.query("user",null,"name=?",new String[]{name},null,null,null);
        }
        while(cursor.moveToNext()){
            name = cursor.getString(1);
            String tell = cursor.getString(2);
            list.add(new User(name,tell));
        }
        cursor.close();
        db.close();
        return list;
    }

}
