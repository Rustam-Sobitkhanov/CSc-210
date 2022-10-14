import java.util.ArrayList;
import java.util.List;

public class Drill03 {

	/*
	 * Takes a string and two characters as parameters.
	 * Returns a string that is the same as the passed in string
	 * except that all occurrences of the first character are replaced
	 * with the second.
	 * You must use recursion to solve this problem.
	 */
	public static String replaceAll(String s, char from, char to) {
		if (s.length() > 0) {
			if (s.charAt(0) == from) {
				return to + replaceAll(s.substring(1), from, to);
			}
			return s.charAt(0) + replaceAll(s.substring(1), from, to);
		}else{
			return "";
		}
	}

	/*
	 * Takes an integer as a parameter.
	 * Returns true if the digits are in sorted order ascending.
	 * Returns false otherwise.
	 * You must use recursion to solve this problem.
	 */
	public static boolean digitsSorted(int x) {
		if (x < 0){
			x = x * -1;
		}
		int prev = x % 10;
		int actualNum = x / 10;
		if (actualNum > 0){
			if (prev >= actualNum % 10){
				if (digitsSorted(actualNum) == false){
					return false;
				}
			}else {
				return false;
			}
		}
		return true;
	}

	/*
	 * Write a recursive function which returns the input string
	 * but with adjacent duplicate characters removed. Do not use
	 * any String functions other than .charAt(), .length(), .isEmpty()
	 * and .substring(). Do not use any loops. We recommend you use a
	 * helper function, so we have provided the helper function header
	 * below
	 * You must use recursion to solve this problem.
	 */
	public static String removeAdjacentDuplicateChars(String s) {
		if (s.length() >= 2){
			if (s.charAt(0) == s.charAt(1)){
				return removeAdjacentDuplicateChars(s.substring(1));
			}
			return s.charAt(0) + removeAdjacentDuplicateChars(s.substring(1));
		}
		return s;
	}
	// Note that the helper function is 'private' since no other code
	// outside of this file needs to call this method.
	private static String removeHelper(String s, int index) {
		return "";
	}

	/*
	 * Write a recursive function that returns the number of occurrences
	 * of an integer ’n’ inside of an array of integers. You may not use
	 * loops or any array functions. You may use array.length to determine
	 * the length of the array. We recommend you use a helper similar to the
	 * one above. It would be useful if your helper function kept track of
	 * which index in the array you are currently checking.
	 * You must use recursion to solve this problem.
	 */
	public static int countOccurrences(int[] arr, int n) {
		return countHelper(arr.length - 1, n, arr);
	}
	private static Integer countHelper(int index, int n, int[] arr) {
		if (index > 0) {
			if (arr[index] == n) {
				return 1 + countHelper(index - 1, n, arr);
			} else {
				return countHelper(index - 1, n, arr);
			}
		}else{
			return 0;
		}
	}

}
