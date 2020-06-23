package dev.maison;

import org.junit.Test;

import dev.maison.exceptions.PieceNullException;
import dev.maison.exceptions.SuperficieNegativeException;

import org.junit.Assert;
import org.junit.Before;

public class maisonTest {
	Maison maison = null;
	
	@Before
	public void creationMaison() {
		maison = new Maison();
	}
	@Test
	public void testAjout1Cuisine() {
		// si ajout d'une cuisine, le nombre de cuisine est cense etre a 1
		maison.ajouterPiece(new Cuisine(12, 0));
		int nbPiece = maison.getNombrePiece("Cuisine");
		Assert.assertEquals(1, nbPiece);
	}

	@Test
	public void testAjout2Cuisine() {
		// si ajout de 2 cuisines, le nombre de cuisine est cense etre a 2
		maison.ajouterPiece(new Cuisine(12, 0));
		maison.ajouterPiece(new Cuisine(12, 1));
		int nbPiece = maison.getNombrePiece("Cuisine");
		Assert.assertEquals(2, nbPiece);
	}

	@Test
	public void TestAjout0Cuisine() {
		// si ajout de 1 Salon, le nombre de cuisine doit rester a 0
		maison.ajouterPiece(new Salon(12, 0));
		maison.ajouterPiece(new WC(12, 1));
		int nbPiece = maison.getNombrePiece("Cuisine");
		Assert.assertEquals(0, nbPiece);
	}

	@Test
	public void testAjoutSousSol() {
		// Si ajout a l'etage -1, superficie de l'etage -1 doit marcher
		maison.ajouterPiece(new Cuisine(12.0, -1));
		double superficie = maison.getSuperficieEtage(-1);
		// 0.1 est la precision pour les doubles de java
		Assert.assertEquals(12.0, superficie, 0.001);
	}

	@Test
	public void testSuperficieCuisine() {
		// si ajout de 2 cuisines, la superficie est le total des 2
		maison.ajouterPiece(new Cuisine(12, 0));
		maison.ajouterPiece(new Cuisine(12, 1));
		double superficie = maison.getSuperficieTypePiece("Cuisine");
		Assert.assertEquals(24.0, superficie, 0.001);
	}

	@Test(expected = PieceNullException.class)
	public void testAjoutPieceNull() {
		// est cense renvoyer une PieceNullException
		maison.ajouterPiece(null);
	}

	@Test(expected = SuperficieNegativeException.class)
	public void testAjoutPieceSuperficieNegative() {
		// est cense renvoyer une exception lorsque la superficie est < 0
		maison.ajouterPiece(new Cuisine(-12, 1));
	}

	@Test
	public void testSuperficieMaisonVide() {
		// Si pas d'ajout, superficie est a 0.0
		Maison maison = new Maison();
		double superficie = maison.getSuperficieTotale();
		Assert.assertEquals(0.0, superficie, 0.001);
	}

	@Test
	public void testSuperficieEtage() {
		// test de superficie avec plusieurs pieces sur un etage
		// resultat est le total de l'etage
		Maison maison = new Maison();
		maison.ajouterPiece(new Cuisine(12, 0));
		maison.ajouterPiece(new Salon(13, 0));
		double superficie = maison.getSuperficieEtage(0);
		Assert.assertEquals(25.0, superficie, 0.001);
	}

	@Test
	public void testSuperficieEtageVide() {
		// test de superficie avec un etage vide
		// resultat doit etre 0
		Maison maison = new Maison();
		maison.ajouterPiece(new Cuisine(12, 0));
		maison.ajouterPiece(new Salon(13, 0));
		double superficie = maison.getSuperficieEtage(1);
		Assert.assertEquals(0.0, superficie, 0.001);
	}

}
