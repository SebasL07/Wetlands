package model;

public class Dagma{

	private static final int MAX_WETLAND = 80;
	private static final int MAX_SPECIE = 100;
	private Wetland[] wetlands;
	private Specie[] species;

	public Dagma(){
		
		wetlands = new Wetland[MAX_WETLAND];
		species = new Specie[MAX_SPECIE];
	}

	public boolean hasSpaceWetland(){
		boolean sen = false;

		for(int i = 0; i<MAX_WETLAND && !sen;i++){

			if(wetlands[i] == null){
				sen = true;
			}
		}

		return sen;
	}

	public boolean hasSpaceSpecie(){
		boolean sen = false;

		for(int i = 0; i<MAX_SPECIE && !sen;i++){

			if(species[i] == null){
				sen = true;
			}
		}

		return sen;
	}

	public int getFirstEmptyPosW(){

		boolean empty = false;
		int pos = -1;

		for(int i = 0; i<MAX_WETLAND && !empty; i++){

			if(wetlands[i] == null){
				empty = true;
				pos = i;
			}
		}

		return pos;
	}

	public int findWetland(String name){

		boolean sentinel = false;
		int position = -1;

		for(int i = 0; i < MAX_WETLAND && !sentinel;i++){

			if(wetlands[i] != null && wetlands[i].getName().equals(name)){

				position = i;
				sentinel = true;
			}

		}
		return position;
	}

	public int getFirstEmptyPosS(){

		boolean empty = true;
		int pos = -1;

		for(int i = 0; i<MAX_WETLAND && !empty; i++){

			if(species[i] == null){
				empty = false;
				pos = i;
			}
		}

		return pos;
	}

	public String addWetland(String name, String location, String type, double area, String photoURL, String protectedStatus, String nameZone){
		
		int position = getFirstEmptyPosW();
		String msg = "";

		if (position != -1){
			wetlands[position] = new Wetland(name, location, type, area, photoURL, protectedStatus, nameZone);
			msg = "Se anadio el humedal exitosmente";
		} else {
			msg = "No se pueden añadir mas humedales";
		}

		return msg;
	}

	public void addEvent2Wetland(String org, double cost, String description,Date eventDate, int numType, String name){

		Events type = null;
		boolean sen = false;

		switch(numType){

		case 1:
			type = Events.MAINTENANCE;
			break;

		case 2:
			type = Events.SCHOOL_TRIP;
			break;

		case 3:
			type = Events.IMPROVEMENT;
			break;
		case 4:
			type = Events.CELEBRATION;
			break;
		}

		Event newEvent = new Event(type, org, cost, description, eventDate);

		int position = findWetland(name);

		if(position != -1){
			wetlands[position].addEvent(newEvent);
		}
	}
}