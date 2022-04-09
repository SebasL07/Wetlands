package model;

public class Wetland{
	private static final int MAX_SPECIE = 100;
	private static final int MAX_EVENTS = 20;

	private String name;
	private String location;
	private String type;
	private double area;
	private String photoURL;
	private String protectedStatus;
	private String nameZone;

	private Specie[] species;
	private Event[] events;
	private EnviormentalPlan percentage;

	public Wetland(String name, String location, String type, double area, String photoURL, String protectedStatus, String nameZone){

		this.name = name;
		this.location = location;
		this.type = type;
		this.area = area;
		this.photoURL = photoURL;
		this.protectedStatus = protectedStatus;
		this.nameZone = nameZone;
		species = new Specie[MAX_SPECIE];
		events = new Event[MAX_EVENTS];
	}

	public String getName(){
		return name;
	}

	public String toString(){
		return "**Datos del humedal**\n" + 
		"Nombre: " + name + "\n" +
		"Localizacion: " + location + "\n" +
		"Estado: " + type + "\n" + 
		"Area: " + area + " metros cuadrados\n" + 
		"URL de la foto: " + photoURL + "\n" + 
		"Area protegida: " + protectedStatus + "\n" +
		"Nombre de la zona: " + nameZone + "\n";
	}

	public String addEvent(Event eve){

		int empPosition = getEmptyPositionE();
		String msg = "";

		if (empPosition == -1){
			msg = "No se ha podido añadir el evento debido a que no hay mas espacio en la base de datos";
		} else{
			events[empPosition] = eve;
			msg = "Se ha registrado el evento exitosamente";
		}

		return msg;
	}

	public String addSpecie(Specie esp){

		int empPosition = getEmptyPositionS();
		String msg = "";

		if (empPosition == -1){
			msg = "No se ha podido añadir el evento debido a que no hay mas espacio en la base de datos";
		} else{
			species[empPosition] = esp;
			msg = "Se ha registrado la especie exitosamente";
		}

		return msg;
	}

	public int getEmptyPositionE(){
		boolean sen = false; 
		int position = -1;

		for(int i = 0; i<MAX_EVENTS && !sen; i++){

			if(events[i] == null){
				position = i;
				sen = true;
			}
		}
		return position;

	}	

	public int getEmptyPositionS(){
		boolean sen = false; 
		int position = -1;

		for(int i = 0; i<MAX_SPECIE && !sen; i++){

			if(species[i] == null){
				position = i;
				sen = true;
			}
		}
		return position;
	} 
	/*
	public String nameZoneOptions(String nameZone){

		String msg = "";

		if(nameZone.toLowerCase().equals("rural")){
			msg = "Nombre del corregimiento: ";
		} else if(nameZone.toLowerCase().equals("urbano")){
			msg = "Nombre del barrio: ";
		}
		return msg;
	}
	*/

}