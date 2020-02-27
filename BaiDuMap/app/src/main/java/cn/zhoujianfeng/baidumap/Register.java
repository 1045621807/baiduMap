package cn.zhoujianfeng.baidumap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {

    private Button bt_Cancel,bt_register_register;
    private EditText et_register_name,et_register_password,et_register_surePassword;
    public static Object password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


        bt_Cancel = findViewById(R.id.bt_Cancel);
        bt_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this,Sign.class);
                startActivity(intent);
            }
        });

        et_register_name = findViewById(R.id.et_register_name);
        et_register_password = findViewById(R.id.et_register_password);
        et_register_surePassword = findViewById(R.id.et_register_surePassword);
        bt_register_register = findViewById(R.id.bt_register_register);

        bt_register_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_register_name.getText().toString().trim();
                password = et_register_password.getText().toString().trim();
                String surePassword = et_register_surePassword.getText().toString().trim();

                if(password.equals("") || surePassword.equals("") || name.equals("")){
                    Toast.makeText(Register.this, "用户名，密码，确认密码不能为空！", Toast.LENGTH_SHORT).show();
                }else if(!password.equals(surePassword)){
                    Toast.makeText(Register.this, "密码与确认密码不一致！", Toast.LENGTH_SHORT).show();
                }else if(password.equals(surePassword)){
                    Intent data = new Intent();
                    data.putExtra("name",name);
                    setResult(RESULT_OK,data);
                    finish();
                }

            }
        });

    }
}
