package org.sonatype.mavenbook.web;

import org.sonatype.mavenbook.weather.WeatherService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WeatherServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String zip = request.getParameter("zip");
        WeatherService weatherService = new WeatherService();
        PrintWriter out = response.getWriter();
        String weather = null;
        try {
            weather = weatherService.retrieveForecast(zip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.println(weather);
        out.flush();
        out.close();
    }
}
