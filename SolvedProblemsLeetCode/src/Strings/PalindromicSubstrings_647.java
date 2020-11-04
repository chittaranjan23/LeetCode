package Strings;

public class PalindromicSubstrings_647 {
    int count = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            //Check for odd and even length strings and note or count the number of palindromes
            countPalandrome(s, i, i);
            countPalandrome(s, i, i + 1);
        }
        return count;
    }


    public void countPalandrome(String s, int i, int j) {
        if (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }
    }
}
