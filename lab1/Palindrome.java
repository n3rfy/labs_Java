public class Palindrome{
    public static void main(String [] args){
        for (int i = 0; i < args.length; i++){
            String s = args[i];
            System.out.println(isPalindrome(s));
        }
    }
    public static String reverseString(String s){
        String new_string = "";
        int len_string = s.length();
        for (int i = 1; i <= len_string; i++){
            int var = len_string - i;
            new_string += s.charAt(var);
        }
        return new_string;
    }
    public static boolean isPalindrome(String s){
        String new_string = reverseString(s);
        return s.equals(new_string);
    }

}
