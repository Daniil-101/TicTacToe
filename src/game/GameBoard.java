package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameBoard {


    private char[][] gameBoard;


    public GameBoard(){
        this.gameBoard =   new char[][]{{' ', '|', ' ', '|', ' ',},
                                        {'-', '+', '-', '+', '-',},
                                        {' ', '|', ' ', '|', ' ',},
                                        {'-', '+', '-', '+', '-',},
                                        {' ', '|', ' ', '|', ' ',}};
    }

    public char[][] getGameBoard(){
        return gameBoard;
    }

    public ArrayList<List> goodOptions(){
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List lefCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rigCol = Arrays.asList(3,6,9);
        List firstDiagonal = Arrays.asList(1,5,9);
        List secondDiagonal = Arrays.asList(3,5,7);

        ArrayList<List> winningCombinations = new ArrayList<>();
        winningCombinations.add(topRow);
        winningCombinations.add(midRow);
        winningCombinations.add(botRow);
        winningCombinations.add(lefCol);
        winningCombinations.add(midCol);
        winningCombinations.add(rigCol);
        winningCombinations.add(firstDiagonal);
        winningCombinations.add(secondDiagonal);
        return winningCombinations;
    }
}
