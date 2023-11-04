package tn.esprit.spring.khaddem.DepartementRestTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import tn.esprit.spring.khaddem.controllers.DepartementRestController;
import tn.esprit.spring.khaddem.entities.Departement;
import tn.esprit.spring.khaddem.services.IDepartementService;
import static org.hamcrest.Matchers.containsString;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class DepartementServiceTest {
    private MockMvc mockMvc;

    @Mock
    private IDepartementService departementService;

    @InjectMocks
    private DepartementRestController departementController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(departementController)
                .build();
    }

    @Test
    public void testRetrieveAllDepartements() throws Exception {
        Departement departement1 = new Departement();
        departement1.setIdDepartement(1);
        departement1.setNomDepart("Informatiques");

        Departement departement2 = new Departement();
        departement2.setIdDepartement(2);
        departement2.setNomDepart("Mathématiques");

        List<Departement> departementList = Arrays.asList(departement1, departement2);

        when(departementService.retrieveAllDepartements()).thenReturn(departementList);

        mockMvc.perform(get("/departement/retrieve-all-departements"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].idDepartement").value(1))
                .andExpect(jsonPath("$[0].nomDepart").value("Informatiques"))
                .andExpect(jsonPath("$[1].idDepartement").value(2))
                .andExpect(jsonPath("$[1].nomDepart").value("Mathématiques"));

        verify(departementService, times(1)).retrieveAllDepartements();
        verifyNoMoreInteractions(departementService);
    }

    @Test
    public void testAddDepartement() throws Exception {
        Departement departement = new Departement();
        departement.setIdDepartement(1);
        departement.setNomDepart("Informatiques");

        when(departementService.addDepartement(any(Departement.class))).thenReturn(departement);

        mockMvc.perform(post("/departement/add-departement")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nomDepart\": \"Informatique\"}"))
                .andExpect(status().isOk());


        verify(departementService, times(1)).addDepartement(any(Departement.class));
        verifyNoMoreInteractions(departementService);
    }

}
