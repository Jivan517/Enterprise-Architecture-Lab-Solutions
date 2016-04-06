package demo;

public class HelloPerson {

	private Person person;
	
	HelloPerson(Person person){
		this.person = person;
	}
	
	public void sayHello(){
		System.out.println("Hello " + person.getFirstName() + " " + person.getLastName());
	}
}
