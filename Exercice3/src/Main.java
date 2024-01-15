import java.lang.reflect.Array;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static ArrayList<Integer> fibo(int n){
        ArrayList<Integer> tab = new ArrayList<>();
        int nb1 = 0;
        int nb2 = 1;
        int nb3 = 0;
        int i;
        tab.add(1);
        tab.add(nb2);
        for(i = 2; i < n; i++){
            nb3 = nb1 + nb2;
            nb1 = nb2;
            nb2 = nb3;
            tab.add(nb3);
        }
        return tab;
    }











    public static ArrayList<Double> approximation_fibo(double epsilon){
        ArrayList<Integer> tt = new ArrayList<>();
        double phi = (1+Math.sqrt(5))/2;
        tt = fibo(10);
        double a = tt.get(tt.size()-1);
        double b = tt.get(tt.size()-2);
        double aDivb = a/b;
        ArrayList<Double> tmp = new ArrayList<>();
        tmp.add(a);
        tmp.add(b);
        for(int i = 0; i < tmp.size(); i++){
            if((tt.get(i+1)/tt.get(i)) <= phi ){
                double e1 = tt.get(i+1);
                double e2 = tt.get(i);
                tmp.add(e1);
                tmp.add(e2);
            }
        }
        return tmp;
    }
    public static void main(String[] args) {
        System.out.println(fibo(10));
        //System.out.println(approximation_fibo(0.01));
    }
}