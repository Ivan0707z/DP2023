package CRUD;

import Entities.Tanks;

import java.util.List;

public interface FileCrudInterface {
    public List<Tanks> readData();
    public void writeData(List<Tanks> data);

}
