package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class OwnerTests {
    Owner owner;

    @BeforeEach
    public void setup(){
        owner = new Owner();
        Pet chat = new Pet();
        chat.setName("Voldemort");
        owner.addPet(chat);
    }

    @ParameterizedTest
    @ValueSource(strings = {"VOLDEMORT", "voldemort", "VolDeMort", "volDemorT"})
    public void verifierExistencePetDansOwner(String nom){
        // Act
        Pet voldemort = owner.getPet(nom);

        //Assert
        assertNotNull(voldemort);
        assertEquals("Voldemort", voldemort.getName());
    }

    @Test
    public void verifierPetNExistePasDansOwner(){
        // Act
        Pet voldemort = owner.getPet("Inconnu");

        //Assert
        assertNull(voldemort);
    }
}
