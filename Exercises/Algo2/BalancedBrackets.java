package Exercises.Algo2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
    */

    public static String isBalanced(String s) {
        // Write your code here
        String no ="NO";
        if(s.length()==1){
            return no;
        }
        String yes = "YES" ;
        
        Deque<String> stack = new ArrayDeque<String>();
        HashMap<String,Integer> brackets = new HashMap<String,Integer>();
        HashMap<Integer,String> closingBrackets = new HashMap<Integer,String>();
        closingBrackets.put(1,"]");
        closingBrackets.put(2,")");
        closingBrackets.put(3,"}");
        brackets.put("[", 1);
        brackets.put("(", 2);
        brackets.put("{", 3);

        if(brackets.get(String.valueOf(s.charAt(0))) == null){
            return no;
        }

        for (int i = 0; i < s.length(); i++) {

            String character = String.valueOf(s.charAt(i));
            if(brackets.get(character) != null ){
                stack.push(character);
            }
            else{
                //System.out.println(stack.peekFirst());
                if( brackets.get(stack.peekFirst()) != null && stack.size() != 0){
                    //String mapedClosing = closingBrackets.get(brackets.get(stack.peekFirst()));
                    if(!closingBrackets.get(brackets.get(stack.peekFirst())).equals(character) ){
                        return no;
                    }
                    else{
                        stack.pop();
                    }
                }
                else{
                    return no;
                }
            }
            //System.out.println(stack.toString());
        }
        return stack.size() == 0 ? yes : no;
    }

    public static void main(String[] argsv){
        String test = "{{}(";
        System.out.println(isBalanced(test));
        
    }

}