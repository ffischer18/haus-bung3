package Beispiel1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WeaponsWorker {

    private List weapons = new ArrayList();

    public List getWeapons() {
        return weapons;
    }

    public void readCSVFile(File csvFile) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile)));) {
            String line;
            while ((line = br.readLine()) != null) {
                Weapons w = Weapons.deserialize(line);
                if (line != null) {
                    weapons.add(w);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WeaponsWorker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WeaponsWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
