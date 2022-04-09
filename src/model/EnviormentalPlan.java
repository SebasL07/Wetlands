package model;

public class EnviormentalPlan{

	private double percentage;
	private String description;

	public EnviormentalPlan(double per, String des){
		percentage = per;
		description = des;
	} 

	public double getPercentage(){
		return percentage;
	}

	public String getDescription(){
		return description;
	}

	public String toString(){

		return "Plan medioambiental\n"+
		"Porcentaje completado: " + percentage + "\n" +
		"Descripción: " + description + "\n";
	}
}