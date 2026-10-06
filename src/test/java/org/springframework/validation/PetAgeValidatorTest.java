package org.springframework.validation;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.rest.validation.PetAgeValidator;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PetAgeValidatorTest {

    private final PetAgeValidator validator = new PetAgeValidator();

    @Test
    void shouldReturnFalseWhenBirthDateIsInFuture() {
        LocalDate futureDate = LocalDate.now().plusDays(1);

        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);
        when(context.buildConstraintViolationWithTemplate(anyString()))
                .thenReturn(mock(ConstraintValidatorContext.ConstraintViolationBuilder.class));

        boolean result = validator.isValid(futureDate, context);

        assertFalse(result);
    }

    // NOTE COURS A26 : ce test échoue intentionnellement (bogue de dette technique --
    // voir README-COURS-A26.md, indice 3). PetAgeValidator accepte maintenant 100 ans,
    // mais le message d'erreur ("50 years") et ce test n'ont pas été mis à jour en
    // conséquence. @Disabled pour garder le build vert par défaut (ex. pour le TP1) ;
    // l'enseignant peut retirer cette annotation quand l'exercice de débogage/cohérence
    // des règles métier est présenté en classe.
    @Disabled("Bogue intentionnel A26 - voir README-COURS-A26.md - à réactiver au moment choisi en classe")
    @Test
    void shouldReturnFalseWhenBirthDateIsOlderThan50Years() {
        LocalDate tooOldDate = LocalDate.now().minusYears(51);

        ConstraintValidatorContext context = mock(ConstraintValidatorContext.class);
        when(context.buildConstraintViolationWithTemplate(anyString()))
                .thenReturn(mock(ConstraintValidatorContext.ConstraintViolationBuilder.class));

        boolean result = validator.isValid(tooOldDate, context);

        assertFalse(result);
    }

    @Test
    void shouldReturnTrueWhenBirthDateIsValid() {
        LocalDate validDate = LocalDate.now().minusYears(10);

        boolean result = validator.isValid(validDate, null);

        assertTrue(result);
    }

    @Test
    void shouldReturnTrueWhenBirthDateIsNull() {
        boolean result = validator.isValid(null, null);

        assertTrue(result);
    }
}