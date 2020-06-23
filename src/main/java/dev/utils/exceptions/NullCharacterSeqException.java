package dev.utils.exceptions;

/**
 * excpetion jetee si une des deux sequences passee en parametre de la methode
 * est null
 * 
 * @author antoinelabeeuw
 *
 */
public class NullCharacterSeqException extends RuntimeException {

	public NullCharacterSeqException(String message) {
		super(message);
	}
}
