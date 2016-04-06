package edu.mum.hw2.control;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.mum.hw2.domain.*;

public class ApplicationWithInheritance {

	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("cs544");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {
		addOrders();
		printOrders();

		emf.close();
	}
	
	public static void printOrders(){
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			List<Book> books = em.createQuery("FROM Book ").getResultList();
			
			if(books != null)
			{
				for(Book b : books){
					System.out.println(b);
				}
			}

			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen()))
				em.close();
		}


	}
	
	public static void addOrders(){
		System.out.println("Started the session");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			
			tx.begin();

			Book book = new Book();
			book.setDescription("book desc");
			book.setTitle("book title");
			book.setName("book name");
			em.persist(book);
			
			Cd cd = new Cd();
			cd.setArtist("CD artist");
			cd.setDescription("CD desc");
			cd.setName("CD name");
			em.persist(cd);
			
			Dvd dvd = new Dvd();
			dvd.setDescription("DVD desc");
			dvd.setGenre("DVD genre");
			dvd.setName("DVD name");
			em.persist(dvd);
			
			
			tx.commit();
			
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen()))
				em.close();
		}
	}

}
