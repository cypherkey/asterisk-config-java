package asteriskconfig;

import static org.junit.Assert.*;

import asteriskconfig.ConfigEntry;
import org.junit.Test;

public class ConfigEntryTest {
	@Test
	public void testConstructor() {
		ConfigEntry p = new ConfigEntry("foo", "bar");
		assertEquals("foo", p.getKey());
		assertEquals("bar", p.getValue());
	}

	@Test
	public void testSetters() {
		ConfigEntry p = new ConfigEntry("foo", "bar");
		assertEquals("bar", p.getValue());

		p.setValue("bar1");
		assertEquals("bar1", p.getValue());
	}

	@Test
	public void testSerialization() {
		ConfigEntry p = new ConfigEntry("foo", "bar");
		assertEquals("foo = bar", p.toString());
	}
}
