package com.example.dirk2.moviedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_message_activity);

        Intent intent = getIntent();
        Movie movie = (Movie) intent.getSerializableExtra("movie");
        TextView text = findViewById(R.id.textView2);
        text.setMovementMethod(new ScrollingMovementMethod());
        text.setText(movie.toString());
    }
}
