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

	public int getDay(){
		return day;
	}

	public int getMonth(){
		return month;
	}

	public int getYear(){
		return year;
	}

	public void setDay(int pDay){
		day = pDay;
	}

	public void setMonth(int pMonth){
		month = pMonth;
	}

	public void setYear(int pYear){
		year = pYear;
	}

	public String toString(){

		return day + "/" + month + "/" + year;
	}
}