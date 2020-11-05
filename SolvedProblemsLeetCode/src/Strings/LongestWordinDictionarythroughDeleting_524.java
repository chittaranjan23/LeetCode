package Strings;

import java.util.List;

public class LongestWordinDictionarythroughDeleting_524 {
    public String findLongestWord(String s, List<String> d) {
        String longestStr = "";
        for (String dict : d) {
            int index = 0;
            for (char ch : s.toCharArray()) {
                if (index < dict.length() && ch == dict.charAt(index)) index++;
            }
            if (index == dict.length() && dict.length() >= longestStr.length()) {
                if(dict.length()> longestStr.length() || dict.compareTo(longestStr)<0)
                    longestStr=dict;
            }
        }
        return longestStr;
    }
}
