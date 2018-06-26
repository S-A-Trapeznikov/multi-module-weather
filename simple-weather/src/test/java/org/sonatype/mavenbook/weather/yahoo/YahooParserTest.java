package org.sonatype.mavenbook.weather.yahoo;

import junit.framework.TestCase;
import org.sonatype.mavenbook.weather.Weather;
import org.sonatype.mavenbook.weather.YahooParser;

import java.io.InputStream;

public class YahooParserTest extends TestCase {
    final private String xmlWeather = "msk-weather.xml";

    public YahooParserTest(String name) {
        super(name);
    }

    public void testParser() throws Exception {
        InputStream mskData = getClass().getClassLoader().getResourceAsStream(xmlWeather);

        Weather weather = new YahooParser().parse(mskData);

        assertEquals("Minsk", weather.getCity());
        assertEquals("Minsk", weather.getRegion());
        assertEquals("Belarus", weather.getCountry());
    }
}
