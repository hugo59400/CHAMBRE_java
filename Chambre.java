package fr.dampierre;

public class Chambre {
  private int numero;
  private int joursRestants;
  private String type; 
  private String nomOccupant;

  // 102, "DOUBLE"
  public Chambre(int numero, String type) {
    this.numero = numero;
    if (type.equals("simple") || type.equals("double") || type.equals("suite")) {
      this.type = type;
    } else {
      this.type = "simple";
    }
    // if (!type.equals("simple") && !type.equals("double") && !type.equals("suite")) {
    // this.type = "simple";
    // }
    joursRestants = 0;
    nomOccupant = null;
  }

// ?
  public String getType() {
    return type;
  }

  public boolean definirOccupant(String occupant, int nbJours) {
    if (nomOccupant == null) {
      nomOccupant = occupant;
      joursRestants = nbJours;
      return true;
    }
    return false;
  }

  public void jourSuivant() {
    if (joursRestants >= 0) {
      joursRestants--;
      if (joursRestants == 0) {
        nomOccupant = null;
      }
    }
  }

  public String toString() {
    // "Chambre 123 : double - louée"
    return "Chambre " + numero + " : " + type + " - " + etatCourant();
  }

  private String etatCourant() {
    return estLibre() ? "libre" : "louée";
  }

  public boolean estLibre() {
    return nomOccupant == null;
  }
}
