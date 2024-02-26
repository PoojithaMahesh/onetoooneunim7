package onetooneunim7.controller;

import onetooneunim7.dao.AadharCardDao;
import onetooneunim7.dao.PersonDao;
import onetooneunim7.dto.AadharCard;
import onetooneunim7.dto.Person;

public class PersonAdharCont {
	public static void main(String[] args) {
//		Person person=new Person();
//		person.setId(2);
//		person.setName("aryan");
//		person.setAddress("Banaglore");
//		
//		
//		PersonDao personDao=new PersonDao();
//		personDao.savePerson(person);
//		
//
//		AadharCard aadharCard=new AadharCard();
//		
//		aadharCard.setId(200);
//		aadharCard.setName("Aryan");
//		aadharCard.setAge(18);
//		
//		
//		AadharCardDao cardDao = new AadharCardDao();
//		cardDao.saveAadharCard(2, aadharCard);
		
//		AadharCard aadharCard = new AadharCard();
//		aadharCard.setName("Pooji");
//		aadharCard.setAge(18);

//		cardDao.updateAadharCard(100, aadharCard);
		
//		Person person=new Person();
//		person.setName("Pooji");
//		person.setAddress("Bangalore");
//		PersonDao  personDao=new PersonDao();
//		personDao.updatePerson(1, person);
//		
		
		AadharCardDao cardDao=new AadharCardDao();
		cardDao.deleteAadharCard(100);
		
		
		

	}
}
