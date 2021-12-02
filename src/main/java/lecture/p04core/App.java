package lecture.p04core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.log4j.Log4j;

@Log4j
public class App {
	
	public static void main(String[] args) {
		
		String contextFilePath = "lecture/p04core/context.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(contextFilePath);
		
		MyServlet s1 = context.getBean(MyServlet.class);
		
		//값이 나오면 스프링이 값을 받아 객체를 만들었다
		
		MyDao d1 = context.getBean(MyDao.class);
		
		log.warn(s1);
		
		log.warn(d1);
		//실제로 객체도 만들어지고 주입도 일어났다는 것을 알아냈음
		log.warn(s1.getMyDao());
		
		//객체 만들고 injection하는 일은 항상 일어남.
		
		
	}
}
