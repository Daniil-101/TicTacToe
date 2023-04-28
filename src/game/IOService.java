package game;

import java.util.Random;
import java.util.Scanner;

public class IOService {

    private Scanner sc = new Scanner(System.in);
    private Random rand = new Random();

    private boolean isFirstInputCall = true;

    public String setPlayerNameSinglePlayer(){
        if(isFirstInputCall){
            System.out.print("Введите ваше имя: ");
        }
        return sc.nextLine();
    }

    public String setPlayerNameDoublesPlayer(){
        if(isFirstInputCall){
            System.out.print("Введите имя первого игрока: ");
            isFirstInputCall =false;
        }else {
            System.out.print("Введите имя второго игрока: ");
        }
        return sc.nextLine();
    }

    public void printGameBoard(char[][] gameBoard){
        for (char[] row : gameBoard){
            for (char ch : row){
                System.out.print(ch);
            }
            System.out.println(" ");
        }
    }

    public int playerMakesMove(){
        int pos = sc.nextInt();
        return pos;
    }

    public int botMakesMove(){
        return rand.nextInt(9)+1;
    }

    public Scanner getScanner() {
        return sc;
    }
}
