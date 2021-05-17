package _01_TestMatchingBrackets;

import java.util.Iterator;
import java.util.Stack;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
    public static boolean doBracketsMatch(String b) {
    	Stack <String> bracket = new Stack <String>();
    	for (int i = 0; i < b.length(); i++) {
			if (b.charAt(i) == '{') {
				bracket.push("{");
			}
			if (b.charAt(i) == '}') {
				if (bracket.isEmpty()) {
					return false;
				}
				bracket.pop();
			}
		}
    	if (bracket.isEmpty()) {
			return true;
		}else {
			return false;
		}
    }
}