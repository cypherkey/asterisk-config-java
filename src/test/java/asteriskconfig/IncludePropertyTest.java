package asteriskconfig;

import static org.junit.Assert.*;

import asteriskconfig.IncludeProperty;
import org.junit.Test;

public class IncludePropertyTest {
	@Test
	public void testConstructor() {
		IncludeProperty p = new IncludeProperty("bar");
		assertEquals("#include", p.getKey());
		assertEquals("bar", p.getValue());
	}

	@Test
	public void testSerialization() {
		IncludeProperty p = new IncludeProperty("bar1");
		assertEquals(String.format("#include bar1"), p.toString());
	}

	@Test
	public void testAllowDuplcates() {
		IncludeProperty p = new IncludeProperty("bar1");
		assertTrue(p.allowDuplicates());
	}
}
