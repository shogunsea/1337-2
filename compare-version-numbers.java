// Compare two version numbers version1 and version1.
// If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

// You may assume that the version strings are non-empty and contain only digits and the . character.
// The . character does not represent a decimal point and is used to separate number sequences.
// For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

// Here is an example of version numbers ordering:

// 0.1 < 1.1 < 1.2 < 13.37
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        boolean oneLonger = v1.length > v2.length;
        int minLen = oneLonger? v2.length : v1.length;

        for (int i = 0; i < minLen; i++) {
            int digitA = Integer.parseInt(v1[i]);
            int digitB = Integer.parseInt(v2[i]);
            if (digitA > digitB) {
                return 1;
            } else if (digitA < digitB) {
                return -1;
            } else {
                continue;
            }
        }

        String[] longer =  oneLonger? v1 : v2;
        int longLen = longer.length;
        int sum = 0;
        for (int j = minLen; j < longLen; j++) {
            int digit = Integer.parseInt(longer[j]);
            sum += digit;
        }
        if (sum == 0) {
            return 0;
        } else if (oneLonger) {
        	return 1;
        } else {
        	return -1;
        }
    }
}