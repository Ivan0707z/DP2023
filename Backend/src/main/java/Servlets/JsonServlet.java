package Servlets;


import Entities.Tanks;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/tanks")
public class JsonServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, @NotNull HttpServletResponse response) throws IOException {
        Tanks tank = new Tanks("Леклерк", 1500, 550, 71, "./assets/img/2.jpg");
        String someJson = new Gson().toJson(tank);
        System.out.println(someJson);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(someJson);
        out.flush();
    }
}
