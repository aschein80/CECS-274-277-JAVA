package demos;

public class StudentDemo {

	public static void main(String[] args) {
		
		Student male = new Student();
		Student female = new Student();
		
		male.setName("Anthony");
		female.setID("011-111-111");
		
		male.addCourse("Math 101");
		male.addCourse("CECS 274");
		female.addCourse("CECS 229");
		female.addCourse("CECS 282");
		System.out.println("Name:  "+ female.getName());
		System.out.println("Name:  "+ male.getName());
		female.printCourses();
		male.printCourses();
		
		System.out.println(male.getID());
		System.out.println(female.getID());
		
	}
}
