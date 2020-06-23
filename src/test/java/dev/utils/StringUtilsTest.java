package dev.utils;

import org.junit.Test;

import dev.utils.exceptions.NullCharacterSeqException;

import org.junit.Assert;

public class StringUtilsTest {
	@Test
	public void levenshteinDistanceTest1() {
		CharSequence c1 = "jav";
		CharSequence c2 = "java";
		// 1 lettre de difference, la methode doit retourner 1
		int resultat = StringUtils.levenshteinDistance(c1, c2);
		Assert.assertEquals(1, resultat);
	}

	@Test
	public void levenshteinDistanceTest0() {
		// aucune lettre de difference, la methode doit retourner 0
		CharSequence c1 = "java";
		CharSequence c2 = "java";
		int resultat = StringUtils.levenshteinDistance(c1, c2);
		Assert.assertEquals(0, resultat);
	}

	@Test
	public void levenshteinDistanceTest1aLenvers() {
		// 1 lettre de difference sur c2 au lieu de c1
		// la methode doit aussi retourner 1
		CharSequence c1 = "java";
		CharSequence c2 = "jav";
		int resultat = StringUtils.levenshteinDistance(c1, c2);
		Assert.assertEquals(1, resultat);
	}

	@Test
	public void levenshteinDistanceTestVide() {
		// mot vide, la methode doit retourner la longueur de c2
		// ici, elle doit retourner 4
		CharSequence c1 = "";
		CharSequence c2 = "java";
		int resultat = StringUtils.levenshteinDistance(c1, c2);
		Assert.assertEquals(4, resultat);
	}

	@Test
	public void levenshteinDistanceTestEspace() {
		// test avec 2 mots identiques, mais un espace a la fin
		// methode doit retourner 1
		CharSequence c1 = "java ";
		CharSequence c2 = "java";
		int resultat = StringUtils.levenshteinDistance(c1, c2);
		Assert.assertEquals(1, resultat);
	}

	@Test(expected = NullCharacterSeqException.class)
	public void levenshteinDistanceTestNull() {
		// test avec chaine de caractere null
		// la methode doit retourner une exception
		CharSequence c1 = null;
		CharSequence c2 = "java";
		int resultat = StringUtils.levenshteinDistance(c1, c2);
	}
}
