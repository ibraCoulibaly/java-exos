import java.util.ArrayList;

public class Main {
    static ArrayList<String> list;
    static ArrayList<String> getList(){
        if (list == null) {
            list=new ArrayList<>();
            list.add("Jean");
            list.add("Ahmed");
            list.add("Lea");
            list.add("Blanca");
        }
        return list;
    }
    //Q1
    public static String describe(){
        String res = "";
        for(int i = 0; i < getList().size(); i++){
            res += list.get(i) + " " + list.get(i).length() + " \n" ;
        }
        return res;
    }

    //Q2
    /*public static String describe(){
        String res = "";
        for(String e : getList()){
            res += e + " " + e.length() + " \n" ;
        }
        return res;
    }*/

    //Q3
    /*public static String describe(){
        String res = "";

        for(String e : getList()){
            if(e.length() > 4){
                res += e + " " + e.length() + " \n" ;
            }

        }
        return res;
    }*/

    //Q4
    public static String to_upper_case(){
        String res = "";
        for(String e : getList()){
            res += e.toUpperCase() + " \n" ;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(describe());
        System.out.println(to_upper_case());
    }
}