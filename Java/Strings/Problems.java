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

    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }

    public int indexOfLeftmostRepeatingCharacter(String s){
        boolean[] visited = new boolean[256];
        int res = -1;
        for(int i = s.length() - 1; i >= 0; i--){
            if(visited[s.charAt(i)]){
                res = i;
            }else{
                visited[s.charAt(i)] = true;
            }
        }
        return res;
    }

    public int indexOfLeftmostNonRepeatingCharacter(String s){
        int[] count = new int[256];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)]++;
        }
        for(int i = 0; i < s.length(); i++){
            if(count[s.charAt(i)] == 1){
                return i;
            }
        }
        return -1;
    }

    public void reverseWords(char[] s){
        reverse(s, 0, s.length - 1);
        int start = 0;
        for(int i = 0; i < s.length; i++){
            if(s[i] == ' '){
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        reverse(s, start, s.length - 1);
    }

    private void reverse(char[] s, int start, int end){
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args){
        
    }
}