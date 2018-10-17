package com.pxy;
/*
 * 经理类
 */
import java.util.Date;

public class Manager extends CompanyMember {
		protected double bonus;
		public Manager(String name, Double salay,Date birthday,double bonus) {
			super(name,salay,birthday);
			this.bonus=bonus;
			type=2;
		}
		//得到薪水
		public double getSalay() {
//			System.out.println(getname()+"这月工资为："+(salary+bonus));
			return salary+bonus;
		}
}	
