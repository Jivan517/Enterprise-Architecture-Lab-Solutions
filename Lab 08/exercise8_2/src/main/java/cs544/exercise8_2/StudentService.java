package cs544.exercise8_2;



import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StudentService {
	private StudentDAO studentdao;
	private static SessionFactory sf ;

	public StudentService(SessionFactory sessionFactory, StudentDAO studentDao) {
		studentdao = studentDao;
		this.sf = sessionFactory;
	}

	public Student getStudent(long studentid) {
		//Transaction tx = sf.getCurrentSession().beginTransaction();
		Student student = studentdao.load(studentid);;
		Hibernate.initialize(student.getCourselist());
		//tx.commit();
		return student;
	}
}
