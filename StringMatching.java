// WAP to implement Naive String Matching Algorithm. Show all the comparisons the naive string matcher makes for the Pattern P and text T
public class StringMatching {
    public static void naiveStringMatcher(String T, String P) {
        int n = T.length();
        int m = P.length();
        int comparisons = 0;
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && T.charAt(i + j) == P.charAt(j)) {
                j++;
                comparisons++;
            }
            if (j == m) {
                System.out.println("Pattern found at index " + i);
            }
        }
        System.out.println("Total comparisons: " + comparisons);
    }    
    public static void main(String[] args) {
        naiveStringMatcher("abababab", "ab");
    }
}
