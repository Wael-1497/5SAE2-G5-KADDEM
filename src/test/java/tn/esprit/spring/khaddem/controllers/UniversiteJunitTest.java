package tn.esprit.spring.khaddem.controllers;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import tn.esprit.spring.khaddem.entities.Universite;
import tn.esprit.spring.khaddem.services.IUniversiteService;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UniversiteJunitTest {

    @Autowired
    IUniversiteService universiteService;

    @Test
    @Order(1)
    public void testRetrieveAllUniversite() {
        List<Universite> listUsers = universiteService.retrieveAllUniversites();
        Assertions.assertEquals(0, listUsers.size());
    }

    @Test
    @Order(2)
    public void AddUniversite() {
        Universite universite =  new Universite(1,"ESPRIT",null);
        universiteService.addUniversite(universite);
        assertThat(universite.getIdUniversite()).isGreaterThan(0);
    }
    @Test
    @Order(3)
    public void getUniversite() {
        Universite facture = universiteService.retrieveUniversite(1);

        assertThat(facture.getIdUniversite()).isEqualTo(1);
    }


}
