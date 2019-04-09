package com.example.hp.xml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView)findViewById(R.id.txt);
        //为文本框注册上下文菜单
        registerForContextMenu(txt);
    }
    @Override
    //供我们初始化菜单类
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //菜单动态加载类
        MenuInflater inflater=new MenuInflater(this);
        //装填R.menu.menu_main菜单,并添加到menu中
        inflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);

    }
    //创建上下文菜单时触发该方法,
    public boolean onOptionsItemSelected(MenuItem mi){
        switch (mi.getItemId()){
            case R.id.font_10:
                txt.setTextSize(20);
                break;
            case R.id.font_16:
                txt.setTextSize(32);
                break;
            case R.id.font_20:
                txt.setTextSize(40);
                break;
            case R.id.red_font:
                txt.setTextColor(android.graphics.Color.RED);
                break;
            case R.id.black_font:
                txt.setTextColor(android.graphics.Color.BLACK);
                break;
            case R.id.plain_item:
                Toast toast =Toast.makeText(MainActivity.this,"这是普通单击项",Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
        return true;
    }

}
