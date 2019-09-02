package lab1;

public class TvUser {

	public static void main(String[] args) {
		/*
		TV tv1 = new SamsungTV();
		tv1.powerOn();
		tv1.powerOff();
		System.out.println();
		TV tv2 = new LgTV();
		tv2.powerOn();
		tv2.powerOff();
		*/
		
		TV tv = TvFactory.makeTV("lg"); // 사용자는 tv 만들지말고 브랜드만 정하면 공장에서 만들어 온 것을 받아오자
		tv.powerOn();
		tv.powerOff();

	}

}
