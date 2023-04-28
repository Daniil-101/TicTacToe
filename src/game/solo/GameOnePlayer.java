package game.solo;

import game.*;

import java.util.ArrayList;
import java.util.List;

public class GameOnePlayer implements Game {
    private GameBoard board;
    private IOService ioService;
    private CreatingPlayer player;
    private CreatingBot bot;
    private static final ArrayList<Integer> player1Position = new ArrayList<>();
    private static final ArrayList<Integer> player2Position = new ArrayList<>();

    public GameOnePlayer(){
        this.board = new GameBoard();
        this.ioService = new IOService();
        this.bot = new CreatingBot();

    }

    public void start() {
        player = new CreatingPlayer(ioService.setPlayerNameSinglePlayer());
        while (true) {
            System.out.println("Введите число от 1 до 9 чтобы сделать ход.");
            int posPlayer = ioService.playerMakesMove();
            turn(board, posPlayer, player.getName());
            int posBot = ioService.botMakesMove();
            turn(board, posBot, bot.getName());
            String end = checkWinner(player.getName(), bot.getName());
            if(end.length() > 0){
                System.out.println(end);
                break;
            }
        }
    }

    public void turn(GameBoard gameBoard, int pos, String player) {
        char symbol = ' ';
        pos = fillingCheck(pos,player);
        if(player.equals(this.player.getName())){
            symbol = 'X';
            player1Position.add(pos);
        }else  {
            symbol = '0';
            player2Position.add(pos);
        }
        cellChange(gameBoard, symbol, pos);
    }

    public void cellChange(GameBoard gameBoard, char symbol, int pos) {
        switch (pos) {
            case 1:
                gameBoard.getGameBoard()[0][0] = symbol;
                break;
            case 2:
                gameBoard.getGameBoard()[0][2] = symbol;
                break;
            case 3:
                gameBoard.getGameBoard()[0][4] = symbol;
                break;
            case 4:
                gameBoard.getGameBoard()[2][0] = symbol;
                break;
            case 5:
                gameBoard.getGameBoard()[2][2] = symbol;
                break;
            case 6:
                gameBoard.getGameBoard()[2][4] = symbol;
                break;
            case 7:
                gameBoard.getGameBoard()[4][0] = symbol;
                break;
            case 8:
                gameBoard.getGameBoard()[4][2] = symbol;
                break;
            case 9:
                gameBoard.getGameBoard()[4][4] = symbol;
                break;
            default:
                break;
        }
        ioService.printGameBoard(gameBoard.getGameBoard());
    }

    public String checkWinner(String player1, String player2){
        ArrayList<List> goodOptions = board.goodOptions();

        for (List l : goodOptions){
            if(player1Position.containsAll(l)){
                return "You win!";
            }else if(player2Position.containsAll(l)){
                return "You lose";
            }else if(player1Position.size()+player2Position.size() == 9){
                return "No winner";
            }
        }
        return "";
    }

    public int fillingCheck(int pos, String player) {
        if (player.equals(bot.getName())){
            while (player1Position.contains(pos) || player2Position.contains(pos)) {
                pos = ioService.botMakesMove();
            }
        }else {
            while (player1Position.contains(pos) || player2Position.contains(pos)) {
                System.out.println("Данная ячейка уже занята. Введие другую.");
                pos = ioService.playerMakesMove();
            }
        }
        return pos;
    }
}
