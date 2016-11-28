package it.alfasoft.rossella.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import it.alfasoft.rossella.dao.FatturaDao;
import it.alfasoft.rossella.model.Fattura;

public class ProvaReadBlob {

	public static void main(String[] args) {
		FatturaDao fDao = new FatturaDao();
		
		Fattura f = fDao.readFatturaConCodice("oiu25");
		
		//Convertire Blob in Pdf
		Blob b = f.getAllegatoPdf();
		
		try {
			byte[] byteArray = b.getBytes(1, (int) b.length()); //ho un array di byte che compongono il file che è presente ne DB
			
			try {
				FileOutputStream outputStream = new FileOutputStream("C:\\Users\\corso\\Desktop\\Jasper\\MioFileBlob.pdf");
				
				outputStream.write(byteArray);
				
				outputStream.close();
			
			} catch ( Exception e) {
				
				e.printStackTrace();
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

	}

}
