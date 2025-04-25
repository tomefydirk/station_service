package lecture;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        station.setNom(line.split(":")[1]);
    
        // Lire jusqu'à "Cuves:"
        while ((line = br.readLine()) != null && !line.equals("Cuves:")) {}

        List<Cuve> cuves = new ArrayList<>();
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] parts = line.split(",");
            if (parts.length != 5) {
                throw new IOException("Format invalide de cuve : " + line);
            }

            Cuve cuve = new Cuve();
            cuve.setNom( parts[0]);
            cuve.setCapacite( Integer.parseInt(parts[1]));

            Carburant carburant = new Carburant();
            carburant.setNom( parts[2]) ;
            carburant.setpA( Integer.parseInt(parts[3]));
            carburant.setPV( Integer.parseInt(parts[4]));

            cuve.setCarb(carburant) ;
            cuves.add(cuve);
        }

        station.setLc( cuves.toArray(new Cuve[0])) ;
        return station;

    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
}
}
