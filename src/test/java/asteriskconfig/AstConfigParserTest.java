package asteriskconfig;

import static org.junit.Assert.*;

import asteriskconfig.AstConfigParser;
import asteriskconfig.ConfigFile;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

public class AstConfigParserTest {

    @Test
    public void testParse() {


        StringReader reader = new StringReader(sample);

        AstConfigParser parser = new AstConfigParser();
        ConfigFile config;
        try {
            config = parser.parse(reader);
            assertEquals("", config.toString());
        } catch (IOException e) {
            assertTrue(false);
        }


    }
}
