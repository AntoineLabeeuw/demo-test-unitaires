package dev.maison;

import dev.maison.exceptions.PieceNullException;
import dev.maison.exceptions.SuperficieNegativeException;

/**
 * Clase conceptualisant une maison, constituee de differentes pieces
 * 
 * @author antoinelabeeuw
 *
 */
public class Maison {
	/** pieces */
	private Piece[] pieces;

	/**
	 * Constructeur : cree un tableau de longueur 0
	 * 
	 */
	public Maison() {
		// initialisation d'un tableau de longueur 0
		this.pieces = new Piece[0];
	}

	/**
	 * methode qui permet d'ajouter une nouvelle piece au tableau. Si le tableau est
	 * plein, la methode permet de rajouter une case automatiquement a celui-ci.
	 * 
	 * @param newPiece : la nouvelle piece a ajouter
	 * @throws SuperficieNegativeException 
	 */
	public void ajouterPiece(Piece nouvellePiece) throws PieceNullException, SuperficieNegativeException {
		if (nouvellePiece != null) {
			// creation d'un tableau de taille Pieces + 1
			Piece[] newPieces = new Piece[pieces.length + 1];
			// stockage de toutes les valeurs de tabNote dans le nouveau tableau
			for (int i = 0; i < pieces.length; i++) {
				newPieces[i] = pieces[i];
			}
			// ajout de la nouvelle valeur a la fin du tableau
			newPieces[newPieces.length - 1] = nouvellePiece;
			// le tableau prend la place de l'anctien
			this.pieces = newPieces;
		} else {
			throw new PieceNullException("Vous avez essayer de rajouter une pièce null à la maison");
		}
	}

	/**
	 * methode qui retourne la superficie totale de la maison
	 * 
	 * @return : la superficie totale de la maison
	 */
	public double getSuperficieTotale() {
		double superficieTotale = 0.0D;
		for (int i = 0; i < pieces.length; i++) {
			superficieTotale += pieces[i].getSuperficie();
		}
		return (superficieTotale);
	}

	/**
	 * methode qui retourne la superficie de toutes les pieces d'un etage
	 * 
	 * @param etage : l'tage dont on veut la superficie
	 * @return : la superficie de l'etage
	 */
	public double getSuperficieEtage(int etage) {
		double superficieEtage = 0.0D;
		for (int i = 0; i < pieces.length; i++) {
			if (pieces[i].getEtage() == etage) {
				superficieEtage += pieces[i].getSuperficie();
			}
		}
		return (superficieEtage);
	}

	/**
	 * methode qui prend en entree un type de piece (ex chambre) et retourne la
	 * superficie ajoutee de toutes ces pieces
	 * 
	 * @param typePiece : le type de la piece (ex : Chambre)
	 * @return : la sueprficie de toutes les piece du type demande
	 */
	public double getSuperficieTypePiece(String typePiece) {
		double superficieTypePiece = 0.0D;
		for (int i = 0; i < pieces.length; i++) {
			if (pieces[i].getTypePiece().equals(typePiece)) {
				superficieTypePiece += pieces[i].getSuperficie();
			}
		}
		return (superficieTypePiece);
	}

	/**
	 * methode qui prend en entree un type de piece (ex chambre) et retourne la le
	 * nombre de ces pieces dans la maison
	 * 
	 * @param typePiece : le type de la piece (ex : Chambre)
	 * @return : Le nombre de pieces du type demande dans la maison
	 */
	public int getNombrePiece(String typePiece) {
		int nombrePiece = 0;
		for (int i = 0; i < pieces.length; i++) {
			if (pieces[i].getTypePiece().equals(typePiece)) {
				nombrePiece += 1;
			}
		}
		return (nombrePiece);
	}

}
