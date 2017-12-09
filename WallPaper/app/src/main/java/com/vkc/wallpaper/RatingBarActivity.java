package com.vkc.wallpaper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class RatingBarActivity extends AppCompatActivity {
    RatingBar ratingBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);
        ratingBar=(RatingBar)findViewById(R.id.rb);
        textView=(TextView)findViewById(R.id.tv1);
    }
    public void submit(View view)
    {
        float ra=ratingBar.getRating();
        textView.setText("RatingBar:"+ra);
        finish();
    }
}
