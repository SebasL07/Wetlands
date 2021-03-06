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
		int pos = -1; 

		for(int i = 0; i < MAX_WETLAND && !sentinel;i++){

			if(wetlands[i] != null && wetlands[i].getName().equals(name)){
				sentinel = true;
				pos = i;
			} 
		}
		return pos;
	}


	public int getFirstEmptyPosS(){

		boolean empty = false;
		int pos = -1;

		for(int i = 0; i<MAX_WETLAND && !empty; i++){

			if(species[i] == null){
				empty = true;
				pos = i;
			}
		}

		return pos;
	}

	public String addWetland(String name, String location, String type, double area, String photoURL, String protectedStatus, String nameZone, double per, String des){
		
		int position = getFirstEmptyPosW();
		String msg = "";

		EnviormentalPlan newPlan = new EnviormentalPlan(per, des);

		if (position != -1){
			wetlands[position] = new Wetland(name, location, type, area, photoURL, protectedStatus, nameZone, newPlan);
			msg = "Se anadio el humedal exitosmente";
		} else {
			msg = "No se pueden añadir mas humedales";
		}

		return msg;
	}

	public void addEvent2Wetland(String org, double cost, String description, int numType, int d, int m, int y, String nameW){

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

		case 5: 
			type = Events.OTHER;
			break;
		}
		Date newDate = new Date(d,m,y);
		Event newEvent = new Event(type, org, cost, description, newDate);

		int position = findWetland(nameW);

		if(position != -1){
			wetlands[position].addEvent(newEvent);
		}

	}

	public void addSpecie2Wetland(String name, String scientificName, String migratorySpecie, int numType, String wetlandName){

		TypeSpecie typeSpecie = null;
		boolean sen = false;

		switch(numType){
		case 1:
			typeSpecie = TypeSpecie.AQUATIC_FLORA;
			break;

		case 2:
			typeSpecie = TypeSpecie.EARTHBOUND_FLORA;
			break;

		case 3:
			typeSpecie =TypeSpecie.BIRD;
			break;
		case 4:
			typeSpecie = TypeSpecie.MAMMAL;
			break;

		case 5: 
			typeSpecie = TypeSpecie.AQUATIC;
			break;
		}
		int positionSpecie = getFirstEmptyPosS();
		if (positionSpecie != -1){
			species[positionSpecie] = new Specie(name,scientificName,migratorySpecie,typeSpecie);

		}
		
		int position = findWetland(wetlandName);

		if(position != -1){
			wetlands[position].addSpecie(species[positionSpecie]);
			species[positionSpecie].addWetland(wetlands[position]);
		}
	}

	public String showWetlands(){
		String msg = "";
		int count = 0;
		for(int i = 0; i < MAX_WETLAND; i++){
			if(wetlands[i] != null){
				msg += wetlands[i].toString() + "\n";
			} else{
				count++;
			}

			if(count == MAX_WETLAND){
				msg = "No hay ningun humedal registrado hasta el momento";
			}
		}
		return msg;
	}

	public int findSpecie(String name){
		
		boolean sentinel = false;
		int pos = -1; 

		for(int i = 0; i < MAX_SPECIE && !sentinel;i++){

			if(species[i] != null && species[i].getName().equals(name)){
				sentinel = true;
				pos = i;
			} 
		}
		return pos;
	}

	public String specieInWetland(String name){
		int pos = findSpecie(name);
		String msg = "";

		if(pos == -1){
			msg = "No se encontro la especie";
		} else{
			msg = species[pos].toString();
		}
		return msg;
	} 

	public String wetlandMoreFauna(){

		int higher = 0;
		int pos = 0;

		for(int i = 0; i<MAX_WETLAND;i++){
			if(wetlands[i] != null && wetlands[i].countFauna() > higher){
				higher = wetlands[i].countFauna();
				pos = i;
			}
		}

		return "El humedal con mas fauna es " + wetlands[pos].getName() + " con " + higher + " animales.";

	}

	public String wetlandLessFauna(){

		int minor = 0;
		int pos = 0;

		for(int i = 0; i<MAX_WETLAND;i++){
			if(wetlands[i] != null && wetlands[i].countFlora() < minor){
				higher = wetlands[i].countFlora();
				pos = i;
			}
		}

		return "El humedal con menos flora es " + wetlands[pos].getName() + " con " + higher + " especies de flora.";

	}

}