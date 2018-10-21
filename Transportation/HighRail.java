/*
 * ¸ßÌúÀà
 */
public class HighRail extends TransportC {
	public HighRail() {
		name="¸ßÌú";
		timeToTransport=15;
		timeBackFromTransport=15;
		timeGetTicket=15;
		timeSecurityCheck=15;
		timeWait=15;	
		price=0.45;
		speed=400;
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
