package com.cg.pack.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.pack.entities.Account;
import com.cg.pack.entities.Pack;
import com.cg.pack.entities.Recharge;
import com.cg.pack.exception.AccountNotFoundException;
import com.cg.pack.exception.UserNotFoundException;

public interface IRechargeService {
	Recharge createrecharge(Pack pack, Account account);

	Recharge update(Recharge recharge) throws UserNotFoundException;

	List<Recharge> findRechargesForUserInDescendingOrderByPurchasedDate(Account account);

	int rechargesForUserCount(Account account) throws AccountNotFoundException;

	List<Recharge> findAllRechargesInPeriod(LocalDate startDate, LocalDate endDate);

	int countRechargesInPeriod(LocalDate startDate, LocalDate endDate);

	double totalRevenueInPeriod(LocalDate startDate, LocalDate endDate);

	int rechargesCount(Pack pack);

	Recharge expireIfValidityFinished(Account account, Recharge recharge);
}
