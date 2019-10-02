package übung18;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import übung13.Student;

public class IteratorShit {

	public static void main(String[] args) {

	}

	public static void CollectionIterator() {
		Collection<Student> studenten = new ArrayList<>();

		for (Student s : studenten) {
			System.out.println(s);
		}

		Iterator<Student> iterator = studenten.iterator();

		while (iterator.hasNext()) {
			Student student = iterator.next();
			System.out.println(student);
		}
	}
	
	public static void ArrayIterator() {
		Student[] studenten = new Student[10];
		
		for(Student s : studenten) {
			System.out.println(s);
		}
	}
}
