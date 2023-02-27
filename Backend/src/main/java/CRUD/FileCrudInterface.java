package CRUD;

import Entities.Tanks;

public interface FileCrudInterface {
    public Tanks readData();
    public void writeData(Tanks data);
}
