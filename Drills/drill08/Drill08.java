import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * For this drill, you will get practice with recursive backtracking. As with
 * the previous drill that emphasized recursion, this drill will be more difficult
 * than other drills for many students. Start early!
 * 
 * Remember these are all recursive backtracking problems. So make sure to ask yourself
 * the questions detailed in the slides. These questions will lead you to the answer.
 * All of the code should be in the general pseudocode shown in the slides. A shortened
 * version:
 * -------------------------------
 * Base Case(s) - if all decisions have been made
 * 
 * Recursive Case - must go through all decisions possible at that point in time
 * 		Choose - choose one decision out of all the options
 * 		Explore - recurse, trying to solve the problem with the choice you just made
 * 		Unchoose - need to undo the choice you made above so that you can try another choice!
 */
public class Drill08 {
    
	
    /* Write a recursive function named canMakeSum that takes a list of
     * integers and an integer target value (sum) and returns true if it is
     * possible to have some set of values from the list that sum to the
     * target value.
     * 
     * For example, the list {2,1,1,3,5} and target value 9 should return true
     * (5 + 3 + 1 = 9).
     * However, the list {5,4,1,6} and target value 8 should return false.
     */
    public static boolean canMakeSum(ArrayList<Integer> list, int sum) {
    	if(sum == 0) {
    		return true;
    	}else if(list.size() == 0) {
    		return false;
    	}
    	for(int i = list.size() - 1; i >= 0; i--) {
    		sum -= list.get(i);
    		int elem = list.remove(i);
    		if(canMakeSum(list, sum)) {
    			return true;
    		}
    		sum += elem;
    		list.add(i, elem);
    	}
    	return false;
    }
    
    
    
    /* Write a recursive function named longestCommonSubsequence that returns the
     * longest common subsequence of two strings. Recall that if a string is a subsequence
     * of another, each of its letters occurs in the longer string in the same order, but
     * not necessarily consecutively.
     * 
     * Some examples:
     *    longestCommonSubsequence("tyler", "kate") -> "te"
     *    longestCommonSubsequence("hannah", "banana") "anna"
     *    longestCommonSubsequence("she sells", "seashells") "sesells"
     *    longestCommonSubsequence("CS210", "arizona") ""
     */
    public static String longestCommonSubsequence(String s1, String s2) {
    	if (s1.length() == 0 || s2.length() == 0 || s1 == null || s2 == null) {
    		return "";
    	}
    	String retString = "";
    	String result = "";
    	for (int i = 0; i < s1.length(); i++) {
    		String cur = s1.substring(i, i+1);
    		int pos = s2.indexOf(cur);
    		if (pos >= 0) {
    			result = cur + longestCommonSubsequence(s1.substring(i+1), s2.substring(pos+1));
    		}
    		if (result.length() > retString.length()) {retString = result;}
    	}
			return retString;
    }
    
    
    
    
    /* Write a recursive function named editDistance that accepts two string
     * parameters and returns the "edit distance" between the two strings as an
     * integer. Edit distance (also called Levenshtein distance) is the minimum
     * number of "changes" required to get from s1 to s2 or vice versa. A "change"
     * is a) inserting a character,
     *    b) deleting a character, or
     *    c) changing a character to a different character.
     *    
     * Some examples:
     *    editDistance("driving", "diving") -> 1
     *    editDistance("debate", "irate") -> 3
     *    editDistance("football", "cookies") -> 6
     */
    public static int editDistance(String s1, String s2) {
    	if(s1.isEmpty()) {
    		return s2.length();
    	}
    	if(s2.isEmpty()) {
    		return s1.length();
    	}
    	int change = editDistance(s1.substring(1), s2.substring(1)) + (s1.charAt(0) == s2.charAt(0) ? 0 : 1);
    	int add = editDistance(s1, s2.substring(1)) + 1;
    	int remove = editDistance(s1.substring(1), s2) + 1;
    	List<Integer> nums = new ArrayList<>();
    	nums.add(change);
    	nums.add(add);
    	nums.add(remove);
    	int min = Collections.min(nums);
    	return min;
    }

}
