package tn.esprit.spring.khaddem.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import tn.esprit.spring.khaddem.entities.Equipe;
import tn.esprit.spring.khaddem.services.IEquipeService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@SpringJUnitConfig
public class EquipeRestControllerTest {

    @Autowired
    private EquipeRestController equipeRestController;
    @MockBean
    private IEquipeService equipeService;


    private Equipe equipe;

    @BeforeEach
    public void setUp() {
        equipe = new Equipe();
        equipe.setIdEquipe(1);
        equipe.setNomEquipe("Equipe de test");
    }

    @Test
    public void testGetEquipes() {
        List<Equipe> equipes = Collections.singletonList(equipe);
        when(equipeService.retrieveAllEquipes()).thenReturn(equipes);

        List<Equipe> result = equipeRestController.getEquipes();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Equipe de test", result.get(0).getNomEquipe());
    }

    @Test
    public void testRetrieveEquipe() {
        when(equipeService.retrieveEquipe(1)).thenReturn(equipe);

        Equipe result = equipeRestController.retrieveEquipe(1);
        assertNotNull(result);
        assertEquals("Equipe de test", result.getNomEquipe());
    }

    @Test
    public void testAddEquipe() {
        when(equipeService.addEquipe(equipe)).thenReturn(equipe);

        Equipe result = equipeRestController.addEquipe(equipe);
        assertNotNull(result);
        assertEquals("Equipe de test", result.getNomEquipe());
    }

    @Test
    public void testUpdateEquipe() {
        when(equipeService.updateEquipe(equipe)).thenReturn(equipe);

        Equipe result = equipeRestController.updateEtudiant(equipe);
        assertNotNull(result);
        assertEquals("Equipe de test", result.getNomEquipe());
    }






}
