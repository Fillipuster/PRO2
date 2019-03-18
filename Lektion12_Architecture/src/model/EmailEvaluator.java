package model;

import java.util.regex.Pattern;

public class EmailEvaluator implements Evaluator {

	@Override
	public boolean isValid(String s) {
		return Pattern.matches("\\A(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*\r\n" + 
				" |  \"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]\r\n" + 
				"      |  \\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")\r\n" + 
				"@ (?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\r\n" + 
				"  |  \\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}\r\n" + 
				"       (?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:\r\n" + 
				"          (?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]\r\n" + 
				"          |  \\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\r\n" + 
				"     \\])\\z", s);
	}

}
