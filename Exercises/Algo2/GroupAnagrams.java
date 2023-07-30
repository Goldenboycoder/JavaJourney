package Exercises.Algo2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution1 {
    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> anagrams = new ArrayList<List<String>>();
        HashMap<String,List<String>> buckets = new HashMap<String,List<String>>();
        for (String word : strs) {
            if(!word.equals("")){
                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                String sortedString = new String(chars);
                if(buckets.containsKey(sortedString)){
                    buckets.get(sortedString).add(word);
                }
                else{
                    List<String> newgroup = new ArrayList<String>();
                    newgroup.add(word);
                    buckets.put(sortedString, newgroup);
                }
            }
            else{
                if(buckets.containsKey(word)){
                    buckets.get(word).add(word);
                }
                else{
                    List<String> newgroup = new ArrayList<String>();
                    newgroup.add(word);
                    buckets.put(word, newgroup);
                }
            }
        }

        for (List<String> list : buckets.values()) {
            anagrams.add(list);
        }
        return anagrams;
    }


    public static void main(String[] argsv){
        String[] test = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(test));
        
    }
}