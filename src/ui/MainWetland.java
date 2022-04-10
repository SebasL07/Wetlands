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
			"1. Registrar un humedal\n"+ 
			"2. Registrar una especie\n"+
			"3. Registrar un evento\n"+
			"4. Mantenimientos de un humedal(wip)\n" +
			"5. Humedal con menos flora\n"+
			"6. Informacion de una especie\n"+
			"7. Informacion de los humedales\n"+
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
			registerSpecie();
			break;
		case 3:
			registerEvent();
			break;
		case 4:
			
			break;
		case 5:
			System.out.println(dagma.wetlandMoreFlora());
			break;
		case 6:
			showSpecie();
			break;
		case 7:
			System.out.println(dagma.showWetlands());
			break;
		case 8:
			System.out.println(dagma.wetlandMoreFauna());		
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

			System.out.println("Ahora la zona en la cual se encuentra el humedal. (Escribir Rural o Urbano)");
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

			System.out.println("El nombre de la zona:");
			String nameZone = reader.nextLine();

			System.out.println("Ingrese el porcentaje completado del plan medioambiental (Solo numeros)");
			double per = reader.nextDouble();
			reader.nextLine();

			System.out.println("Por ultimo, ingrese una pequeña descripción del plan");
			String des = reader.nextLine();

			System.out.println("\nRegistrando humedal...\n");

			System.out.println(dagma.addWetland(name, location, type, area, url, protec, nameZone, per, des));

		} else {
			System.out.println("Lo sentimos, ya se alcanzo el limite de humedales. Se encuentran registrados los 80 humedales.");
		}
	}

	public void registerEvent(){
		String nameWetland = "";
		do{
			System.out.println("Ingrese el nombre del humedal en el que se llevara a cabo el evento:");
			nameWetland = reader.nextLine();
			if(dagma.findWetland(nameWetland) == -1){
				System.out.println("Lo sentimos, ese humedal no existe en el sistema, intentelo de nuevo");
			}
		}while(dagma.findWetland(nameWetland) == -1);

		System.out.println("Ingrese el nombre del organizador:");
		String name = reader.nextLine();

		System.out.println("Ingrese el tipo de evento:\n 1) Mantenimiento\n 2) Viaje Escolar\n 3) Actividad de mejoramiento\n 4) Celebracion\n 5) Otro" );
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

		dagma.addEvent2Wetland(name,cost,description,optionEv, d, m, y, nameWetland);
	}

	public void registerSpecie(){
		String nameWetland = "";

		System.out.println("Ingrese el nombre de la especie:");
		String name = reader.nextLine();

		System.out.println("Ingrese el nombre cientifico de la especie: ");
		String scientificName = reader.nextLine();

		System.out.println("Es una especie migratoria? (Si/No)");
		String migratorySpecie = reader.nextLine();

		System.out.println("Ingrese el tipo de especie:\n 1) Flora acuatica\n 2) Flora terrestre\n 3) Ave\n 4) Mamifero\n 5) Acuatico" );
		int optionSp = reader.nextInt();
		reader.nextLine();

		do{
			System.out.println("Ingrese el nombre del humedal en el que se encuentra la especie:");
			nameWetland = reader.nextLine();
			if(dagma.findWetland(nameWetland) == -1){
				System.out.println("Lo sentimos, ese humedal no existe en el sistema, intentelo de nuevo");
			}
		}while(dagma.findWetland(nameWetland) == -1);

		dagma.addSpecie2Wetland(name,scientificName,migratorySpecie,optionSp, nameWetland);
	}

	public void showSpecie(){

		System.out.println("Que especie desea buscar? Ingrese el nombre de la especie");
		String name = reader.nextLine();

		System.out.println(dagma.specieInWetland(name));
	} 
	/*
	public void maintenance(){
		String nameWetland = "";
		do{
			System.out.println("De que humedal desea ver esta informacion?");
			nameWetland = reader.nextLine();
			if(dagma.findWetland(nameWetland) == -1){
				System.out.println("Lo sentimos, ese humedal no existe en el sistema, intentelo de nuevo");
			}
		}while(dagma.findWetland(nameWetland) == -1);

		System.out.println("En que año?");
		int y = reader.nextInt();
		reader.nextLine();

		System.out.println("En el humedal " + nameWetland + " se han hecho " + dagma.maintenanceInAYear(y, nameWetland));
	}
	*/
}