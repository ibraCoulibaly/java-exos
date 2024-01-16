import java.lang.reflect.Array;
import java.util.ArrayList;











//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static ArrayList<Integer> fibo(int n){
        ArrayList<Integer> tab = new ArrayList<>();
        int nb1 = 0;
        int nb2 = 1;
        int suivant;

        tab.add(nb1);
        tab.add(nb2);
        for(int i =  2; i < n; i++){
            suivant = nb1 + nb2;
            nb1 = nb2;
            nb2 = suivant;
            tab.add(suivant);
        }
        return tab;
    }




    public static double[] approximation_fibo(double x) {
        double phi = (1.0 + Math.sqrt(5.0)) / 2.0;
        double a = 2;
        double b = 1;
        double c = 1;

        while (Math.abs((a / b) - phi) >= x) {
                c = b;
                b = a;
                a = b + c;
        }
        double[] ans = {a, b};
        return ans;
    }









    public static void main(String[] args) {
        //System.out.println(fibo(10));
        double[] result = approximation_fibo(0.01);
        System.out.println("{" + (int)result[0] + ", " + (int)result[1] + "}");
        //System.out.println(approximation_fibo(0.01));


    }
}