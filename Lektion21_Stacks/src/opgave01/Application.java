package opgave01;

public class Application {

	public static void main(String[] args) {
		
//		ArrayStack<String> stack = new ArrayStack<>();
		LinkedListStack<String> stack = new LinkedListStack<>();
		
		String[] stackType = stack.getClass().toString().split(".");
		System.out.println(stackType.length);
		System.out.println("Testing for stacktype : " + stackType[0]);
		
		System.out.println("\tCreating stack...");
		stack.push("World");
		stack.push("Hello");
		System.out.println(stack + "\n");
		
		System.out.println("\tPeeking...");
		System.out.println(stack.peek());
		System.out.println(stack + "\n");
		
		System.out.println("\tPopping...");
		System.out.println(stack.pop());
		System.out.println(stack + "\n");
		
		System.out.println("\tOverload checking...");
		for (int i = 0; i < 100; i++) {
			stack.push(String.valueOf(i));
		}
		System.out.println(stack);
		
	}

}
