import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.khaddem.controllers.ContratRestController;
import tn.esprit.spring.khaddem.entities.Contrat;
import tn.esprit.spring.khaddem.entities.Etudiant;
import tn.esprit.spring.khaddem.entities.Specialite;
import tn.esprit.spring.khaddem.repositories.ContratRepository;
import tn.esprit.spring.khaddem.services.ContratServiceImpl;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class testcontrat {


    @InjectMocks
    private ContratServiceImpl contratService;

    @Mock
    private ContratRepository contratRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveContrat() {
        // Créez un exemple de contrat fictif pour les tests
        Contrat contrat = new Contrat();
        contrat.setIdContrat(1);
        contrat.setDateDebutContrat(new Date());
        contrat.setDateFinContrat(new Date());
        contrat.setSpecialite(Specialite.IA);
        contrat.setArchived(false);
        contrat.setMontantContrat(1000);
        contrat.setEtudiant(new Etudiant());

        // Configurez le mock pour renvoyer le contrat fictif lorsque la méthode findById est appelée
        when(contratRepository.findById(1)).thenReturn(Optional.of(contrat));

        // Appelez la méthode retrieveContrat avec l'ID 1
        Contrat retrievedContrat = contratService.retrieveContrat(1);

        // Vérifiez que le contrat renvoyé correspond au contrat fictif
        assertEquals(contrat, retrievedContrat);
    }

    @Test
    public void testAddContrat() {
        // Créez un exemple de contrat fictif pour les tests
        Contrat contrat = new Contrat();
        contrat.setIdContrat(1);
        contrat.setDateDebutContrat(new Date());
        contrat.setDateFinContrat(new Date());
        contrat.setSpecialite(Specialite.IA);
        contrat.setArchived(false);
        contrat.setMontantContrat(1000);
        contrat.setEtudiant(new Etudiant());

        // Configurez le mock pour renvoyer le contrat fictif lorsque la méthode save est appelée
        when(contratRepository.save(contrat)).thenReturn(contrat);

        // Appelez la méthode addContrat avec le contrat fictif
        Contrat addedContrat = contratService.addContrat(contrat);

        // Vérifiez que le contrat ajouté correspond au contrat fictif
        assertEquals(contrat, addedContrat);
    }

    @Test
    public void testUpdateContrat() {
        // Créez un exemple de contrat fictif pour les tests
        Contrat contrat = new Contrat();
        contrat.setIdContrat(1);
        contrat.setDateDebutContrat(new Date());
        contrat.setDateFinContrat(new Date());
        contrat.setSpecialite(Specialite.IA);
        contrat.setArchived(false);
        contrat.setMontantContrat(1000);
        contrat.setEtudiant(new Etudiant());

        // Configurez le mock pour renvoyer le contrat fictif lorsque la méthode save est appelée
        when(contratRepository.save(contrat)).thenReturn(contrat);

        // Appelez la méthode updateContrat avec le contrat fictif
        Contrat updatedContrat = contratService.updateContrat(contrat);

        // Vérifiez que le contrat mis à jour correspond au contrat fictif
        assertEquals(contrat, updatedContrat);
    }


}
