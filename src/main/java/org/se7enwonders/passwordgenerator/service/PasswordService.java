package org.se7enwonders.passwordgenerator.service;

import org.se7enwonders.passwordgenerator.dto.PasswordModel;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordService {
    private final SecureRandom secureRandom = new SecureRandom();

    public String generatePassword(PasswordModel passwordModel) {
        List<Character> chars = new ArrayList<>();

        addLowercase(chars, passwordModel.getNumberOfSmallLetter());
        addUppercase(chars, passwordModel.getNumberOfCapitalLetter());
        addDigits(chars, passwordModel.getNumberOfDigits());
        addSpecials(chars, passwordModel.getNumberOfSpecialChars());

        Collections.shuffle(chars, secureRandom);
        StringBuilder stringBuilder = new StringBuilder(chars.size());
        for (char c : chars) stringBuilder.append(c);
        return stringBuilder.toString();
    }

    private void addLowercase(List<Character> out, int count) {
        for (int i = 0; i < count; i++) {
            out.add(randomCharInRange('a', 'z'));
        }
    }

    private void addUppercase(List<Character> out, int count) {
        for (int i = 0; i < count; i++) {
            out.add(randomCharInRange('A', 'Z'));
        }
    }

    private void addDigits(List<Character> out, int count) {
        for (int i = 0; i < count; i++) {
            out.add(randomCharInRange('0', '9'));
        }
    }

    private void addSpecials(List<Character> out, int count) {
        for (int i = 0; i < count; i++) {
            out.add(randomSpecialAscii());
        }
    }

    private char randomCharInRange(char start, char end) {
        int bound = (end - start) + 1;
        return (char) (start + secureRandom.nextInt(bound));
    }

    private char randomSpecialAscii() {
        int[][] ranges = {
                {33, 47},
                {58, 64},
                {91, 96},
                {123, 126}
        };

        int[] range = ranges[secureRandom.nextInt(ranges.length)];
        int codePoint = range[0] + secureRandom.nextInt((range[1] - range[0]) + 1);
        return (char) codePoint;
    }

}
