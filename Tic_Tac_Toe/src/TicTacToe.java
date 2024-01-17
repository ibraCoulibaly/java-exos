import java.util.Scanner;

public class TicTacToe {
    private static final int size = 3;
    private Cell [][] tab;
    private Player player;

    public TicTacToe(){
        tab = new Cell[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++) {
                tab[i][j] = new Cell();
            }
        }
    }

    public void display(){
        tiret();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(tab[i][j].getRepresentation());// + i + "," + j
            }
            System.out.println("|");
            tiret();
        }
    }

    public void tiret(){
        Cell newCell = new Cell();
        for (int i = 0; i <= newCell.getRepresentation().length()*size; i++){
            System.out.print("-");
        }
        System.out.println("");

    }


//    public void getMoveFromPlayer(){
//
//        Player player = new Player();
//        Scanner s = new Scanner(System.in);
//        System.out.println("Entrer les coordonnées x et y: ");
//        int recupCoord = s.nextInt();
//        String recupChoix = player.choixPlayer();
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                String concatIJ = "" + i + j;
//                int iJ = Integer.parseInt(concatIJ);
//                if(recupCoord == iJ && recupChoix.equals("X")  ){
//                    tab[i][j].setRepresentation("| X ");
//                    display();
//                } else if (recupCoord == iJ && recupChoix.equals("O")) {
//                    tab[i][j].setRepresentation("| O ");
//                    display();
//
//                }
//            }
//        }
//
//    }

}
