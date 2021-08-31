package demos;

import java.util.LinkedList;
import java.util.ListIterator;
public class LinkedListDemo {
	
	public static void main(String[] args) {
		LinkedList<String> superheros = new LinkedList<String>();
		superheros.addFirst("Superman"); //5
		superheros.addFirst("Wonderwoman"); //W 5
		superheros.addFirst("Flash"); // F W S
		superheros.addLast("Batman"); // F W S B
		System.out.println(superheros);
		System.out.println(superheros.getFirst());
		System.out.println(superheros.getLast());
		ListIterator<String> iter = superheros.listIterator(); // F W S B
		System.out.println(iter.next()); // F | W S B
		System.out.println(iter.next()); // F W | S B
		System.out.println(iter.next()); // F W S | B
		iter.remove(); // F W | B
		
		iter.previous(); // F W B |
		iter.remove(); // F | B since the iterator traversed wonderwoman last, she is the that gets removed
		System.out.println(superheros); // 
		iter = superheros.listIterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
		}
		iter.add("Hulk"); // F B H | Note: When adding, the element is added after the 
		//iterator and then the iterator traverses the new element
		System.out.println(superheros);
		iter.previous(); //F B H | 
		iter.previous(); // F B | H
		iter.add("Iron Man");
		System.out.println(superheros);  // F I B H
		
		superheros.add("Spiderman"); // add(element) behaves the same way as add last
		System.out.println(superheros);
		superheros.add(2, "Elastic Girl"); //this is creating and using an iterator in the background
		System.out.println(superheros);
		System.out.println(superheros.get(3)); //NOTE: THIS IS NOT A CONSTANT TIME OPERATION because this is creating an iterator to
		//traverse 4 nodes and get to the desired node
		}

}
