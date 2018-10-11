package com.pc.model;

import com.pc.entities.enums.TaxableTypeEnum;
import com.pc.entities.enums.YearsEnum;

public class TaxInputBean {

	/**Tax Year*/
	private YearsEnum year;
	
	/**Age*/
	private int age;
	
	/**Total Taxable Earnings*/
	private double totalTaxableEarnings;
	
	/**Taxable Earnings(monthly or annual)*/
	private TaxableTypeEnum taxableType;
	
	/**Medical Aid Members + Main*/
	private boolean medicalAidMember;
	
	
	
	public TaxInputBean() {
		super();
	}

	public TaxInputBean(YearsEnum year, int age, double totalTaxableEarnings, TaxableTypeEnum taxableType,
			boolean medicalAidMember) {
		super();
		this.year = year;
		this.age = age;
		this.totalTaxableEarnings = totalTaxableEarnings;
		this.taxableType = taxableType;
		this.medicalAidMember = medicalAidMember;
	}
	
	/**
	 * @return the year
	 */
	public YearsEnum getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(YearsEnum year) {
		this.year = year;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the totalTaxableEarnings
	 */
	public double getTotalTaxableEarnings() {
		return totalTaxableEarnings;
	}
	/**
	 * @param totalTaxableEarnings the totalTaxableEarnings to set
	 */
	public void setTotalTaxableEarnings(double totalTaxableEarnings) {
		this.totalTaxableEarnings = totalTaxableEarnings;
	}
	/**
	 * @return the taxableType
	 */
	public TaxableTypeEnum getTaxableType() {
		return taxableType;
	}
	/**
	 * @param taxableType the taxableType to set
	 */
	public void setTaxableType(TaxableTypeEnum taxableType) {
		this.taxableType = taxableType;
	}
	/**
	 * @return the medicalAidMember
	 */
	public boolean isMedicalAidMember() {
		return medicalAidMember;
	}
	/**
	 * @param medicalAidMember the medicalAidMember to set
	 */
	public void setMedicalAidMember(boolean medicalAidMember) {
		this.medicalAidMember = medicalAidMember;
	}
	
}
