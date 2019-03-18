package opgave02;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import opgave01.ArrayStack;

public class Application {

	public static boolean checkParenteses(String s) {
		ArrayStack<Character> parenteses = new ArrayStack<>();

		try {
			for (int i = 0; i < s.length(); i++) {
				switch (s.charAt(i)) {
				case '(':
					parenteses.push('(');
					break;
				case ')':
					if (parenteses.pop() != '(') {
						return false;
					}
					break;
				case '[':
					parenteses.push('[');
					break;
				case ']':
					if (parenteses.pop() != '[') {
						return false;
					}
					break;
				case '{':
					parenteses.push('{');
					break;
				case '}':
					if (parenteses.pop() != '{') {
						return false;
					}
					break;
				}
			}
		} catch (EmptyStackException e) {
			return false;
		} catch (NoSuchElementException e) {
			return false;
		}

		return parenteses.isEmpty();
	}

	public static void main(String[] args) {
		String s0 = "()";
		String s1 = "(}){";
		String s2 = "({][})";
		String s3 = "(3+{5{99{*}}[23[{67}67]]})";

		System.out.println(String.format("Check for %s\n\t%s", s0, checkParenteses(s0)));
		System.out.println(String.format("Check for %s\n\t%s", s1, checkParenteses(s1)));
		System.out.println(String.format("Check for %s\n\t%s", s2, checkParenteses(s2)));
		System.out.println(String.format("Check for %s\n\t%s", s3, checkParenteses(s3)));
	}

}