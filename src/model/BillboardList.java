package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BillboardList {

	private List<Billboard> billboard;

	private Boolean use = false;

	public BillboardList() {

		billboard = new ArrayList<Billboard>();

	}

	public void addBillboard(boolean use, int w, int h, String brand) {

		billboard.add(new Billboard(use, w, h, brand));

	}

	public void loadBillboard() throws IOException {
		File file = new File("./files/Datos1.csv");

		FileReader fr = new FileReader(file);

		BufferedReader input = new BufferedReader(fr);

		input.readLine();

		while (input.ready()) {

			String line = input.readLine();
			String[] data = line.split(";");

			String stringUse = Boolean.toString(use);

			stringUse = data[0];
			

			int w = Integer.parseInt(data[1]);

			int h = Integer.parseInt(data[2]);
			

			String brand = data[3];

			addBillboard(use, w, h, brand);
		}

		input.close();
		fr.close();

	}
	
	

	public List<Billboard> getBillboard() {
		return billboard;
	}

}
