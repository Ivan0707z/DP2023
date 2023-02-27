package CRUD;

import Entities.Tanks;
import FileIO.FileIO;
import FileIO.FileIOInterface;

import java.util.List;

public class FileCrudIO implements FileCrudInterface{
      FileIOInterface fio;
    public FileCrudIO(){
        this.fio = new FileIO();
    }
    @Override
    public List<Tanks> readData() {
        return fio.readFromFile();
    }
    @Override
    public void writeData(List<Tanks> data) {
        fio.loadToFile(data);
    }
}
