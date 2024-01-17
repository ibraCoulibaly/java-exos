public class Main {
    public static void main(String[] args) {

        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.display();


        Player player1 = new Player();
        Player player2 = new Player();

        int i = 0;
        while(i < 9){
            ticTacToe.getMoveFromPlayer();
            i++;
        }


    }
}