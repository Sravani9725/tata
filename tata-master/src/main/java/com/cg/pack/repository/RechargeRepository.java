package com.cg.pack.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.pack.entities.Account;
import com.cg.pack.entities.Recharge;

public interface RechargeRepository extends JpaRepository<Recharge, Long> {

}
