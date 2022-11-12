package BUSINESS.exceptions;

public class InvalidPassword extends Exception {
    public InvalidPassword() {
        super("Паролата трябва да е поне 8 символа, да поне енда съдържа главна буква и едно число!");
    }
}
