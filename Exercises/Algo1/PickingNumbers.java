package Exercises.Algo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * 
 */

class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     * 
     * 1,1,2,2,3,4,5,6,7,7,8
     */

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        a.sort((b,c)-> b.compareTo(c));
        System.out.println(a);
        int longest = 0;
        int currentLength = 0;
        for (int i = 1; i < a.size(); i++) {
            if(Math.abs(a.get(i) - a.get(i-1)) <= 1){
                if(currentLength > 0 && (Math.abs(a.get(i) - a.get(i-(currentLength))) <= 1)){
                    currentLength ++;
                }
                else if(currentLength == 0){
                    currentLength = currentLength == 0 ? 2: currentLength+1;
                }
                else{
                    longest = currentLength > longest ? currentLength : longest;
                    currentLength = 0;
                    continue;
                }
                
            }
            else{
                longest = currentLength > longest ? currentLength : longest;
                currentLength = 0;
            }

            if(i == a.size()-1 && (currentLength > 0 && longest==0)){
                longest= currentLength;
            }
        }
        return longest;
    }

    public static void main(String[] argsv){
        List<Integer> list = Arrays.asList(
        66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66,66
        );
        System.out.println(pickingNumbers(list));

    }

}