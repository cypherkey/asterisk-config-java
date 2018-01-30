package asteriskconfig;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConfigSectionTest {

	@Test
	public void testConstructor() {
		ConfigSection section = new ConfigSection("test");
		assertEquals("test", section.getName());
		
	}

	@Test
	public void testAddProperty() {
		ConfigSection section = new ConfigSection("test");
		section.addEntry(new ConfigEntry("bob", "alice"));
		section.addEntry(new Include("file1"));
		
		assertEquals(2, section.getEntries().size());
		assertEquals("bob", ((IKeyValue)section.getEntries().get(0)).getKey());
		assertEquals("alice", ((IKeyValue)section.getEntries().get(0)).getValue());
	}

	@Test
	public void testSerialization() {
		ConfigSection section = new ConfigSection("test");
		section.addEntry(new ConfigEntry("bob", "alice"));
		section.addEntry(new Include("file1"));
		
		assertEquals(String.format("[test]\nbob = alice\n#include file1\n"), section.toString());
	}
}