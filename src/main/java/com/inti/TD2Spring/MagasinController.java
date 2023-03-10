package com.inti.TD2Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inti.TD2Spring.service.MagasinService;
import com.inti.model.Magasin;



@Controller
@RequestMapping("magasin")
public class MagasinController {
	
	@Autowired
	MagasinService ms;
	
	@GetMapping("ajout")
	public String ajoutMagasin()
	{
		return "enregistrementMag";
	}
	
	@PostMapping("save")
	public String enregistrerProduit(@ModelAttribute ("m") Magasin m)
	{
		 ms.saveMagasin(m);;
			
		return "redirect:/magasin/ajout";
	}

}
