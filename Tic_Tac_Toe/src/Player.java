import java.util.Scanner;
public class Player {
    private String representation = "";


//    public Player(){
//        this.representation = "";
//    }

    public String getRepresentation(){
        return this.representation;
    }

    public void setRepresentation(String representation) {
        this.representation = representation;
    }

    public String choixPlayer(){
        System.out.print("Choisir un symbole X ou O : ");
        Scanner str = new Scanner(System.in);

        String recupChoix = str.next();
        String res = "";
        if (recupChoix.equals("X") || recupChoix.equals("O")){
            res = recupChoix;
        }else {
            res = "Choisir entre X ou O en majuscule!!!";
        }
        return res;
    }


}
