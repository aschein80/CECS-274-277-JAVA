package CatLab;

public class PlayfulState implements State {
	Cat cat;
	public PlayfulState(Cat cat){
		this.cat=cat;
	}
	@Override
	public void sleep() {
		System.out.print("The Cat is going to sleep");
		cat.setState(cat.getAsleepState());
	}

	@Override
	public void eat() {
		System.out.println("The Cat is going to eat");
		cat.setState(cat.getHungryState());
	}

	@Override
	public void play() {
		System.out.println("The Cat is playing");
		
	}

	@Override
	public void ignore() {
		// TODO Auto-generated method stub
		System.out.println("The cat is playing with you and will not ignore");
	}
	
	public String toString(){
		return "is playing";
	}

}
