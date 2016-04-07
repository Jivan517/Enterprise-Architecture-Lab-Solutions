package cs544.exercise8_2;


import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StudentDAO {

	private  SessionFactory sf;
	
	
	
	public StudentDAO(SessionFactory sessionFactory){
		this.sf = sessionFactory;
	}
	

	@Transactional
	public Student load(long studentid) {
		return (Student) sf.getCurrentSession().get(Student.class, studentid);
	}
	
	@Transactional
	public void create(){
		//Session session = sf.getCurrentSession();
		//Transaction tx = session.beginTransaction();
		
		Random rnd = new Random();
		int id = rnd.nextInt(2334);
		int id2 = id +1;
		int id3 = id + 3;
		
		Student student = new Student(id, "Frank", "Brown");
		Course course1 = new Course(id2, "Java", "A");
		Course course2 = new Course(id3, "Math", "B-");
		student.addCourse(course1);
		student.addCourse(course2);
		sf.getCurrentSession().persist(student);
		//session.persist(student);
		//tx.commit();
	}
}
