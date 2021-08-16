package Practice;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class JunitPractice {

	@ParameterizedTest     
	@ValueSource(strings = {"LambdaTest", "JUnit", "Annotations","" })     
	void ExampleCode(String data)     
	{      
		System.out.println(data);
	  assertNotNull(data);     
	}
	
}
