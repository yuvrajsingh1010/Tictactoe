package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isWinner=false;
    int imgClicked=-1;
    int player=1;
    int [][]winningStates={{0,1,2},{3,4,5},{6,7,8}};
    int []gameState={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load(View view) {

            ImageView v = (ImageView) view;
            int tag = Integer.parseInt(v.getTag().toString());
            imgClicked=gameState[tag];
        if(isWinner == false && imgClicked==-1){
            if (player == 1) {
                v.setImageResource(R.drawable.cross);
                gameState[tag] = player;
                Toast.makeText(this, tag + "" + "cross", Toast.LENGTH_SHORT).show();
                player = 0;
            } else {
                v.setImageResource(R.drawable.zero);
                gameState[tag] = player;
                Toast.makeText(this, tag + "" + "zero", Toast.LENGTH_SHORT).show();
                player = 1;
            }
            for (int i = 0; i < winningStates.length; i++) {
                if ((gameState[winningStates[i][0]] == gameState[winningStates[i][1]]) && (gameState[winningStates[i][1]] == gameState[winningStates[i][2]]) && gameState[winningStates[i][0]] > -1) {
                    Toast.makeText(this, "winner is" + (player==0?1:0), Toast.LENGTH_SHORT).show();
                    isWinner=true;
                }
            }
            for (int i = 0; i < winningStates.length; i++) {
                if ((gameState[winningStates[0][i]] == gameState[winningStates[1][i]]) && (gameState[winningStates[1][i]] == gameState[winningStates[2][i]]) && gameState[winningStates[0][i]] > -1) {
                    Toast.makeText(this, "winner is" + (player==0?1:0), Toast.LENGTH_SHORT).show();
                    isWinner=true;
                }
            }
            for (int i = 0; i < winningStates.length; i++) {
                if ((gameState[winningStates[0][0]] == gameState[winningStates[1][1]]) && (gameState[winningStates[1][1]] == gameState[winningStates[2][2]]) && gameState[winningStates[0][0]] > -1) {
                    Toast.makeText(this, "winner is" + (player==0?1:0), Toast.LENGTH_SHORT).show();
                    isWinner=true;
                }
            }
            for (int i = 0; i < winningStates.length; i++) {
                if ((gameState[winningStates[2][0]] == gameState[winningStates[1][1]]) && (gameState[winningStates[1][1]] == gameState[winningStates[2][0]]) && gameState[winningStates[0][0]] > -1) {
                    Toast.makeText(this, "winner is" + (player==0?1:0), Toast.LENGTH_SHORT).show();
                    isWinner=true;
                }
            }



        }
    }
    public void reset(View view){
        GridLayout gridLayout=findViewById(R.id.gridlayout);
        int total_images=gridLayout.getChildCount();
        for(int i=0;i<total_images;i++){
            ImageView v = (ImageView) gridLayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        isWinner=false;
        imgClicked=-1;
        player=1;
        for(int i=0;i<gameState.length;i++)
            gameState[i]=-1;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}