package com.dsquare.news;

import android.net.Uri;
import android.os.Handler;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.logging.LogRecord;

public class News extends AppCompatActivity {

    private TextView text1,text2,text3;
    private RelativeLayout relative1,relative2;
    private ImageView image1;
    private int images[] = new int[2];
    private VideoView video_player_view;
    private DisplayMetrics dm;
    private SurfaceView sur_View;
    private MediaController media_Controller;
    private int width,height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        text1 = (TextView)findViewById(R.id.scrollText3);
        text2 = (TextView)findViewById(R.id.scrollText1);
        text3 = (TextView)findViewById(R.id.scrollText);

        relative1 = (RelativeLayout)findViewById(R.id.relative1);
        relative2 = (RelativeLayout)findViewById(R.id.bottom);

        video_player_view = (VideoView) findViewById(R.id.video_player_view);
        media_Controller = new MediaController(this);
        dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        height = dm.heightPixels;
        width = dm.widthPixels;

        images[0] = R.drawable.airtel;
        images[1] = R.drawable.c;

        playVideo();
        startImageChanging();
    }

    public void setTextScrolls() {
        relative1.setVisibility(View.VISIBLE);
        relative2.setVisibility(View.VISIBLE);

        Animation anim1 = AnimationUtils.loadAnimation(this,R.anim.scroll1);
        anim1.setRepeatCount(Animation.INFINITE);
        text1.startAnimation(anim1);

        Animation anim2 = AnimationUtils.loadAnimation(this,R.anim.scroll2);
        anim2.setRepeatCount(Animation.INFINITE);
        text2.startAnimation(anim2);

        Animation anim3 = AnimationUtils.loadAnimation(this, R.anim.scroll3);
        anim3.setRepeatCount(Animation.INFINITE);
        text3.startAnimation(anim3);
    }

    public void playVideo(){
        video_player_view.setMinimumWidth(width);
        video_player_view.setMinimumHeight(height);
        video_player_view.setMediaController(media_Controller);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.a);
        video_player_view.setVideoPath(uri.toString());
        video_player_view.start();
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            public void run() {
                setTextScrolls();
            }
        };
        handler.postDelayed(runnable, 15000); //for initial delay..
    }

    public void startImageChanging(){
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i=0;
            public void run() {
                image1.setImageResource(images[i]);
                i++;
                if(i>images.length-1)
                {
                    i=0;
                }
                handler.postDelayed(this, 50);  //for interval...
            }
        };
        handler.postDelayed(runnable, 2000); //for initial delay..
    }
}
