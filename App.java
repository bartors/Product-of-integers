import java.util.ArrayList;

public class App {

    public static void main(String[] arg){
        Product p = new Product();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(3);
        list.add(3);
        System.out.println(p.product(list));
    }
}
