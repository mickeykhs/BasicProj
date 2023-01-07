package emp_management.emp;

import java.sql.Date;
import java.util.Objects;

public class EmpVO {
	private int empNum;
	private String empNm;
	private String empAdd;
	private String empPhNum;
	private int empAge;
	private String empGen;
	private String empAcc;
	private Date empFowDate;
	private String empPw;
	private Date empSevDate;
	private int empAnu;
	private String empDepCde;
	private String empPosCde;
	
	public EmpVO() {
	}

	public EmpVO(int empNum, int empAnu) {
		this.empNum = empNum;
		this.empAnu = empAnu;
	}

	public EmpVO(int empNum) {
		this.empNum = empNum;
	}

	public EmpVO(int empNum, String empPw) {
		this.empNum = empNum;
		this.empPw = empPw;
	}

	public EmpVO(int empNum, String empNm, String empAdd, String empPhNum, int empAge, String empGen, String empAcc,
			Date empFowDate, String empPw, Date empSevDate, int empAnu, String empDepCde, String empPosCde) {
		this.empNum = empNum;
		this.empNm = empNm;
		this.empAdd = empAdd;
		this.empPhNum = empPhNum;
		this.empAge = empAge;
		this.empGen = empGen;
		this.empAcc = empAcc;
		this.empFowDate = empFowDate;
		this.empPw = empPw;
		this.empSevDate = empSevDate;
		this.empAnu = empAnu;
		this.empDepCde = empDepCde;
		this.empPosCde = empPosCde;
	}
	
	public int getEmpNum() {
		return empNum;
	}

	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}

	public String getEmpNm() {
		return empNm;
	}

	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}

	public String getEmpAdd() {
		return empAdd;
	}

	public void setEmpAdd(String empAdd) {
		this.empAdd = empAdd;
	}

	public String getEmpPhNum() {
		return empPhNum;
	}

	public void setEmpPhNum(String empPhNum) {
		this.empPhNum = empPhNum;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public String getEmpGen() {
		return empGen;
	}

	public void setEmpGen(String empGen) {
		this.empGen = empGen;
	}

	public String getEmpAcc() {
		return empAcc;
	}

	public void setEmpAcc(String empAcc) {
		this.empAcc = empAcc;
	}

	public Date getEmpFowDate() {
		return empFowDate;
	}

	public void setEmpFowDate(Date empFowDate) {
		this.empFowDate = empFowDate;
	}

	public String getEmpPw() {
		return empPw;
	}

	public void setEmpPw(String empPw) {
		this.empPw = empPw;
	}

	public Date getEmpSevDate() {
		return empSevDate;
	}

	public void setEmpSevDate(Date empSevDate) {
		this.empSevDate = empSevDate;
	}

	public int getEmpAnu() {
		return empAnu;
	}

	public void setEmpAnu(int empAnu) {
		this.empAnu = empAnu;
	}



	public String getEmpDepCde() {
		return empDepCde;
	}



	public void setEmpDepCde(String empDepCde) {
		this.empDepCde = empDepCde;
	}



	public String getEmpPosCde() {
		return empPosCde;
	}



	public void setEmpPosCde(String empPosCde) {
		this.empPosCde = empPosCde;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empNum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof EmpVO)) {
			return false;
		}
		EmpVO other = (EmpVO) obj;
		return empNum == other.empNum;
	}

	public void invalidate() {
		this.empNum = 0;
		this.empNm = null;
		this.empAdd = null;
		this.empPhNum = null;
		this.empAge = 0;
		this.empGen = null;
		this.empAcc = null;
		this.empFowDate = null;
		this.empPw = null;
		this.empSevDate = null;
		this.empAnu = 0;
		this.empDepCde = null;
		this.empPosCde = null;
	}

	@Override
	public String toString() {
		return String.format(
				"%s\t%s\t%-20s\t%s\t%s\t%s\t%-24s\t%-14s\t%s\t\t%-13s\t%s\t%s\t%s",
//				"%d\t%s\t%-20s\t%s\t%d\t%s\t%s\t%-20s\t%s\t%s\t%-15,d\t%-15s\t%s",
				empNum, empNm, empAdd, empPhNum, empAge, empGen, empAcc, empFowDate, empPw, empSevDate, empAnu,
				empDepCde, empPosCde);
	}

//	@Override
//	public String toString() {
//		return String.format(
//				empNum, empNm, empAdd, empPhNum, empAge,empGen, empAcc, empFowDate, empPw,empSevDate, empAnu,  empDepCde, empPosCde);
//	}
	
	

}
