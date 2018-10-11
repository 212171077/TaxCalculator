package com.pc.model;

public class TaxOutputBean 
{
	/**Calculated Monthly PAYE – before tax credit*/
	private double monthlyPAYEBeforeTax;
	
	/**Calculated Annually PAYE – before tax credit*/
	private double annualPAYEBeforeTax;
	
	/**Tax Credits*/
	private double taxCredits;
	
	/**PAYE Due – After Tax Credit*/
	private double PAYEDueAfterTax;
	
	/**Net Cash Pay after PAYE Due*/
	private double NetCashPay;
	
	
	public TaxOutputBean() {
		super();
	}
	
	public TaxOutputBean(double monthlyPAYEBeforeTax, double annualPAYEBeforeTax, double taxCredits,
			double pAYEDueAfterTax, double netCashPay) {
		super();
		this.monthlyPAYEBeforeTax = monthlyPAYEBeforeTax;
		this.annualPAYEBeforeTax = annualPAYEBeforeTax;
		this.taxCredits = taxCredits;
		PAYEDueAfterTax = pAYEDueAfterTax;
		NetCashPay = netCashPay;
	}
	/**
	 * @return the monthlyPAYEBeforeTax
	 */
	public double getMonthlyPAYEBeforeTax() {
		return monthlyPAYEBeforeTax;
	}
	/**
	 * @param monthlyPAYEBeforeTax the monthlyPAYEBeforeTax to set
	 */
	public void setMonthlyPAYEBeforeTax(double monthlyPAYEBeforeTax) {
		this.monthlyPAYEBeforeTax = monthlyPAYEBeforeTax;
	}
	/**
	 * @return the annualPAYEBeforeTax
	 */
	public double getAnnualPAYEBeforeTax() {
		return annualPAYEBeforeTax;
	}
	/**
	 * @param annualPAYEBeforeTax the annualPAYEBeforeTax to set
	 */
	public void setAnnualPAYEBeforeTax(double annualPAYEBeforeTax) {
		this.annualPAYEBeforeTax = annualPAYEBeforeTax;
	}
	/**
	 * @return the taxCredits
	 */
	public double getTaxCredits() {
		return taxCredits;
	}
	/**
	 * @param taxCredits the taxCredits to set
	 */
	public void setTaxCredits(double taxCredits) {
		this.taxCredits = taxCredits;
	}
	/**
	 * @return the pAYEDueAfterTax
	 */
	public double getPAYEDueAfterTax() {
		return PAYEDueAfterTax;
	}
	/**
	 * @param pAYEDueAfterTax the pAYEDueAfterTax to set
	 */
	public void setPAYEDueAfterTax(double pAYEDueAfterTax) {
		PAYEDueAfterTax = pAYEDueAfterTax;
	}
	/**
	 * @return the netCashPay
	 */
	public double getNetCashPay() {
		return NetCashPay;
	}
	/**
	 * @param netCashPay the netCashPay to set
	 */
	public void setNetCashPay(double netCashPay) {
		NetCashPay = netCashPay;
	}

}
