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

	public String showNamesW(){
		String msg = "";
		for(int i = 0; i<MAX_WETLAND; i++){
			msg += wetlandName[i].getName() + "\n";
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