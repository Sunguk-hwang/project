package lab2;

public class LgTV implements TV {

	public LgTV() {
		System.out.println("LgTV 생성자");
	}

	public void powerOn() {
		System.out.println(this.getClass().getSimpleName() + "전원이 켜집니다.");
	}

	public void powerOff() {
		System.out.println(this.getClass().getSimpleName() + "전원이 꺼집니다.");
	}

}
