package opgave02;

public class MainApp {

	public static void main(String[] args) {
		// Counter conter = new Counter(); // Fails, constructor is private;
		
		Counter counter = Counter.getInstance();
		System.out.println(counter);
		
		counter.count();
		System.out.println(counter);
		
		counter.times2();
		System.out.println(counter);
		
		counter.count();
		System.out.println(counter);
		
		counter.times2();
		System.out.println(counter);
		
		counter.times2();
		System.out.println(counter);
		
		counter.times2();
		System.out.println(counter);
	}

}
