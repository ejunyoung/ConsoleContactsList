package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddressDetails;
import model.ContactsListItem;
import model.School;

/**
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewListServlet")
public class createNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public createNewListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ContactsListItemHelper lih = new ContactsListItemHelper();
		String addressName = request.getParameter("addressName");
		System.out.println("Address Name: " + addressName);

		String schoolName = request.getParameter("schoolName");

		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		List<ContactsListItem> selectedItemsInList = new ArrayList<ContactsListItem>();
		if (selectedItems != null && selectedItems.length > 0) {
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				ContactsListItem c = lih.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);

			}
		}

		School school = new School(schoolName);
		AddressDetails ad = new AddressDetails(addressName, school);
		ad.setListOfItems(selectedItemsInList);
		AddressDetailsHelper adh = new AddressDetailsHelper();
		adh.insertNewListDetails(ad);

		System.out.println("Success!");
		System.out.println(ad.toString());

		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}