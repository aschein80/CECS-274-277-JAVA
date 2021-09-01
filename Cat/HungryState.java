package CatLab;


public class HungryState implements State{
	Cat cat;
	public HungryState(Cat cat){
		this.cat=cat;
	}
	@Override
	public void sleep() {
		System.out.println("The Cat is going to sleep");
		cat.setState(cat.getAsleepState());
	}

	@Override
	public void eat() {
		System.out.println("The Cat is going to eat");
		
	}

	@Override
	public void play() {
		System.out.println("The Cat is going to play");
		cat.setState(cat.getPlayfulState());
	}

	@Override
	public void ignore() {
		System.out.println("The Cat is ignoring you");
		
	}
	
	public String toString(){
		return "is hungry";
	}
}
