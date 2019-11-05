package odev;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class Odev {

	public static void main(String[] args) throws URISyntaxException, IOException {
		Contraceptive Contra = null;
		File file = new File("src/cmc.data");
		FileReader fileReader = new FileReader(file);
		String line;
		BufferedReader br = new BufferedReader(fileReader);
		String[] lines = null;
		float mse=0;
		while ((line = br.readLine()) != null) {

		    lines = line.split(",");

		    
	        Contra = new Contraceptive(Integer.parseInt(lines[0]),Integer.parseInt(lines[1]),
	        		Integer.parseInt(lines[2]),
	        		Integer.parseInt(lines[3]),Integer.parseInt(lines[4]),Integer.parseInt(lines[5]),
	        		Integer.parseInt(lines[6]),Integer.parseInt(lines[7]),Integer.parseInt(lines[8]));
	        
	        if((((float)Integer.parseInt(lines[9])-Contra.getir())/(float)Integer.parseInt(lines[9]))>0)
	        	mse += (((float)Integer.parseInt(lines[9])-Contra.getir())/(float)Integer.parseInt(lines[9]));
	        else
	        	mse =  mse - (((float)Integer.parseInt(lines[9])-Contra.getir())/(float)Integer.parseInt(lines[9]));    	
		}
		System.out.println("MSE Hata :"+mse*100/1473);
		br.close();
                JFuzzyChart.get().chart(Contra.getModel());
            }
}

