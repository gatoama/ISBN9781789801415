// Finding the first non-repeated character: Write a program that returns the first non-repeated character from a given string.

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problem2 {
    private static final int EXTENDED_ASCII_CODES = 256;

    public static void main(String[] args) {
        String s = firstNonRepeatedCharacter("aabbccbbccdeeeff");
        System.out.println(s);
    }

    public static String firstNonRepeatedCharacter(String str) {

        Map<Integer, Long> chs = str.codePoints()
                                    .mapToObj(cp -> cp)
                                    .collect(Collectors.groupingBy(Function.identity(),
                                                                   LinkedHashMap::new, Collectors.counting()));

        int cp = chs.entrySet().stream()
                    .filter(e -> e.getValue() == 1L)
                    .findFirst()
                    .map(Map.Entry::getKey)
                    .orElse(Integer.valueOf(Character.MIN_VALUE));

        return String.valueOf(Character.toChars(cp));
    }
}
