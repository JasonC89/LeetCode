package leetcode.common.Second100;

/**
 * Created by Jason on 6/28/16.
 * Compare Version Numbers
 *
 * Compare two version numbers version1 and version2.
 If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

 Here is an example of version numbers ordering:

 0.1 < 1.1 < 1.2 < 13.37
 */
public class Solution165 {
    public int compareVersion(String version1, String version2) {
        String[] array1 = version1.split("\\.");
        String[] array2 = version2.split("\\.");
        int length = Math.max(array1.length, array2.length);
        for (int i = 0; i < length; i++) {
            int num1 = i < array1.length? Integer.valueOf(array1[i]): 0;
            int num2 = i < array2.length? Integer.valueOf(array2[i]): 0;
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }
        return 0;
    }

    static public void main(String[] args) {
        Solution165 solution165 = new Solution165();
        solution165.compareVersion("1", "0");
    }
}
