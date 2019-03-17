package persistence;

import java.util.ArrayList;

public interface IFiles {
public abstract ArrayList<Object> readFile(String path);
public abstract void writeFile(String path,ArrayList<Object> data);
}
