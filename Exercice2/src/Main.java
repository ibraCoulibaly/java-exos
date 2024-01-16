//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static double plusPetitCarreSupN(int n){

        while(n % Math.sqrt(n) != 0){
            n++;
        }
        return n;
    }

    public static double plusPetitCarreInfN(int n){

        while(n % Math.sqrt(n) != 0){
            n--;
        }
        return n;
    }

//        double result = 0;
//        for(int i = n; i > 0; i--){
//            if(n%Math.sqrt(n) == 0){
//                result = Math.sqrt(n);
//            }else{
//                n--;
//            }
//        }
//        return result*result;
//    }
    public static void main(String[] args) {
        System.out.println(plusPetitCarreSupN(59));
        System.out.println(plusPetitCarreSupN(64));
        System.out.println(plusPetitCarreInfN(63));

    }
}