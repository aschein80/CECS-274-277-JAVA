package Project3;

public interface AlienCellPhone {
	   public void alienSendText(String fileName);
	   public void alienReadText(String fileName);
	   //translateText returns the name of the output file
	   //that has the translated message
	   public String translateText(String fileName);
	}