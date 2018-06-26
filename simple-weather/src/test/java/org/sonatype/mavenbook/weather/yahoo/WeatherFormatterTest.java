package org.sonatype.mavenbook.weather.yahoo;

import junit.framework.TestCase;
import org.apache.commons.io.IOUtils;
import org.sonatype.mavenbook.weather.Weather;
import org.sonatype.mavenbook.weather.WeatherFormatter;
import org.sonatype.mavenbook.weather.YahooParser;

import java.io.InputStream;

public class WeatherFormatterTest extends TestCase {

    final private String xmlWeather = "msk-weather.xml";
    final private String expectedResultData = "format-expected.dat";

    public WeatherFormatterTest(String name) {
        super(name);
    }

    public void testFormat() throws Exception {
        InputStream mskData = getClass().getClassLoader().getResourceAsStream(xmlWeather);
        InputStream expectedResult = getClass().getClassLoader().getResourceAsStream(expectedResultData);
        Weather weather = new YahooParser().parse(mskData);
        String formattedResult = new WeatherFormatter().format(weather).trim();
        String expected = IOUtils.toString(expectedResult).trim();
        assertEquals(expected,formattedResult);
    }
}
