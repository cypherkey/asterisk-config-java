package asteriskconfig;

import static org.junit.Assert.*;

import asteriskconfig.KeyValueProperty;
import org.junit.Test;

public class KeyValuePropertyTest {
	@Test
	public void testConstructor() {
		KeyValueProperty p = new KeyValueProperty("foo", "bar");
		assertEquals("foo", p.getKey());
		assertEquals("bar", p.getValue());
	}

	@Test
	public void testSerialization() {
		KeyValueProperty p = new KeyValueProperty("foo", "bar");
		assertEquals("foo = bar", p.toString());
	}

	@Test
	public void testAllowDuplcates() {
		KeyValueProperty p = new KeyValueProperty("foo", "bar");
		assertFalse(p.allowDuplicates());
		
		p.setValue("bar1");
		assertEquals("bar1", p.getValue());
	}

	@Test
	public void testSetters() {
		KeyValueProperty p = new KeyValueProperty("foo", "bar");
		assertEquals("bar", p.getValue());

		p.setValue("bar1");
		assertEquals("bar1", p.getValue());
	}
}
