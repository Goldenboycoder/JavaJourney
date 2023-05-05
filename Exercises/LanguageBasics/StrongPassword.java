

class driver{
    

    /*
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     * criteria:

        Its length is at least 6.
        It contains at least one digit.
        It contains at least one lowercase English character.
        It contains at least one uppercase English character.
        It contains at least one special character. The special characters are: !@#$%^&*()-+

        numbers = "0123456789"
        lower_case = "abcdefghijklmnopqrstuvwxyz"
        upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        special_characters = "!@#$%^&*()-+"
     */

    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        
        //System.out.println(password);
        int characterToAdd = 0;

        if(!password.matches(".*\\d+.*")){
            //System.out.println("Has no digit");
            characterToAdd++ ;
        }

        if(!password.matches(".*[a-z].*")){
            //System.out.println("Has no lowercase");
            characterToAdd++ ;
        }

        if(!password.matches(".*[A-Z].*")){
            //System.out.println("Has no uppercase");
            characterToAdd++ ;
        }

        if(!password.matches(".*[!@#$%^&*()+-].*")){
            //System.out.println("Has no lowercase");
            characterToAdd++ ;
        }

        if(password.length() + characterToAdd < 6){
            characterToAdd += 6 - (password.length() + characterToAdd) ;
        }



        return characterToAdd;
    }

    public static void main(String[] args) {
        String password = "AUzs-nV";
        System.out.println(minimumNumber(password.length(), password));

    }
}
