package com.inti.TD2Spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.TD2Spring.service.MagasinService;
import com.inti.TD2Spring.service.ProduitService;
import com.inti.model.Magasin;
import com.inti.model.Produit;

@Controller
@RequestMapping("admin")
public class AdminController {
	@Autowired
	MagasinService ms;
	@Autowired
	ProduitService ps;
	
	@GetMapping("associerProduitsToMagasins")
	public String associerProduitsToMagasins( Model m)
	{
		m.addAttribute("listeM", ms.getMagasin());
		m.addAttribute("listeP", ps.getProduits());
		
		return "Produit_Magasin";
	}
	
	@PostMapping("affecterProduitsToMagasins")
	public String affecterProduitsToMagasins(@RequestParam("selectedProduits")List<Integer> listeIdP,
			                                 @RequestParam("selectedMagasins")List<Integer> listeIdM)
	{
		System.out.println("liste Id Produits : " + listeIdP);
		System.out.println("liste Id Magasins : " + listeIdM);
		
		
		List<Produit> listeProduit = new ArrayList<>();
		for(Integer idP : listeIdP)
		{
			listeProduit.add(ps.getProduit(idP));
		}
		
		List<Magasin> listeMagasin = new ArrayList<>();
		for(Integer idM : listeIdM) {
			
		listeMagasin.add(ms.getMagasin(idM));
		}
		
		for (Magasin magasin : listeMagasin) {
			// on recupère les anciens produits qu'on ajoute au nouveau, sinon ils sont supprimés
			for(Produit p : magasin.getListeProduit()) {
				listeProduit.add(p);		
			}
			
			magasin.setListeProduit(listeProduit);
			ms.updateMagasin(magasin);
			
		}	
		
		return "redirect:/admin/associerProduitsToMagasins";
	}

}
