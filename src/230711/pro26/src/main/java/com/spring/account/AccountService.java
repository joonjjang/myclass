package com.spring.account;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Transactional(propagation = Propagation.REQUIRED)
public class AccountService {
	
	AccountDAO accDAO;
	
	public void setAccDAO(AccountDAO accDAO) {
		this.accDAO = accDAO;
	}
	
	
	public void sendMoney () {
		
		accDAO.updateBalance1();
	      System.out.println("1송금완료");

		accDAO.updateBalance2();
		
	      System.out.println("2송금완료");

	}
	
}


