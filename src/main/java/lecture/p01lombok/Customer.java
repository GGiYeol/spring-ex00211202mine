package lecture.p01lombok;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//어노테이션을 만들면 get, set이 자동으로 만들어진다. 
@Getter
@Setter
@ToString
//생성자 자동 생성
@AllArgsConstructor
//파라미터 없는 생성자 생성
@NoArgsConstructor
public class Customer {
	
	private int id;
	private String name;
	private String city;
	private String address;
	
	//lombok은 get,set메서드를 쉽게 만들어줌.
}
