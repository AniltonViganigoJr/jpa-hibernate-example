package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Person;

public class Program {

	public static void main(String[] args) {

		Person p1 = new Person(null, "Person Name", "Person Email Address");
		
		//Entity Manager Factory Instantiate
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		
		//Entity Manager Instantiate
		EntityManager em = emf.createEntityManager();
		
		//Persist Person
		em.getTransaction().begin();
		em.persist(p1);
		em.getTransaction().commit();
		
		//Person Find By Id
		Person person = em.find(Person.class, 1);
		System.out.println(person);
		
		//Person Remove By Id
		person = em.find(Person.class, 1);
		em.getTransaction().begin();
		em.remove(person);
		em.getTransaction().commit();
		
		System.out.println("Done!");

		em.close();
		emf.close();
	}
}