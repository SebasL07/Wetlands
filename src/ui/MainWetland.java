package ui;
import java.util.Scanner;

import model.Dagma;

//javac -cp src src/ui/MainWetland.java -d bin
//java -d bin ui.MainWetland.java 

public class MainWetland{
	
	static Scanner reader;

	private Dagma dagma;

	public MainWetland(){

		reader = new Scanner(System.in);
	}
	
	public static void main(String[] a){
		System.out.println("\n**Bienvenido/a a la aplicacion de administracion de humedales.**\n");

		MainWetland obj = new MainWetland();
		obj.startApp();

		int option = 0;

		do{
			option = obj.menu();
			obj.menuOption(option);
		}while(option != 0);
		
	}

	public int menu(){
		int option;
		System.out.println("**Elija una de las opciones escribiendo el numero con la informacion que desee ver (0 para cerrar la app):**\n" + 
			"1. Registrar un humedal(wip)\n"+ 
			"2. Registrar una especie(wip)\n"+
			"3. Registrar un evento(wip)\n"+
			"4. Mantenimientos de un humedal(wip)\n" +
			"5. Humedal con mas flora(wip)\n"+
			"6. *Aun pensando el nombre de la opcion*\n"+
			"7. Informacion de los humedales(wip)\n"+
			"8. Humedal con mas fauna\n");

		option = reader.nextInt();
		reader.nextLine();
		return option;
	}

	public void menuOption(int op){
		switch(op){
		case 0:
			System.out.println("Cerrando el programa. Tenga un buen dia!");
			break;
		case 1:
			registerWetland();
			break;
		case 2:
			break;
		case 3:
			registerEvent();
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:		
		}


	}

	public void startApp(){

		System.out.println("Iniciando la app, un momento...\n");

		dagma = new Dagma();
	}

	public void registerWetland(){

		if(dagma.hasSpaceWetland()){
			System.out.println("Ingrese el nombre del humedal");
			String name = reader.nextLine();

			System.out.println("Ahora la zona en la cual se encuentra el humedal. (Escribir Rural o Urbano)" + name.toLowerCase());
			String location  = reader.nextLine();

			System.out.println("El humedal es publico o privado? (Escirba publico o privado)");
			String type = reader.nextLine();

			System.out.println("Area del humedal: (Solo numeros)");
			double area = reader.nextDouble();
			reader.nextLine();

			System.out.println("Agregue la URL de la foto del humedal");
			String url = reader.nextLine();

			System.out.println("Es una area protegida? (Si/No)");
			String protec = reader.nextLine();

			System.out.println("Por ultimo, el nombre de la zona:");
			String nameZone = reader.nextLine();

			System.out.println("\nRegistrando humedal...\n");

			System.out.println(dagma.addWetland(name, location, type, area, url, protec, nameZone));

		} else {
			System.out.println("Lo sentimos, ya se alcanzo el limite de humedales. Se encuentran registrados los 80 humedales.");
		}
	}

	public void registerEvent(){
		String nameWetland = "";
		do{
			System.out.println("Ingrese el nombre del humedal en el que se llevara a cabo el evento:");
			nameWetland = reader.nextLine();
			System.out.println(dagma.findWetland(nameWetland));
		}while(dagma.findWetland(nameWetland).equals("Lo sentimos, ese humedal no existe en la base de datos"));

		System.out.println("Ingrese el nombre del organizador:");
		String name = reader.nextLine();

		System.out.println("Ingrese el tipo de evento: 1) Mantenimiento\n 2) Viaje Escolar\n 3) Actividad de mejoramiento\n 4) Celebracion\n 5)Otro" );
		int optionEv = reader.nextInt();
		reader.nextLine();

		System.out.println("Ingrese el costo de realizacion del evento:");
		double cost = reader.nextDouble();
		reader.nextLine();

		System.out.println("Ingrese la fecha del evento. Primero el dia:");
		int d = reader.nextInt();
		reader.nextLine();
		System.out.println("Ahora el mes:");
		int m = reader.nextInt();
		reader.nextLine();
		System.out.println("Por ultimo el año:");
		int y = reader.nextInt();
		reader.nextLine();


		System.out.println("Por ultimo ingrese una pequeña descripción del evento: ");
		String description = reader.nextLine();

		dagma.addEvent2Wetland(name,cost,description,optionEv,nameWetland, d, m, y );
	}

}