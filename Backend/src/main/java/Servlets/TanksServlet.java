package Servlets;


import CRUD.FileCrudInterface;
import Entities.Tanks;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/tanks/*")
public class TanksServlet extends HttpServlet {

    List<Tanks> tanksList = new ArrayList<Tanks>();
    ServletConfigInterface servletConfig;
    FileCrudInterface fileCrud;
    public TanksServlet() {
        this.servletConfig = new ServletConfig();
        this.fileCrud = servletConfig.getCrud();

    }
    @Override
    public void doGet(HttpServletRequest request, @NotNull HttpServletResponse response) throws IOException {
        setAccessControlHeaders(response);
        this.tanksList = this.fileCrud.readData();
        String someJson = new Gson().toJson(this.tanksList);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(someJson);
        out.flush();
    }
    @Override
    public void doPut(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws IOException {
        setAccessControlHeaders(response);
        Tanks manpad = Helper.userParse(request);
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        int index = Helper.getIndexByUserId(id, this.tanksList);
        this.tanksList.set(index, manpad);
        this.fileCrud.writeData(this.tanksList);
        doGet(request,response);
    }
    @Override
    public void doPost(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws ServletException, IOException {
        setAccessControlHeaders(response);
        Tanks tank = Helper.userParse(request);
        tank.setId(Helper.getNextId(this.tanksList));
        this.tanksList.add(tank);
        this.fileCrud.writeData(this.tanksList);
        doGet(request,response);
    }
    @Override
    public void doDelete(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws ServletException, IOException {
        setAccessControlHeaders(response);
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        int index = Helper.getIndexByUserId(id, this.tanksList);
        this.tanksList.remove(index);
        this.fileCrud.writeData(this.tanksList);
        doGet(request,response);
    }
    @Override
    protected void doOptions(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws ServletException, IOException{
        setAccessControlHeaders(response);
        response.setStatus(HttpServletResponse.SC_OK);
    }
    private void setAccessControlHeaders(@NotNull HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");
    }
}
