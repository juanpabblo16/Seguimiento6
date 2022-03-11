package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import model.Billboard;
import model.BillboardList;

public class Main {

	static BillboardList billboardlist;
	
	static Scanner sn = new Scanner(System.in);

	public static void main(String[] args) throws IOException, ClassNotFoundException, IndexOutOfBoundsException {

		// ATRIBUTOS
		
		

		billboardlist = new BillboardList();

		billboardlist.loadBillboard();

		// MENU
		boolean salir = false;

		int opcion = 0;

		System.out.println("BIENVENIDOS AL CONTROL DE INFORMACION DE DATOS DE VALLAS PUBLICITARIAS" + "\n");

		System.out.println("A continuacion vera las opciones disponibles con las que cuenta el pograma" + "\n"
				+ "Ingrese la opcion deseada");

		while (!salir) {

			System.out.println("1. Importar datos CSV" + "\n");

			System.out.println("2. Agregar valla publicitaria" + "\n");

			System.out.println("3. Mostrar vallas publicitarias" + "\n");

			System.out.println("4. Exportar reporte de peligrosidad" + "\n");

			System.out.println("5. Salir" + "\n");

			System.out.println("Ingrese la opcion deseada:" + "\n");

			opcion = sn.nextInt();

		}

		switch (opcion) {
		case 1:
			System.out.println("Has seleccionado la opcion 1");

			importarDatos();

			break;
		case 2:
			System.out.println("Has seleccionado la opcion 2");

			AgregarValla();

			break;
		case 3:
			System.out.println("Has seleccionado la opcion 3");

			MostrarVallas();

			break;

		case 4:
			System.out.println("Has seleccionado la opcion 4");

			ReporteDeSeguridad();

			break;
		case 5:
			salir = true;
			break;
		default:
			System.out.println("Solo números entre 1 y 4");
		}

		// METODOS

	}

	private static void ReporteDeSeguridad() throws ClassNotFoundException, IOException {

		deserialize();
		readVallaBuffer();
		
		
	}

	private static void MostrarVallas() throws IOException, ClassNotFoundException {
		
		deserialize();
		readVallaBuffer();
		
	}

	private static void AgregarValla() {
		
		try {
			deserialize();
			writeValla();
			
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void importarDatos() {
	}

	// TRABAJO INTERNO PERSISTENCIA

	public static void serialize() throws IOException {

		File file = new File("./files/Datos1.csv");
		File file2 = new File("./files/Datos2.csv");

		FileOutputStream fos = new FileOutputStream(file);
		FileOutputStream fos2 = new FileOutputStream(file2);

		ObjectOutputStream oos = new ObjectOutputStream(fos);
		ObjectOutputStream oos2 = new ObjectOutputStream(fos2);

		oos.writeObject(billboardlist.getBillboard());
		oos2.writeObject(billboardlist.getBillboard());

		oos2.close();
		oos.close();
		fos2.close();
		fos.close();

		System.out.println("Serializado");

	}

	public static void deserialize() throws IOException, ClassNotFoundException {

		File file = new File("./files/Datos1.csv");
		File file2 = new File("./files/Datos2.csv");

		FileInputStream fis = new FileInputStream(file);
		FileInputStream fis2 = new FileInputStream(file2);

		ObjectInputStream ois = new ObjectInputStream(fis);
		ObjectInputStream ois2 = new ObjectInputStream(fis2);

		ArrayList<Billboard> obj = (ArrayList<Billboard>) ois.readObject();
		System.out.println(obj);

		ois2.close();
		ois.close();
		fis2.close();
		fis.close();

		System.out.println("Deserializado");
	}

	public static void readVallaBuffer() throws IOException {
		
		File file = new File("./files/Datos1.csv");
		File file2 = new File("./files/Datos2.csv");
		
		FileReader fr = new FileReader(file);
		FileReader fr2 = new FileReader(file2);

		
		BufferedReader input = new BufferedReader(fr);
		BufferedReader input2 = new BufferedReader(fr2);

		
		while (input.ready() && input2.ready()) {
			
			System.out.println(input.readLine());
			System.out.println(input2.readLine());
			
			
			
		}
		
		
		fr.close();
		fr2.close();
		input.close();
		input2.close();

	}
	
	public static void writeValla() throws IOException {
				
		File file = new File("./files/Datos1.csv");
		File file2 = new File("./files/Datos2.csv");
		
		FileWriter fw = new FileWriter(file);
		FileWriter fw2 = new FileWriter(file2);
		
		BufferedWriter output = new BufferedWriter(fw);
		BufferedWriter output2 = new BufferedWriter(fw2);
		
		System.out.println("Ingrese la valla a agregar con los parametros que se muestran a continuacion"+"\n");
		
		System.out.println("EJEMPLO:"+"\n");
		
		System.out.println("W" + "H" + "inUse" + "Brand");
		
		System.out.println("200++300++true++Mister Wings\n"
				+ "");
		
		String newValla = sn.nextLine();
		
		System.out.println("Ahora ingrese los datos del archivo #2");
		
		System.out.println("Ingrese la valla a agregar con los parametros que se muestran a continuacion"+"\n");
		
		System.out.println("EJEMPLO:"+"\n");
		
		System.out.println("W" + "H" + "inUse" + "Brand");
		
		System.out.println("200++300++true++Mister Wings\n"
				+ "");
		
		String newValla2 = sn.nextLine();
		
		
		
		output.write(newValla);
		output.newLine();
		
		output2.write(newValla2);
		output2.newLine();
		
		output.close();
		output2.close();
		fw.close();
		fw2.close();
	}
	
	public void ReporteSeguridad() throws IOException {

		File file = new File("./files/Datos1.csv");
		File file2 = new File("./files/Datos2.csv");

		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileWriter fw2 = null;
		try {
			fw2 = new FileWriter(file2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		BufferedWriter output = new BufferedWriter(fw);
		BufferedWriter output2 = new BufferedWriter(fw2);

		System.out.println(
				"Ahora ingresa los valores solicitados manualmente del reporte para verificar su seguridad:" + "\n");

		System.out.println("La altura en cm cuadrados: H");
		double reporteHSeguridad = sn.nextInt();

		System.out.println("El peso en cm cuadrados: W");
		double reporteWSeguridad = sn.nextInt();

		output.write((int) reporteHSeguridad);
		output.newLine();

		output2.write((int) reporteWSeguridad);
		output2.newLine();
		
		if (reporteHSeguridad >= 200.000 && reporteWSeguridad >= 200.000) {
			
			System.out.println("===========================\n"
					+ "DANGEROUS BILLBOARD REPORT\n"
					+ "===========================\n"
					+ "");
			
			System.out.println("ingresar el nombre de la marca");
			
			String nameBrandTemporally = sn.nextLine();
			
			System.out.println("La valla peligrosa es:\n"
					+ "1. Marca" + nameBrandTemporally + "con area" +reporteHSeguridad + reporteWSeguridad + "\n"
					+ "");
			
			System.out.println("Su valla se considera peligrosa y/o obstruye la visibildad de la via" + "\n");

			
			System.out.println("Favor retirarla de inmediato" + "\n");
			
			output.write(nameBrandTemporally);
			output.newLine();
			
			
		}
		

		output2.close();
		output.close();
		
	}

}
