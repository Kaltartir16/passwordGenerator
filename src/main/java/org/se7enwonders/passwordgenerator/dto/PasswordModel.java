package org.se7enwonders.passwordgenerator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@Builder
public class PasswordModel {
    private Integer passwordLength;
    private Integer numberOfSmallLetter;
    private Integer numberOfCapitalLetter;
    private Integer numberOfDigits;
    private Integer numberOfSpecialChars;
}


