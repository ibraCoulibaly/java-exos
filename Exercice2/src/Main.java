//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static double plusPetitCarre(int n){
        double result = 0;
        for(int i = 0; i < n; i++){
            if(Math.sqrt(n)%2 == 0){
                result = Math.sqrt(n);
            }else{
                n++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(plusPetitCarre(30));


    }
}