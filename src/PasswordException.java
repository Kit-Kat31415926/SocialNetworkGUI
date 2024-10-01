public abstract class PasswordException extends Exception {
}

class UpperCaseCharacterMissing extends PasswordException {
}

class LowerCaseCharacterMissing extends PasswordException {
}

class SpecialCharacterMissing extends PasswordException {
}

class NumberCharacterMissing extends PasswordException {
}

class Minimum8CharactersRequired extends PasswordException {
}