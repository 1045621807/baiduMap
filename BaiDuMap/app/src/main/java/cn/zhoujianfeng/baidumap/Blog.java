package cn.zhoujianfeng.baidumap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Blog extends Activity {

    private Button bt_back;
    private Button bt_write;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blog);

        bt_back = findViewById(R.id.bt_back);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Blog.this,Search.class);
                startActivity(intent);
            }
        });

        bt_write = findViewById(R.id.bt_write);
        bt_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Blog.this,WriteBlog.class);
                startActivity(intent);
            }
        });

    }
}
