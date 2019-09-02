package lab4;

//import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component("car2") // "people2" 생략하면 클래스 이름의 소문자를 기본값으로
public class Car {
	
	String model;
	int price;
	
	public Car() {
		
	}
	
	public Car(String model, int price) {
		super();
		this.model = model;
		this.price = price;
	}
	
	public String getModel() {
		return model;
	}
	
	//@Required
	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [model=" + model + ", price=" + price + "]";
	}

	

}
