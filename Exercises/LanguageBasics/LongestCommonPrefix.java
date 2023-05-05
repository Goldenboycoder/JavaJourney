public class LongestCommonPrefix {

    public static String longestCommonPrefixf(String[] strs) {
        String res = "";
        // naive approach
        String ex = strs[0];
        int exIndexCommon = ex.length()-1;
        if(strs.length == 1){
            return res = ex;
        }

        for(int i=1;i<strs.length;i++){
            int secondWordLength = strs[i].length();
            int limit = 1;
            boolean isExLonger = false;
            int exIndex = -1;
            if(ex.length()>=secondWordLength){
                limit=ex.length();
                isExLonger=true;
            }
            else{
                limit = secondWordLength;
            }

            for(int j= 0; j< limit; j++){
                if(isExLonger){

                    if(j > strs[i].length()-1){
                        break;
                    } 
                }
                else{
                    if(j > ex.length()-1){
                        break;
                    }
                }

                if(ex.charAt(j) == strs[i].charAt(j)){
                    exIndex++;
                }
                else{
                    break;
                }
            }


            if(exIndex< exIndexCommon){
                exIndexCommon = exIndex;
            }
        }

        res = new StringBuilder(ex.substring(0, exIndexCommon+1)).toString();
        return res;
    }


    public static void main(String[] args) {
        String[] strs = new String[]{"d"};
        System.out.println(longestCommonPrefixf(strs));

    }
}
