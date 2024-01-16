import java.util.ArrayList;

public class Main {

    //Q1
    /*public static String describe(){
        String res = "";
        ArrayList<String> list = new ArrayList<>();
        list.add("Jean");
        list.add("Ahmed");
        list.add("Lea");
        list.add("Blanca");
        for(int i = 0; i < list.size(); i++){
            res += list.get(i) + " " + list.get(i).length() + " \n" ;
        }
        return res;
    }*/

    //Q2
    /*public static String describe(){
        String res = "";
        ArrayList<String> list = new ArrayList<>();
        list.add("Jean");
        list.add("Ahmed");
        list.add("Lea");
        list.add("Blanca");
        for(String e : list){
            res += e + " " + e.length() + " \n" ;
        }
        return res;
    }*/

    //Q3
    public static String describe(){
        String res = "";
        ArrayList<String> list = new ArrayList<>();
        list.add("Jean");
        list.add("Ahmed");
        list.add("Lea");
        list.add("Blanca");
        for(String e : list){
            if(e.length() > 4){
                res += e + " " + e.length() + " \n" ;
            }

        }
        return res;
    }

    //Q4
    public static String to_upper_case(){
        String res = "";
        ArrayList<String> list = new ArrayList<>();
        list.add("Jean");
        list.add("Ahmed");
        list.add("Lea");
        list.add("Blanca");
        for(String e : list){
            res += e.toUpperCase() + " \n" ;
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(describe());
        System.out.println(to_upper_case());
    }
}