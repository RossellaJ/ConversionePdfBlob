package it.alfasoft.rossella.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import hibernateUtil.HibernateUtil;
import it.alfasoft.rossella.dao.FatturaDao;
import it.alfasoft.rossella.model.Fattura;

public class Main {

	public static void main(String[] args) {
		
		Date d = new Date();
		Fattura fattura = new Fattura(d,2500,"oiu25");
		FatturaDao fDao = new FatturaDao();
		
		//prendo il file pdf in java
		File file= new File("C:\\Users\\corso\\Desktop\\Jasper\\FatturaAzienda 001.pdf");
		
		
		Session session = HibernateUtil.openSession(); //apro la sessione in hibernate
		try {
			FileInputStream fileInputStream = new FileInputStream(file); //lettura del file
		
			//Convertire file.pdf in Blob
			Blob blob = Hibernate.getLobCreator(session)
							 .createBlob(fileInputStream, file.length()); //crea Blob
			session.close();
			
			
			fattura.setAllegatoPdf(blob);
			fDao.createFattura(fattura);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
