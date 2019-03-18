package model;

public class NumberEvaluator implements Evaluator {

	@Override
	public boolean isValid(String s) {
		try {
			Double.parseDouble(s);			
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
}
