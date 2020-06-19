package com.example.android.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[] gameState={2,2,2,2,2,2,2,2,2};

    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameactive = true;

    int activePlayer = 0;
    public void dropIn(View view){
        ImageView counter  = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        counter.setTranslationY(-1500);
        if(gameState[tappedCounter]==2) {
            gameState[tappedCounter] = activePlayer;
        }
        else{
            Toast.makeText(this,"Please make a valid Move!!",Toast.LENGTH_SHORT).show();
            return;
        }

        if(gameactive==true) {
            gameState[tappedCounter] = activePlayer;
        }
        else{
            Toast.makeText(this,"GAME FINISHED!!\nPLEASE RESET",Toast.LENGTH_SHORT).show();
            return;
        }


        if (activePlayer == 0) {
            counter.setImageResource(R.drawable.o);
            counter.animate().translationYBy(1500).setDuration(300);
            activePlayer=1;
        }
        else{
            counter.setImageResource(R.drawable.x);
            counter.animate().translationYBy(1500).setDuration(300);
            activePlayer=0;
        }

        for(int[] winningPosition: winningPositions){
            String winner = "";
            if(gameState[winningPosition[0]]==gameState[winningPosition[1]]&&gameState[winningPosition[0]]==gameState[winningPosition[2]]&&gameState[winningPosition[0]]!=2){

                if(activePlayer==0)
                    winner = "Micky";
                else
                    winner = "Minnie";
                gameactive=false;

                TextView textView = (TextView) findViewById(R.id.textView);
                Button button = (Button) findViewById(R.id.button);
                textView.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
                textView.setText(winner+" has Won!!!");
            }

        }
    }

    public void playAgain(View view){
        TextView textView = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button);
        textView.setVisibility(View.INVISIBLE);
        button.setVisibility(View.INVISIBLE);

        ImageView imageView = (ImageView)findViewById(R.id.imageView1);
        imageView.setImageDrawable(null);
        imageView = (ImageView)findViewById(R.id.imageView2);
        imageView.setImageDrawable(null);
        imageView = (ImageView)findViewById(R.id.imageView3);
        imageView.setImageDrawable(null);
        imageView = (ImageView)findViewById(R.id.imageView4);
        imageView.setImageDrawable(null);
        imageView = (ImageView)findViewById(R.id.imageView5);
        imageView.setImageDrawable(null);
        imageView = (ImageView)findViewById(R.id.imageView6);
        imageView.setImageDrawable(null);
        imageView = (ImageView)findViewById(R.id.imageView7);
        imageView.setImageDrawable(null);
        imageView = (ImageView)findViewById(R.id.imageView8);
        imageView.setImageDrawable(null);
        imageView = (ImageView)findViewById(R.id.imageView9);
        imageView.setImageDrawable(null);


        gameactive=true;
        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
