package com.inti.TD2Spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inti.model.Magasin;


@Service
public interface MagasinService {
	public List<Magasin> getMagasin();
	public void saveMagasin(Magasin p);
	public Magasin getMagasin(int id);
	public void deleteMagasin(int id);
	public Magasin updateMagasin(Magasin m);

}
