package asteriskconfig;

import static org.junit.Assert.*;

import asteriskconfig.ConfigEntry;
import org.junit.Test;

public class ConfigEntryTest {
	@Test
	public void testConstructor() {
		ConfigEntry entry = new ConfigEntry("foo", "bar");
		assertEquals("foo", entry.getKey());
		assertEquals("bar", entry.getValue());

		entry = new ConfigEntry("bob", "alice", "mycomment");
		assertEquals("bob", entry.getKey());
		assertEquals("alice", entry.getValue());
		assertEquals("mycomment", entry.getComment());
	}

	@Test
	public void testSetters() {
		ConfigEntry entry = new ConfigEntry("foo", "bar");
		assertEquals("bar", entry.getValue());

		entry.setValue("bar1");
		assertEquals("bar1", entry.getValue());
	}

	@Test
	public void testSerialization() {
		ConfigEntry entry = new ConfigEntry("foo", "bar");
		assertEquals("foo = bar", entry.toString());

		entry = new ConfigEntry("bob","alice","mycomment");
		assertEquals(String.format("bob = alice%s; mycomment", GlobalSettings.getInstance().getInlineCommentPrefix()), entry.toString());
	}
}
