package cn.zhoujianfeng.baidumap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WriteBlog extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writeblog);

        EditText mEditText = (EditText) findViewById(R.id.et_write);
        mEditText.setFocusable(true);
        mEditText.setFocusableInTouchMode(true);

        Button btn_cancel = findViewById(R.id.bt_cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WriteBlog.this,Blog.class);
                startActivity(intent);
            }
        });

        Button btn_publish = findViewById(R.id.bt_publish);
        btn_publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WriteBlog.this,"发表成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(WriteBlog.this,Blog.class);
                startActivity(intent);
            }
        });


    }
}
