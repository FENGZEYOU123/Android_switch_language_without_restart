package com.yfz.mian;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import java.util.Locale;

/**
 * 资料代码来源于: http://www.manongjc.com/article/148482.html
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 点击按钮，更换语言
     *
     * @param view
     */
    public void changeLanguage(View view) {
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration(); // 获取资源配置
        if (configuration.locale.equals(Locale.CHINA)) { // 判断当前语言是否是中文
            configuration.locale = Locale.ENGLISH; // 设置当前语言配置为英文
        } else {
            configuration.locale = Locale.CHINA; // 设置当前语言配置为中文
        }
        DisplayMetrics metrics = new DisplayMetrics();
        resources.updateConfiguration(configuration, metrics); // 更新配置文件
        sendBroadcast(new Intent("language")); // 发送广播，广播接受后重新开启此Activtiy以重新初始化界面语言.
    Intent intent = new Intent(MainActivity.this, MainActivity.class); //或者可以直接跳转MainActivity
    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION); //去除掉跳转的动画，让用户看起来好像没有跳转的感觉
    startActivity(intent);
        finish();
    }
}