package com.cg.pack.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pack.entities.Pack;
import com.cg.pack.exception.PackNotFoundException;
import com.cg.pack.repository.PackRepository;

@Service
public class PackServiceImpl implements IPackService {

	Logger logger = LoggerFactory.getLogger(PackServiceImpl.class);
	public List<Pack> packList;

	@Autowired
	private PackRepository repository;

	@Override
	public Pack addPack(Pack pack) {
		logger.info(pack.getPackName());		
		return repository.save(pack);

	}

//	@Override
//	public Pack updatePack(Pack pack) throws PackNotFoundException {
//
//		logger.info("Update pack");
//
//		Optional<Pack> entity = repository.findById(pack.getPackId());
//		if(!entity.isPresent()) {
//			throw new PackNotFoundException();
//		}
//
//		p.setPackCost(pack.getPackCost());
//		p.setPackDescription(pack.getPackDescription());
//		p.setPackName(pack.getPackName());
//		p.setPackValidity(pack.getPackValidity());
//
//		
//		return repository.save(p);
//
//	}

	@Override
	public Pack findPackById(Long PackId) throws PackNotFoundException {

		logger.info("FindPackById");

		Optional<Pack> pack = repository.findById(PackId);

		if (pack.isPresent()) {
			return pack.get();
		} else {
			throw new PackNotFoundException();
		}
	}

	@Override
	public Pack findBypackName(String packName) throws PackNotFoundException {

		logger.info("Find Pack By Name");

		Optional<Pack> pack = repository.findBypackName(packName);

		if (pack.isPresent()) {
			return pack.get();
		} else {
			throw new PackNotFoundException();
		}

	}

	@Override
	public List<Pack> findPacksGreaterThanAmount(double amount) {

		logger.info("Find Packs Greater Than The Amount");

		List<Pack> packs = repository.findAll();
		List<Pack> result = packs.stream().filter(p -> (p.getPackCost() > amount)).collect(Collectors.toList());
		return result;

	}

//	@Override
//	public List<Pack> findPacksInAscendingOrderByCost() {
//
//		logger.info("Find Packs In Ascending Order By Cost");
//		List<Pack> packs = repository.findAll();
//		Collections.sort(packs);
//		return packs;
//
//	}

	@Override
	public List<Pack> findPacksInAscendingOrderByDaysValidity() {

		logger.info("Find Packs In Ascending Order By Validity");

		List<Pack> packs = repository.findAll();
		//Collections.sort(packs, (p1, p2) -> p2.getPackValidity() - p1.getPackValidity());
		return packs;
	}

	
//	  @Override 
//	  public List<Pack> popularPacks() {
//	  
//	  logger.info("Popular Packs");
//	  
//	  return repository.findPopularPacks(); }
//	 

	@Override
	public void deleteByPackId(Long packId) throws PackNotFoundException {

		logger.info("Delete Pack");

		Optional<Pack> pack = repository.findById(packId);

		if (pack.isPresent()) {
			repository.deleteById(packId);
		} else {
			throw new PackNotFoundException();
		}
	}

}
