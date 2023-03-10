package com.inti.TD2Spring.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;


import com.inti.model.Produit;
import com.inti.util.HibernateUtil;

@Service
public class ProduitServiceImpl implements ProduitService{
	private static Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public List<Produit> getProduits() {
		List<Produit> listeProduits = null;
		try
		{
			session.beginTransaction();
			
		listeProduits = session.createNativeQuery("select * from produit", Produit.class).list();
			
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		return listeProduits;
	}

	@Override
	public void saveProduit(Produit p) {
		try
		{
			session.beginTransaction();
			
			session.save(p);
			
			session.getTransaction().commit();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		
		
	}

	@Override
	public Produit getProduit(int id) {
		Produit prod = null;
		try
		{
			session.beginTransaction();
			
			prod = session.get(Produit.class, id);
			
			session.getTransaction().commit();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		return prod;
	}

	@Override
	public void deleteProduit(int id) {
		try
		{
			session.beginTransaction();
			
			session.delete(session.get(Produit.class, id));;
			
			session.getTransaction().commit();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}
	
	

}
