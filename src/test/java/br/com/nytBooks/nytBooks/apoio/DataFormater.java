package br.com.nytBooks.nytBooks.apoio;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataFormater {
	
	final static Date currentTime = new Date();
	final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm");
	
	public static String data(){
		String d = sdf.format(currentTime);
		return d;
	}
	
	public static String mesAniversario(String mes){
		String mouth = "";
		switch(mes){
		case "01" : mouth = "January"; break;
		case "02" : mouth = "February"; break;	
		case "03" : mouth = "March"; break;	
		case "04" : mouth = "April"; break;	
		case "05" : mouth = "May"; break;	
		case "06" : mouth = "June"; break;	
		case "07" : mouth = "July"; break;	
		case "08" : mouth = "August"; break;	
		case "09" : mouth = "September"; break;	
		case "10" : mouth = "October"; break;	
		case "11" : mouth = "November"; break;	
		case "12" : mouth = "December"; break;	
		}
		return mouth;
	}

}
