public class TicTacToe {
    private static final int size = 4;
    private Cell [] tab;
    private Player player;

    public TicTacToe(){
        tab = new Cell[size];
        for(int i = 0; i < size; i++){
            tab[i] = new Cell();
        }
    }

    public void display(){
        System.out.println("-------------");
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i].getRepresentation());
        }
        System.out.println("");
        System.out.println("-------------");

        for (int j= 0; j < tab.length; j++) {
            System.out.print(tab[j].getRepresentation());
        }
        System.out.println("");
        System.out.println("-------------");

        for(int k = 0; k < tab.length; k++){
            System.out.print(tab[k].getRepresentation());
        }
        System.out.println("");
        System.out.println("-------------");
    }

    public int getMoveFromPlayer(){
        int result = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if (j == 0 && i == 0){

                }
            }
        }
        return result;
    }

}
