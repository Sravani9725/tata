package com.cg.pack.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pack.entities.Account;
import com.cg.pack.entities.Pack;
import com.cg.pack.entities.Recharge;
import com.cg.pack.exception.AccountNotFoundException;
import com.cg.pack.exception.UserNotFoundException;
import com.cg.pack.repository.RechargeRepository;

@Service
public class RechargeServiceImpl implements IRechargeService {
	Logger logger = LoggerFactory.getLogger(RechargeServiceImpl.class);

	@Autowired
	private RechargeRepository repository;

	@Override
	public Recharge createrecharge(Pack pack, Account account) {
		logger.info("Inside \"createrecharge\" pack");
		Recharge getpackdetails = repository.findById(pack.getPackId()).orElse(null);
		Recharge dorecharge = null;
		dorecharge.setPlanDescription(getpackdetails.getPlanDescription());
		dorecharge.setAmount(getpackdetails.getAmount());
		dorecharge.setDaysValidity(getpackdetails.getDaysValidity());
		dorecharge.setPurcahsedDate(LocalDate.now());
		dorecharge.setChannels(getpackdetails.getChannels());
		return repository.save(dorecharge);
	}

	@Override
	public Recharge update(Recharge recharge) throws UserNotFoundException{
		logger.info("Inside \"updateServiceImpl\" class");
		Recharge updaterecharge = repository.findById(recharge.getRechargeid()).orElse(null);
		recharge.setPlanDescription(updaterecharge.getPlanDescription());
		recharge.setAmount(updaterecharge.getAmount());
		recharge.setDaysValidity(updaterecharge.getDaysValidity());
		recharge.setPurcahsedDate(LocalDate.now());
		recharge.setChannels(updaterecharge.getChannels());
		return repository.save(recharge);
	}


	@Override
	public int rechargesForUserCount(Account account) throws AccountNotFoundException {
		logger.info("Inside \"rechargesForUserCount\" class");
		Recharge accdetails = repository.findById(account.getAccountId()).orElse(null);
		List<String> actual = accdetails.getChannels();
		int count = actual.lastIndexOf(actual);
		return count;
	}

	@Override
	public List<Recharge> findAllRechargesInPeriod(LocalDate startDate, LocalDate endDate) {
		logger.info("Inside \"findAllRechargesInPeriod\" class");
		List<Recharge> frecharge=repository.findAll();
		List<Recharge> rlist = null;
		for(Recharge r:frecharge) {
			if(r.getPurcahsedDate().isAfter(startDate) && r.getPurcahsedDate().isBefore(endDate)) {
				rlist=frecharge;
			}
		}
		return rlist;
	}

	@Override
	public int countRechargesInPeriod(LocalDate startDate, LocalDate endDate) {
		logger.info("Inside \"countRechargesInPeriod\" class");
		int count=0;
		List<Recharge> lrecharge=repository.findAll();
		for(Recharge c:lrecharge) {
			if(c.getPurcahsedDate().isAfter(startDate) && c.getPurcahsedDate().isBefore(endDate))
				count++;
		}
		return count;
	}

	@Override
	public double totalRevenueInPeriod(LocalDate startDate, LocalDate endDate) {
		logger.info("Inside \"totalRevenueInPeriod\" class");
		List<Recharge> recharge = repository.findAll();
		double revenue=0d;
		for(Recharge r :recharge) {
			if(r.getPurcahsedDate().isAfter(startDate) && r.getPurcahsedDate().isBefore(endDate)) {
				revenue+=r.getAmount();
			}
		}
		return revenue;
	}

	@Override
	// no variable present in pack to enable the count
	public int rechargesCount(Pack pack) {
		logger.info("Inside \"rechargesCount\" class");
		
		
		return 0;
	}

	@Override
	public Recharge expireIfValidityFinished(Account account, Recharge recharge) {
		logger.info("Inside \"expireIfValidityFinished\" class");
		double val = recharge.getDaysValidity();
		LocalDate expiry = recharge.getPurcahsedDate().plusDays((long) val);
		LocalDate today = LocalDate.now();
		String date_expiry = expiry.toString();
		String todays_date = today.toString();
		double days = expiry.compareTo(today);
		if (days >= val)
			repository.deleteById(recharge.getRechargeid());
		return recharge;
	}


	@Override
	public List<Recharge> findRechargesForUserInDescendingOrderByPurchasedDate(Account account) {
		logger.info("Inside \"findRechargesForUserInDescendingOrderByPurchasedDate\" class");
		List<Recharge> recharge = repository.findAll();
		
		return null;
	}
}
