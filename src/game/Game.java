package game;


public interface Game {

    public void start();

    public void turn(GameBoard gameBoard, int pos, String player);

    public void cellChange(GameBoard gameBoard, char symbol, int pos);

    public String checkWinner(String player1, String player2);

    public int fillingCheck(int pos, String player);

}
