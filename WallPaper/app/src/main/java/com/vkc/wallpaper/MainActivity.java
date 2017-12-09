package com.vkc.wallpaper;
import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    private ImageView Pic;
    private Button iButton, gButton,button1;
     Menu menu;
    private int currentImage = 0;
    int[] images = {R.drawable.abc,R.drawable.abc1,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6,R.drawable.nature2,
            R.drawable.nature3,R.drawable.rahul1,R.drawable.rahul2,R.drawable.rahul3,R.drawable.rahul4,R.drawable.rahul5};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=(Button)findViewById(R.id.button);
        Pic = (ImageView) findViewById(R.id.image1);

        iButton = (Button) findViewById(R.id.b1);
        gButton = (Button) findViewById(R.id.b2);
        iButton.setOnClickListener(iButtonChangeImageListener);
        gButton.setOnClickListener(gButtonChangeImageListener);

        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                WallpaperManager wm=WallpaperManager.getInstance(getApplicationContext());

                for(int i=0;i<images.length;i++)
                {
                    if(currentImage==i)
                    {
                        try {
                            wm.setResource(images[i]);
                            Toast.makeText(getApplicationContext(),"Wallpaer set",Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    View.OnClickListener iButtonChangeImageListener = new OnClickListener() {

        public void onClick(View v) {
            //Increase Counter to move to next Image
            currentImage++;
            currentImage = currentImage % images.length;

            Pic.setImageResource(images[currentImage]);

        }
    };

    View.OnClickListener gButtonChangeImageListener = new OnClickListener() {

        public void onClick(View v) {
            //Increase Counter to move to next Image
            currentImage--;
            currentImage = (currentImage + images.length) % images.length;

            Pic.setImageResource(images[currentImage]);

        }
    };
}


