package cn.zhoujianfeng.baidumap;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Sign extends Activity {

    private String name;
    public static final int REGISTER = 0;
    private Button bt_register_register, bt_register1,bt_Cancel;
    private EditText et_register_name, et_register_password;
    private static final String PREFS_NAME = "MyPrefsFile";
    private SharedPreferences sp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign);

        et_register_name = findViewById(R.id.et_register_name);
        bt_register_register = findViewById(R.id.bt_register_register);
        et_register_password = findViewById(R.id.et_register_password);
        final CheckBox cb_flag = findViewById(R.id.cb_flag);
        sp = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean flag = sp.getBoolean("flag", false);
        if (flag) {
            String name = sp.getString("name", "");
            String password = sp.getString("password", "");
            et_register_name.setText(name);
            et_register_password.setText(password);
        }

        bt_register_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = et_register_password.getText().toString().trim();
                String name = et_register_name.getText().toString().trim();
                if (name.equals("") || password.equals("")) {
                    Toast.makeText(Sign.this, "用户名、密码不能为空！", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(Register.password)) {
                    Toast.makeText(Sign.this, "用户名、密码有误！", Toast.LENGTH_SHORT).show();
                } else if (password.equals(Register.password)) {
                    SharedPreferences.Editor editor = sp.edit();
                    if (cb_flag.isChecked()) {
                        String names = et_register_name.getText().toString().trim();
                        String passwords = et_register_password.getText().toString().trim();
                        editor.putString("names", names);
                        editor.putString("passwords", passwords);
                        editor.putBoolean("flag", true);
                    } else {
                        editor.putBoolean("flag", false);
                    }
                    editor.commit();
                    String input_name = et_register_name.getText().toString().trim();
                    Check.userName = input_name;
                    Intent intent = new Intent(Sign.this, Search.class);
                    intent.putExtra("name",input_name);
                    startActivity(intent);
                    finish();
                }
            }
        });

        bt_register1 = findViewById(R.id.bt_register1);
        bt_register1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sign.this, Register.class);
                startActivityForResult(intent,REGISTER);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_OK) {
            name = data.getStringExtra("name");
            et_register_name.setText(name);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
