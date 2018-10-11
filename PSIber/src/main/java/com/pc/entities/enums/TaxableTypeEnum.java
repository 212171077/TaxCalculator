package com.pc.entities.enums;

public enum TaxableTypeEnum {

  monthly("Per Month"),
  annual("Per Year");

  private String displayName;

  private TaxableTypeEnum(String displayNameX)
  {
    displayName = displayNameX;
  }

  @Override
  public String toString()
  {
    return displayName;
  }

  public String getFriendlyName()
  {
    return toString();
  }
}
