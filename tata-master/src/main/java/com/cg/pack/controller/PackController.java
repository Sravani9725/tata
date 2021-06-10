package com.cg.pack.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;

import com.cg.pack.entities.Pack;
import com.cg.pack.exception.PackNotFoundException;
import com.cg.pack.service.IPackService;

@RestController
@RequestMapping("/packs")
public class PackController {

	Logger logger = LoggerFactory.getLogger(PackController.class);
	@Autowired
	private IPackService packservice;

	@PostMapping("{/addpack}")
	@ApiOperation("Add New Pack")
	public Pack addPack(@Valid @RequestBody Pack pack) {
		logger.info("Add a Pack");
		return packservice.addPack(pack);

	}

//	@PutMapping("{/updatepack}")
//	@ApiOperation("Üpdate the pack")
//	public Pack updatePack(@Valid @RequestBody Pack pack) throws PackNotFoundException {
//		logger.info("Update the Pack");
//
//		return packservice.updatePack(pack);
//
//	}
//	
	@DeleteMapping("/delete/{id}")
	@ApiOperation("Delete a Pack")
	public ResponseEntity<Void> deletePack(@RequestParam long packId) throws PackNotFoundException {
		logger.info("Delete a Pack");

		packservice.deleteByPackId(packId);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/getPackById/{packId}")
	@ApiOperation("Get Pack By ID")
	public Pack findById(@PathVariable Long packId)
			throws NumberFormatException, PackNotFoundException {
		logger.info("Find By Id %s", packId);

		return packservice.findPackById(packId);
	}

	@GetMapping("/getPackByName/{packName}")
	@ApiOperation("Get Pack By Name")
	public Pack findPackByName(@PathVariable String packName)
			throws PackNotFoundException {
		logger.info("Find By Name %s", packName);

		return packservice.findBypackName(packName);

	}

	
//	  @GetMapping("/popularpacks")
//	  
//	  @ApiOperation("Get popular packs") public List<Pack> popularPacks() throws
//	  PackNotFoundException {
//	  logger.info("popular packs");
//	  
//	  return packservice.popularPacks();
//	  
//	  }
	 
	@GetMapping("/daysvalidity")
	@ApiOperation("Packs By Ascending order based on Validity")
	public List<Pack> findPacksInAscendingOrderByDaysValidity()
			throws PackNotFoundException {
		logger.info("Order By validity");
		return packservice.findPacksInAscendingOrderByDaysValidity();

	}

//	@GetMapping("/cost")
//	@ApiOperation("Packs By Descending Order based on cost")
//	public List<Pack> findPacksInAscendingOrderByCost() throws PackNotFoundException {
//		logger.info("Order by cost");
//
//		return packservice.findPacksInAscendingOrderByCost();
//	}

	@GetMapping("/amount")
	@ApiOperation("Packs By amount")
	public List<Pack> findPacksGreaterThanAmount(@RequestParam double amount) throws PackNotFoundException {
		logger.info("Packs Greater amount");

		return packservice.findPacksGreaterThanAmount(amount);

	}
}