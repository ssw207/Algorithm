package com.prac.src.real.real4;

import java.util.ArrayList;
import java.util.List;

public class Stack {
	public static void main(String[] args) {
		Stack stack = new Stack();
		//stack을 활용한 lint
		String str = "(var x = {y: [1, 2, 3]})";
		stack.lint(str);
	}
	
	/*
	 * 1.입력받은 문자열을 char[] 로 쪼갠다.
	 * 2.배열에서 하나씩꺼내 여는 괄호이면 checkList에 add한다.
	 * 3.배열에서 하나씩꺼내 닫는 괄호이면 checkList에서 마지막에 add한 값을 꺼내 매칭되는 괄호이면 checkList를 pop한다.
	 * 4.checkList가 비어있지 않으면 괄호를 닫지 않았으므로 에러발생
	 */
	char[] openingBranch = {'(', '{', '['};
	char[] closingBranch = {')', '}', ']'};
	
	List<Character> checkList = new ArrayList<Character>();
	
	public void lint(String str) {
		
		char[] checkArr = str.toCharArray();
		
		for (int i = 0; i < checkArr.length; i++) {
			char c =checkArr[i];
			
			if(isOpeningBranch(c)) {
				checkList.add(c);
				
			} else if (isClosingBranch(c)){
				if(isClosingRecentOpenedBranch(c)) {
					checkList.remove(checkList.size()-1);
				} else {
					int idx = checkList.size()-1;
					System.out.println(checkList.get(idx) +"괄호를 닫지 않았습니다. index : "+i);
					return;
				}
			}
		}
		
		if(checkList.size() != 0) {
			System.out.println(checkList.get(0) +"괄호를 닫지 않았습니다.");
		}
	}

	private boolean isClosingRecentOpenedBranch(char c) {
		if (checkList.size() == 0) {
			return false;
		}
		
		char lastAddedBranch = checkList.get(checkList.size()-1);
		
		if(getPairBranch(lastAddedBranch) == c) {
			return true;
		}
		
		return false;
	}

	private boolean isClosingBranch(char c) {
		for (char branch : closingBranch) {
			if (branch == c) {
				return true;
			}
		}
		return false;
	}

	private boolean isOpeningBranch(char c) {
		for (char branch : openingBranch) {
			if (branch == c) {
				return true;
			}
		}
		return false;
	}
	
	private char getPairBranch(char c) {
		switch (c) {
		case '(':
			return ')';
		case '{':
			return '}';
		case '[':
			return ']';
		default:
			return c;
		}
	}
}
