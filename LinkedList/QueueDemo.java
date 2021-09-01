package Project5;

public class QueueDemo {
	
	public static void main(String[] args) {
		DLQueue names = new DLQueue();
		names.add("Jose");
		names.add("Sean");
		names.add("Shaan");
		names.add("Kathya");
		
		
		System.out.println(names.peek());
		System.out.println(names.remove());
		System.out.println(names.peek());
		System.out.println(names.remove());
		System.out.println(names.peek());
		System.out.println(names.remove());
		System.out.println(names.peek());
		System.out.println(names.remove());
		System.out.println(names.peek()); //expecting exception
	}

}
