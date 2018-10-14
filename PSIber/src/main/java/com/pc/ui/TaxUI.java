package com.pc.ui;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pc.model.TaxInputBean;
import com.pc.model.TaxOutputBean;
import com.pc.service.TaxService;
import com.pc.framework.AbstractUI;
import com.pc.framework.OfflineContext;;

@Component
@ManagedBean(name="taxUI")
@ViewScoped
public class TaxUI extends AbstractUI{

	/**Tax Output*/
	private TaxOutputBean taxOutput;
	
	/**Tax Input*/
	private TaxInputBean taxInput;
	
	/**The Tax Service*/
	@Autowired
	TaxService taxService;
	
	@PostConstruct
	public void init() {
		taxOutput=new TaxOutputBean();
		taxInput=new TaxInputBean();
	}
	
	
	/**Calculate tax*/
	public void calculateTax()
	{
		taxOutput=taxService.calculateTax(taxInput);
		
		//Round Off
		taxOutput.setAnnualPAYEBeforeTax(Math.round(taxOutput.getAnnualPAYEBeforeTax()));
		taxOutput.setMonthlyPAYEBeforeTax(Math.round(taxOutput.getMonthlyPAYEBeforeTax()));
		taxOutput.setNetCashPay(Math.round(taxOutput.getNetCashPay()));
		taxOutput.setPAYEDueAfterTax(Math.round(taxOutput.getPAYEDueAfterTax()));
		taxOutput.setTaxCredits(Math.round(taxOutput.getTaxCredits()));
		
		taxInput=new TaxInputBean();
	}
	

	/**
	 * @return the taxOutput
	 */
	public TaxOutputBean getTaxOutput() {
		return taxOutput;
	}

	/**
	 * @param taxOutput the taxOutput to set
	 */
	public void setTaxOutput(TaxOutputBean taxOutput) {
		this.taxOutput = taxOutput;
	}

	/**
	 * @return the taxInput
	 */
	public TaxInputBean getTaxInput() {
		return taxInput;
	}

	/**
	 * @param taxInput the taxInput to set
	 */
	public void setTaxInput(TaxInputBean taxInput) {
		this.taxInput = taxInput;
	}

	
	


	

}
