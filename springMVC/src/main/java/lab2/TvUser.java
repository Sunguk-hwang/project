package lab2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TvUser {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("lab2.xml"); 
		//TV tv = (TV)context.getBean("stv");
		TV tv = context.getBean("stv", TV.class);
		tv.powerOn();
		tv.powerOff();

	}

}
