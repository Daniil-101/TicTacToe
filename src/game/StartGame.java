package game;

import game.duo.GameTwoPlayer;
import game.solo.GameOnePlayer;

import java.util.InputMismatchException;

public class StartGame {
    private final GameBoard gameBoard;
    private final GameOnePlayer gameOnePlayer;
    private GameTwoPlayer gameTwoPlayer;
    private IOService ioService;

    public StartGame(GameBoard board, IOService ioService, GameOnePlayer gameOnePlayer) {
        gameBoard = board;
        this.ioService = ioService;
        this.gameOnePlayer = gameOnePlayer;
    }

    public StartGame(GameBoard board, IOService ioService, GameOnePlayer gameOnePlayer, GameTwoPlayer gameTwoPlayer) {
        gameBoard = board;
        this.ioService = ioService;
        this.gameOnePlayer = gameOnePlayer;
        this.gameTwoPlayer = gameTwoPlayer;
    }

    public void run() {
        int mode = 0;
        ioService.printGameBoard(gameBoard.getGameBoard());
        System.out.println("Выберите режим игры. \n" +
                "1. Против ИИ. \n" +
                "2. Друг против друга.");
        while (ioService.getScanner().hasNextInt()) {
            mode = ioService.getScanner().nextInt();
            if (mode == 1) {
                gameOnePlayer.start();
                break;
            } else if (mode == 2) {
                gameTwoPlayer.start();
                break;
            } else if (mode < 1 || mode > 2) {
                System.out.println("Нет режима игры с указанным вами номером. Выберите режим из предложенных.");
            } else {
                System.out.println("Некорректный ввод. Выберите режим из предложенных.");
            }
        }
    }
}


