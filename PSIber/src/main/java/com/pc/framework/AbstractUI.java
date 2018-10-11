package com.pc.framework;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractUI implements Serializable
{
	@PostConstruct
	public void init() {
		 
	}
	
	
	public void displayInfoMssg(String mssg)
	{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mssg));
	}
	
	public void displaySuccessMssg(String mssg)
	{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mssg));
	}
	
	public void displayWarningMssg(String mssg)
	{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mssg));
	}
	
	public void displayFatalMssg(String mssg)
	{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mssg));
	}
	
	public void displayErrorMssg(String mssg)
	{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", mssg));
	}
	
	/**
	 * Redirect to specified page.
	 *
	 * @param outcome
	 *            the outcome
	 */
	protected void ajaxRedirect(String outcome) {
		FacesContext ctx = getContext();
		ExternalContext extContext = ctx.getExternalContext();
		String url = extContext.encodeActionURL(ctx.getApplication().getViewHandler().getActionURL(ctx, outcome));
		try {
			extContext.redirect(url);
		} catch (IOException ioe) {
			throw new FacesException(ioe);
		}
	}
	
	/**
	 * Return the FacexContext.
	 *
	 * @return the context
	 */
	protected FacesContext getContext() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (context == null) context = OfflineContext.getCurrentInstance();
		return context;
	}

}
