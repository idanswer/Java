package com.pxy;
/*
 * 公司类 连接其他所有的类
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
	private Set<CompanyMember> memberSet;//成员set
	private Map<String,Double> salaryMap;//key：名字 value：工资
//	private SimpleDateFormat formatter=new SimpleDateFormat("yyyy-mm-dd");
	public Company() {
		memberSet=new TreeSet<CompanyMember>();
		salaryMap=new HashMap<String,Double>();
	}
	/*
	 * @加员工进memberSet
	 */
	public void addCompanyMember() {
	SimpleDateFormat formatter=new SimpleDateFormat("yyyy-mm-dd");
		System.out.println("请输入你要加的员工类型(1：员工2：经理3：股东)");
		Scanner in=new Scanner(System.in);
		byte memberType=in.nextByte();
		if(memberType==1) {
			CompanyMember employee;
			Date birthday=null;
			System.out.println("请输入员工的姓名");
			String name=in.next();
			System.out.println("请输入员工的月薪");
			double salary=in.nextDouble();
			System.out.println("请输入员工的生日（格式：例：2017-03-02）");
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
			System.out.println("请输入员工的姓名");
			String name=in.next();
			System.out.println("请输入员工的月薪");
			double salary=in.nextDouble();
			System.out.println("请输入员工的奖金");
			double bonus=in.nextDouble();
			System.out.println("请输入员工的生日（格式：例：2017-03-02）");
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
			System.out.println("请输入员工的姓名");
			String name=in.next();
			System.out.println("请输入员工的生日（格式：例：2017-03-02）");
			String dateStr=in.next();
			System.out.println("请输入员工的股份(0-1)");
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
				System.out.println("股份溢出，添加员工失败");
		}
	}
	/*
	 * 发当月工资并显示出来
	 */
	public void payoff() throws ParseException {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
		Scanner in=new Scanner(System.in);
		System.out.println("请输入发工资的月份（例:12）");
		int month=in.nextInt();
		
		for(CompanyMember member:memberSet) {
			if(member.getType()==1) {
				Employee e1=(Employee)member;
				String birthdayStr=format.format(e1.birthday);
				String[] array = birthdayStr.split("-");
				int getMonth=Integer.parseInt(array[1]);
				if(month==getMonth)
					System.out.println("本月为该员工生日，发生日礼物5000元");
				System.out.println(e1.name+"的工资为："+e1.getSalay());
			}
			if(member.getType()==2) {
				Manager m1=(Manager)member;
				String birthdayStr=format.format(m1.birthday);
				String[] array = birthdayStr.split("-");
				int getMonth=Integer.parseInt(array[1]);
				if(month==getMonth)
					System.out.println("本月为该员工生日，发生日礼物5000元");
				System.out.println(m1.name+"的工资为："+m1.getSalay());
			}
			if(member.getType()==3) {
				ShareHolder s1= (ShareHolder)member;
				if(month==12) {
					System.out.println(s1.name+"的工资为："+s1.getShare()*(getTurnover()-getAllSalary()));
				}
				else
					System.out.println("该员工为股东，没有月薪");
			}
		}
	}
	/*
	 * 得到所有支出
	 * @return 一年支出
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
	 * 随机生成营业额
	 */
	public double getTurnover() {
		Random random=new Random();
		int turnover=(random.nextInt(10)+1)*1000000;
		return Double.valueOf(turnover);
	}
	/*
	 * 查询某个人的工资
	 */
	public void inserch() {
		System.out.println("请输入要查询的 人名");
		Scanner in=new Scanner(System.in);
		String name=in.nextLine();
		double getSalary=salaryMap.get(name);
		if(getSalary>1)
			System.out.println(name+"的月薪为"+getSalary+"元");
		else
			System.out.println(name+"的股份为"+getSalary);
	}
	/*
	 * 运行整个公司
	 */
	public void startCompany() throws ParseException {
		System.out.println("开业大吉！");
		Scanner in=new Scanner(System.in);
		while(true){
			System.out.println("是否要添加员工（y/n）");
			String input=in.next();
			if("y".equals(input.toLowerCase())) {
				addCompanyMember();
			}
			else
			{
				System.out.println("添加员工完成");
				break;
			}
		}
//		System.out.println("输出这一年所有");
		while(true){
			System.out.println("是否要发放工资（y/n）");
			String input=in.next();
			if("y".equals(input.toLowerCase())) {
				payoff();
			}
			else
			{
				System.out.println("发放工资完成");
				break;
			}
		}
		while(true){
			System.out.println("是否要查询某一个人的工资（y/n）");
			String input=in.next();
			if("y".equals(input.toLowerCase())) {
				inserch();
			}
			else
			{
				System.out.println("查询完成");
				break;
			}
		}
	}
}
