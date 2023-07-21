package Exercises.Algo1;

class Solution {
    
    public static boolean isPalindrome(int x) {
        String test = String.valueOf(x);
        if(test.length()==2 && (test.charAt(0) != test.charAt(1))){
            return false;
        }
        int leftIndex= test.length()%2 == 0 ? (test.length()/2) -1:  (test.length()/2 )-1;
        int rightIndex= test.length()%2 == 0 ? (test.length()/2) :  test.length()/2 +1;
        // 1223
        for(int i =0 ; i< (int)(test.length()/2);i++){

            if(test.charAt(leftIndex-i) != test.charAt(rightIndex+i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] argsv){
        
        System.out.println(isPalindrome(10));

    }
}
