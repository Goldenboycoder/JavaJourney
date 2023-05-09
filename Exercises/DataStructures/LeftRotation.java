
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftRotation{
    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        // [1,2,3,4,5]
        // d= 1 [2,3,4,5,1]
        int effectiveShifts = d % arr.size(); // no need to loop more than the array size
        for(int i =0 ;i < effectiveShifts;i++){
            arr.add(arr.remove(0));
        }
        return arr;
    }

    public static void main(String[] args){
        List<Integer> arr = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        System.out.println(rotateLeft(4, arr));
    }


}