package Exercises.Algo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Result1 {

    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        Map<Integer,Integer> candlesMap = new HashMap<Integer,Integer>();

        for (int i = 0; i < candles.size(); i++) {
            if(candlesMap.containsKey(candles.get(i))){
                candlesMap.put(candles.get(i), candlesMap.get(candles.get(i)) + 1) ;
            }
            else{
                candlesMap.put(candles.get(i), 1);
            }
        }

        List <Integer> list = new ArrayList<Integer>(candlesMap.keySet());
        list.sort((a,b)-> a.compareTo(b));
        return candlesMap.get(list.get(list.size()-1));
    }



    public static void main(String[] argsv){
        List<Integer> list = Arrays.asList(3, 2, 1, 3);
        System.out.println(birthdayCakeCandles(list));

    }
}