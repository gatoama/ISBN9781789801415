// Counting duplicate characters: Write a program that counts duplicate characters from a given string.

import java.util.Map;
import java.util.stream.Collectors;

public class Problem1 {
    public static void main(String[] args) {
        String dupStr = "abcbccddeeeff";
        Map<Character, Long> result = countDuplicateCharacters(dupStr);
        System.out.println(result);
    }

    public static Map<Character, Long> countDuplicateCharacters(String str) {
        return str.chars()
                  .mapToObj(c -> (char) c)
                  .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }
}
