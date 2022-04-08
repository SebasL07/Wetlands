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

	public void setPercentage(double percentage){
		this.percentage = percentage;
	}

	public void setDescription(String description){
		this.description = description;
	}
}