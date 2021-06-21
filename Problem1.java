// Counting duplicate characters: Write a program that counts duplicate characters from a given string.

import java.util.Map;
import java.util.stream.Collectors;

public class Problem1 {
    public static void main(String[] args) {
        System.out.println(countDuplicateCharacters("abcbccddeeeff"));
    }

    public static Map<String, Long> countDuplicateCharacters(String str) {
        return str.codePoints()
                  .mapToObj(c -> String.valueOf(Character.toChars(c)))
                  .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }
}
