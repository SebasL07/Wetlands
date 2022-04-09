package model;

public class Event{

	private Events type;
	private String organizer;
	private double cost;
	private String description;

	private Date eventDate;

	public Events getType(){
		return type;
	}

	public Date getEventDate(){
		 return eventDate;
	}

	public Event(Events type, String organizer, double cost, String description, Date eventDate){

		this.type = type;
		this.organizer = organizer;
		this.cost = cost;
		this.description = description;
		this.eventDate = eventDate;
	}
	
	public String toString(){
		return "**Datos del evento**\n" + 
		"Tipos de evento: " + type + "\n" + 
		"Organzador: " + organizer + "\n" + 
		"Costo del evento: " + cost + "\n" + 
		"Descripción del evento: " + description + "\n" +
		"Fecha del evento (DD/MM/YY): " + eventDate.toString();

	} 
	
}