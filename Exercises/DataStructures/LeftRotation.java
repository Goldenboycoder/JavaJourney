
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftRotation{
    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        // [1,2,3,4]
        // d= 1 [2,3,4,1]
        int size = arr.size();
        List<Integer> arr2 = new ArrayList<>(arr.size());
        for(int i =0 ;i<arr.size();i++){
            System.out.println("At index "+i+" value"+arr.get(i));
            int nidx =  (i + d ) % arr.size() -1; 
            arr2.set(nidx, arr.get(i)) ;
        }
        return arr2;
    }

    public static void main(String[] args){
        List<Integer> arr = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        System.out.println(rotateLeft(2, arr));
    }


}