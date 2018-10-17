package com.pxy;
/*
 * @class 父类 公司成员
 */
import java.util.Date;

public class CompanyMember implements Comparable {
	protected String name;
	protected double salary;
	protected Date birthday;
	protected byte type;
	CompanyMember(String name,Date birthday){
		this.name=name;
		this.birthday=birthday;
	}
	CompanyMember(String name,double salary,Date birthday) {
		this.name=name;
		this.salary=salary;
		this.birthday=birthday;
	}
	
	
	/*
	 * @return 重写哈希code
	 */
	public int hashCode() {
		return name.hashCode();
	}
	/*
	 * @return 判断相等
	 */
	public boolean equles(Object o) {
		CompanyMember companyMember=(CompanyMember)o;
		return name.equals(companyMember.name);
	}
	/*
	 * 重载compareTo()
	 */
		@Override
public int compareTo(Object o) {
		CompanyMember companyMember=(CompanyMember)o;
		Byte byte1=new Byte(type);
		Byte byte2=new Byte(companyMember.getType());
		return byte1.compareTo(byte2);
	}
//	得到类型
	public byte getType() {
		return type;
	}
	
//	得到名字
	public String getname() {
		return name;
	}
}
