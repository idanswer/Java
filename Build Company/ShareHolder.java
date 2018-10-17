package com.pxy;
/*
 * 股东类
 */
import java.util.Date;
import java.util.Set;

public class ShareHolder extends CompanyMember {
	protected double share;
	public ShareHolder(String name,Date birthday,double share) {
		super(name,birthday);
		this.share=share;
		type=3;
	}
	/*
	 * 判断所有股东的股份加起来是否超过100%
	 */
	public boolean checkShares(double shares,Set<CompanyMember> companyMemberSet) {
		double allShare = 0;
		for(CompanyMember companyMember :companyMemberSet){
			if(companyMember.getType()==3) {
				ShareHolder s1=(ShareHolder)companyMember;
				allShare=allShare+s1.getShare();
			}	
		}
		if(allShare>0&&allShare<1)
			return true;
		else
			return false;
	}
	public double getShare() {
		return share;
	}
}
