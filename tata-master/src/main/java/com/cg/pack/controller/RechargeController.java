package com.cg.pack.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pack.entities.Account;
import com.cg.pack.entities.Pack;
import com.cg.pack.entities.Recharge;
import com.cg.pack.exception.AccountNotFoundException;
import com.cg.pack.exception.UserNotFoundException;
import com.cg.pack.service.IRechargeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/recharges")
public class RechargeController {
	
	@Autowired
	private IRechargeService service;

	@PostMapping("/addRecharge")
	@ApiOperation("Recharge your Account")
	public Recharge addRecharge(@RequestBody Pack pack, Account account) {
		return service.createrecharge(pack, account);
	}

	@PutMapping("/updateRecharge")
	@ApiOperation("Admin Update module")
	public Recharge updateRecharge(@RequestBody Recharge recharge) throws UserNotFoundException {
		return service.update(recharge);
	}

//	@GetMapping("/Recharges List in Descending Order")
//	@ApiOperation("Recharge History")
//	public List<Recharge> DecsOrder(@RequestBody Account account) {
//		return service.findRechargesForUserInDescendingOrderByPurchasedDate(account);
//	}

	@GetMapping("/userRechargeCount")
	@ApiOperation("Total Rechages Done")
	public int UserRechargesCount(@RequestBody Account account) throws AccountNotFoundException {
		return service.rechargesForUserCount(account);
	}

	@GetMapping("/list_of_recharges_In_Period/{startDate,endDate}")
	@ApiOperation("Recharge History in period")
	public List<Recharge> AllRechargesInPeriod(@PathVariable LocalDate startDate, LocalDate endDate) {
		return service.findAllRechargesInPeriod(startDate, endDate);
	}

	@GetMapping("/count_of_Recharges_in_Period/{startDate,endDate}")
	@ApiOperation("Recharge Count in period")
	public int countRechargeInPeriod(@PathVariable LocalDate startDate, LocalDate endDate) {
		return service.countRechargesInPeriod(startDate, endDate);
	}

	@GetMapping("/revenue_In_Period/{startDate,endDate}")
	@ApiOperation("Total Revenue in period ")
	public double RevenueInPeriod(@RequestBody LocalDate startDate, LocalDate endDate) {
		return service.totalRevenueInPeriod(startDate, endDate);
	}

	@GetMapping("/admin_Recharge_Count")
	@ApiOperation("Admin Complete Recharge Count")
	public int AdminReechargeCount(@RequestBody Pack pack) {
		return service.rechargesCount(pack);
	}

	@DeleteMapping("/delete_if_Expired")
	@ApiOperation("Pack Expiry")
	public Recharge Expiry(@RequestBody Account account, Recharge recharge) {
		return service.expireIfValidityFinished(account, recharge);
	}
}