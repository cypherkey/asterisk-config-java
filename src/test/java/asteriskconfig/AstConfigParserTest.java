package asteriskconfig;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AstConfigParserTest {

    @Test
    public void testParseExten() throws Exception {
        File f = new File(getClass().getClassLoader().getResource("exten.conf").getFile());

        AstConfigParser parser = new AstConfigParser();
        ConfigFile config = parser.parse(f);
        String expected = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("exten-expected.conf").toURI())));

        // Test serialization
        assertEquals(expected, config.toString());

        // Check the trunktollfree section
        assertTrue(config.hasSection("trunktollfree"));
        ConfigSection section = config.getSection("trunktollfree");
        assertEquals(7, section.getEntries().size());
        assertEquals("Long distance context accessed through trunk interface", ((Comment) section.get(1)).getComment());
        assertEquals("exten", ((Directive) section.get(3)).getKey());
        assertEquals("_91800NXXXXXX,1,Dial(${GLOBAL(TRUNK)}/${EXTEN:${GLOBAL(TRUNKMSD)}})", ((Directive) section.get(3)).getValue());
        assertEquals(3, section.getEntriesOfType(Comment.class).size());
        assertEquals(4, section.getEntriesOfType(Directive.class).size());
    }

    @Test
    public void testParseSip() throws Exception {
    	File f = new File(getClass().getClassLoader().getResource("sip.conf").getFile());

    	AstConfigParser parser = new AstConfigParser();
        ConfigFile config = parser.parse(f);
        String expected = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("sip-expected.conf").toURI())));

        // Test serialization
        assertEquals(expected, config.toString());

        // Check the global section
        ConfigSection section = config.getGlobal();
        Comment c = (Comment) section.getEntries().get(1);
        assertEquals("SIP Configuration example for Asterisk", c.getComment());

        // Check the general section
        assertTrue(config.hasSection("general"));
        section = config.getSection("general");
        ConfigEntry entry = (ConfigEntry) section.getEntries().get(5);
        assertEquals("allowoverlap", entry.getKey());
        assertEquals("no", entry.getValue());
        assertEquals("Disable overlap dialing support. (Default is yes)", entry.getComment());

        // Check the 4723136505 section
        assertTrue(config.hasSection("4723136505"));
        section = config.getSection("4723136505");
        ConfigEntry cfg = (ConfigEntry) section.getEntries().get(0);
        assertEquals("host", cfg.getKey());
        assertEquals("1.1.1.1", cfg.getValue());

        assertFalse(config.hasSection("invalidsection"));
    }
}