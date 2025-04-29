
package lecture;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import fonction.Carburant;
import fonction.Cuve;
import fonction.Station;

public class FStream {
    public static Station from_data(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
    
            // Lire Station:
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue; // Ignorer lignes vides
                if (line.startsWith("Station:")) break;
            }
    
            if (line == null || !line.startsWith("Station:")) {
                throw new IOException("Format invalide : Station manquante");
            }
    
            Station station = new Station();
            station.setNom(line.substring("Station:".length()).trim());
    
            List<Carburant> carburants = new ArrayList<>();
            List<Cuve> cuves = new ArrayList<>();
    
            // Sauter jusqu'au premier break;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.equalsIgnoreCase("break;")) break;
            }
    
            // Lire Carburant:
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                if (line.equalsIgnoreCase("Carburant:")) break;
            }
    
            if (line == null || !line.equalsIgnoreCase("Carburant:")) {
                throw new IOException("Format invalide : section Carburant manquante");
            }
    
            // Lire carburants jusqu'au break;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                if (line.equalsIgnoreCase("break;")) break;
    
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    throw new IOException("Format invalide de carburant : " + line);
                }
    
                Carburant carburant = new Carburant();
                carburant.setNom(parts[0].trim());
                carburant.setpA(Integer.parseInt(parts[1].trim()));
                carburant.setpV(Integer.parseInt(parts[2].trim()));
                carburants.add(carburant);
            }
    
            // Lire Cuves:
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                if (line.equalsIgnoreCase("Cuves:")) break;
            }
    
            if (line == null || !line.equalsIgnoreCase("Cuves:")) {
                throw new IOException("Format invalide : section Cuves manquante");
            }
    
            // Lire cuves
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
    
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    throw new IOException("Format invalide de cuve : " + line);
                }
    
                Cuve cuve = new Cuve();
                cuve.setNom(parts[0].trim());
                cuve.setCapacite(Integer.parseInt(parts[1].trim()));
    
                String carburantNom = parts[2].trim();
                Carburant carburantAssocie = null;
                for (Carburant c : carburants) {
                    if (c.getNom().equalsIgnoreCase(carburantNom)) {
                        carburantAssocie = c;
                        break;
                    }
                }
    
                if (carburantAssocie == null) {
                    throw new IOException("Carburant non trouvé pour cuve : " + carburantNom);
                }
    
                cuve.setCarb(carburantAssocie);
                cuves.add(cuve);
            }
    
            station.setLc(cuves.toArray(new Cuve[0]));
            return station;
    
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    public static void saveStationToFile(Station station, String filePath) {
    try (PrintWriter pw = new PrintWriter(filePath)) {
        pw.println("Station:" + station.getNom());
        pw.println("break;");
        pw.println("Carburant:");

        List<String> dejaEcrit = new ArrayList<>();
        for (Cuve c : station.getLc()) {
            Carburant carb = c.getCarb();
            if (!dejaEcrit.contains(carb.getNom().toLowerCase())) {
                pw.println(carb.getNom() + "," + carb.getpA() + "," + carb.getpV());
                dejaEcrit.add(carb.getNom().toLowerCase());
            }
        }

        pw.println("break;");
        pw.println("Cuves:");
        for (Cuve c : station.getLc()) {
            pw.println(c.getNom() + "," + c.getCapacite() + "," + c.getCarb().getNom());
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public static void main(String[] args) {
        Station f=from_data("/home/tomefy/Documents/prog/java/station_service/save/info_station/total.txt");
        saveStationToFile(f,"/home/tomefy/Documents/prog/java/station_service/save/info_station/total2.txt" );
    }
}
