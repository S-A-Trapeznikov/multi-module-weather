package org.sonatype.mavenbook.weather;

import org.apache.log4j.PropertyConfigurator;

import java.io.InputStream;

public class Main {

    public static void main (String[] args) {
        PropertyConfigurator.configure(Main.class.getClassLoader().getResource("log4j.properties"));
        String zipCode="834463";
        try{
            zipCode=args[0];
        }catch(Exception e) {}

        new Main(zipCode).start();
    }

    private String zip;

    public Main(String zip){
        this.zip=zip;
    }

    public void start() {
        //Retrieve Data
        InputStream dataIn = null;
        try {
            dataIn = new YahooRetriever().retriever(zip);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Parser Data
        Weather weather = null;
        try {
            weather = new YahooParser().parse(dataIn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Format (Print) Data
        try {
            System.out.print(new WeatherFormatter().format(weather));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
