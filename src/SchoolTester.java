import java.util.List;

import controller.AddressDetailsHelper;
import controller.SchoolHelper;
import model.AddressDetails;
import model.School;

public class SchoolTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		School dmacc = new School("DMACC");
		SchoolHelper sh = new SchoolHelper();
		sh.insertSchool(dmacc);
		List<School> allSchools = sh.showAllSchools();
		for (School a : allSchools) {
			System.out.println(a.toString());
		}

		AddressDetailsHelper adh = new AddressDetailsHelper();
		AddressDetails dmaccList = new AddressDetails("DMACC's List", dmacc);
		adh.insertNewListDetails(dmaccList);

		List<AddressDetails> allLists = adh.getLists();
		for (AddressDetails a : allLists) {
			System.out.println(a.toString());
		}

//		School susan = new School("Susan");
//		
//		AddressDetailsHelper adh = new AddressDetailsHelper();
//		
//		ListItem shampoo = new ListItem("Target", "Shampoo");
//		ListItem brush = new ListItem("Target", "Brush");
//		
//		List<ListItem> susansItems = new ArrayList<ListItem>();
//		susansItems.add(shampoo);
//		susansItems.add(brush);
//		
//		AddressDetails susansList = new AddressDetails("Susan's ShoppingList", LocalDate.now(), susan);
//		susansList.setListOfItems(susansItems);
//		
//		ldh.insertNewListDetails(susansList);
//		
//		
//		List<AddressDetails> allLists = ldh.getLists();
//		for(AddressDetails a: allLists) {
//			System.out.println(a.toString());
//		}

	}

}