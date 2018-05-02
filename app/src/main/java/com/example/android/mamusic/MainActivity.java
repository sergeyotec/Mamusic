package com.example.android.mamusic;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = (Button) findViewById(R.id.play_button);
        Button pauseButton = (Button) findViewById(R.id.pause_button);
        Button resetButton = (Button) findViewById(R.id.some_button);
        mediaPlayer = MediaPlayer.create(this, R.raw.sssr);

        playButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Готово кагбэ!",
                                Toast.LENGTH_LONG);
                        toast.show();
                    }
                });
            }
        });
        pauseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mediaPlayer.pause();
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mediaPlayer.reset();
            }
        });
        if (mediaPlayer.isPlaying())
            playButton.setBackgroundColor(getResources().getColor(R.color.playing));


    }
}
