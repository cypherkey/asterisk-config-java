package asteriskconfig;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AstConfigParserTest {
    @Test
    public void testParseSip() throws Exception {
    	File f = new File(getClass().getClassLoader().getResource("sip.conf").getFile());

    	AstConfigParser parser = new AstConfigParser();
        ConfigFile config = parser.parse(f);
        String expected = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("sip-expected.conf").toURI())));

        System.out.println(expected);
        System.out.println("-----");
        System.out.println(config.toString());
        
        assertEquals(expected, config.toString());

        ConfigSection section = config.getSection("general");

        ConfigEntry d = (ConfigEntry) section.getEntries().get(5);
        assertEquals("allowoverlap", d.getKey());
        assertEquals("no", d.getValue());
        assertEquals("Disable overlap dialing support. (Default is yes)", d.getComment());
        
        section = config.getGlobal();
        Comment c = (Comment) section.getEntries().get(1);
        assertEquals("SIP Configuration example for Asterisk", c.getComment());

        assertTrue(config.hasSection("4723136505"));
        assertFalse(config.hasSection("invalidsection"));

        section = config.getSection("4723136505");
        ConfigEntry cfg = (ConfigEntry) section.getEntries().get(0);
        assertEquals("host", cfg.getKey());
        assertEquals("1.1.1.1", cfg.getValue());
    }
}
