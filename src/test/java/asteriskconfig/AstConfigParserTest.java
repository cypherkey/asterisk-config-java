package asteriskconfig;

import static org.junit.Assert.*;

import asteriskconfig.AstConfigParser;
import asteriskconfig.ConfigFile;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class AstConfigParserTest {
    @Test
    public void testParseSip() {
    	File f = new File(getClass().getClassLoader().getResource("sip.conf").getFile());

        AstConfigParser parser = new AstConfigParser();
        ConfigFile config;
        try {
            config = parser.parse(f);
            assertEquals("", config.toString());
        } catch (IOException e) {
            assertTrue(false);
        }
    }
}
