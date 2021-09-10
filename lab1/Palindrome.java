public class Palindrome{
    public static void main(String [] args){
        ///the main function starts a cycle all words
        for (int i = 0; i < args.length; i++){
            String s = args[i];
            System.out.println(isPalindrome(s));
        }
    }
    public static String reverseString(String s){
        ///returns reverse words 
        String new_string = "";
        int len_string = s.length();
        for (int i = 1; i <= len_string; i++){
            int var = len_string - i;
            new_string += s.charAt(var);
        }
        return new_string;
    }
    public static boolean isPalindrome(String s){
        ///returns whether the word is Palindrome
        String new_string = reverseString(s);
        return s.equals(new_string);
    }

}
