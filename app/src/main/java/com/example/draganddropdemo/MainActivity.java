package com.example.draganddropdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    TextView txt;
    float xd=0,yd=0;
    float xm,ym;
    float xdes,ydes;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.imglogo);
        txt=findViewById(R.id.txtdemo);

        img.setOnTouchListener(tc);
        txt.setOnTouchListener(tc);

    }

    View.OnTouchListener tc=new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int e=event.getActionMasked();

            switch(e)
            {
                case MotionEvent.ACTION_DOWN:
                    xd=event.getX();
                    yd=event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    xm=event.getX();
                    ym=event.getY();

                    xdes=xm-xd;
                    ydes=ym-yd;

                    v.setX(v.getX()+xdes);
                    v.setY(v.getY()+ydes);


                    break;
            }
            return true;
        }
    };
}
