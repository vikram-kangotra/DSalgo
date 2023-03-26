public class AnagramSearch {
   
    /*
     * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once.
     * 
     * Given a String text and a String pattern, check if the pattern is an anagram of any substring of text.
     */

    public boolean isAnangramPresent(String text, String pattern){
        int[] countT = new int[256];
        int[] countP = new int[256];
        for(int i = 0; i < pattern.length(); i++){
            countT[text.charAt(i)]++;
            countP[pattern.charAt(i)]++;
        }
        for(int i = pattern.length(); i < text.length(); i++){
            if(isSame(countT, countP)){
                return true;
            }
            countT[text.charAt(i)]++;
            countT[text.charAt(i - pattern.length())]--;
        }
        return false;
    }

    private boolean isSame(int[] countT, int[] countP){
        for(int i = 0; i < 256; i++){
            if(countT[i] != countP[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        AnagramSearch as = new AnagramSearch();
        System.out.println(as.isAnangramPresent("anagram", "rag"));
    }

}
