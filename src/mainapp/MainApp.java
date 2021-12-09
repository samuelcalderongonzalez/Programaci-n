package mainapp;

import java.util.ArrayList;
import java.util.Scanner;
import models.CuentaCorriente;
import models.Persona;

public class MainApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Persona> personas = new ArrayList<Persona>(); // He hecho dos arraylist; uno para las personas y otro
																// para las cuentas
		ArrayList<CuentaCorriente> cuentas = new ArrayList<CuentaCorriente>();
		int nCuenta = 1; // Contador para asignar un numero de cuenta
		String opcion;
		do { // Men� principal: Bucle que se repite mientras no se elija la opci�n de salida

			System.out
					.println("Elija una opci�n...\na. A�adir persona\tb. Elegir persona\tc. Borrar persona\td. Salir");
			opcion = sc.nextLine(); // Elegir opcion
			switch (opcion) { // Switch con la opcion
			case "a":
				System.out.println("Por favor, introduzca los datos necesarios para la creaci�n de la cuenta:");
				System.out.print("Nombre: ");
				String nombre = sc.nextLine();
				System.out.print("Apellidos: ");
				String apellidos = sc.nextLine();
				System.out.print("DNI: ");
				String dni = sc.nextLine();
				System.out.print("Sueldo: ");
				double sueldo = Double.parseDouble(sc.nextLine());
				// Creo la cuenta antes que la persona para evitar errores
				cuentas.add(new CuentaCorriente(nCuenta, 0, null));
				// Le asigno a la persona la �ltima cuenta creada
				personas.add(new Persona(nombre, apellidos, dni, sueldo, cuentas.get(cuentas.size() - 1)));
				cuentas.get(cuentas.size() - 1).setTitular(personas.get(cuentas.size() - 1));
				nCuenta++; // Sumo 1 al contador de asignaci�n de numero de cuenta
				break;
			case "b":
				if (personas.isEmpty())
					System.out.println("No hay personas para elegir");
				else {
					int i = 1;
					for (Persona p : personas) { // Bucle que recorre e imprime el arraylist
						System.out.println(i + ". " + p.getNombre() + ", DNI -> " + p.getDni());
						i++;
					}
					int elegirP;
					do {
						System.out.print("Elija la persona: ");
						elegirP = Integer.parseInt(sc.nextLine());
						if (elegirP > i | elegirP <= 0) // Comprobaci�n de elecci�n v�lida
							System.out.println("Elija una opci�n v�lida. Debe ser un entero que est� en la lista");
					} while (elegirP > i | elegirP <= 0); // Se repite bucle hasta que se elija opci�n v�lida
					System.out.println("�Que quieres hacer, " + personas.get(elegirP - 1).getNombre() + "?");
					System.out.println("1. Cobrar sueldo\t2. Sacar pasta\t3. Subir sueldo\t4. Mostrar detalles"); // Creacion
																													// de
																													// submen�
					int opcion2 = Integer.parseInt(sc.nextLine());
					switch (opcion2) {
					case 1:
						personas.get(elegirP - 1).cobrarSueldo(); // Realizar los m�todos correspondientes con su
																	// respectiva
																	// comprobaci�n de erroes
						break;
					case 2:
						System.out.print("�Cu�nto dinero quieres sacar?: ");
						try {
							personas.get(elegirP - 1).sacarPasta(Integer.parseInt(sc.nextLine()));
						} catch (NumberFormatException e) {
							e.printStackTrace();
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					case 3:
						System.out.print("Introduzca el nuevo sueldo: ");
						try {
							personas.get(elegirP - 1).subirSueldo(Integer.parseInt(sc.nextLine()));
						} catch (NumberFormatException e) {
							e.printStackTrace();
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					case 4:
						System.out.println(personas.get(elegirP - 1));
						break;
					default:
						System.out.println("Por favor, elija una opci�n v�lida");
						break;
					}
				}
				break;
			case "c":
				if (personas.isEmpty())
					System.out.println("No hay personas para eliminar");
				else {
					int j = 1;
					for (Persona p : personas) { // Vuelvo a recorrer e imprimir el arraylist
						System.out.println(j + ". " + p.getNombre() + ", DNI -> " + p.getDni());
						j++;
					}
					int eliminar;
					do {
						System.out.print("Elija la persona que quiere eliminar: ");
						eliminar = Integer.parseInt(sc.nextLine()); // Elimino la persona y su respectiva cuenta del
																	// arraylist
						if (eliminar > personas.size() | eliminar <= 0)
							System.out.println("Introduzca un numero valido");
						else {
							System.out.println("Persona "+personas.get(eliminar-1).getNombre()+" eliminada");
							personas.remove(eliminar - 1);
							cuentas.remove(eliminar - 1);						
							break;
						}
					} while (eliminar > personas.size() | eliminar <= 0);
				}
				break;
			case "d":
				int easteregg = (int) (Math.random() * 8192) + 1; // He implementado un easter egg con un mensaje de
																	// despedida especial. Este tiene la misma
																	// probabilidad que un pokemon shiny =)
				int despedida = (int) (Math.random() * 4) + 1; // Imprime una despedida aleatoria entre 4 opciones
				if (easteregg != 69) {
					switch (despedida) {
					case 1:
						System.out.println("Adi�s, tenga un buen d�a :)");
						break;
					case 2:
						System.out.println("Hasta luego, vuelva pronto");
						break;
					case 3:
						System.out.println("�Cyao!");
						break;
					case 4:
						System.out.println("Bye.");
						break;
					}
				} else if (easteregg == 69)
					System.out.println("Este mensaje tiene la misma probabilidad de aparici�n que un pokemon shiny. Buen d�a! =)");
				break;
			default:
				System.out.println("Por favor, elija una opci�n v�lida");
				break;
			}

		} while (!opcion.equals("d"));

		sc.close();
	}

}
