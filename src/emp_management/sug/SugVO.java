package emp_management.sug;

import java.sql.Date;

public class SugVO {
	private int sugNum;
	private String sugTit;
	private String sugCon;
	private Date sugWrtDate;
	private int sugEmpNum;
	
	public SugVO() {
		
	}
	
	public SugVO(String sugTit, String sugCon) {
		super();
		this.sugTit = sugTit;
		this.sugCon = sugCon;
	}
	
	public SugVO(int sugNum, String sugTit, String sugCon) {
		super();
		this.sugNum = sugNum;
		this.sugTit = sugTit;
		this.sugCon = sugCon;
	}
	
	public SugVO(int sugNum, String sugTit, String sugCon, Date sugWrtDate, int sugEmpNum) {
		super();
		this.sugNum = sugNum;
		this.sugTit = sugTit;
		this.sugCon = sugCon;
		this.sugWrtDate = sugWrtDate;
		this.sugEmpNum = sugEmpNum;
	}

	public int getSugNum() {
		return sugNum;
	}

	public void setSugNum(int sugNum) {
		this.sugNum = sugNum;
	}

	public String getSugTit() {
		return sugTit;
	}

	public void setSugTit(String sugTit) {
		this.sugTit = sugTit;
	}

	public String getSugCon() {
		return sugCon;
	}

	public void setSugCon(String sugCon) {
		this.sugCon = sugCon;
	}

	public Date getSugWrtDate() {
		return sugWrtDate;
	}

	public void setSugWrtDate(Date sugWrtDate) {
		this.sugWrtDate = sugWrtDate;
	}

	public int getSugEmpNum() {
		return sugEmpNum;
	}

	public void setSugEmpNum(int sugEmpNum) {
		this.sugEmpNum = sugEmpNum;
	}
	@Override
	public String toString() {
		return String.format("%s\t%-17s\t%-55s\t%s\t%s\n", sugNum, sugTit, sugCon, sugWrtDate, sugEmpNum);
	}
}
