import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    private static final int size = 3;
    private Cell [][] tab;

    String choixUser = "";// choix d'utilisateur entre X et O
    Player player = new Player();




    public TicTacToe(){
        tab = new Cell[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++) {
                tab[i][j] = new Cell();
            }
        }
//        player1 = new Player();
//        player2 = new Player();
//        player1.setChoix("| X ");
//        player2.setChoix("| O ");

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


    public String choixPlayer(){
        String recupChoix = "";
        do{
            System.out.print(joueurXouO());
            Scanner str = new Scanner(System.in);
            recupChoix = str.next();
        }while (!recupChoix.equals("X") && !recupChoix.equals("O"));
        //System.out.println("player choosed "+recupChoix);
        return recupChoix;
    }

    public String joueurXouO(){
        String joueur = "";
        if (choixUser.equals("X")){
            joueur += "le tour du jouer X : ";
        }else{
            joueur += "le tour du jouer O : ";
        }
        return joueur;
    }

    public String getMoveFromPlayer(){
        String result = "Hors coordonnées";
        //try catch
        try{
            choixUser = choixPlayer();
            Scanner entier1 = new Scanner(System.in);
            System.out.print("Entrer les coordonnées x : ");
            int recupCoord1 = entier1.nextInt();

            Scanner entier2 = new Scanner(System.in);
            System.out.print("Entrer les coordonnées y : ");
            int recupCoord2 = entier2.nextInt();

            while (recupCoord1 < size && recupCoord2 < size ){
                result = "" + recupCoord1 + recupCoord2;
                break;
            }
        }catch(InputMismatchException e){
            System.out.println(e);
        }

        return result;
    }

    public void setOwner(String coord, Player player){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                String concatIJ = "" + i + j;
                if(coord.equals(concatIJ) && choixUser.equals("X")){
                    tab[i][j].setRepresentation("| X ");
                    display();
                }else if(coord.equals(concatIJ) && choixUser.equals("O")){
                    tab[i][j].setRepresentation("| O ");
                    display();
                }
            }
        }

    }
    public void play() {
        int k = 0;

        while (k < size*size){
            String coordonner = getMoveFromPlayer();
            setOwner(coordonner, player);
            k++;
        }

    }

}
