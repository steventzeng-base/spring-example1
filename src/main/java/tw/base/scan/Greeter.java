package tw.base.scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Greeter {
	@Autowired
	@Qualifier("default")
	//@Qualifier("tranlate")
	private Welcome welcome;
	
	public void welcomeVisitors(){
		System.out.println(welcome.buldPhrase("New York"));
	}
}
