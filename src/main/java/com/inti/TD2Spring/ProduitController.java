package com.inti.TD2Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.TD2Spring.service.ProduitService;
import com.inti.model.Produit;

@Controller
@RequestMapping("produit")
public class ProduitController {
	
	@Autowired
	ProduitService ps;
	
	@GetMapping("affichage")
	public String affichageNomProduit(@RequestParam(value="nom", required = true, defaultValue = "Marie") String nom, Model m)
	{
		m.addAttribute("nomP", nom);
		return "nomProduit";
	}
	
	@GetMapping("prix")
	public String affichagePrixProduit(@RequestParam(value="prix", required = true, defaultValue = "10") String prix, Model m)
	{
		m.addAttribute("prixP", prix);
		return "prixProduit";
	}
	
	@GetMapping("calcul")
	public String calculProduit(@RequestParam("nom") String nom,@RequestParam("prixHT") String prix, Model m)
	{
		m.addAttribute("nomP", nom);
		m.addAttribute("prixHT", prix);
		
		return "calculProduit";
	}
	
	@GetMapping("ajout")
	public String ajoutProduit()
	{
		return "enregistrement";
	}
	
	@PostMapping("save")
	public String enregistrerProduit(@ModelAttribute ("p") Produit p)
	{
		 ps.saveProduit(p);
			
		return "redirect:/produit/ajout";
	}
	
	@GetMapping("listeP")
	public String getAllProduit(Model m)
	{
	    m.addAttribute("listeP", ps.getProduits());
	
	
	return "listeProduits";
	
	}
	
	@GetMapping("P")
	public String getOneProduit(@RequestParam("id") int id, Model m )
	{
		
	   m.addAttribute("p" , ps.getProduit(id));
	
	
	return "produit";
	
	}
	@GetMapping("supprimer/{id}")
	public String deleteProduit(@PathVariable int id )
	{
		
	   ps.deleteProduit(id);;
	
	
	return "redirect:/produit/listeP";
	
	}

}
