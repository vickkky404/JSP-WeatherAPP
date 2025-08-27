package com.weatherapp.weatherapp;

import java.io.*;

import java.net.*;
import java.util.Scanner;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "MyServlet", value = "/My-Servlet")
public class MyServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "This is Servlet file";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


//        OpenWeather API.....
        String apiKey = "e66f4ac846e0cdaaa4f3c322b2153432";
        // Get the city from the form input
        String city = request.getParameter("city");

        // Create the URL for the OpenWeatherMap API request
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=New%20Delhi&appid=e66f4ac846e0cdaaa4f3c322b2153432&units=metric\n" + city + "&appid=" + apiKey;

        //API integration...
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        // reading data from network
        InputStream inputStream = con.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream);

        //store data in String
        StringBuilder responseContent = new StringBuilder();

        //Input from reader..will create scanner obj.
        Scanner scanner = new Scanner(reader);


        while (scanner.hasNext()) {
            responseContent.append(scanner.nextLine());
        }

        scanner.close();


        // typecasting = parsing the data into JSON
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(responseContent.toString());
    }
}