import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    private static final int SIZE = 3;
    private Cell[][] tab;


    private int nTour;
    private Player player = new Player("X");
    //private String choicePlayer = player.getRepresentation();


    public TicTacToe() {
        tab = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                tab[i][j] = new Cell();
            }
        }
        player.setRepresentation("X");

    }

    /**
     * Affiche le platau du jeu TicTacToe de taille SIZE sur SIZE
     * */
    public void display() {
        displayTiret();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(tab[i][j].getRepresentation());// + i + "," + j
            }
            System.out.println("|");
            displayTiret();
        }
    }

    /**
     * Affiche un tiret de 6 (-) à la taille de la representation de Cell fois la SIZE
     * */

    public void displayTiret() {
        Cell newCell = new Cell();
        for (int i = 0; i <= newCell.getRepresentation().length() * SIZE; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }


    /**
     * donne le tour au joueur prochain, par default le premier joueur est representé par X
     * @return : la representation du joueur prochain -> O
     * */
    public String nextPlayer(){
        if (player.getRepresentation().equals("X")){
            return "O";
        }
        return "X";

    }

    /**
     * Verifie les coordonnées abscisse et ordonnée saisie par user s'ils sont bien des coordonees de mon plateau
     * @return : concatene les coordonnées x et y  en chaine de caractere -> xy
     * */
    public String getMoveFromPlayer() {
        String result = "Hors coordonnées";
        try {
            int x;
            int y;

            do {
                Scanner cordX = new Scanner(System.in);
                System.out.print("Entrer le coordonné x : ");
                x = cordX.nextInt();

                Scanner cordY = new Scanner(System.in);
                System.out.print("Entrer le coordonné y : ");
                y = cordY.nextInt();
            }while ( ( x < 0 || y < 0) || (x >= SIZE || y >= SIZE) || tab[x][y].isOccupied() );
            result = "" + x + y;

        } catch (InputMismatchException e) {
            System.out.println(e + " -> Coordonnée non valide");
        }

        return result;
    }

    /**
     * change la représentation de la Cell pour y mettre celle du joueur
     * @param : prend en param le retour de la fonction getMoveFromPlayer() et un Player
     * Affiche le plateau avec la representation du player sur la cellule indiquée  par getMoveFromPlayer() passeé en param
     * */
    public void setOwner(String coord, Player player) {
        this.player = player;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                String concatIJ = "" + i + j;
                if (coord.equals(concatIJ) && !tab[i][j].isOccupied()) {
                    tab[i][j].updateRep(player.getRepresentation());
                    player.setRepresentation(nextPlayer());
                }
            }
        }
        display();

    }

    /**
     *
     * @param : prend en param le retour de la fonction getMoveFromPlayer() et un Player
     * Affiche le plateau avec la representation du player sur la cellule indiquée  par getMoveFromPlayer() passeé en param
     * */

    public void play() {
        do {
            nTour = 0;
            String coordonner;
            System.out.println("Tour du jouer " + player.getRepresentation());
            coordonner = getMoveFromPlayer();
            setOwner(coordonner, player);
            nTour++;

        }while (isOver());


    }

    public boolean isFull(){
        return nTour == SIZE*SIZE;
    }


    /**
     * Verifie toutes les cellules par ligne de mon plateau si on a le meme representation de player
     * @param : un tableau à 2 dimension de type Cell
     * @return : la representation du player
     * */
    public String lineWin(Cell[][] tab, int y){
        String result;
        String player = tab[0][y].getRepresentation();
        boolean change = false;
        for (int x = 0; x < tab.length; x++) {
            if (!tab[x][y].getRepresentation().equals(player)){
                change = true;
            }
        }
        if (change){
            result = "*";
        }else {
            result = player;
        }
        return result;
    }

    /**
     * Verifie toutes les cellules par colonne de mon plateau si on a le meme representation de player
     * @param : un tableau à 2 dimension de type Cell
     * @return : la representation du player
     * */
    public String colWin(Cell[][] tab, int x){
        String result;
        String player = tab[x][0].getRepresentation();
        boolean change = false;
        for (int y = 0; y < tab.length; y++) {
            if (!tab[y][x].getRepresentation().equals(player)){
                change = true;
            }
        }
        if (change){
            result = "*";
        }else {
            result = player;
        }
        return result;
    }

    /**
     * Verifie le diagonale de mon plateau si on a le meme representation de player
     * @param : un tableau à 2 dimension de type Cell
     * @return : la representation player
     * */
    public boolean isWin(Cell[][] tab){
        boolean result = false;
        for (int i = 0; i < tab.length; i++) {
            String line = lineWin(tab, i);

            if (!line.equals("*")){
                result =  true;
            }
            String col = this.colWin(tab, i);
            if (!col.equals("*")){
                result =  true;
            }
        }
        for(int i = 0; i < 2; i++) {
            String dia = this.diaWin(tab, i);
            if(!dia.equals("*")) {
                result = true;
            }
        }

        return result;
    }

    /**
     * Verifie le diagonale de mon plateau si on a le meme representation de player
     * @param : un tableau à 2 dimension de type Cell
     * @return : la representation player
    * */
    public String diaWin (Cell[][] tab, int d) {
        int i;
        if(d==0) {
            i = 0;
        }
        else {
            i = tab.length - 1;
        }
        String player = tab[i][0].getRepresentation();
        boolean changed = false;
        for(int x = 0; x < tab.length; x++) {
            if(d==0) {
                i = x;
            }
            else {
                i = tab.length-1-x;
            }
            if(!tab[i][x].getRepresentation().equals(player)) {
                changed = true;
            }
        }
        if(changed){
            return "*";
        }
        else {
            return player;
        }
    }


    /**
     * Verifie si le jeu est terminé
     * @return : un boolean
     * */

    public boolean isOver(){
        return isWin(tab) || isFull();
    }

}