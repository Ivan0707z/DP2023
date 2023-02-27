package Servlets;


import CRUD.FileCrudInterface;
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
public class TanksServlet extends HttpServlet {
    ServletConfigInterface servletConfig;
    FileCrudInterface fileCrud;
    public TanksServlet() {
        this.servletConfig = new ServletConfig();
        this.fileCrud = servletConfig.getCrud();

    }
    @Override
    public void doGet(HttpServletRequest request, @NotNull HttpServletResponse response) throws IOException {

        String someJson = new Gson().toJson(this.fileCrud.readData());
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(someJson);
        out.flush();
    }
    @Override
    public void doPut(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        int power = Integer.parseInt(request.getParameter("power"));
        int power_reserve = Integer.parseInt(request.getParameter("power-reserve"));
        int speed = Integer.parseInt(request.getParameter("speed"));
        String photo = request.getParameter("photo");
        this.fileCrud.writeData(new Tanks(name,power,power_reserve,speed,photo));
    }
}
