/*
 * ·É»úÀà
 */
public class Plane extends TransportC {
	public Plane() {
		name="·É»ú";
		timeToTransport=20;
		timeBackFromTransport=20;
		timeGetTicket=10;
		timeSecurityCheck=10;
		timeWait=20;
		price=0.75;
		speed=800;
	}
	
	@Override
	public double countMenoy(double distance) {
		double Menoy=distance*getPrice();
		return Menoy;
	}

	@Override
	public double countTime(double distance) {
		double time=timeToTransport+timeBackFromTransport+timeGetTicket+timeSecurityCheck+timeWait+(distance/speed)*60;
		return time;
	}
}
