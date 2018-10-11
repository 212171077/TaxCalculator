package com.pc.service;

import org.springframework.stereotype.Service;

import com.pc.model.TaxInputBean;
import com.pc.model.TaxOutputBean;



@Service
public class TaxService {
	
	
	
	public TaxOutputBean calculateTax(TaxInputBean taxInput)
	{
		TaxOutputBean taxOutput=new TaxOutputBean();
		
		taxOutput.setAnnualPAYEBeforeTax(1000000.00);
		taxOutput.setMonthlyPAYEBeforeTax(10000);
		taxOutput.setNetCashPay(12000);
		taxOutput.setPAYEDueAfterTax(6000);
		taxOutput.setTaxCredits(8000);
		
		return taxOutput;
	}
	
}
