package fr.dampierre;

public class Hotel {

  private String nom;
  private int nbChambres;
  private Chambre[] chambres;

  public Hotel(String nom, int nbChambres, int nbEtages) {
    this.nom = nom;
    this.nbChambres = nbChambres;
    creerChambres(nbChambres, nbEtages);
  }

  private void creerChambres(int nbChambres, int nbEtages) {
    chambres = new Chambre[nbChambres];
    int nbChambresParEtage = nbChambres / nbEtages;
    int indexInsertion = 0;
    for (int numEtage = 1; numEtage <= nbEtages; numEtage++) {
      int numChambre = numEtage * 100;
      for (int i = 1; i <= nbChambresParEtage; i++) {
        String type;
        if (i <= 4) {
          type = "simple";
        } else if (i < nbChambresParEtage) {
          type = "double";
        } else {
          type = "suite";
        }
        Chambre chambre = new Chambre(numChambre, type);
        chambres[indexInsertion] = chambre;
        indexInsertion++;
        numChambre++;
      }
    }
  }

  public int getNbChambres() {
    return nbChambres;
  }

  public int nbChambresOccupées() {
    int nbOccupées = 0;
    for (Chambre chambre : chambres) {
      if (chambre.estLibre() == false) {
        nbOccupées++;
      }
    }
    return nbOccupées;
  }

  public double tauxOccupation() {
    // nombre chambres oocupées / nombre total de chambres * 100
    return ((double) nbChambresOccupées()) / nbChambres * 100;
  }

  public boolean louerChambre(String typeSouhaité, String nomClient, int nbJours) {
    for (Chambre chambre : chambres) {
      if (chambre.estLibre() && chambre.getType().equals(typeSouhaité)) {
        chambre.definirOccupant(nomClient, nbJours);
        return true;
      }
    }
    return false;
  }

  public void jourSuivant() {
    for (Chambre chambre : chambres) {
      chambre.jourSuivant();
    }
  }

  public String toString() {
    // Hotel Aifone : 10 % d'occupation. Voici la liste des chambres :
    // Chambre 100 : simple – louée
    // Chambre 101 : simple – libre
    // Chambre 102 : simple – libre
    String res = "";
    res = res + "Hotel " + nom + " : " + tauxOccupation()
        + " % d'occupation. Voici la liste des chambres :\n";
    for (Chambre chambre : chambres) {
      res += chambre.toString() + "\n";
    }
    return res;
  }
}
