package dev.maison;

/**
 * Classe conceptualisant une chambre d'une maison
 * 
 * @author antoinelabeeuw
 *
 */
public class Chambre extends Piece {

	/**
	 * Constructeur
	 * 
	 * @param superficie : la superficie de la chambre
	 * @param etage      : l'etage ou elle est situee
	 */
	public Chambre(double superficie, int etage) {
		super(superficie, etage);
	}
}
