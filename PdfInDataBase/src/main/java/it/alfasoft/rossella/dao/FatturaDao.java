package it.alfasoft.rossella.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.alfasoft.rossella.model.Fattura;
import hibernateUtil.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FatturaDao {
	
	 // 1 create
	
	public boolean createFattura(Fattura f) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			
			tx.begin();
			session.persist(f);
			tx.commit();
			
			res = true;
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;

	}
	//2a read con id del DB
	
			public Fattura readFatturaConId(long id) {
				
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				Fattura f = null;
				
				try {	
					tx = session.getTransaction();
					
					tx.begin();
					Query query = session.createQuery("from Fattura where id=:idInserito");
					query.setLong("idInserito", id);
					f = (Fattura) query.uniqueResult();
					tx.commit();
					
				} catch (Exception ex) {
					tx.rollback();
				} finally {
					session.close();			
				}		
				return f;
			}
			
			//2a read con codiceAdiendale
			
			public Fattura readFatturaConCodice(String codiceFattura) {
				
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				Fattura f = null;
				
				try {	
					tx = session.getTransaction();
					
					tx.begin();
					Query query = session.createQuery("from Fattura where codiceFattura=:codiceInserito");
					query.setString("codiceInserito", codiceFattura);
					f = (Fattura) query.uniqueResult();
					tx.commit();
					
				} catch (Exception ex) {
					tx.rollback();
				} finally {
					session.close();			
				}		
				return f;
			}
			
			
			//2b read tutti
			public List<Fattura> readTutteFatture(){
			
			List<Fattura> listaFatture = new ArrayList<Fattura>();

			Session session = HibernateUtil.openSession();
			Transaction tx = null;
			
			try {	
				tx = session.getTransaction();
				tx.begin();
				
				Query query = session.createQuery("From Fattura");
				
				listaFatture= query.list();
					
				tx.commit();
				
			} catch (Exception ex) {
				tx.rollback();
			} finally {
				session.close();			
			}
			
			return listaFatture;
			}
			
			//read tutte fatture con Date
			
			public List<Fattura> readFattureConData(Date dataInizio, Date dataFine){
				List<Fattura> listaFatture = new ArrayList<Fattura>();
				
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				
				try {	
					tx = session.getTransaction();
					tx.begin();
					
					Query query = session.createQuery("from Fattura as f where f.data between :dataInizio and :dataFine");
					query.setDate("dataInizio", dataInizio);
					query.setDate("dataFine", dataFine );
					
					listaFatture= query.list();
						
					tx.commit();
					
				} catch (Exception ex) {
					tx.rollback();
				} finally {
					session.close();			
				}		
				return listaFatture;
			}
			
			//3 update
			
			public boolean updateFattura(Fattura f) {
				
				boolean res = false;
				
				Session session = HibernateUtil.openSession();
				
				Transaction tx = null;
				
				try {
					
					tx = session.getTransaction();
					
					tx.begin();
					
					session.update(f);
					
					tx.commit();
					
					res = true;
					
				} catch (Exception ex) {
					
					tx.rollback();
					
				} finally {
					
					session.close();
					
				}
				
				return res;
				
			}
			
			//4 delete
			
				public boolean deleteFattura(Fattura f) {

					boolean res = false;

					Session session = HibernateUtil.openSession();

					Transaction tx = null;

					try {

						tx = session.getTransaction();

						tx.begin();

						session.delete(f);

						tx.commit();

						res = true;

					} catch (Exception ex) {

						tx.rollback();

					} finally {

						session.close();

					}

					return res;

				}
				
				

}
