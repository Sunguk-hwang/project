package lab1;

public class TvFactory { // tv 만드는 공장, 여기서만 만들 수 있다.
	
	public static TV makeTV(String brand) {
		TV tv = null;
		
		if(brand.equals("sam")){
			tv = new SamsungTV();
		} else if(brand.equals("lg")) {
			tv = new LgTV();
		}
		return tv;
	}

}
