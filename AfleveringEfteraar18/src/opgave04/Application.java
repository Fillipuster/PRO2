package opgave04;

class Application {

	public static void main(String[] args) {
		ThreadHandler th = new ThreadHandler();
		
		Receptionist r0 = new Receptionist(th, 100, true);
		Receptionist r1 = new Receptionist(th, 70, true);
		Indgang i0 = new Indgang(th, 100, true, "Peter");
		Indgang i1 = new Indgang(th, 80, true, "Oscar");

		r0.start();
		r1.start();
		i0.start();
		i1.start();
	}

}
