package trng.reflection.annotation.use;

import trng.reflection.annotation.Test;
import trng.reflection.annotation.TesterInfo;
import trng.reflection.annotation.TesterInfo.Priority;
 
@TesterInfo(
	priority = Priority.HIGH, 
	createdBy = "manohar@test.com",  
	tags = {"sales","test" }
)
public class TestExample {

	@Test
	public void testA() {
		if (true)
			throw new RuntimeException("This test always failed");
	}

	@Test(enabled = false)
	void testB() {
		if (false)
			throw new RuntimeException("This test always passed");
	}

	@Test(enabled = true)
	void testC() {
		if (10 > 1) {
			// do nothing, this test always passed.
		}
	}

}