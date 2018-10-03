package ar.sarm.unq.sga;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ar.sarm.unq.sga.hibernate.SessionFactoryContainer;

public class GenerateData {

	public static void main(String[] args) {

		SessionFactoryContainer.buildSessionFactory(true);
		Session s = SessionFactoryContainer.getSessionFactory().getCurrentSession();

		Transaction transaction = s.beginTransaction();

		try {
			
			transaction.commit();
			
		} catch (RuntimeException e) {
			transaction.rollback();
			throw e;
			
		} finally {
			s.close();
			SessionFactoryContainer.getSessionFactory().close();
		}

	}

}
