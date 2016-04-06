package cs.mum.edu.hw3.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import cs.mum.edu.hw3.domain.proba.Department;
import cs.mum.edu.hw3.domain.proba.Employee;
import cs.mum.edu.hw3.domain.proba.Office;
import cs.mum.edu.hw3.domain.probb.Book;
import cs.mum.edu.hw3.domain.probb.Publisher;
import cs.mum.edu.hw3.domain.probc.Course;
import cs.mum.edu.hw3.domain.probc.Student;
import cs.mum.edu.hw3.domain.probd.Customer;
import cs.mum.edu.hw3.domain.probd.Reservation;

public class Application {
	
	private static EntityManagerFactory emf ;
	
	static{
		try {
			emf = Persistence.createEntityManagerFactory("cs544");
		} catch (Throwable e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
			
		}
	}

	public static void main(String[] args) {
		addEntities();
		printEntities();
		
		emf.close();

	}
	
	private static void addEntities(){
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			//Create Department, Employee and Office
			Department dept = new Department();
			dept.setName("Computer Science");
			
			Office office = new Office();
			office.setBuilding("Bld232");
			office.setRoomNumber("CS322");
			
			Employee emp = new Employee();
			emp.setDepartment(dept);
			emp.setEmployeeNumber("EMP2323");
			emp.setName("Tom Harley");
			emp.setOffice(office);
			
			em.persist(dept);
			em.persist(office);
			em.persist(emp);
			
			//Book and Publisher
			Publisher pub = new Publisher();
			pub.setName("Oreilly Publications");
			
			Book book = new Book();
			book.setAuthor("Orlando Arrorcha");
			book.setIsbn("IS3343BN343");
			book.setTitle("Enterprise Architecture");
			book.setPublisher(pub);
			
			em.persist(pub);
			em.persist(book);
			
			//Student & Course
			
			Student student1 = new Student();
			student1.setFirstname("Jivan");
			student1.setLastName("Nepali");
			student1.setStudentId("Stu23232");
			
			Course course1 = new Course();
			course1.setCourseNumber("CS450");
			course1.setName("MPP");
			
			Course course2 = new Course();
			course2.setName("EA");
			course2.setCourseNumber("CS544");
			
			student1.getCourses().add(course1);
			student1.getCourses().add(course2);
			
			em.persist(course1);
			em.persist(course2);
			em.persist(student1);
			
			Customer customer = new Customer();
			customer.setName("Tom Cruz");
			
			Reservation reservation = new Reservation();
			reservation.setDate(new Date());
			reservation.setBook(book);
			
			
			customer.getReservations().add(reservation);
			em.persist(reservation);
			em.persist(customer);
			
			
			tx.commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void printEntities(){
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			List<Department> departments = em.createQuery("FROM Department").getResultList();
			for(Department d: departments){
				System.out.println(d);
			}
			
			
			Customer customer = em.find(Customer.class, 8); //Searches for Customer with Id:7, if not found returns null
			System.out.println(customer);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
