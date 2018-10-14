package com.pc.service;

import org.springframework.stereotype.Service;

import com.pc.entities.enums.TaxableTypeEnum;
import com.pc.entities.enums.YearsEnum;
import com.pc.model.TaxInputBean;
import com.pc.model.TaxOutputBean;



@Service
public class TaxService {
	
	private TaxOutputBean taxOutput;

	private double netCashPay;
	private double totalMonSary;
	private double totalAnnualySalary;
	
	public TaxOutputBean calculateTax(TaxInputBean taxInput)
	{
		taxOutput=new TaxOutputBean();
		if(taxInput.getYear() == YearsEnum.year2018)
		{
			calculate2018Tax(taxInput);
		}
		else
		{
			 calculate2017Tax(taxInput);
		}
		
		return taxOutput;
	}
	
	
	
	public TaxOutputBean calculate2018Tax(TaxInputBean taxInput)
	{
		preparAnnualyMonIncome( taxInput);
		double taxRebates=getTaxRebates(taxInput);
		double monthlyTax=0.00;
		double annuallyTax=0.00;
		
		//Setting PAYE – before tax credit
		taxOutput.setMonthlyPAYEBeforeTax(totalMonSary);
		taxOutput.setAnnualPAYEBeforeTax(totalAnnualySalary);
		
		if(checkTaxThresholds(taxInput))
		{
			//Setting tax Credits
			taxOutput.setTaxCredits(taxRebates);
			if(totalAnnualySalary<=189880.00)
			{
				monthlyTax=totalAnnualySalary*0.18;
				monthlyTax=monthlyTax-taxRebates;
				monthlyTax=monthlyTax/12;
			}
			else if(totalAnnualySalary<=296540.00)
			{
				//34 178 + 26% of taxable income above 189 880
				totalAnnualySalary=totalAnnualySalary-189880.00;
				monthlyTax=totalAnnualySalary*0.26;
				monthlyTax=monthlyTax+34178.00;
				monthlyTax=monthlyTax-taxRebates;
				monthlyTax=monthlyTax/12;
			}
			else if(totalAnnualySalary<=410460.00)
			{
				//61 910 + 31% of taxable income above 296 540
				totalAnnualySalary=totalAnnualySalary-296540.00;
				monthlyTax=totalAnnualySalary*0.31;
				monthlyTax=monthlyTax+61910.00;
				monthlyTax=monthlyTax-taxRebates;
				monthlyTax=monthlyTax/12;
			}
			else if(totalAnnualySalary<=555600.00)
			{
				//97 225 + 36% of taxable income above 410 460
				totalAnnualySalary=totalAnnualySalary-410460.00;
				monthlyTax=totalAnnualySalary*0.36;
				monthlyTax=monthlyTax+97225.00;
				monthlyTax=monthlyTax-taxRebates;
				monthlyTax=monthlyTax/12;
			}
			else if(totalAnnualySalary<=708310.00)
			{
				//149 475 + 39% of taxable income above 555 600
				totalAnnualySalary=totalAnnualySalary-555600.00;
				monthlyTax=totalAnnualySalary*0.39;
				monthlyTax=monthlyTax+149475.00;
				monthlyTax=monthlyTax-taxRebates;
				monthlyTax=monthlyTax/12;
			}
			else if(totalAnnualySalary<=1500000.00)
			{
				//209 032 + 41% of taxable income above 708 310
				totalAnnualySalary=totalAnnualySalary-708310.00;
				monthlyTax=totalAnnualySalary*0.41;
				monthlyTax=monthlyTax+209032.00;
				monthlyTax=monthlyTax-taxRebates;
				monthlyTax=monthlyTax/12;
			}
			else 
			{
				//533 625 + 45% of taxable income above 1 500 000
				totalAnnualySalary=totalAnnualySalary-1500000.00;
				monthlyTax=totalAnnualySalary*0.45;
				monthlyTax=monthlyTax+533625.00;
				monthlyTax=monthlyTax-taxRebates;
				monthlyTax=monthlyTax/12;
			}
			//Calculating Annually Tax
			annuallyTax=monthlyTax*12;
			taxOutput.setPayTax(true);
		}
		else
		{
			taxOutput.setPayTax(false);
			monthlyTax=0.00;
			monthlyTax=0.00;
		}
		
		/*
		 *Setting PAYE Due – After Tax Credit and 
		 *Net Cash Pay after PAYE Due
		 * */
		if(taxInput.getTaxableType()==TaxableTypeEnum.annual)
		{
			taxOutput.setPAYEDueAfterTax(annuallyTax);
			netCashPay=totalAnnualySalary-annuallyTax;
			//taxOutput.setNetCashPay(netCashPay);
			taxOutput.setNetCashPay(netCashPay-getUIF());
		}
		else
		{
			taxOutput.setPAYEDueAfterTax(monthlyTax);
			netCashPay=totalMonSary-monthlyTax;
			//taxOutput.setNetCashPay(netCashPay);
			taxOutput.setNetCashPay(netCashPay-getUIF());
		}
		return taxOutput;
	}
	
	public TaxOutputBean calculate2017Tax(TaxInputBean taxInput)
	{
		preparAnnualyMonIncome( taxInput);
		double taxRebates=getTaxRebates(taxInput);
		double monthlyTax=0.00;
		double annuallyTax=0.00;
		//Setting PAYE – before tax credit
		taxOutput.setMonthlyPAYEBeforeTax(totalMonSary);
		taxOutput.setAnnualPAYEBeforeTax(totalAnnualySalary);
		
		if(checkTaxThresholds(taxInput))
		{
			//Setting tax Credits
			taxOutput.setTaxCredits(taxRebates);
			
			if(totalAnnualySalary<=188000.00)
			{
				monthlyTax=totalAnnualySalary*0.18;
				monthlyTax=monthlyTax-taxRebates;
				monthlyTax=monthlyTax/12;
			}
			else if(totalAnnualySalary<=293600.00)
			{
				//33 840 + 26% of taxable income above 188 000
				totalAnnualySalary=totalAnnualySalary-188000.00;
				monthlyTax=totalAnnualySalary*0.26;
				monthlyTax=monthlyTax+33840.00;
				monthlyTax=monthlyTax-taxRebates;
				monthlyTax=monthlyTax/12;
			}
			else if(totalAnnualySalary<=406400.00)
			{
				//61 296 + 31% of taxable income above 293 600
				totalAnnualySalary=totalAnnualySalary-293600.00;
				monthlyTax=totalAnnualySalary*0.31;
				monthlyTax=monthlyTax+61296.00;
				monthlyTax=monthlyTax-taxRebates;
				monthlyTax=monthlyTax/12;
			}
			else if(totalAnnualySalary<=550100.00)
			{
				//96 264 + 36% of taxable income above 406 400
				totalAnnualySalary=totalAnnualySalary-406400.00;
				monthlyTax=totalAnnualySalary*0.36;
				monthlyTax=monthlyTax+96264.00;
				monthlyTax=monthlyTax-taxRebates;
				monthlyTax=monthlyTax/12;
			}
			else if(totalAnnualySalary<=701300.00)
			{
				//147 996 + 39% of taxable income above 550 100
				totalAnnualySalary=totalAnnualySalary-550100.00;
				monthlyTax=totalAnnualySalary*0.39;
				monthlyTax=monthlyTax+147996.00;
				monthlyTax=monthlyTax-taxRebates;
				monthlyTax=monthlyTax/12;
			}
			else 
			{
				//206 964 + 41% of taxable income above 701 300
				totalAnnualySalary=totalAnnualySalary-701300.00;
				monthlyTax=totalAnnualySalary*0.41;
				monthlyTax=monthlyTax+206964.00;
				monthlyTax=monthlyTax-taxRebates;
				monthlyTax=monthlyTax/12;
			}
			//Calculating Annually Tax
			annuallyTax=monthlyTax*12;
			taxOutput.setPayTax(true);
		}
		else
		{
			taxOutput.setPayTax(false);
			annuallyTax=0.00;
			monthlyTax=0.00;
		}
		/*
		 *Setting PAYE Due – After Tax Credit and 
		 *Net Cash Pay after PAYE Due
		 * */
		if(taxInput.getTaxableType()==TaxableTypeEnum.annual)
		{
			taxOutput.setPAYEDueAfterTax(annuallyTax);
			netCashPay=totalAnnualySalary-annuallyTax;
			//taxOutput.setNetCashPay(netCashPay);
			taxOutput.setNetCashPay(netCashPay-getUIF());
		}
		else
		{
			taxOutput.setPAYEDueAfterTax(monthlyTax);
			netCashPay=totalMonSary-monthlyTax;
			//taxOutput.setNetCashPay(netCashPay);
			taxOutput.setNetCashPay(netCashPay-getUIF());
		}
		return taxOutput;
		
	}
	
	/**
	 * Prepare Annually and Monthly Income
	 * */
	public void preparAnnualyMonIncome(TaxInputBean taxInput)
	{
		 
		 if(taxInput.getTaxableType()==TaxableTypeEnum.annual)
		 {
			 totalAnnualySalary=taxInput.getTotalTaxableEarnings();
			 totalMonSary=totalAnnualySalary/12;
		 }
		 else
		 {
			 totalMonSary=taxInput.getTotalTaxableEarnings();
			 totalAnnualySalary=totalMonSary*12;
		 }
	}
	
	/**
	 * Returns tax rebate 
	 * base on a year selected
	 * */
	public double getTaxRebates(TaxInputBean taxInput)
	{
		double taxRebate=0.00;
		if(taxInput.getYear()==YearsEnum.year2018)
		{
			if(taxInput.getAge()<65)
			{
				//Primary
				taxRebate=13635.00;
			}
			else if(taxInput.getAge()<75)
			{
				//Secondary (Persons 65 and older)
				taxRebate=7479.00;
			}
			else
			{
				//Tertiary (Persons 75 and older)
				taxRebate=2493.00;
			}
				
			
		}
		else
		{
			if(taxInput.getAge()<65)
			{
				//Primary
				taxRebate=13500.00;
			}
			else if(taxInput.getAge()<75)
			{
				//Secondary (Persons 65 and older)
				taxRebate=7407.00;
			}
			else
			{
				//Tertiary (Persons 75 and older)
				taxRebate=2466.00;
			}
		}
		//Adding Medical Aid Credits
		taxRebate +=getMedicalAidTaxCredits(taxInput);
		
		return taxRebate;
	}
	
	/**
	 * Tax Thresholds.
	 * Check if user should pay tax or not
	* */
	public boolean checkTaxThresholds(TaxInputBean taxInput)
	{
		boolean payTax=true;
		if(taxInput.getYear()==YearsEnum.year2018)
		{
			if(taxInput.getAge()<65 && totalAnnualySalary<75750.00)
			{
				payTax=false;
			}
			else if(taxInput.getAge()<=75 && totalAnnualySalary<117300.00)
			{
				payTax=false;
			}
			else if(taxInput.getAge()>75 && totalAnnualySalary<131150.00)
			{
				payTax=false;
			}
				
		}
		else
		{
			if(taxInput.getAge()<65 && totalAnnualySalary<75000.00)
			{
				payTax=false;
			}
			else if(taxInput.getAge()<=75 && totalAnnualySalary<116150.00)
			{
				payTax=false;
			}
			else if(taxInput.getAge()>75 && totalAnnualySalary<129850.00)
			{
				payTax=false;
			}
		}
		return payTax;
	}
	
	/**Calculate UIF*/
	public double getUIF()
	{
		double uif=totalMonSary*0.01;
		
		if(uif>148.72)
		{
			uif=148.72;
		}
		return uif;
	}
	
	/**Medical Aid Tax Credits*/
	public double getMedicalAidTaxCredits(TaxInputBean taxInput)
	{
		
		double creadits=0.00;
		
		if(taxInput.isMedicalAidMember())
		{
			int numberOfDep=taxInput.getNumOfependent();
			if(taxInput.getYear()==YearsEnum.year2018)
			{	//Credit for the taxpayer who paid the medical scheme contributions
				creadits=286.00;
				if(numberOfDep>1)
				{
					//Credit for the first dependant
					creadits +=286.00;
					numberOfDep=numberOfDep-1;
					if(numberOfDep>1)
					{
						//Credit for each additional dependant(s)
						int additionalCredits=numberOfDep*192;
						creadits +=additionalCredits;
					}
				}
			}
			else
			{
				//Credit for the taxpayer who paid the medical scheme contributions
				creadits=303.00;
				if(numberOfDep>1)
				{
					//Credit for the first dependant
					creadits +=303.00;
					numberOfDep=numberOfDep-1;
					if(numberOfDep>1)
					{
						//Credit for each additional dependant(s)
						int additionalCredits=numberOfDep*203;
						creadits +=additionalCredits;
					}
				}
			}
		}
		//Medical Aid Tax Credits for a year
		creadits =creadits*12;
		return creadits; 
	}
	
	
	
	
	
}
