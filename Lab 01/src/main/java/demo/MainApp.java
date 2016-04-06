package demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class MainApp {

	public static void main(String[] args){
		
		try{
			ConfigurableApplicationContext context = 
					new ClassPathXmlApplicationContext("./application-context.xml");
			HelloPerson hello = (HelloPerson) context.getBean("helloWorld");
			hello.sayHello();
			
			
		}catch(Exception ex){
			System.out.println("Exception " + ex);
		}
		}
}
