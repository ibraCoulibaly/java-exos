import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    private static final int SIZE = 3;
    private Cell[][] tab;

    public String choixUser;// choix d'utilisateur entre X et O, pour pouvoir l'utiliser dans plusieur fonction
    private Player player = new Player();


    public TicTacToe() {
        choixUser = "";
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


    /*Verifie la saisi de l'utilisateur si c'est X ou O sinon redemande toujours la sasie*/
    public String choixPlayer() {
        String recupChoix = "";
        do {
            System.out.print("Tour du jouer " + joueurXouO() + " : ");
            Scanner str = new Scanner(System.in);
            recupChoix = str.next();
        } while (!recupChoix.equals("X") && !recupChoix.equals("O"));
        return recupChoix;
    }


    /*Retourne une chaine pour savoir si c'est le tour du joueur O ou X Et le jeux commence par le joueur O */
    public String joueurXouO() {
        String joueur;
        if (choixUser.equals("O")) {
            joueur = "X";
        } else {
            joueur = "O";
        }
        return joueur;
    }

    /*Verifie la saisie de user si c'est une bonne coordonneée sinon renvoie Hors connection
    j'ai pris les iterateur i et j et de les concatener en chaine de caractere
    Donc mon retour sera une chaine de carectere : 00, 01, 02, .... */

    public String getMoveFromPlayer() {
        String result = "Hors coordonnées";
        //try catch
        try {
            choixUser = choixPlayer();
            Scanner entier1 = new Scanner(System.in);
            System.out.print("Entrer le coordonné x : ");
            int recupCoord1 = entier1.nextInt();

            Scanner entier2 = new Scanner(System.in);
            System.out.print("Entrer le coordonné y : ");
            int recupCoord2 = entier2.nextInt();

            while (recupCoord1 < SIZE && recupCoord2 < SIZE ) {
                result = "" + recupCoord1 + recupCoord2;
                break;
            }
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
                }

            }
        }
        display();
        return  done;


    }

    public void play() {
        int k = 0;
        String coordonner;
        while (k < SIZE * SIZE) {
            coordonner = getMoveFromPlayer();
            if (setOwner(coordonner, player)){
                k++;
            }
        }



    }

}
