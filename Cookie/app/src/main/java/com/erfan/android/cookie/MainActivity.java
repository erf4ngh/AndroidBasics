package com.erfan.android.cookie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.erfan.android.cookie.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the cookie should be eaten.
     */
    public void eatCookie(View view) {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView cookie = (ImageView) findViewById(R.id.android_cookie_image_view);
        cookie.setImageResource(R.drawable.ecookie);
        // TODO: Find a reference to the TextView in the layout. Change the text.
        TextView hungry = (TextView) findViewById(R.id.status_text_view);
        hungry.setText("I'm so full");
    }
}