package com.pxy;
/*
 * 员工类
 */
import java.util.Date;

public class Employee extends CompanyMember {

	public Employee(String name, double salary, Date birthday) {
		super(name, salary, birthday);
		type=1;
	}
	//得到薪水
	public double getSalay() {
//		System.out.println(getname()+"这月工资为"+salary);
		return salary;
	}
}
