import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    private static final int SIZE = 3;
    private Cell[][] tab;

    public String choixUser = "X";
    public int nTour;
    private Player player = new Player();


    public TicTacToe() {
        tab = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                tab[i][j] = new Cell();
            }
        }

    }

    public void display() {
        tiret();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(tab[i][j].getRepresentation());// + i + "," + j
            }
            System.out.println("|");
            tiret();
        }
    }


    public void tiret() {
        Cell newCell = new Cell();
        for (int i = 0; i <= newCell.getRepresentation().length() * SIZE; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }


    public String nextPlayer(){
        if (choixUser.equals("X")){
            return "O";
        }
        return "X";

    }

    public String getMoveFromPlayer() {
        String result = "Hors coordonnées";
        //try catch
        try {
            int recupCoord1;
            int recupCoord2;
            System.out.println("Tour du jouer " + choixUser);
            do {
                Scanner entier1 = new Scanner(System.in);
                System.out.print("Entrer le coordonné x : ");
                recupCoord1 = entier1.nextInt();

                Scanner entier2 = new Scanner(System.in);
                System.out.print("Entrer le coordonné y : ");
                recupCoord2 = entier2.nextInt();
            }while ((recupCoord1 > SIZE || recupCoord2 > SIZE) && tab[recupCoord1][recupCoord2].isOccupied());
            result = "" + recupCoord1 + recupCoord2;



        } catch (InputMismatchException e) {
            System.out.println(e);
        }

        return result;
    }

    public boolean setOwner(String coord, Player player) {
        boolean done = false;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                String concatIJ = "" + i + j;
                if (coord.equals(concatIJ) && !tab[i][j].isOccupied()) {
                    done = tab[i][j].updateRep(choixUser);
                    choixUser = nextPlayer();
                }
            }
        }
        display();
        return  done;
    }

    public void play() {
        nTour = 0;
        String coordonner;
        while (!isOver()) {
            coordonner = getMoveFromPlayer();
            setOwner(coordonner, player);
            nTour++;
        }
    }

    public boolean isFull(){
        return nTour == SIZE*SIZE;
    }

    public boolean isAlignThree(){
        return false;
    }

    public boolean isOver(){
        return isAlignThree() || isFull();
    }

}