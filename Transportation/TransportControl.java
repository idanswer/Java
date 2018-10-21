import java.util.Scanner;
/*
 * 连接三种方式的类
 */
public class TransportControl {
	private TransportC car;
	private TransportC highRail;
	private TransportC plane;
	public TransportControl() {
		car=new Car();
		highRail=new HighRail();
		plane=new Plane();
	}
	//运行
	public void run() {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入出发地，目的地，和距离(以enter键分隔)");	
		String start=input.nextLine();
		String end=input.nextLine();
		double distance=input.nextDouble();
		System.out.println(start+"到"+end);
		car.printSpend(car.countMenoy(distance));
		car.printTime(car.countTime(distance));
		highRail.printSpend(highRail.countMenoy(distance));
		highRail.printTime(highRail.countTime(distance));
		plane.printSpend(plane.countMenoy(distance));
		plane.printTime(plane.countTime(distance));
	}
}
