package model;

public class Specie{

	private static final int MAX_WETLAND = 80;
	private String name;
	private String scientificName;
	private String migratorySpecie;
	private TypeSpecie type;
	private Wetland[] wetlandName;

	public Specie(String n, String sN, String mS, TypeSpecie type){
		name = n;
		scientificName =sN;
		migratorySpecie = mS;
		this.type = type;
		wetlandName = new Wetland[MAX_WETLAND]; 
	}

	public String getName(){
		return name;
	}

	public String addWetland(Wetland w){
		
		int position = getFirstEmptyPos();
		String msg = "";

		if (position != -1){
			wetlandName[position] = w;
			msg = "Se anadio el humedal exitosmente";
		} else {
			msg = "No se pueden añadir mas humedales";
		}

		return msg;
	}

	public int getFirstEmptyPos(){

		boolean empty = false;
		int pos = -1;

		for(int i = 0; i<MAX_WETLAND && !empty; i++){

			if(wetlandName[i] == null){
				empty = true;
				pos = i;
			}
		}

		return pos;
	}

	public String showNamesW(){
		String msg = "";
		for(int i = 0; i<MAX_WETLAND; i++){
			if(wetlandName[i] != null){
				msg += (i+1)+") " + wetlandName[i].getName() + "\n";
			}
			
		}
		return msg;
	}

	public String toString(){
		return "**Datos de la especie**" + "\n" +
		"Nombre: " + name + "\n" + 
		"Nombre Cientifico : "+ scientificName + "\n" +
		"Migatroria : " +  migratorySpecie + "\n" +
		"Tipo de especie : " + type + "\n" +
		"Humedal(es)donde se encuentra: " + showNamesW();
	}
} 