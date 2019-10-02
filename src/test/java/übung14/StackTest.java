package übung14;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

	Stack2 stack = new Stack2();

	Object test1 = new Object();
	Object test2 = new Object();
	Object test3 = new Object();
	Character c = new Character('a');

	@BeforeEach
	void SetUp() {
	}

	@Test
	void test_push() {
		stack.push(test1);
		stack.push(test2);
		stack.push(test3);

		assertEquals(3, stack.getSize());
		assertEquals(test3, stack.pop());
		assertEquals(test2, stack.pop());
		assertEquals(test1, stack.pop());
	}

	@Test
	void test_pop() {
		stack.push(test1);
		stack.push(test2);
		stack.push(test3);

		assertEquals(test3, stack.pop());
		assertEquals(test2, stack.pop());
		assertEquals(test1, stack.pop());
		assertEquals(0, stack.getSize());
	}

	@Test
	void test_popButEmpty_exception() {
		stack.push(test1);
		stack.push(test2);
		stack.push(test3);

		try {
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			fail("out of bounds");
		} catch (Exception e) {

		}
	}

}
