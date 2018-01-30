package asteriskconfig;

import static org.junit.Assert.*;

import asteriskconfig.ConfigFile;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigFileTest {

	@Test
	public void testConstructor() {
		ConfigFile configFile = new ConfigFile();
		assertNotNull(configFile.getGlobal());
	}

	@Test
	public void testAddNewSection() {
		ConfigFile configFile = new ConfigFile();
		configFile.createNewSection("section1");
		assertTrue(configFile.hasSection("section1"));
	}

	@Test(expected = SectionAlreadyExistsException.class)
	public void testSectionAlreadyExists() {
		ConfigFile configFile = new ConfigFile();
		configFile.createNewSection("section1");
		configFile.createNewSection("section1");
	}

	@Test
    public void testSerialization() throws Exception {
        ConfigFile configFile = new ConfigFile();

        ConfigSection section1 = configFile.createNewSection("section1");
        section1.addEntry(new Comment("this is a comment"));
        section1.addEntry(new Directive("exten", "directive1"));
        section1.addEntry(new ConfigEntry("key1", "value1"));

        ConfigSection section2 = configFile.createNewSection("section2");
        section2.addEntry(new Comment("this is another comment"));
        section2.addEntry(new Directive("exten", "directive2"));
        section2.addEntry(new ConfigEntry("key2", "value2"));

        String expected = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("section-expected.conf").toURI())));
        assertEquals(expected, configFile.toString());
    }
}
