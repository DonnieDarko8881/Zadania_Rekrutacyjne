package rekrutacja.arraysandstrings;

import java.util.*;

public class PermutationWord {

    public boolean checkIfWordsArePemutationEachOther(String wordA, String wordB){
        char[] arrayOfCharacterWordA = wordA.toCharArray();
        char[] arrayOfCharacterWordB = wordB.toCharArray();

        Map<Character, Integer> mapOfCharacterWordA =getMapOfCharacter(arrayOfCharacterWordA);
        Map<Character, Integer> mapOfCharacterWordB =getMapOfCharacter(arrayOfCharacterWordB);

        if(arrayOfCharacterWordA.length!=arrayOfCharacterWordB.length){
            return false;
        }

        for (Character character :mapOfCharacterWordA.keySet()) {
            if(!mapOfCharacterWordB.containsKey(character)
                    || !(mapOfCharacterWordA.get(character).equals(mapOfCharacterWordB.get(character))) ){
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> getMapOfCharacter(char[] arrayOfCharacterWord) {
        Map<Character, Integer> mapOfCharacterWord = new HashMap<>();
        for (int i = 0; i < arrayOfCharacterWord.length; i++) {
            if (mapOfCharacterWord.containsKey(arrayOfCharacterWord[i]) == false) {
                mapOfCharacterWord.put(arrayOfCharacterWord[i], 1);
            } else if ( mapOfCharacterWord.containsKey(arrayOfCharacterWord[i])) {
                mapOfCharacterWord.put(arrayOfCharacterWord[i],  mapOfCharacterWord.get(arrayOfCharacterWord[i]) + 1);
            }
        }
        return  mapOfCharacterWord;
    }

    public static void main(String[] args) {
        PermutationWord permutationWord = new PermutationWord();
        System.out.println(permutationWord.checkIfWordsArePemutationEachOther("zupaz", "pazuz"));

    }
}
