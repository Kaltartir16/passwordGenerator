package org.se7enwonders.passwordgenerator.validation;

import org.se7enwonders.passwordgenerator.constants.Constants;
import org.se7enwonders.passwordgenerator.dto.PasswordModel;
import org.se7enwonders.passwordgenerator.exception.PasswordException;

public class PasswordBusinessValidation {

    public void checkBusinessRulesForPassword(PasswordModel passwordModel) {


        if (passwordModel.getPasswordLength() > Constants.MIN_LENGTH_OF_PASSWORD && passwordModel.getPasswordLength() > Constants.MAX_LENGTH_OF_PASSWORD) {
            throw new PasswordException(" ERROR:  the password length must be in between 8 and 12. ");
        }

        if (passwordModel.getNumberOfSmallLetter() + passwordModel.getNumberOfCapitalLetter() +
                passwordModel.getNumberOfSpecialChars() + passwordModel.getNumberOfDigits()
                > passwordModel.getPasswordLength()) {
            throw new PasswordException("ERROR: The summation of accepted characters length is more than the password length which is " + passwordModel.getPasswordLength());
        }
    }
}
