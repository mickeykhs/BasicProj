package emp_management.notice;

import java.util.Date;

public class NoticeVO {

	private int ntcNum;
	private int ntcMstNum;
	private String ntcTit;
	private String ntcCon;
	private Date ntcWrtDate;
	
	public NoticeVO() {
	}
	public NoticeVO(String ntcTit, String ntcCon) {
		super();
		this.ntcTit = ntcTit;
		this.ntcCon = ntcCon;
	}
	
	   public NoticeVO(int ntcNum, String ntcTit, String ntcCon) {
		      super();
		      this.ntcNum = ntcNum;
		      this.ntcTit = ntcTit;
		      this.ntcCon = ntcCon;
		   }
	public NoticeVO(int ntcNum, int ntcMstNum, String ntcTit, String ntcCon, Date ntcWrtDate) {
		this.ntcNum = ntcNum;
		this.ntcMstNum = ntcMstNum;
		this.ntcTit = ntcTit;
		this.ntcCon = ntcCon;
		this.ntcWrtDate = ntcWrtDate;
	}
	public int getNtcNum() {
		return ntcNum;
	}
	public void setNtcNum(int ntcNum) {
		this.ntcNum = ntcNum;
	}
	public int getNtcMstNum() {
		return ntcMstNum;
	}
	public void setNtcMstNum(int ntcMstNum) {
		this.ntcMstNum = ntcMstNum;
	}
	public String getNtcTit() {
		return ntcTit;
	}
	public void setNtcTit(String ntcTit) {
		this.ntcTit = ntcTit;
	}
	public String getNtcCon() {
		return ntcCon;
	}
	public void setNtcCon(String ntcCon) {
		this.ntcCon = ntcCon;
	}
	public Date getNtcWrtDate() {
		return ntcWrtDate;
	}
	public void setNtcWrtDate(Date ntcWrtDate) {
		this.ntcWrtDate = ntcWrtDate;
	}
	

		   

	@Override
	public String toString() {
		return String.format("%s\t%s\t%s\t%s\t%s", ntcNum,
				ntcMstNum,  ntcWrtDate, ntcTit, ntcCon);
	}
	
	
	
}
