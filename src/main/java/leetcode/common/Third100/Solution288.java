package leetcode.common.Third100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Jason on 7/3/16.
 * Unique Word Abbreviation
 *
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

 a) it                      --> it    (no abbreviation)

 1
 b) d|o|g                   --> d1g

 1    1  1
 1---5----0----5--8
 c) i|nternationalizatio|n  --> i18n

 1
 1---5----0
 d) l|ocalizatio|n          --> l10n
 Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

 Example:
 Given dictionary = [ "deer", "door", "cake", "card" ]

 isUnique("dear") -> false
 isUnique("cart") -> true
 isUnique("cane") -> false
 isUnique("make") -> true
 */
public class Solution288 {

    Map<String, String> map;
    public Solution288(String[] dictionary) {
        map = new HashMap<String, String>();
        for(String str:dictionary){
            String key = abbr(str);
            // If there is more than one string belong to the same key
            // then the key will be invalid, we set the value to ""
            if(map.containsKey(key)){
                if(!map.get(key).equals(str)){
                    map.put(key, "");
                }
            }
            else{
                map.put(key, str);
            }
        }
    }

    public boolean isUnique(String word) {
        return !map.containsKey(abbr(word))||map.get(abbr(word)).equals(word);
    }

    private String abbr(String word) {
        if (word.length() <= 2) {
            return word;
        }
        return String.valueOf(word.charAt(0))
                + String.valueOf(word.length()-2)
                + String.valueOf(word.charAt(word.length()-1));
    }

}
