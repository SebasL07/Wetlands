package model;

public class Date{

	private int day;
	private int month;
	private int year;

	public Date(int d, int m, int y){
		day = d;
		month = m;
		year = y;
	}
	
	public int getYear(){
		return year;
	}

	public String toString(){

		return day + "/" + month + "/" + year;
	}
}