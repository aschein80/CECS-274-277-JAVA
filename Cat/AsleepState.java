package CatLab;
public class AsleepState implements State{
	
    Cat cat;
    
	public AsleepState(Cat cat){
		this.cat=cat;
	}


	public void sleep() {
		System.out.println("The Cat is already sleeping");
		
	}


	public void eat() {
		System.out.println("The Cat is going to eat");
		cat.setState(cat.getHungryState());

		
	}

	public void play() {

		System.out.println("The Cat does not want to play. It ignores you and continues to sleep.");
		
	}


	public void ignore() {

		System.out.println("The Cat ignores you");
	}
	
	public String toString(){
		return "is sleeping";
	}
}
