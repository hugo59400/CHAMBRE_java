package fr.dampierre;

import org.junit.Test;

import static org.junit.Assert.*;

public class HotelTests {

  @Test
  public void tauxOccupation_40chambresOccupeesSur200_Retourne20Pourcent() {
    // Contexte
    Hotel hotel = new Hotel("Carvalho Royal", 200, 10);
    for (int nbChambres = 0; nbChambres < 40; nbChambres++) {
      hotel.louerChambre("simple", "Coleau", 20);
    }

    // Action
    double taux = hotel.tauxOccupation();

    // Resultat
    assertEquals(20.0, taux, 0.01);
  }
}

