package cn.zhoujianfeng.baidumap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Check extends Activity {

    private Button bt_Back,bt_register,bt_save;

    public static String userName = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check);


        bt_Back = findViewById(R.id.bt_backHome);
        bt_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Check.this,MainActivity.class);
                startActivity(intent);
            }
        });

        bt_register = findViewById(R.id.bt_register);
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Check.this,Sign.class);
                startActivity(intent);
            }
        });

        bt_save = findViewById(R.id.bt_save);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Check.this, "保存成功！", Toast.LENGTH_SHORT).show();
            }
        });

        if(userName!=""){
            TextView tv_user = findViewById(R.id.tv_user);
            tv_user.setText(userName);
        }

    }
}
