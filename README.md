# XML
实验三XML
1.使用XML定义菜单
我们使用的是option menu(选项菜单)
activity_main.xml
我们需要在显示的布局文件中建立一个TextView,用来显示相关内容并为它绑定一个菜单
```
activity_main.xml
<?xml version="1.0" encoding="UTF-8"?>
<LinearLayout
    android:layout_height="match_parent"
    android:layout_width="match_parent"
    android:orientation="vertical"
    xmlns:android="http://schemas.android.com/apk/res/android">

    <TextView
        android:layout_height="wrap_content"
        android:layout_width="match_parent"
        android:text="@string/text"
        android:textSize="15pt"
        android:id="@+id/txt">
    </TextView>
    
</LinearLayout>

```
menu_main.xml
设计题目要求的菜单内容
<?xml version="1.0" encoding="utf-8"?>
<!--根元素，无任何属性-->
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <!--定义菜单项-->
    <item
        android:title="@string/font_size">
        <!--子菜单-->
        <menu>
            <!--定义一组单选菜单项-->
            <group >
                <!--定义多个菜单项-->
                <item
                    android:id="@+id/font_10"
                    android:title="@string/font10"/>
                <item
                    android:id="@+id/font_16"
                    android:title="@string/font16"/>
                <item
                    android:id="@+id/font_20"
                    android:title="@string/font20"/>
            </group>
        </menu>
    </item>

    <!--定义一个普通菜单项-->
    <item
        android:id="@+id/plain_item"
        android:title="@string/plain_item"/>

    <item
        android:title="@string/font_color"
        >
        <menu>
            <!--定义一组普通菜单项-->
            <group>
                <!--定义两个菜单项-->
                <item
                    android:id="@+id/red_font"
                    android:title="@string/red_title" />
                <item
                    android:title="@string/black_title"
                    android:id="@+id/black_font"/>
            </group>
        </menu>
    </item>
</menu>

string.xml
写需要在菜单里显示的文字
```
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="text">MenuTest</string>
    <string name="font_size">字体大小</string>
    <string name="font10">10号字</string>
    <string name="font16">16号字</string>
    <string name="font20">20号字</string>
    <string name="plain_item">普通菜单选项</string>
    <string name="font_color">字体颜色</string>
    <string name="red_title">红色</string>
    <string name="black_title">黑色</string>
</resources>
```
MainActivity.java
当写好了一个菜单我们需要在MainActivity中使用它
```
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

```
结果截图:
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190405153242313.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwOTQ2MDUz,size_16,color_FFFFFF,t_70)




![在这里插入图片描述](https://img-blog.csdnimg.cn/20190405153006165.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwOTQ2MDUz,size_16,color_FFFFFF,t_70)![在这里插入图片描述](https://img-blog.csdnimg.cn/20190405153059789.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwOTQ2MDUz,size_16,color_FFFFFF,t_70)![在这里插入图片描述](https://img-blog.csdnimg.cn/20190405153346704.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwOTQ2MDUz,size_16,color_FFFFFF,t_70)
