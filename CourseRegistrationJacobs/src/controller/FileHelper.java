package controller;

import java.util.ArrayList;

public interface FileHelper {
	public boolean doesAFileExist();
	public boolean writeFile(ArrayList<?> list);
	public ArrayList<?> readFile();
}
