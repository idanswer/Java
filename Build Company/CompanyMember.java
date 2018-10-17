package com.pxy;
/*
 * @class ���� ��˾��Ա
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
	 * @return ��д��ϣcode
	 */
	public int hashCode() {
		return name.hashCode();
	}
	/*
	 * @return �ж����
	 */
	public boolean equles(Object o) {
		CompanyMember companyMember=(CompanyMember)o;
		return name.equals(companyMember.name);
	}
	/*
	 * ����compareTo()
	 */
		@Override
public int compareTo(Object o) {
		CompanyMember companyMember=(CompanyMember)o;
		Byte byte1=new Byte(type);
		Byte byte2=new Byte(companyMember.getType());
		return byte1.compareTo(byte2);
	}
//	�õ�����
	public byte getType() {
		return type;
	}
	
//	�õ�����
	public String getname() {
		return name;
	}
}
