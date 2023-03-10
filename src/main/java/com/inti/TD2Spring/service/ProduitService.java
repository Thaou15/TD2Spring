package com.inti.TD2Spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inti.model.Produit;

@Service
public interface ProduitService {
	public List<Produit> getProduits();
	public void saveProduit(Produit p);
	public Produit getProduit(int id);
	public void deleteProduit(int id);

}
