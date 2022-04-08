package model;

public class Specie{

	private String name;
	private String scientificName;
	private boolean migratorySpecie;
	private String type;

	private Wetland whereIsFound;

	public Specie(String n, String sN, boolean mS, String type){
		name = n;
		scientificName =sN;
		migratorySpecie = mS;
		this.type = type; 
	}

	public String getName(){
		return name;
	}
	public void setName(String pName){
		name = pName;
	}

	public String getScientificName(){
		return scientificName;
	}

	public boolean getMigratorySpecie(){
		return migratorySpecie;
	}

	public String getType(){
		return type;
	}

	public Wetland getWhereIsFound(){
		return whereIsFound;
	}

	public String migratoryYesNo(){
		String msg = "";

		if(migratorySpecie == true){
			msg = "Si";
		}else 
			msg = "No";

		return msg;
	}

	public String toString(){
		return "**Datos de la especie**" + "\n" +
		"Nombre: " + name + "\n" + 
		"Nombre Cientifico : "+ scientificName + "\n" +
		"Migatroria : " +  migratoryYesNo() + "\n" +
		"Tipo de especie : " + type;
	}
} 