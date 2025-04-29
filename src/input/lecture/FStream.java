
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
        String line = br.readLine();
        if (line == null || !line.startsWith("Station:")) {
            throw new IOException("Format invalide : ligne Station manquante");
        }

        Station station = new Station();
        station.setNom(line.split(":")[1].trim());

        List<Carburant> carburants = new ArrayList<>();
        List<Cuve> cuves = new ArrayList<>();

        // Lire jusqu'à "Carburant:"
        while ((line = br.readLine()) != null && !line.equals("Carburant:")) {}

        // Lire les carburants
        while ((line = br.readLine()) != null && !line.isEmpty() && !line.equals("Cuves:")) {
            String[] parts = line.split(",");
            if (parts.length != 3) {
                throw new IOException("Format invalide de carburant : " + line);
            }
            Carburant carburant = new Carburant();
            carburant.setNom(parts[0]);
            carburant.setpA(Integer.parseInt(parts[1]));
            carburant.setpV(Integer.parseInt(parts[2]));
            carburants.add(carburant);
        }

        // Lire les cuves
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] parts = line.split(",");
            if (parts.length != 3) {
                throw new IOException("Format invalide de cuve : " + line);
            }
            Cuve cuve = new Cuve();
            cuve.setNom(parts[0]);
            cuve.setCapacite(Integer.parseInt(parts[1]));

            // Associer le bon Carburant par son nom
            String carburantNom = parts[2];
            Carburant carburantTrouve = null;
            for (Carburant c : carburants) {
                if (c.getNom().equals(carburantNom)) {
                    carburantTrouve = c;
                    break;
                }
            }
            if (carburantTrouve == null) {
                throw new IOException("Carburant introuvable pour la cuve : " + carburantNom);
            }
            cuve.setCarb(carburantTrouve);
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
        pw.println();
        pw.println("Carburant:");


        List<String> dejaEcrit = new ArrayList<>();
        for (Cuve c : station.getLc()) {
            Carburant carb = c.getCarb();
            if (!dejaEcrit.contains(carb.getNom())) {
                pw.println(carb.getNom() + "," + carb.getpA() + "," + carb.getpV());
                dejaEcrit.add(carb.getNom());
            }
        }

        pw.println();
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
