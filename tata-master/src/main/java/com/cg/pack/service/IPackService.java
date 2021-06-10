package com.cg.pack.service;

import java.util.List;

import com.cg.pack.entities.Pack;
import com.cg.pack.exception.PackNotFoundException;

public interface IPackService {

	public Pack addPack(Pack pack);

	//public Pack updatePack(Pack pack) throws PackNotFoundException;
	
	public Pack findPackById(Long packId) throws PackNotFoundException;
	
	public Pack findBypackName(String packName) throws PackNotFoundException;
	
	public List<Pack> findPacksGreaterThanAmount(double amount);
	
	//public List<Pack> findPacksInAscendingOrderByCost(); 
	
	public List<Pack> findPacksInAscendingOrderByDaysValidity();
	
    //public List<Pack> popularPacks()throws PackNotFoundException;
	 
	
	public void deleteByPackId(Long packId) throws PackNotFoundException;
	
	
	
	
	
	
	
}
