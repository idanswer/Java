/*
 * @author answer
 * ����� ��ͨ��
 */
public abstract class TransportC implements Transport{
	String name;//��ͨ��ʽ����
	double timeToTransport;
	double timeBackFromTransport;
	double timeGetTicket;
	double timeSecurityCheck;
	double timeWait;
	double speed;
	double price;
	//���ؼ۸�
	public double getPrice() {
		return price;
	}
	//�����Ǯ
	public void printSpend(double menoy) {
		System.out.print(name+"�����ѵĽ�ǮΪ��"+menoy+"Ԫ"+"\t");
	}
	//���ʱ��
	public void printTime(double time) {
		System.out.println("ʱ��Ϊ��"+time+"����");
	}
}
