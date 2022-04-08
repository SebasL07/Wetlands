package model;

public class Wetland{
	private static final int MAX_SPECIE = 100;
	private static final int MAX_EVENTS = 20;

	private String name;
	private boolean location;
	private boolean type;
	private double area;
	private String photoURL;
	private boolean protectedStatus;
	private String nameZone;

	private Specie[] species;
	private Event[] events;
	private EnviormentalPlan percentage;

	public Wetland(String name, boolean location, boolean type, double area, String photoURL, boolean protectedStatus, String nameZone){

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

	public String locationString(){

		String msg;

		if(location == true){
			msg = "Rural" + "\n" +
			"Nombre del corregimiento: " + nameZone;
		}else{
			msg = "Urbano" + "\n" +
			"Nombre del barrio: " + nameZone;
		}

		return msg;
	}

	public String typeString(){

		String msg;

		if(type == true){
			msg = "Publico";
		}else{
			msg = "Privado";
		}

		return msg;
	}

	public String protectedStatusString(){

		String msg;

		if(protectedStatus == true){
			msg = "Si";
		}else{
			msg = "No";
		}

		return msg;
	}

	public String toString(){
		return "**Datos del humedal**\n" + 
		"Nombre: " + name + "\n" +
		"Localizacion: " + locationString() + "\n" +
		"Estado: " + typeString() + "\n" + 
		"Area: " + area + "metros cuadrados\n" + 
		"URL de la foto: " + photoURL + "\n" + 
		"Area protegida: " + protectedStatusString() + "\n";
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

}