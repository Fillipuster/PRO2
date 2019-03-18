package opgave02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {

	private static void pPrint(String msg, Object result) {
		System.out.println(msg);
		System.out.println("-> " + result + "\n");
	}
	
	public static void main(String[] args) {
		// SearchableList:
		System.out.println("Testing for SearchableList:\n");
		List<String> list = new ArrayList<>();
		list.add("Holme");
		list.add("Skåde");
		list.add("Viby");
		list.add("Beder");
		list.add("Stautrup");
		list.add("Engdal");
		list.add("Forældreskolen");
		list.add("Malling");
		
		SearchableList<String> searchList = new SearchableList<>(list);
		
		pPrint("Search for 'Malling'", searchList.search("Malling"));
		pPrint("Search for 'Riiskov'", searchList.search("Riiskov"));
		
		// SearchableArray:
		System.out.println("Testing for SearchableArray:\n");
		String[] arr = new String[8];
		arr[0] = "Holme";
		arr[1] = "Skåde";
		arr[2] = "Viby";
		arr[3] = "Beder";
		arr[4] = "Stautrup";
		arr[5] = "Engdal";
		arr[6] = "Forældreskolen";
		arr[7] = "Malling";
		
		SearchableArray<String> searchArray = new SearchableArray<>(arr);
		
		pPrint("Search for 'Malling'", searchArray.search("Malling"));
		pPrint("Search for 'Riiskov'", searchArray.search("Riiskov"));
		
		// SearchableArrayBin:
		System.out.println("Testing for SearchableArrayBin:\n");
		String[] arrBin = new String[8];
		arrBin[0] = "Holme";
		arrBin[1] = "Skåde";
		arrBin[2] = "Viby";
		arrBin[3] = "Beder";
		arrBin[4] = "Stautrup";
		arrBin[5] = "Engdal";
		arrBin[6] = "Forældreskolen";
		arrBin[7] = "Malling";
		
		Collections.sort(Arrays.asList(arrBin));
		
		SearchableArray<String> searchArrayBin = new SearchableArray<>(arrBin);
		
		pPrint("Search for 'Malling'", searchArrayBin.search("Malling"));
		pPrint("Search for 'Riiskov'", searchArrayBin.search("Riiskov"));
	}

}
