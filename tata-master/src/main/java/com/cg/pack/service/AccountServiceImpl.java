package com.cg.pack.service;

import java.util.List;
//import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pack.entities.Account;
import com.cg.pack.entities.Pack;
import com.cg.pack.exception.AccountNotFoundException;
import com.cg.pack.exception.PackNotFoundException;
import com.cg.pack.repository.AccountRepository;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private AccountRepository repository;

	Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Override
	public Account addAccount(Account account) {
		logger.info("inside AccountserviceImpl add account method");
		return repository.save(account);
	}

	@Override
	public Account fetchById(long accountId) throws AccountNotFoundException, NumberFormatException {
		// TODO Auto-generated method stub
		logger.info("inside AccountserviceImpl fetchById method");

		Optional<Account> acc = repository.findById(accountId);
		if (!acc.isPresent())
			throw new AccountNotFoundException();
		return acc.get();

	}

	@Override
	public Account updateAccount(Account account) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		logger.info("inside AccountserviceImpl update account method");

		Optional<Account> acc = repository.findById(account.getAccountId());

		if (!acc.isPresent())
			throw new AccountNotFoundException();

		return repository.save(account);
	}

	@Override
	public void deleteByAccountId(long accountId) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		logger.info("inside AccountserviceImpl delete account by id method");
		Optional<Account> acc = repository.findById(accountId);
		if (!acc.isPresent())
			throw new AccountNotFoundException();
		repository.deleteById(accountId);

	}

//	@Override
//	public int countCreatedAccountsInPeriod(LocalDate startDate, LocalDate endDate) {
//		// TODO Auto-generated method stub
//		logger.info("inside AccountserviceImpl countCreatedAccountsInPeriod method");
//		List<Account> account = repository.findAll();
//		int count = 0;
//		for (Account a : account) {
//			if (a.getRegisteredDate().isAfter(startDate) && a.getRegisteredDate().isBefore(endDate))
//				count += 1;
//		}
//
//		return count;
//
//	}

	@Override
	public int countAccounts() {
		// TODO Auto-generated method stub
		logger.info("inside AccountserviceImpl CountAccounts method");

		return repository.findAll().size();
	}

	@Override
	public void removePackFromAccount(Account account, Pack pack)
			throws AccountNotFoundException, PackNotFoundException {
		// TODO Auto-generated method stub
		logger.info("inside AccountserviceImpl removePackFromAccount method");
		Optional<Account> acc = repository.findById(account.getAccountId());
		List<Pack> packs = account.getCurrentPacks();
		

		if (!acc.isPresent())
			throw new AccountNotFoundException();
		for (Pack p : packs) {
			if (!(p.getPackId() == pack.getPackId()))
				throw new PackNotFoundException();
			else
				packs.remove(p);
		}
		account.setCurrentPacks(packs);
		repository.save(account);
	}

}