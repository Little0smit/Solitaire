package Exceptions;

public class IncorrectValueException extends Throwable {
	int value;

	public IncorrectValueException(int value) {
		this.value = value;
	}

	public String toString() {
		return "Incompatible value: " + value;
	}
}
