package lecture.p03core;

import lombok.Setter;

@Setter
public class MyServlet {

	private MyDao dao = new MyDao(); // dependency라고 함(의존)
	
	public void doGet() {
		//사전작업
		
		//request handle
		
		//business logic
		dao.update();
		// add attribute
		
		//forward / redirect
		
		
	}
}
