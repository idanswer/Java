import java.util.Scanner;
/*
 * �������ַ�ʽ����
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
	//����
	public void run() {
		Scanner input=new Scanner(System.in);
		System.out.println("����������أ�Ŀ�ĵأ��;���(��enter���ָ�)");	
		String start=input.nextLine();
		String end=input.nextLine();
		double distance=input.nextDouble();
		System.out.println(start+"��"+end);
		car.printSpend(car.countMenoy(distance));
		car.printTime(car.countTime(distance));
		highRail.printSpend(highRail.countMenoy(distance));
		highRail.printTime(highRail.countTime(distance));
		plane.printSpend(plane.countMenoy(distance));
		plane.printTime(plane.countTime(distance));
	}
}
