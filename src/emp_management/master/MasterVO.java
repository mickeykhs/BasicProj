package emp_management.master;

import java.util.Objects;

public class MasterVO {
	private int mstNum;
	private int mstId;
	private String mstPw;
	private String mstNm;

	public MasterVO() {
	}

	public MasterVO(int mstId, String mstPw) {
		this.mstId = mstId;
		this.mstPw = mstPw;
	}

	public MasterVO(int mstNum, int mstId, String mstPw, String mstNm) {
		this.mstNum = mstNum;
		this.mstId = mstId;
		this.mstPw = mstPw;
		this.mstNm = mstNm;
	}

	public int getMstNum() {
		return mstNum;
	}

	public void setMstNum(int mstNum) {
		this.mstNum = mstNum;
	}

	public int getMstId() {
		return mstId;
	}

	public void setMstId(int mstId) {
		this.mstId = mstId;
	}

	public String getMstPw() {
		return mstPw;
	}

	public void setMstPw(String mstPw) {
		this.mstPw = mstPw;
	}

	public String getMstNm() {
		return mstNm;
	}

	public void setMstNm(String mstNm) {
		this.mstNm = mstNm;
	}



	@Override
	public int hashCode() {
		return Objects.hash(mstNum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof MasterVO)) {
			return false;
		}
		MasterVO other = (MasterVO) obj;
		return mstNum == other.mstNum;
	}

	@Override
	public String toString() {
		return String.format("MasterVO [mstNum=%s, mstId=%s, mstPw=%s, mstNm=%s]", mstNum, mstId, mstPw, mstNm);
	}

	

	
	
	
	
}