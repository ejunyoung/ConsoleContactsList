import java.util.List;
import java.util.Scanner;

import controller.ContactsListItemHelper;
import model.ContactsListItem;

public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static ContactsListItemHelper lih = new ContactsListItemHelper();

	private static void addAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter a name: ");
		String name = in.nextLine();
		System.out.print("Enter an email: ");
		String email = in.nextLine();

		ContactsListItem toAdd = new ContactsListItem(name, email);
		lih.insertItem(toAdd);
	}

	private static void deleteAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the name to delete: ");
		String name = in.nextLine();
		System.out.print("Enter the email to delete: ");
		String email = in.nextLine();

		ContactsListItem toDelete = new ContactsListItem(name, email);
		lih.deleteItem(toDelete);
	}

	private static void editAnItem() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by NAME");
		System.out.println("2 : Search by EMAIL");
		int searchBy = in.nextInt();
		in.nextLine();
		List<ContactsListItem> foundItems;
		if (searchBy == 1) {
			System.out.print("Enter the contact name: ");
			String storeName = in.nextLine();
			foundItems = lih.searchForItemByStore(storeName);
		} else {
			System.out.print("Enter the email: ");
			String itemName = in.nextLine();
			foundItems = lih.searchForItemByItem(itemName);
		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (ContactsListItem l : foundItems) {
				System.out.println(l.getId() + " : " + l.returnItemDetails());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			ContactsListItem toEdit = lih.searchForItemById(idToEdit);
			System.out.println("Retrieved " + toEdit.getEmail() + " from " + toEdit.getName());
			System.out.println("1 : Update Name");
			System.out.println("2 : Update Email");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Name: ");
				String newName = in.nextLine();
				toEdit.setName(newName);
			} else if (update == 2) {
				System.out.print("New Email: ");
				String newEmail = in.nextLine();
				toEdit.setEmail(newEmail);
			}

			lih.updateItem(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Contacts List! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add an item");
			System.out.println("*  2 -- Edit an item");
			System.out.println("*  3 -- Delete an item");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else if (selection == 4) {
				viewTheList();
			} else {
				lih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		List<ContactsListItem> allItems = lih.showAllItems();
		for (ContactsListItem singleItem : allItems) {
			System.out.println(singleItem.returnItemDetails());
		}

	}

}