package opgave03;

public class Application {

	public static void main(String[] args) {
		ArrayDropOutStack<Integer> stack = new ArrayDropOutStack<>(4);
//		LinkedDropOutStack<Integer> stack = new LinkedDropOutStack<>(4);
		
		stack.display();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Pushing " + i + "...");
			stack.push(i);
			stack.display();
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Pop! " + stack.pop());
		}
	}

}
