package com.vkc.wallpaper;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mf = getMenuInflater();
        mf.inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.rate:
                // Toast.makeText(this, "you gone Rating page", Toast.LENGTH_SHORT).show();
                Rate();
                return true;
            case R.id.hom:
                Share();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void Share() {
        Intent sharingIntent=new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "AndroidSolved");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "https://androidsolved.wordpress.com/ ");
        startActivity(Intent.createChooser(sharingIntent, "Share via"));

    }

    private void Rate() {
        Intent i = new Intent(this, RatingBarActivity.class);
        startActivity(i);
    }
    public void MainButton(View view)
    {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
