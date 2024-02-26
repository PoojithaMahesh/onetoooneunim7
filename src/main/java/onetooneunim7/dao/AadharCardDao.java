package onetooneunim7.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetooneunim7.dto.AadharCard;
import onetooneunim7.dto.Person;

public class AadharCardDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveAadharCard(int personId, AadharCard card) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person dbPerson = entityManager.find(Person.class, personId);
		if (dbPerson != null) {
//			that person is present and he is a valid person 
//			now i can save the addharcard ,,,,, i can give adharcard
			entityTransaction.begin();
			entityManager.persist(card);
//			update the Person details
			dbPerson.setAadharCard(card);
			entityTransaction.commit();
		} else {
//			dbperson is not present
			System.out.println("sorry person is not a valid person");
		}

	}

	public void updateAadharCard(int id, AadharCard aadharCard) {
		EntityManager entityManager = getEntityManager();
		AadharCard dbAadharCard = entityManager.find(AadharCard.class, id);
		if (dbAadharCard != null) {
//			that id is present then i can update the data

			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

			aadharCard.setId(id);
			entityManager.merge(aadharCard);
			entityTransaction.commit();

		} else {
			System.out.println("Sorry that id is not present to update the data");
		}
	}

	public void findAadharCard(int id) {
		EntityManager entityManager = getEntityManager();
		AadharCard dbAadharCard = entityManager.find(AadharCard.class, id);
		if (dbAadharCard != null) {
//			that id is present then i can update the data

			System.out.println(dbAadharCard);

		} else {
			System.out.println("Sorry that id is not present to update the data");
		}
	}

	public void deleteAadharCard(int id) {
		EntityManager entityManager = getEntityManager();
		AadharCard dbAadharCard = entityManager.find(AadharCard.class, id);
		if (dbAadharCard != null) {
//			that id is present then i can update the data

			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

			entityManager.remove(dbAadharCard);
			entityTransaction.commit();

		} else {
			System.out.println("Sorry that id is not present to update the data");
		}
	}

}
