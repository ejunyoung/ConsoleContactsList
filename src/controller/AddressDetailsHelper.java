package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.AddressDetails;

public class AddressDetailsHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UserContactsList");

	public void insertNewListDetails(AddressDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}

	public List<AddressDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<AddressDetails> allDetails = em.createQuery("SELECT d FROM AddressDetails d").getResultList();
		return allDetails;
	}

	public AddressDetails searchForListById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		AddressDetails found = em.find(AddressDetails.class, tempId);
		em.close();
		return found;
	}

	public void deleteItem(AddressDetails listToDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<AddressDetails> typedQuery = em
				.createQuery("select d from AddressDetails d where d.id = :selectedid", AddressDetails.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedid", listToDelete.getId());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list detail object
		AddressDetails result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public void updateList(AddressDetails toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

}