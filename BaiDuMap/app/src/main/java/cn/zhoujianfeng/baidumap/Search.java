package cn.zhoujianfeng.baidumap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Search extends Activity {

    private Button bt_location,bt_blog,bt_set,bt_scenic,bt_hotel,bt_food;
    private List<User> list;
    private MySql mySql;
//    private MyAdapter myAdapter;
    private ListView lv_data ;
    private Users users;
    public int sID;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        bt_location = findViewById(R.id.bt_location);
        bt_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Search.this,MainActivity.class);
                startActivity(intent);
            }
        });

        bt_blog = findViewById(R.id.bt_blog);
        bt_blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Search.this,Blog.class);
                startActivity(intent);
            }
        });

        bt_set = findViewById(R.id.bt_set);
        bt_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Search.this,Set.class);
                startActivity(intent);
            }
        });

        bt_scenic =findViewById(R.id.bt_scenic);
        bt_scenic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Search.this,Scenic.class);
                startActivity(intent);
            }
        });

        bt_hotel = findViewById(R.id.bt_hotel);
        bt_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Search.this,Hotel.class);
                startActivity(intent);
            }
        });


        bt_food = findViewById(R.id.bt_food);
        bt_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Search.this,Food.class);
                startActivity(intent);
            }
        });




    }


}
