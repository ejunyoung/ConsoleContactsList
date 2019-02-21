package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.School;

public class SchoolHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UserContactsList");

	public void insertSchool(School s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}

	public List<School> showAllSchools() {
		EntityManager em = emfactory.createEntityManager();
		List<School> allSchools = em.createQuery("SELECT s FROM School s").getResultList();
		return allSchools;
	}

//	public School searchForSchoolByName(String schoolName) {
//		// TODO Auto-generated method stub
//		EntityManager em = emfactory.createEntityManager();
//		em.getTransaction().begin();
//		TypedQuery<School> typedQuery = em.createQuery("select s from School s where s.schoolName = :selectedName",
//				School.class);
//		typedQuery.setParameter("selectedName", schoolName);
//		typedQuery.setMaxResults(1);
//
//		School found = typedQuery.getSingleResult();
//		em.close();
//		return found;
//	}

}