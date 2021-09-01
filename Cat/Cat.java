package CatLab;

public class Cat {
	State asleepState;
	State hungryState;
	State playfulState;
	State state;
	public Cat(){
		asleepState= new AsleepState(this);
		hungryState= new HungryState(this);
		playfulState=new PlayfulState(this);
		
		state=asleepState;
		
	}
	
	public void sleep(){
		state.sleep();
	}
	
	public void eat(){
		state.eat();
	}
	
	public void play(){
		state.play();
	}
	
	public void ignore(){
		state.ignore();
	}
	public void setState(State state) {
		this.state = state;
	}
	
	public State getAsleepState(){
		return asleepState;
	}
	
	public State getHungryState(){
		return hungryState;
	}
	
	public State getPlayfulState(){
		return playfulState;
	}
	public String toString(){
		return "Cat "+state;
	}
}
