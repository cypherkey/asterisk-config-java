package asteriskconfig;

import static org.junit.Assert.*;

import asteriskconfig.ConfigSection;
import asteriskconfig.IncludeProperty;
import asteriskconfig.KeyValueProperty;
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
		section.addProperty(new KeyValueProperty("bob", "alice"));
		section.addProperty(new IncludeProperty("file1"));
		
	}

	@Test
	public void testSerialization() {
		ConfigSection section = new ConfigSection("test");
		section.addProperty(new KeyValueProperty("bob", "alice"));
		section.addProperty(new IncludeProperty("file1"));
		
		assertEquals(String.format("[test]%nbob = alice%n#include file1%n"), section.toString());
	}

	@Test
	public void testDuplicateKeyValueProperty() {
		ConfigSection section = new ConfigSection("test");
		section.addProperty(new KeyValueProperty("bob", "alice"));
		section.addProperty(new KeyValueProperty("bob", "mary"));

		assertEquals(String.format("[test]%nbob = mary%n"), section.toString());
	}

	@Test
	public void testDuplicateIncludeProperty() {
		ConfigSection section = new ConfigSection("test");
		section.addProperty(new IncludeProperty("file1"));
		section.addProperty(new IncludeProperty("file2"));

		assertEquals(String.format("[test]%n#include file1%n#include file2%n"), section.toString());
	}
}