//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static double plusPetitCarreSupN(int n){
        double result = 0;
        for(int i = 0; i < n; i++){
            if(n%Math.sqrt(n) == 0){
                result = Math.sqrt(n);
            }else{
                n++;
            }
        }
        return result*result;
    }

    public static double plusPetitCarreInfN(int n){

        double result = 0;
        for(int i = n; i > 0; i--){
            if(n%Math.sqrt(n) == 0){
                result = Math.sqrt(n);
            }else{
                n--;
            }
        }
        return result*result;
    }
    public static void main(String[] args) {
        System.out.println(plusPetitCarreSupN(11));
        System.out.println(plusPetitCarreInfN(40));


    }
}