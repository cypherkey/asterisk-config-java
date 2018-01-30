package asteriskconfig;

import static org.junit.Assert.*;

import asteriskconfig.ConfigSection;
import asteriskconfig.IncludeProperty;
import asteriskconfig.ConfigEntry;
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
		section.addProperty(new ConfigEntry("bob", "alice"));
		section.addProperty(new IncludeProperty("file1"));
		
		assertEquals(2, section.getProperties().size());
		assertEquals("bob", ((IKeyValue)section.getProperties().get(0)).getKey());
		assertEquals("alice", ((IKeyValue)section.getProperties().get(0)).getValue());
	}

	@Test
	public void testSerialization() {
		ConfigSection section = new ConfigSection("test");
		section.addProperty(new ConfigEntry("bob", "alice"));
		section.addProperty(new IncludeProperty("file1"));
		
		assertEquals(String.format("[test]\nbob = alice\n#include file1\n"), section.toString());
	}
}