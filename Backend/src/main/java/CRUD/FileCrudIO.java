package CRUD;

import Entities.Tanks;
import FileIO.FileIO;
import FileIO.FileIOInterface;
public class FileCrudIO implements FileCrudInterface{
      FileIOInterface fio;
    public FileCrudIO(){
        this.fio = new FileIO();
    }
    @Override
    public Tanks readData() {
        return (Tanks) fio.readFromFile();
    }
    @Override
    public void writeData(Tanks data) {
        fio.loadToFile(data);
    }
}
