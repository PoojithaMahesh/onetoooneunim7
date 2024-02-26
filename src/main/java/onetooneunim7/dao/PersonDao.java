package onetooneunim7.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetooneunim7.dto.Person;

public class PersonDao {
public EntityManager getEntityManager() {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	return entityManager;
}
public void savePerson(Person person) {
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(person);
	entityTransaction.commit();
}
public void updatePerson(int personId,Person person) {
//	person=name.address
	EntityManager entityManager=getEntityManager();
	Person dbPerson=entityManager.find(Person.class, personId);
	if(dbPerson!=null) {
//		that id is present then i can update the data
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		person.setId(personId);
//		person=id, addres,
//		
		person.setAadharCard(dbPerson.getAadharCard());
		
//		person=id,name,address.aadharcard
		entityManager.merge(person);
		entityTransaction.commit();
	}else {
		System.out.println("Sorry id is not present to update the data");
	}
	
	
	
}

public void findPerson(int id) {
	EntityManager entityManager=getEntityManager();
	Person dbPerson=entityManager.find(Person.class, id);
	if(dbPerson!=null) {
//		that id is present
		System.out.println(dbPerson);
	}else {
		System.out.println("Id is not present to find the data");
	}
}


public void deletePerson(int id) {
	EntityManager entityManager=getEntityManager();
	Person dbPerson=entityManager.find(Person.class, id);
	if(dbPerson!=null) {
    EntityTransaction entityTransaction=entityManager.getTransaction();
    entityTransaction.begin();
    entityManager.remove(dbPerson);
    entityTransaction.commit();
		
	}else {
		System.out.println("Sorry ID is not present to delete the data");
	}
	
}




}
