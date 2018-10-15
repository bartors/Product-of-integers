import java.util.ArrayList;

public class Product {
    private Integer first;
    private Integer second;
    private Integer third;

    public Product(){

    }

    public int product(ArrayList<Integer> list){
        first=Integer.MIN_VALUE;
        second=Integer.MIN_VALUE;
        third=Integer.MIN_VALUE;
        int length = list.size();
        for(int i =0;i<length;i++){
            //check if is bigger than third biggest number
            if(list.get(i)>third){
                //check if is bigger than second biggest number
                if(list.get(i)>second){
                    //check if is bigger than biggest number
                    if(list.get(i)>first){
                        third=second;
                        second=first;
                        first=list.get(i);
                    }else{
                        third=second;
                        second=list.get(i);

                    }
                }else{
                    third=list.get(i);
                }
            }
        }
        return first*second*third;
    }
}
