package com.inti.TD2Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.service.ProduitService;

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
	
	@PostMapping("save")
	public String enregistrerProduit(@ModelAttribute "p" Produit p, Model m)
	{
		return "enregistrer";
	}

}
