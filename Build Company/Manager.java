package com.pxy;
/*
 * ������
 */
import java.util.Date;

public class Manager extends CompanyMember {
		protected double bonus;
		public Manager(String name, Double salay,Date birthday,double bonus) {
			super(name,salay,birthday);
			this.bonus=bonus;
			type=2;
		}
		//�õ�нˮ
		public double getSalay() {
//			System.out.println(getname()+"���¹���Ϊ��"+(salary+bonus));
			return salary+bonus;
		}
}	
