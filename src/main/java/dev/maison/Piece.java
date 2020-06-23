package dev.maison;

import dev.maison.exceptions.SuperficieNegativeException;

/**
 * Classe conceptualisant une piece quelconque d'une maison
 * 
 * @author antoinelabeeuw
 *
 */
public abstract class Piece {
	/** superficie */
	private double superficie;
	/** etage */
	private int etage;

	/**
	 * Constructeur
	 * 
	 * @param superficie : la superficie de la piece
	 * @param etage      : l'etage ou est situee la piece : 0 pour RDC , 1 pour 1e
	 *                   etage..
	 */
	public Piece(double superficie, int etage) throws SuperficieNegativeException {
		if (superficie > 0) {
			this.superficie = superficie;
			this.etage = etage;
		} else {
			throw new SuperficieNegativeException("La superficie de la pièce que vous essayer d'ajouter est inférieure à 0.");
		}
	}

	/**
	 * @return : la superficie de la piece
	 */
	public double getSuperficie() {
		return superficie;
	}

	/**
	 * @param superficie : la superficie a modifier
	 */
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	/**
	 * @return l'etage ou est la piece
	 */
	public int getEtage() {
		return etage;
	}

	/**
	 * @param etage : l'tage de la piece a modifier
	 */
	public void setEtage(int etage) {
		this.etage = etage;
	}

	/**
	 * methode qui retourne le type de piece le type de piece == le nom de la classe
	 * utilise la methode getclass().getSimpleName() pour obtenir le nom de la
	 * classe
	 * 
	 * @return : le nom de la piece
	 */
	public String getTypePiece() {
		return (this.getClass().getSimpleName());
	}
}
