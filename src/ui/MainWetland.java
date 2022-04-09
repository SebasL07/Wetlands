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

		int option = 0;

		MainWetland obj = new MainWetland();
		obj.startApp();

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

		case 1:

		case 2:

		case 3:

		case 4:

		case 5:

		case 6:

		case 7:

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

			System.out.println("Por ultimo, el nombre de la zona:");
			String nameZone = reader.nextLine();

			System.out.println("Registrando humedal...");

			System.out.println(dagma.addWetland(name, location, type, area, url, protec, nameZone));

		} else {
			System.out.println("Lo sentimos, ya se alcanzo el limite de humedales. Se encuentran registrados los 80 humedales.")
		}
	}

}