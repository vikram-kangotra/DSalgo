import java.util.List;
import java.util.ArrayList;
public class PatternSearch {
    
    // Rabin-Karp algorithm
    /*
     * 1. Compute the hash value of the pattern
     * 2. Compute the hash value of the first window of text
     * 3. Compare the hash value of the pattern and the first window of text
     * 4. If the hash value of the pattern and the first window of text are the same, compare the pattern and the first window of text
     * 5. If the hash value of the pattern and the first window of text are not the same, compute the hash value of the next window of text
     * 6. Repeat step 3 to 5 until the end of the text
     */
    
    public static final int d = 256;
    /* pat -> pattern
        txt -> text
        q -> A prime number
    */

    public List<Integer> search1(String pat, String txt, int q){
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;
 
        List<Integer> occurrences = new ArrayList<>();
        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;

        // Calculate the hash value of pattern and first window of text
        for (i = 0; i < M; i++){
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++){
            // Check the hash values of current window of text and pattern. If the hash values match then only check for characters on by one
            if ( p == t ){
                /* Check for characters one by one */
                for (j = 0; j < M; j++){
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }
                // if p == t and pat[0...M-1] = txt[i, i + 1, ...i + M-1]
                if (j == M)
                    occurrences.add(i);
            }
            // Calculate hash value for next window of text: Remove leading digit, add trailing digit
            if ( i < N - M ){
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
                // We might get negative value of t, converting it to positive
                if (t < 0)
                    t = (t + q);
            }
        }
        return occurrences;
    }

    // KMP algorithm
    /*
     * 1. Compute the longest proper prefix which is also a suffix for each character of the pattern
     * 2. Compare the pattern and the text
     * 3. If the pattern and the text are the same, return the index of the first character of the pattern
     * 4. If the pattern and the text are not the same, compare the pattern and the text from the index of the longest proper prefix which is also a suffix of the pattern
     * 5. Repeat step 2 to 4 until the end of the text
     
     */

     /*
      * Construction of lps array
        * 1. lps[0] = 0
        * 2. lps[i] = lps[i - 1] + 1 if pat[i] == pat[lps[i - 1]]
        * 3. lps[i] = lps[lps[i - 1]] if pat[i] != pat[lps[i - 1]]

      */

    private int[] generateLPS(String pattern){
        int[] lps = new int[pattern.length()];
        int i = 1, len = 0;

        while (i < pattern.length()){
            if (pattern.charAt(i) == pattern.charAt(len)) { // If the characters at indices i and len match
                len++; // Increment len
                lps[i] = len; // Store the length of the longest proper prefix that is also a suffix ending at index i in the lps array
                i++; // Increment i
            } else {
                if (len != 0) { // If len is non-zero
                    len = lps[len - 1]; // Update len to the length of the longest proper prefix that is also a suffix ending at index len - 1
                } else { // If len is zero
                    lps[i] = len; // Store the value of len (which is 0) in the lps array at index i
                    i++; // Increment i
                }
            }
        }
        return lps;
    }

    public List<Integer> search2(String text, String pattern){
        List<Integer> occurrences = new ArrayList<>();

        // Preprocess the pattern to generate the lps array
        int[] lps = generateLPS(pattern);
        int i = 0, j = 0; // i is the index for text and j is the index for pattern
        while (i < text.length()){
            if (pattern.charAt(j) == text.charAt(i)){ // If the characters at indices i and j match
                i++; // Increment i
                j++; // Increment j
            }
            if (j == pattern.length()){ // // If the entire pattern string has been matched
                occurrences.add(i - j); // Add the index of the first character of the pattern in the text to the occurrences list
                j = lps[j - 1]; // Update j to the length of the longest proper prefix that is also a suffix ending at index j - 1
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)){ // If there is a mismatch between the text and pattern at index i and j
                if (j != 0) // If j is non-zero
                    j = lps[j - 1]; // Update j to the length of the longest proper prefix that is also a suffix ending at index j - 1
                else // If j is zero
                    i++; // Increment i
            }
        }
        return occurrences;
    }
    

    

    public static void main(String[] args){
        String txt = "GEEKS FOR GEEKS";
        String pat = "GEEK";
        int q = 101; // A prime number
        PatternSearch ps = new PatternSearch();
        List<Integer> occurrences1 = ps.search1(pat, txt, q);
        System.out.println(occurrences1);
        List<Integer> occurrences2 = ps.search2(txt, pat);
        System.out.println(occurrences2);
    }
}
