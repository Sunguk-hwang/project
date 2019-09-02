package lab1;

public class LgTV implements TV{
	
	public void powerOn() {
		System.out.println(this.getClass().getSimpleName() + "전원이 켜집니다.");
	}
	
	public void powerOff() {
		System.out.println(this.getClass().getSimpleName() + "전원이 꺼집니다.");
	}

}
