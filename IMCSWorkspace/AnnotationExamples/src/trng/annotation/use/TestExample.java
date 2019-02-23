package trng.annotation.use;

import trng.annotation.Test;
import trng.annotation.TesterInfo;
import trng.annotation.TesterInfo.Priority;
 
@TesterInfo(
	priority = Priority.HIGH, 
	createdBy = "manohar@test.com",  
	tags = {"sales","test" }
)
public class TestExample {

	@Test(enabled = false)
	@SuppressWarnings(value="unused")
	public void testA() {
		if (1==1) {
			//
		}
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