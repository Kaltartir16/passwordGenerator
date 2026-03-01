package org.se7enwonders.passwordgenerator.controller;

import lombok.AllArgsConstructor;
import org.se7enwonders.passwordgenerator.dto.PasswordModel;
import org.se7enwonders.passwordgenerator.resolver.ResolvePasswordModel;
import org.se7enwonders.passwordgenerator.service.PasswordService;
import org.se7enwonders.passwordgenerator.service.PasswordServiceImpl;
import org.se7enwonders.passwordgenerator.validation.PasswordBusinessValidation;
import org.se7enwonders.passwordgenerator.validation.PasswordTechnicalValidation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/password/")
@AllArgsConstructor
public class PasswordGeneratorController {
    private PasswordService passwordService;
    private PasswordTechnicalValidation passwordTechnicalValidation;
    private PasswordBusinessValidation passwordBusinessValidation;
    private ResolvePasswordModel resolvePasswordModel;

    @PostMapping("generatePassword")
    public ResponseEntity<String> generatePassword(@RequestBody PasswordModel passwordModel) {
        passwordTechnicalValidation.checkPasswordValidation(passwordModel);
        resolvePasswordModel.resolvePassword(passwordModel);
        passwordBusinessValidation.checkBusinessRulesForPassword(passwordModel);
        return ResponseEntity.status(HttpStatus.OK).body(passwordService.generatePassword(passwordModel));
    }
}
