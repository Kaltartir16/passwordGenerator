package org.se7enwonders.passwordgenerator.config;

import org.se7enwonders.passwordgenerator.resolver.ResolvePasswordModel;
import org.se7enwonders.passwordgenerator.service.PasswordService;
import org.se7enwonders.passwordgenerator.validation.PasswordBusinessValidation;
import org.se7enwonders.passwordgenerator.validation.PasswordTechnicalValidation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PasswordConfiguration {
    @Bean
    public ResolvePasswordModel resolvePasswordModel() {
        return new ResolvePasswordModel();
    }

    @Bean
    public PasswordService passwordService() {
        return new PasswordService();
    }

    @Bean
    public PasswordBusinessValidation passwordBusinessValidation() {
        return new PasswordBusinessValidation();
    }

    @Bean
    public PasswordTechnicalValidation passwordTechnicalValidation() {
        return new PasswordTechnicalValidation();
    }
}
