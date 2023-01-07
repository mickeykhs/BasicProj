package emp_management.rep;

public class RepVO {
	private int repNum;
	private int repSugNum;
	private int repMstNum;
	private String repCon;
	
	public RepVO() {
		
	}

	public RepVO(String repCon, int repNum) {
		this.repCon = repCon;
		this.repNum = repNum;
	}

	public RepVO(String repCon) {
		super();
		this.repCon = repCon;
	}

	public RepVO(int repSugNum, String repCon) {
	      this.repSugNum=repSugNum;
	      this.repCon=repCon;
	   }   
	
	public RepVO(int repNum, int repSugNum, int repMstNum) {
		super();
		this.repNum = repNum;
		this.repSugNum = repSugNum;
		this.repMstNum = repMstNum;
	}

	public RepVO(int repSugNum, int repMstNum, String repCon) {
		super();
		this.repSugNum = repSugNum;
		this.repMstNum = repMstNum;
		this.repCon = repCon;
	}
	public RepVO(int repNum, int repSugNum, int repMstNum, String repCon) {
		super();
		this.repNum = repNum;
		this.repSugNum = repSugNum;
		this.repMstNum = repMstNum;
		this.repCon = repCon;
	}


	public int getRepNum() {
		return repNum;
	}

	public void setRepNum(int repNum) {
		this.repNum = repNum;
	}

	public int getRepSugNum() {
		return repSugNum;
	}

	public void setRepSugNum(int repSugNum) {
		this.repSugNum = repSugNum;
	}

	public int getRepMstNum() {
		return repMstNum;
	}

	public void setRepMstNum(int repMstNum) {
		this.repMstNum = repMstNum;
	}

	public String getRepCon() {
		return repCon;
	}

	public void setRepCon(String repCon) {
		this.repCon = repCon;
	}

	@Override
	   public String toString() {
	      return String.format("%s \t %s \t\t %s \t %s \n ", repNum, repSugNum, repMstNum, repCon);
	   }
	}
