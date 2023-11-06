import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.khaddem.entities.Departement;
import tn.esprit.spring.khaddem.entities.Universite;
import tn.esprit.spring.khaddem.repositories.UniversiteRepository;
import tn.esprit.spring.khaddem.services.UniversiteServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class UniversiteImplTest {

    @Mock
    UniversiteRepository universiteRepository;

    @InjectMocks
    UniversiteServiceImpl universiteService;
    List<Departement> departements=new ArrayList<>();
    Universite universite = new Universite(1,"ESPRIT",departements);
    Universite universite2 = new Universite(2,"ESPRIT2",departements);
    Universite universite3 = new Universite(3,"ESPRIT3",departements);
    Universite universite4 = new Universite(4,"ESPRIT4",departements);
    List<Universite>  universites = new ArrayList<Universite>() {
        {
            add(universite);
            add(universite2);
            add(universite3);
            add(universite4);
        }
    };

    @Test
    void TestretrieveAllUniversite() {
        Mockito.when(universiteRepository.findAll()).thenReturn(universites);
        List<Universite> produitList = universiteService.retrieveAllUniversites();
        Assertions.assertEquals(4, produitList.size());
    }

    @Test
    public void testCreateUniversite() {
        Universite universite = new Universite();
        universite.setIdUniversite(1);
        universite.setNomUniv("ESPRIT");

        Mockito.when(universiteRepository.save(universite)).thenReturn(universite);

        Universite savedUniversite = universiteService.addUniversite(universite);

        // Asserts to verify that the save method was called and returned the expected result
        Assertions.assertEquals(universite, savedUniversite);
    }

    @Test
    public void testGetUniversiteById() {
        Integer universiteId = 1;
        Universite universite = new Universite();
        universite.setIdUniversite(universiteId);
        universite.setNomUniv("ESPRIT");

        Mockito.when(universiteRepository.findById(universiteId)).thenReturn(Optional.of(universite));

        Universite retrievedUniversite = universiteService.retrieveUniversite(universiteId);

        // Asserts to verify that the findById method was called and returned the expected result
        Assertions.assertEquals(universite, retrievedUniversite);
    }


    @Test
    public void testUpdateUniversite() {
        Integer universiteId = 1;
        Universite existingUniversite = new Universite();
        existingUniversite.setIdUniversite(universiteId);
        existingUniversite.setNomUniv("Nom de l'Université");

        Universite updatedUniversite = new Universite();
        updatedUniversite.setIdUniversite(universiteId);
        updatedUniversite.setNomUniv("Nouveau Nom de l'Université");

        Mockito.when(universiteRepository.save(updatedUniversite)).thenReturn(updatedUniversite);

        Universite savedUniversite = universiteService.updateUniversite(updatedUniversite);

        // Asserts to verify that the findById and save methods were called and returned the expected result
        Assertions.assertEquals(updatedUniversite, savedUniversite);
    }


}
