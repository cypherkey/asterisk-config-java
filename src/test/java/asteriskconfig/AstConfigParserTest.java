package asteriskconfig;

import static org.junit.Assert.*;

import asteriskconfig.AstConfigParser;
import asteriskconfig.ConfigFile;
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

        ConfigEntry d = (ConfigEntry) section.getProperties().get(5);
        assertEquals("allowoverlap", d.getKey());
        assertEquals("no", d.getValue());
        assertEquals("Disable overlap dialing support. (Default is yes)", d.getComment());
        
        section = config.getGlobal();
        Comment c = (Comment) section.getProperties().get(1);
        assertEquals("SIP Configuration example for Asterisk", c.getComment());
        
        section = config.getSection("4723136505");
        ConfigEntry cfg = (ConfigEntry) section.getProperties().get(0);
        assertEquals("host", cfg.getKey());
        assertEquals("209.141.61.119", cfg.getValue());
    }
}
