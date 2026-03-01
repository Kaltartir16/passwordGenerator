package org.se7enwonders.passwordgenerator.resolver;

import org.se7enwonders.passwordgenerator.dto.PasswordModel;
import org.springframework.beans.factory.annotation.Value;

import java.util.Optional;

public class ResolvePasswordModel {

    @Value("${password.generator.numberOfSmallLetter}")
    private int numberOfSmallLetter;

    @Value("${password.generator.numberOfCapitalLetter}")
    private int numberOfCapitalLetter;

    @Value("${password.generator.numberOfDigits}")
    private int numberOfDigits;

    @Value("${password.generator.numberOfSpecialChars}")
    private int numberOfSpecialChars;

    public void resolvePassword(PasswordModel passwordModel) {

        passwordModel.setNumberOfSmallLetter(Optional.ofNullable(passwordModel.getNumberOfSmallLetter()).orElse(numberOfSmallLetter));
        passwordModel.setNumberOfCapitalLetter(Optional.ofNullable(passwordModel.getNumberOfCapitalLetter()).orElse(numberOfCapitalLetter));
        passwordModel.setNumberOfSpecialChars(Optional.ofNullable(passwordModel.getNumberOfSpecialChars()).orElse(numberOfSpecialChars));
        passwordModel.setNumberOfDigits(Optional.ofNullable(passwordModel.getNumberOfDigits()).orElse(numberOfDigits));

    }
}
