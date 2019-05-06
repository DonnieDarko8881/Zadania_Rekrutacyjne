package rekrutacja.arraysandstrings;

//1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
//      cannot use additional data structures?

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UniqueWord {

    public static boolean checkIfHasUniqueCharacter(String text) {

        char[] chars = text.toCharArray();
        Map<Character, Integer> charsInWord = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (charsInWord.containsKey(chars[i]) == false) {
                charsInWord.put(chars[i], 1);
            } else if (charsInWord.containsKey(chars[i])) {
                charsInWord.put(chars[i], charsInWord.get(chars[i]) + 1);
            }
        }
        List<Character> repeatedCharacterInWord = getRepeatedCharacter(charsInWord);

        if (repeatedCharacterInWord.size() == 0) {
            System.out.println("String has all unique characters");
            return true;
        } else {
            showRepeatedCharacter(charsInWord, repeatedCharacterInWord);
            return false;
        }
    }

    private static void showRepeatedCharacter(Map<Character, Integer> charsInWord, List<Character> repeatedCharacterInWord) {
        System.out.println("Characters which are repeated:");
        for (int i = 0; i < repeatedCharacterInWord.size(); i++) {
            int finalI = i;
            charsInWord.entrySet().stream()
                    .filter(mapOfchar -> mapOfchar.getKey().equals(repeatedCharacterInWord.get(finalI)))
                    .forEach(mapOfChar -> System.out.println("Character: " + mapOfChar.getKey()
                            + " repeats: " + mapOfChar.getValue() + " times"));
        }
    }

    private static List<Character> getRepeatedCharacter(Map<Character, Integer> charsInWord) {
        return charsInWord.entrySet().stream()
                    .filter(letter -> letter.getValue() > 1)
                    .map(letter -> letter.getKey())
                    .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        checkIfHasUniqueCharacter("asdfdkjsadjkkl");
    }
}

