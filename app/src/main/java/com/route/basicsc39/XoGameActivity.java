package com.route.basicsc39;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Arrays;

public class XoGameActivity extends AppCompatActivity {
    int counter = 0;
    String[] initialBoard = {
            "", "", "",
            "", "", "",
            "", "", ""};
    int player1Score = 0;
    int player2Score = 0;
    TextView player1TvScore, player2TvScore;

    ArrayList<String> board = new ArrayList<>(Arrays.asList(initialBoard));
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xo_game);
        constraintLayout = findViewById(R.id.mainView);
        player1TvScore = findViewById(R.id.player1Score);
        player2TvScore = findViewById(R.id.player2Score);
    }

    public void onButtonClick(View v) {
        Button clickedButton = (Button) v;
        if (!clickedButton.getText().toString().isEmpty()) return;
        String symbol = counter % 2 == 0 ? "O" : "X";
        clickedButton.setText(symbol);
        int index = Integer.parseInt(clickedButton.getTag().toString());
        board.set(index, symbol);
        counter++;
        if (checkWinner(symbol)) {
            if (symbol.equals("O")) {
                player1Score++;
                player1TvScore.setText(player1Score + "");
            } else {
                player2Score++;
                player2TvScore.setText(player2Score + "");
            }
            resetBoard();
        } else if (counter == 9) {
            resetBoard();
        }

    }

    private void resetBoard() {
        board = new ArrayList<>(Arrays.asList(initialBoard));
        int childCount = constraintLayout.getChildCount();
//        for(int i = 0; i < childCount; i++){
//          View view =   constraintLayout.getChildAt(i);
//          if(view instanceof  Button){
//              ((Button) view).setText("");
//          }
//        }
        for (int i = 0; i < 9; i++) {
            Button button = constraintLayout.findViewWithTag(i + "");
            button.setText("");
        }
        counter = 0;
    }

    private boolean checkWinner(String symbol) {
        ///Rows
        for (int i = 0; i < 9; i += 3) {
            if (symbol.equals(board.get(i)) &&
                    symbol.equals(board.get(i + 1)) &&
                    symbol.equals(board.get(i + 2))) {
                return true;
            }
        }
        ///Column
        for (int i = 0; i < 3; i++) {
            if (symbol.equals(board.get(i)) &&
                    symbol.equals(board.get(i + 3)) &&
                    symbol.equals(board.get(i + 6))) {
                return true;
            }
        }
        ///Diagonals
        if (symbol.equals(board.get(2)) &&
                symbol.equals(board.get(4)) &&
                symbol.equals(board.get(6))) {
            return true;
        }
        return symbol.equals(board.get(0)) &&
                symbol.equals(board.get(4)) &&
                symbol.equals(board.get(8));
    }
}