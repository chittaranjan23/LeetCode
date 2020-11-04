package Map;

import java.util.Map;
import java.util.TreeMap;

public class HandofStraights_846 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> map = new TreeMap();
        for(Integer i: hand){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        while(map.size()>0){
            //Get the start key
            Integer key = map.firstKey();
            // From the start key check if there are start+W key inside the map and reduce the count by 1
            // If there are no keys start, start+1, start+2.... start+W-1 keys return false
            for(int start=key;start< key+W;start++){
                if(!map.containsKey(start)) return false;
                //If there is only one key remove key from map
                if(map.get(start)==1) map.remove(start);
                else map.put(start, map.get(start)-1);
            }
        }
        return true;
    }
}
