package com.example.dirk2.moviedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.ScrollView;
import android.widget.Button;
import android.os.StrictMode;
import android.content.Intent;
import android.widget.EditText;




public class MainActivity extends AppCompatActivity {

    Button[] movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String[] options = new String[] {
                "Title",
                "Vote"
        };
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner, options
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner);
        spinner.setAdapter(spinnerArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        try {
                            setButtonsAlpha();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 1:
                        try {
                            setButtonsVote();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        movieList = new Button[20];
        ScrollView scroller = findViewById(R.id.scrollView2);
        movieList[0] = (Button) findViewById(R.id.button1);
        movieList[1] = (Button) findViewById(R.id.button2);
        movieList[2] = (Button) findViewById(R.id.button3);
        movieList[3] = (Button) findViewById(R.id.button4);
        movieList[4] = (Button) findViewById(R.id.button5);
        movieList[5] = (Button) findViewById(R.id.button6);
        movieList[6] = (Button) findViewById(R.id.button7);
        movieList[7] = (Button) findViewById(R.id.button8);
        movieList[8] = (Button) findViewById(R.id.button9);
        movieList[9] = (Button) findViewById(R.id.button10);
        movieList[10] = (Button) findViewById(R.id.button11);
        movieList[11] = (Button) findViewById(R.id.button12);
        movieList[12] = (Button) findViewById(R.id.button13);
        movieList[13] = (Button) findViewById(R.id.button14);
        movieList[14] = (Button) findViewById(R.id.button15);
        movieList[15] = (Button) findViewById(R.id.button16);
        movieList[16] = (Button) findViewById(R.id.button17);
        movieList[17] = (Button) findViewById(R.id.button18);
        movieList[18] = (Button) findViewById(R.id.button19);
        movieList[19] = (Button) findViewById(R.id.button20);

        try {
            setButtonsAlpha();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Button refresher = findViewById(R.id.button);
        refresher.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    setButtonsAlpha();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void setButtonsAlpha() throws Exception {
        Movie[] movies = ListGenerator.getMoviesAlpha();
        for(int i = 0; i < 20; i++) {
            movieList[i].setText(movies[i].getTitle());
            final Movie sendOff = movies[i];
            movieList[i].setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    sendData(v, sendOff);
                }
            });
        }
    }

    public void setButtonsVote() throws Exception {
        Movie[] movies = ListGenerator.getMoviesVote();
        for(int i = 0; i < 20; i++) {
            movieList[i].setText(movies[i].getTitle());
            final Movie sendOff = movies[i];
            movieList[i].setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    sendData(v, sendOff);
                }
            });
        }
    }

    public void sendData(View v, Movie movie) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra("movie", movie);
        startActivity(intent);
    }




}
