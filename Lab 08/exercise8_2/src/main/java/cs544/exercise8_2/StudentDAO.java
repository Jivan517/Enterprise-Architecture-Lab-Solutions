package cs544.exercise8_2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentDAO {

	private static SessionFactory sf = HibernateUtil.getSessionFactory();

	static {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Student student = new Student(11334, "Frank", "Brown");
		Course course1 = new Course(1101, "Java", "A");
		Course course2 = new Course(1102, "Math", "B-");
		student.addCourse(course1);
		student.addCourse(course2);

		session.persist(student);
		tx.commit();
	}

	public Student load(long studentid) {
		return (Student) sf.getCurrentSession().get(Student.class, studentid);
	}
}
