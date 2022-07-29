package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": DOING DB WORK: ADDING A VANILLA ACCOUNT");
	}

	// on ajoute une méthode pour tester si le dernier pointcut prend vraiment tt
	// les méthodes d'un même package:
	public boolean doWork() {
		System.out.println(getClass() + ": è_é inside public boolean doWork() method è_é");
		return false;
	}
}
