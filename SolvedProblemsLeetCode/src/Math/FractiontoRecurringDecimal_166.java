package Math;

import java.util.HashMap;
import java.util.Map;

public class FractiontoRecurringDecimal_166 {
    public String fractionToDecimal(int numerator, int denominator) {
        //Return if numerator is 0;
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        //Check any of the value is neg and mark or append to result the negative value
        if (numerator < 0 ^ denominator < 0) sb.append("-");

        //Convert to long to handle overflow
        Long num = Math.abs(Long.valueOf(numerator));
        Long denm = Math.abs(Long.valueOf(denominator));

        long remainder = num % denm;
        sb.append(String.valueOf(num / denm));

        //Check if remainder is 0 if yes return result;
        if (remainder == 0) return sb.toString();
        sb.append(".");
        Map<Long, Integer> map = new HashMap();

        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(String.valueOf(remainder / denm));
            remainder %= denm;
        }
        return sb.toString();
    }
}

