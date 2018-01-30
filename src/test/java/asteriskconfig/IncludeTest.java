package asteriskconfig;

import static org.junit.Assert.*;

import org.junit.Test;

public class IncludeTest {
	@Test
	public void testConstructor() {
		Include p = new Include("bar");
		assertEquals("bar", p.getValue());
	}

	@Test
	public void testSerialization() {
		Include p = new Include("bar1");
		assertEquals(String.format("#include bar1"), p.toString());
	}
}
