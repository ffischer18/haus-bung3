package Beispiel1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws IOException {
        WeaponsWorker ww = new WeaponsWorker();
        ww.readCSVFile();
        //ww.printWeapons();
        ww.printTable();
    }
}
