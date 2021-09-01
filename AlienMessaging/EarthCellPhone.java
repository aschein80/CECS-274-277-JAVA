package Project3;

import java.io.InvalidClassException;

public interface EarthCellPhone {
	   public void sendMessage(String languageType, String fileName) 
	           throws   InvalidClassException;
	   public void readMessage(String fileName);
	}