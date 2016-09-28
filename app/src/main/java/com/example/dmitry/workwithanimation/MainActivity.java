package com.example.dmitry.workwithanimation;

import android.graphics.Color;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private Button fade_in;
    private Button rotate;
    private Button zoom;
    private Button move;
    private Button slide;
    private Button multi;
     static final int multiint = 1;
     static final int slideint = 3;
     static final int moveint = 4;
     static final int zoomint = 5;
     static final int rotateint = 6;
     static final int fade_inint = 7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout frameeLayout = new FrameLayout(this);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams
                (FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);

        params.gravity = Gravity.CENTER;


        textView = new TextView(this);
        textView.setText("My text");
        textView.setTextSize(30);
        textView.setTextColor(Color.BLACK);
        frameeLayout.addView(textView, params);

        LinearLayout linearLayout1 = new LinearLayout(this);
        linearLayout1.setOrientation(LinearLayout.VERTICAL);
        FrameLayout.LayoutParams param1 = new FrameLayout.LayoutParams
                (FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        param1.gravity = Gravity.BOTTOM;

        frameeLayout.addView(linearLayout1, param1);

        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(LinearLayout.VERTICAL);
        FrameLayout.LayoutParams param2 = new FrameLayout.LayoutParams
                (FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
      //  param2.gravity = Gravity.RIGHT;
        param2.gravity = Gravity.END + Gravity.BOTTOM;

        frameeLayout.addView(linearLayout2, param2);


        fade_in = new Button(this);
        rotate = new Button(this);
        zoom = new Button(this);
        move = new Button(this);
        slide = new Button(this);
        multi = new Button(this);

        fade_in.setOnClickListener(this);
        rotate.setOnClickListener(this);
        zoom.setOnClickListener(this);
        move.setOnClickListener(this);
        slide.setOnClickListener(this);
        multi.setOnClickListener(this);


        fade_in.setText("fade_in");
        fade_in.setId(fade_inint);
        rotate.setText("rotate");
        rotate.setId(rotateint);
        zoom.setText("zoom");
        zoom.setId(zoomint);
        move.setText("move");
        move.setId(moveint);
        slide.setText("slide");
        slide.setId(slideint);
        multi.setText("multi");
        multi.setId(multiint);

        linearLayout1.addView(fade_in);
        linearLayout1.addView(rotate);
        linearLayout1.addView(zoom);
        linearLayout2.addView(move);
        linearLayout2.addView(slide);
        linearLayout2.addView(multi);


        setContentView(frameeLayout);


    }

    @Override
    public void onClick(View view) {
        Animation anim = null;
        switch (view.getId()){
            case multiint:{
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.multi);
                break;
            }
            case zoomint:{
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
                break;
            }
            case fade_inint:{
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                break;
            }
            case slideint:{
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);

                break;
            }
            case rotateint:{
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);

                break;
            }
            case moveint:{
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
                break;
            }
        }
        textView.startAnimation(anim);
    }
}
