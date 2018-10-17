package com.pxy;
/*
 * ��˾�� �����������е���
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Company {
	private Set<CompanyMember> memberSet;//��Աset
	private Map<String,Double> salaryMap;//key������ value������
//	private SimpleDateFormat formatter=new SimpleDateFormat("yyyy-mm-dd");
	public Company() {
		memberSet=new TreeSet<CompanyMember>();
		salaryMap=new HashMap<String,Double>();
	}
	/*
	 * @��Ա����memberSet
	 */
	public void addCompanyMember() {
	SimpleDateFormat formatter=new SimpleDateFormat("yyyy-mm-dd");
		System.out.println("��������Ҫ�ӵ�Ա������(1��Ա��2������3���ɶ�)");
		Scanner in=new Scanner(System.in);
		byte memberType=in.nextByte();
		if(memberType==1) {
			CompanyMember employee;
			Date birthday=null;
			System.out.println("������Ա��������");
			String name=in.next();
			System.out.println("������Ա������н");
			double salary=in.nextDouble();
			System.out.println("������Ա�������գ���ʽ������2017-03-02��");
			String dateStr=in.next();
			try {
				birthday=formatter.parse(dateStr);
//				employee=new Employee(in.nextLine(),in.nextDouble(),formatter.parse(in.nextLine()));
//				memberSet.add(employee);
			} catch (ParseException e) {
				e.printStackTrace();
				return;
			}
			employee=new Employee(name,salary,birthday);
			memberSet.add(employee);
			salaryMap.put(name, salary);
		}
		if(memberType==2) {
			CompanyMember manager;
			Date birthday=null;
			System.out.println("������Ա��������");
			String name=in.next();
			System.out.println("������Ա������н");
			double salary=in.nextDouble();
			System.out.println("������Ա���Ľ���");
			double bonus=in.nextDouble();
			System.out.println("������Ա�������գ���ʽ������2017-03-02��");
			String dateStr=in.next();
			try {
				birthday=formatter.parse(dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
				return;
			}	
			manager=new Manager(name,salary,birthday,bonus);
			memberSet.add(manager);
			salaryMap.put(name, salary+bonus);
		}
		if(memberType==3) {
			ShareHolder shareHolder;
			Date birthday=null;
			System.out.println("������Ա��������");
			String name=in.next();
			System.out.println("������Ա�������գ���ʽ������2017-03-02��");
			String dateStr=in.next();
			System.out.println("������Ա���Ĺɷ�(0-1)");
			double share=in.nextDouble();
			try {
				birthday=formatter.parse(dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
				return;
			}
			shareHolder=new ShareHolder(name,birthday,share);
			if(shareHolder.checkShares(share, memberSet)) {
				memberSet.add(shareHolder);
				salaryMap.put(name, share);
			}
			else
				System.out.println("�ɷ���������Ա��ʧ��");
		}
	}
	/*
	 * �����¹��ʲ���ʾ����
	 */
	public void payoff() throws ParseException {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
		Scanner in=new Scanner(System.in);
		System.out.println("�����뷢���ʵ��·ݣ���:12��");
		int month=in.nextInt();
		
		for(CompanyMember member:memberSet) {
			if(member.getType()==1) {
				Employee e1=(Employee)member;
				String birthdayStr=format.format(e1.birthday);
				String[] array = birthdayStr.split("-");
				int getMonth=Integer.parseInt(array[1]);
				if(month==getMonth)
					System.out.println("����Ϊ��Ա�����գ�����������5000Ԫ");
				System.out.println(e1.name+"�Ĺ���Ϊ��"+e1.getSalay());
			}
			if(member.getType()==2) {
				Manager m1=(Manager)member;
				String birthdayStr=format.format(m1.birthday);
				String[] array = birthdayStr.split("-");
				int getMonth=Integer.parseInt(array[1]);
				if(month==getMonth)
					System.out.println("����Ϊ��Ա�����գ�����������5000Ԫ");
				System.out.println(m1.name+"�Ĺ���Ϊ��"+m1.getSalay());
			}
			if(member.getType()==3) {
				ShareHolder s1= (ShareHolder)member;
				if(month==12) {
					System.out.println(s1.name+"�Ĺ���Ϊ��"+s1.getShare()*(getTurnover()-getAllSalary()));
				}
				else
					System.out.println("��Ա��Ϊ�ɶ���û����н");
			}
		}
	}
	/*
	 * �õ�����֧��
	 * @return һ��֧��
	 */
	public double getAllSalary() {
		double allSalary = 0;
		for(CompanyMember member:memberSet) {
			if(member.getType()==1) {
				Employee e1=(Employee)member;
				allSalary=allSalary+e1.getSalay()*12;
			}
			if(member.getType()==2) {
				Manager m1=(Manager)member;
				allSalary=allSalary+m1.getSalay()*12;
			}
		}
		return allSalary;
	}
	/*
	 * �������Ӫҵ��
	 */
	public double getTurnover() {
		Random random=new Random();
		int turnover=(random.nextInt(10)+1)*1000000;
		return Double.valueOf(turnover);
	}
	/*
	 * ��ѯĳ���˵Ĺ���
	 */
	public void inserch() {
		System.out.println("������Ҫ��ѯ�� ����");
		Scanner in=new Scanner(System.in);
		String name=in.nextLine();
		double getSalary=salaryMap.get(name);
		if(getSalary>1)
			System.out.println(name+"����нΪ"+getSalary+"Ԫ");
		else
			System.out.println(name+"�Ĺɷ�Ϊ"+getSalary);
	}
	/*
	 * ����������˾
	 */
	public void startCompany() throws ParseException {
		System.out.println("��ҵ�󼪣�");
		Scanner in=new Scanner(System.in);
		while(true){
			System.out.println("�Ƿ�Ҫ���Ա����y/n��");
			String input=in.next();
			if("y".equals(input.toLowerCase())) {
				addCompanyMember();
			}
			else
			{
				System.out.println("���Ա�����");
				break;
			}
		}
//		System.out.println("�����һ������");
		while(true){
			System.out.println("�Ƿ�Ҫ���Ź��ʣ�y/n��");
			String input=in.next();
			if("y".equals(input.toLowerCase())) {
				payoff();
			}
			else
			{
				System.out.println("���Ź������");
				break;
			}
		}
		while(true){
			System.out.println("�Ƿ�Ҫ��ѯĳһ���˵Ĺ��ʣ�y/n��");
			String input=in.next();
			if("y".equals(input.toLowerCase())) {
				inserch();
			}
			else
			{
				System.out.println("��ѯ���");
				break;
			}
		}
	}
}
