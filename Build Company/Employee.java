package com.pxy;
/*
 * Ա����
 */
import java.util.Date;

public class Employee extends CompanyMember {

	public Employee(String name, double salary, Date birthday) {
		super(name, salary, birthday);
		type=1;
	}
	//�õ�нˮ
	public double getSalay() {
//		System.out.println(getname()+"���¹���Ϊ"+salary);
		return salary;
	}
}
