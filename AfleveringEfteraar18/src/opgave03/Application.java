package opgave03;

class Application {

	public static void main(String[] args) {
		ThreadHandler th = new ThreadHandler();
		
		Receptionist r0 = new Receptionist(th, 10, false);
		Indgang i0 = new Indgang(th, 40, true);
		Indgang i1 = new Indgang(th, 50, true);

		r0.start();
		i0.start();
		i1.start();
	}

}
