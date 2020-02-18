package etc;

import java.util.ArrayList;
import java.util.List;

public class Stack {
	public static void main(String[] args) {
		Stack s = new Stack();
		//stack을 활용한 lint
	}
	
	public void lint(String str) {
		str = "(var x = {y: [1, 2, 3]})";
		
		String[] pushTarget = {"(", "{", "["};
		String[] popTarget = {")", "}", "]"};
		
		List checkList = new ArrayList();
		
		char[] arr = str.toCharArray();
		for (char c : arr) {
			for (String target : pushTarget) {
				if (target.equals(c)) {
					checkList.add(c);
				}
			}
		}
	}
}
