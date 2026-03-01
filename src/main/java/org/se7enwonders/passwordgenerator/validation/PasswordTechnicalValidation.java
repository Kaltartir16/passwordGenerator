package org.se7enwonders.passwordgenerator.validation;

import org.se7enwonders.passwordgenerator.dto.PasswordModel;
import org.se7enwonders.passwordgenerator.exception.PasswordException;

public class PasswordTechnicalValidation {

    public static final int MAX_LENGTH_OF_PASSWORD = 12;

    public void checkPasswordValidation(PasswordModel passwordModel) {

        if (passwordModel == null){
            throw new PasswordException(" ERROR: EMPTY DATA. ");
        }
        if (passwordModel.getPasswordLength() == null){
            throw new PasswordException(" ERROR: Must insert length of password. ");
        }
        if (passwordModel.getPasswordLength() > MAX_LENGTH_OF_PASSWORD){
            throw new PasswordException(" ERROR:  Password length must be in between 8 and 12. ");
        }
    }
}
