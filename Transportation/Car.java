/*
 * Æû³µÀà
 */
public class Car extends TransportC {
	public Car() {
		name="Æû³µ";
		timeToTransport=10;
		timeBackFromTransport=10;
		timeGetTicket=0;
		timeSecurityCheck=0;
		timeWait=0;
		price=0.32;
		speed=80;
	}
	
	@Override
	public double countMenoy(double distance) {
		double Menoy=distance*getPrice();
		return Menoy;
	}
	@Override
	public double countTime(double distance) {
		double time=timeToTransport+timeBackFromTransport+(distance/speed)*60;
		return time;
	}
	
}














