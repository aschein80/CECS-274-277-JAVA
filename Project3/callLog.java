
package project3;

import java.util.ArrayList;

/**
 * @author Alex Schein, Bradley Hoang, Dennis Maya, Brian Tran
 * @version 1.0.1
 * @Class Description - This class sets and gets type, number, date, time and, call type and count. 
 */

public class callLog {
	
	private String type;
	private String num;
	private ArrayList<String> date;
	private ArrayList<String> time;
	private ArrayList<String> callType;
	private int count;
	
	/**
	 * initializes the array lists for date, time, type, num, and count of calls
	 */
	public callLog() {
		this.type = "";
		this.num = "";
		this.date = new ArrayList<String>();
		this.time = new ArrayList<String>();
		this.callType = new ArrayList<String>();
		this.count = 0;
	}
	
	/**
	 * 
	 * @param type- string for the type of call (incoming vs outgoing)
	 * @param num- the string of the number being contacted
	 * @param date- date of the call
	 * @param time- time of the call
	 * @param callType- 
	 */
	public callLog(String type, String num, String date, String time, String callType) {
		this.type = type;
		this.num = num;
		this.date = new ArrayList<String>();
		this.date.add(date);
		this.time = new ArrayList<String>();
		this.time.add(time);
		this.callType = new ArrayList<String>();
		this.callType.add(callType);
		this.count = 1;
		
	}
	
	/**
	 * sets the type
	 * @param type - is a string equal to "Contact", "favorite", or "number"
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * sets the string for the number
	 * @param num - the string of the number in the call
	 */
	public void setNum(String num) {
		this.num = num;
	}
	
	/**
	 * sets the date of the call
	 * @param date- the date the call was made
	 */
	public void setDate(String date) {
		this.date.add(date);
	}
	
	/**
	 * sets the time of the phone call
	 * @param time- string for time of the call
	 */
	public void setTime(String time) {
		this.time.add(time);
	}
	
	/**
	 * sets the call
	 * @param callType the type of call made (outoging or incoming)
	 */
	public void setCallType(String callType) {
		this.callType.add(callType);
	}
	
	/**
	 * updates the count of phone calls
	 */
	public void setCount() {
		count++;
	}
	
	/**
	 * gets the type of phone call
	 * @return the type of call made
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * gets the date of the call
	 * @param i- integer for the date of the call 
	 * @return- i for the date of the call
	 */
	public String getDate(int i) {
		return this.date.get(i);
	}
	
	/**
	 *gets the time of the call 
	 * @param i- integer of the time 
	 * @return time of call 
	 */
	public String getTime(int i) {
		return this.time.get(i);
	}
	
	/**
	 * gets the call type (outoging or incoming)
	 * @param i - integer for the call type
	 * @return the call type
	 */
	public String getCallType(int i) {
		return this.callType.get(i);
	}
	
	/**
	 * gets the count for phone calls 
	 * @return count of phone calls
	 */
	public int getCount() {
		return this.count;
	}
	
	/**
	 * gets the phone number 
	 * @return num for the phone number
	 */
	public String getNum() {
		return this.num;
	}
	
	/**
	 * formats the object contents into a string
	 */
	public String toString() {
		String str = null;
		if (this.count == 1) {
			str = String.format("%s: %s\tDate:\t%s\tTime: %s\tType: %s\n",type,num,date.get(0),time.get(0),callType.get(0));
		}
		else {
			str = String.format("%s: %s\tCalls Logged: %d ", type,num,count);
		}
		return str;
	}
	
}

