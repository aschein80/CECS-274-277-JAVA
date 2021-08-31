package Project5;

public class LinkedListdemoo {
	public static void main(String[] args) {
		DLinkedList natlParks = new DLinkedList();
		
		natlParks.addFirst("Yosemite");
		natlParks.addFirst("Grand Canyon");
		natlParks.addLast("Zion");
		natlParks.addLast("Olympic");
		ListIterator iter = natlParks.listIterator(); // | G Y Z O
		System.out.println("Original Parks: ");
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		iter.previous(); // G Y Z | O
		iter.previous(); // G Y | Z O
		iter.add("Joshua Tree"); // G Y J | Z O
		iter.next(); // G Y J | Z O
		iter.next(); // G Y J Z O
		iter = natlParks.listIterator(); // | G Y J Z O
		System.out.println("\n\nParks After Add: ");
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("\nContains 'Yosemite' : " + natlParks.contains("Yosemite"));
		System.out.println("Contains 'Smokey Mountains' : " + natlParks.contains("Smokey Mountains"));
		
		System.out.println("\nRemoving 'Olympic': "+ natlParks.removeLast()); // G Y J Z 
		System.out.println("Removing 'Grand Canyon': "+ natlParks.removeFirst()); // Y J Z 
		
		iter = natlParks.listIterator(); // | Y J Z
		iter.next(); // Y | J Z 
		iter.next();// Y J | Z 
		iter.set("Joshua National Park");
		System.out.println("\nPrinting 'Joshua National Park': "+iter.previous()); // Y | J Z
		System.out.println("\nFirst park: " + natlParks.getFirst()); //Expecting 'Yosemite'
		System.out.println("\nLast park: " + natlParks.getLast()); //Expecting 'Zion'
		
		DLinkedList states = new DLinkedList();
		states.getFirst(); //Expecting exception
		
	}

}
