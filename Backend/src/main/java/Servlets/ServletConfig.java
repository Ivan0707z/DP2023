package Servlets;

import CRUD.FileCrudIO;
import CRUD.FileCrudInterface;

public class ServletConfig implements ServletConfigInterface {
    FileCrudInterface fileCrud;
    public ServletConfig() {
        this.fileCrud = new FileCrudIO();
    }
    @Override
    public FileCrudInterface getCrud() {
        return fileCrud;
    }
}
