package com.pc.ui;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.springframework.stereotype.Component;

import com.pc.entities.enums.TaxableTypeEnum;
import com.pc.entities.enums.YearsEnum;
import com.pc.framework.AbstractUI;


@Component("commonItemUI")
@ViewScoped
public class CommonItemUI  extends AbstractUI
{
	public List<SelectItem> getYearsDD() {
		List<SelectItem> l = new ArrayList<SelectItem>();
		for (YearsEnum val : YearsEnum.values()) {
			l.add(new SelectItem(val, String.valueOf(val.getYear())));
		}
		return l;
	}
	
	public List<SelectItem> getTaxableTypeEnumDD() {
		List<SelectItem> l = new ArrayList<SelectItem>();
		for (TaxableTypeEnum val : TaxableTypeEnum.values()) {
			l.add(new SelectItem(val, String.valueOf(val.getFriendlyName())));
		}
		return l;
	}
	
	

}
