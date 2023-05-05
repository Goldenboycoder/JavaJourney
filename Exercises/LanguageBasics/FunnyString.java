public class FunnyString {
    
    public static String funnyString(String s) {
        // Write your code here
        String funny = "Funny";
        String notfunny = "Not Funny";

        for(int i = 0; i<s.length();i++){

            if(i <= s.length()-2){
                //o
                Math.abs(i);
                //r
                int rIndex = (s.length()-1) - i;

                if(
                    Math.abs(s.charAt(i)-s.charAt(i+1)) != Math.abs(s.charAt(rIndex)-s.charAt(rIndex-1))
                ){
                    return notfunny;
                }
                 
            }
            else
                break;

            
            
        }

        return funny;
    }

    public static void main(String[] args) {
        String str = "bcxz";
        System.out.println(funnyString(str));

    }
}
