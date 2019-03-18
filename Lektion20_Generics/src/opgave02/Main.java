package opgave02;

@SuppressWarnings("unused")
public class Main {

	private static void pPrint(String msg, Object result) {
		System.out.println(msg);
		System.out.println("-> " + result.toString() + "\n");
	}
	
	public static void main(String[] args) {
//		testBoring();
		testInteresting();
	}
	
	private static void testBoring() {
		Dictionary<String, Integer> dict = new Dictionary<>();
		
		System.out.println("Is empty : " + dict.isEmpty());
		System.out.println("Adding values...");
		dict.put("alder", 22);
		dict.put("kager", 3);
		dict.put("biler", 0);
		
		System.out.println("\n" + dict + "\n");
		System.out.println("Is empty : " + dict.isEmpty());
		System.out.println("Removing kager : " + dict.remove("kager") + "\n");
		System.out.println(dict);
	}
	
	private static void testInteresting() {
		HashDictionary<String, Integer> dict = new HashDictionary<>();
		System.out.println(dict + "\n");
		pPrint("isEmpty()", dict.isEmpty());
		pPrint("size()", dict.size());
		System.out.println("Adding elements..." + "\n");
		dict.put("Jonas", 21);
		dict.put("Oscar", 22);
		dict.put("Jacob", 22);
		dict.put("Jacob's Søster", 24);
		dict.put("Henrik's Søster", 29);
		dict.put("Henrik", 22);
		dict.put("Kennet", 25);
		System.out.println(dict + "\n");
		pPrint("isEmpty()", dict.isEmpty());
		pPrint("size()", dict.size());
		pPrint("containsKey('Jonas')", dict.containsKey("Jonas"));
		pPrint("remove('Jonas')", dict.remove("Jonas"));
		System.out.println(dict + "\n");
		pPrint("containsKey('Jonas')", dict.containsKey("Jonas"));
		pPrint("values()", dict.values());
		pPrint("size()", dict.size());
	}

}
