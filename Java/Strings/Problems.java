public class Problems{

    public boolean isPalindrome(String s){
        if(s.length() == 0 || s.length() == 1){
            return true;
        }
        int begin = 0;
        int end = s.length() - 1;
        while(begin < end){
            if(s.charAt(begin) != s.charAt(end)){
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    public boolean isSubsequence(String s, String t){
        if(s.length() == 0){
            return true;
        }
        int index = 0;
        for(int i = 0; i < t.length(); i++){
            if(s.charAt(index) == t.charAt(i)){
                index++;
            }
            
        }
        return index == s.length();
    }

    public static void main(String[] args){
        
    }
}