package edu.mum.hw2.control;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.mum.hw2.domain.Order;
import edu.mum.hw2.domain.OrderLine;
import edu.mum.hw2.domain.Product;


public class ApplicationWithoutInheritance {

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
			List<Order> orders = em.createQuery("FROM CustomerOrder").getResultList();
			if(orders != null){
				for(Order o : orders){
					System.out.println(o);
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

			Order o = new Order();
			o.setOrderId(234);
			o.setDate(new Date());
			
			Product p = new Product();
			p.setDescription("Good product");
			p.setName("Apple");
			
			Product prod = new Product();
			prod.setDescription("Orange desc");
			prod.setName("Orange");
			
			OrderLine ol = new OrderLine();
			ol.setQuantity(23);
			
			
			List<OrderLine> list = new ArrayList<>();
			list.add(ol);
			
			o.setOrderLines(list);
			
			o.setOrderLines(Arrays.asList(ol));
			p.setOrderLines(Arrays.asList(ol));
			
			em.persist(p);
			em.persist(o);
			
			
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

}
