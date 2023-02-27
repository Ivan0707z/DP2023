package FileIO;

import Entities.Tanks;

import java.util.List;

public interface FileIOInterface {
    public void loadToFile(List<Tanks> object);
    public List<Tanks> readFromFile();
}
