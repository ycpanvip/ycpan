package com.wen.security.model;
import java.io.Serializable;

public class TrialBalanceParam implements Serializable {

  private static final long serialVersionUID = 3104317336062606435L;
  private String userId;

  private String universalLedger;
  private String leUniversal;
  private String leLocal;
  private String mrcUniversal;
  private String fiscalYear;
  private String period;
  private String sourceSystem;
  private String accountType;
  private int accountTypeCode;
  private String accountsFrom;
  private String accountsTo;
  private String userInput;
  private String globalFunctionalArea;
  private boolean mrcChecked;
  private boolean localGlChecked;
  private boolean gfsGlChecked;
  private boolean bravoChecked;
  private boolean gtwChecked;
  
  private boolean useLucene = true;
  private boolean coercion = false; // the flag that result from line_item or c1c2_report


  @Override
  public String toString() {
    return "TrialBalanceParam [userId=" + userId + ", universalLedger=" + universalLedger + ", leUniversal="
        + leUniversal + ", leLocal=" + leLocal + ", mrcUniversal=" + mrcUniversal + ", fiscalYear=" + fiscalYear
        + ", period=" + period + ", sourceSystem=" + sourceSystem + ", accountType=" + accountType
        + ", accountTypeCode=" + accountTypeCode + ", accountsFrom=" + accountsFrom + ", accountsTo=" + accountsTo
        + ", userInput=" + userInput + ", globalFunctionalArea=" + globalFunctionalArea + ", mrcChecked=" + mrcChecked
        + ", localGlChecked=" + localGlChecked + ", gfsGlChecked=" + gfsGlChecked + ", bravoChecked=" + bravoChecked
        + ", gtwChecked=" + gtwChecked + "]";
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUniversalLedger() {
    return universalLedger;
  }

  public void setUniversalLedger(String universalLedger) {
    this.universalLedger = universalLedger;
  }

  public String getLeUniversal() {
    return leUniversal;
  }

  public void setLeUniversal(String leUniversal) {
    this.leUniversal = leUniversal;
  }

  public String getLeLocal() {
    return leLocal;
  }

  public void setLeLocal(String leLocal) {
    this.leLocal = leLocal;
  }

  public String getMrcUniversal() {
    return mrcUniversal;
  }

  public void setMrcUniversal(String mrcUniversal) {
    this.mrcUniversal = mrcUniversal;
  }

  public String getFiscalYear() {
    return fiscalYear;
  }

  public void setFiscalYear(String fiscalYear) {
    this.fiscalYear = fiscalYear;
  }

  public String getPeriod() {
    return period;
  }

  public void setPeriod(String period) {
    this.period = period;
  }

  public String getSourceSystem() {
    return sourceSystem;
  }

  public void setSourceSystem(String sourceSystem) {
    this.sourceSystem = sourceSystem;
  }

  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public int getAccountTypeCode() {
    return accountTypeCode;
  }

  public void setAccountTypeCode(int accountTypeCode) {
    this.accountTypeCode = accountTypeCode;
  }

  public String getAccountsFrom() {
    return accountsFrom;
  }

  public void setAccountsFrom(String accountsFrom) {
    this.accountsFrom = accountsFrom;
  }

  public String getAccountsTo() {
    return accountsTo;
  }

  public void setAccountsTo(String accountsTo) {
    this.accountsTo = accountsTo;
  }

  public String getUserInput() {
    return userInput;
  }

  public void setUserInput(String userInput) {
    this.userInput = userInput;
  }

  public String getGlobalFunctionalArea() {
    return globalFunctionalArea;
  }

  public void setGlobalFunctionalArea(String globalFunctionalArea) {
    this.globalFunctionalArea = globalFunctionalArea;
  }

  public boolean isMrcChecked() {
    return mrcChecked;
  }

  public void setMrcChecked(boolean mrcChecked) {
    this.mrcChecked = mrcChecked;
  }

  public boolean isLocalGlChecked() {
    return localGlChecked;
  }

  public void setLocalGlChecked(boolean localGlChecked) {
    this.localGlChecked = localGlChecked;
  }

  public boolean isGfsGlChecked() {
    return gfsGlChecked;
  }

  public void setGfsGlChecked(boolean gfsGlChecked) {
    this.gfsGlChecked = gfsGlChecked;
  }

  public boolean isBravoChecked() {
    return bravoChecked;
  }

  public void setBravoChecked(boolean bravoChecked) {
    this.bravoChecked = bravoChecked;
  }

  public boolean isGtwChecked() {
    return gtwChecked;
  }

  public void setGtwChecked(boolean gtwChecked) {
    this.gtwChecked = gtwChecked;
  }

  public boolean isUseLucene() {
    return useLucene;
  }

  public void setUseLucene(boolean useLucene) {
    this.useLucene = useLucene;
  }

  public boolean isCoercion() {
    return coercion;
  }

  public void setCoercion(boolean coercion) {
    this.coercion = coercion;
  }
}
