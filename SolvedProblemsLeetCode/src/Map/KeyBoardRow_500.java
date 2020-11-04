package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyBoardRow_500 {
}

class Solution {
    public String[] findWords(String[] words) {
        String[] str = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < str.length; i++) {
            for (char ch : str[i].toCharArray()) {
                map.put(ch, i);
            }
        }
        int index = 0;
        List<String> result = new ArrayList();
        for (String word : words) {
            if (word.equals("")) continue;
            index = map.get(Character.toLowerCase(word.charAt(0)));
            for (char ch : word.toLowerCase().toCharArray()) {
                if (map.get(ch) != index) {
                    index = -1;
                    break;
                }
            }
            if (index != -1) result.add(word);
        }
        return result.toArray(new String[0]);
    }
}