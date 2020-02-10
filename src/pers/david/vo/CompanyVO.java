package pers.david.vo;

public class CompanyVO implements java.io.Serializable{
    private static final long serialVersionUID = 8683452581122892189L;
    
	String companyName;

	public CompanyVO() {
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
