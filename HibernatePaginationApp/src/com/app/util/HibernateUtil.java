package com.app.util; 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
		static SessionFactory sf;
		Session ses;
		
		static {
			Configuration cfg=new Configuration(); 
			cfg.configure();
			sf=cfg.buildSessionFactory();
		}
	 	
		public static SessionFactory getSessionFactory() {
			return sf;
		}
}

