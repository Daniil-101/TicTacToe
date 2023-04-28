import game.GameBoard;
import game.IOService;
import game.StartGame;
import game.solo.GameOnePlayer;
import game.duo.GameTwoPlayer;

public class Main {



    public static void main(String[] args) {
        IOService ioService = new IOService();
        GameBoard board = new GameBoard();
        GameOnePlayer game1 = new GameOnePlayer();
        GameTwoPlayer game2 = new GameTwoPlayer();
        StartGame startGame = new StartGame(board, ioService, game1, game2);
        startGame.run();

    }
}