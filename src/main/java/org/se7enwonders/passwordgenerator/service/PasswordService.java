package org.se7enwonders.passwordgenerator.service;

import org.se7enwonders.passwordgenerator.dto.PasswordModel;

public interface PasswordService {
    String generatePassword(PasswordModel passwordModel);
}
