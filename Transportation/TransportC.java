/*
 * @author answer
 * 虚基类 交通类
 */
public abstract class TransportC implements Transport{
	String name;//交通方式名称
	double timeToTransport;
	double timeBackFromTransport;
	double timeGetTicket;
	double timeSecurityCheck;
	double timeWait;
	double speed;
	double price;
	//返回价格
	public double getPrice() {
		return price;
	}
	//输出金钱
	public void printSpend(double menoy) {
		System.out.print(name+"所花费的金钱为："+menoy+"元"+"\t");
	}
	//输出时间
	public void printTime(double time) {
		System.out.println("时间为："+time+"分钟");
	}
}
