package cn.zhoujianfeng.baidumap;


import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.Window;

public class LaunchActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.load);

        PackageManager pm = getPackageManager();
        try {
            PackageInfo pi = pm.getPackageInfo("com.lyt.android", 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }

        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                Intent intent = new Intent(LaunchActivity.this,GuideActivity.class);
                startActivity(intent);
                LaunchActivity.this.finish();
            }
        }, 5000);

    }
}

