package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ContactsListItem;

public class ContactsListItemHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleContactsList");

	public void insertItem(ContactsListItem li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}

	public List<ContactsListItem> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		List<ContactsListItem> allItems = em.createQuery("SELECT i FROM ContactsListItem i").getResultList();
		return allItems;
	}

	public void deleteItem(ContactsListItem toDelete) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ContactsListItem> typedQuery = em.createQuery(
				"select li from ContactsListItem li where li.store = :selectedName and li.item = :selectedEmail",
				ContactsListItem.class);

		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedEmail", toDelete.getEmail());

		typedQuery.setMaxResults(1);

		ContactsListItem result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public ContactsListItem searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ContactsListItem found = em.find(ContactsListItem.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(ContactsListItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<ContactsListItem> searchForItemByStore(String ContactName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ContactsListItem> typedQuery = em.createQuery(
				"select li from ContactsListItem li where li.store = :selectedName", ContactsListItem.class);
		typedQuery.setParameter("selectedName", ContactName);

		List<ContactsListItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<ContactsListItem> searchForItemByItem(String emailAddress) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ContactsListItem> typedQuery = em.createQuery(
				"select li from ContactsListItem li where li.item = :selectedEmail", ContactsListItem.class);
		typedQuery.setParameter("selectedItem", emailAddress);

		List<ContactsListItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public void cleanUp() {
		emfactory.close();
	}

}