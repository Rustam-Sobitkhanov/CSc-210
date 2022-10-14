import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Drill02 {
	
	/* -------- Stacks/Queues -------- */
 
	/*
	 * Given a stack as input, return a stack that has the same
	 * values, but in reverse order.
	 * Remember you can always view the testcases in this project for
	 * expected results.
	 */
	static Stack<Integer> reverseStack(Stack<Integer> in) {
		Stack<Integer> stack = new Stack<>();
		while (!in.isEmpty()){
			stack.add(in.pop());
		}
		return stack;
	}

	/*
	 * Given a queue, return a new queue that has the same values in
	 * reverse order.
	 * Remember you can always view the testcases in this project for
	 * expected results.
	 */
	static Queue<Integer> reverseQueue(Queue<Integer> in) {
		Queue<Integer> out = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		while (!in.isEmpty()){
			stack.push(in.remove());
		}
		while (!stack.isEmpty()){
			out.add(stack.pop());
		}
		return out;
	}
	
	
	/* -------- Recursion -------- */

	/*
	 * Takes a number of characters to print as a parameter and returns
	 * a String with one or two asterisks in the middle surrounded by
	 * alligators.
	 * See the file included in this project: drill02-README.md
	 * Remember you can always view the testcases in this project for
	 * expected results.
	 */
    public static String zigzag(int n) {
		if (n == 1 | n ==2){
			return new String(new char[n]).replace("\0", "*");
		}
		return "<" + (zigzag(n - 2)) + ">";
    }

    /*
     * Takes a String and a character as parameters and returns
     * the string with all copies of the character moved to the end
     * and capitalized.
     * See the file included in this proejct: drill02-README.md
     * Remember you can always view the testcases in this project for
	 * expected results.
     */
    public static String moveToEnd(String s, char c) {
		boolean matches = Character.toString(s.charAt(0)).equalsIgnoreCase(Character.toString(c));
		if (s.isEmpty()) return "";
		else if (s.length() < 2){
			if (matches){
				return Character.toString(c).toUpperCase();
			}
			return s;
		} else if(matches){
			return moveToEnd(s.substring(1), c) + Character.toUpperCase(c);
		}
		return s.charAt(0) + moveToEnd(s.substring(1), c);
    }

}
