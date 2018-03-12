package com.example.administrator.drawarrowtest;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    private LinearLayout mylayout;
    private TextView tt;
    private Bitmap bitmap;
    private int x=0, y=0, xx=800, yy=480;
    Paint paint;
    Canvas canvas;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylayout = (LinearLayout)findViewById(R.id.activity_main);
//        tt = (TextView)findViewById(R.id.myText);


        //使用 DrawGeometryView 绘制箭头
        RelativeLayout myrl=(RelativeLayout) findViewById(R.id.myrl);
//        myrl.addView(new DrawGeometryView(this));
        //使用 MyCanvas 绘制箭头
        myrl.addView(new MyCanvas(this));



    }

    private void drawLine() {
        paint = new Paint();

        paint.setStrokeWidth(5);//笔宽5像素
        paint.setColor(Color.RED);//设置为红笔
        paint.setAntiAlias(true);//锯齿不显示

        bitmap = Bitmap.createBitmap(800, 480, Bitmap.Config.ARGB_8888); //设置位图的宽高,bitmap为透明
        canvas = new Canvas(bitmap);
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);//设置为透明，画布也是透明


        canvas.drawLine(0, 20, 750, 200, paint);
//        mylayout.addView(canvas);

        //在画布上贴张小图
//        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.add_icon_location);
////        canvas.drawBitmap(bm, 0, 0, paint);
//        canvas.drawBitmap(bm, 750, 200, paint);




//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));//橡皮擦一样擦除
//        canvas.drawLine(0, 20, 750, 200, paint);
//
//        paint.setXfermode(null);//取消擦除模式
//        paint.setColor(Color.BLUE);
//        canvas.drawLine(0, 20, 750, 200, paint);
//
//
        Drawable drawable = new BitmapDrawable(bitmap) ;
        mylayout.setBackgroundDrawable(drawable);

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_main, menu);
//        return true;
//    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub

        if(keyCode == 19){

            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));//橡皮擦一样擦除
            canvas.drawLine(x, y, xx, yy, paint);


            x +=20;
            y +=20;
            xx-=20;
            yy-=20;
            paint.setXfermode(null);//取消擦除模式
            paint.setColor(Color.BLUE);
            canvas.drawLine(x, y, xx, yy, paint);


            Drawable drawable = new BitmapDrawable(bitmap) ;
            mylayout.setBackgroundDrawable(drawable);
        }

        return super.onKeyDown(keyCode, event);
    }
}
