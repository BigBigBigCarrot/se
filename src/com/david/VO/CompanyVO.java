package com.david.VO;

public class CompanyVO implements java.io.Serializable{
    private static final long serialVersionUID = 8683452581122892189L;
    
	String companyName;

	public CompanyVO() {
		// TODO Auto-generated constructor stub
	}
	public CompanyVO(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
