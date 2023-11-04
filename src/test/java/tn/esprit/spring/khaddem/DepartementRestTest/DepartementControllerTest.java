package tn.esprit.spring.khaddem.DepartementRestTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tn.esprit.spring.khaddem.controllers.DepartementRestController;
import tn.esprit.spring.khaddem.entities.Departement;
import tn.esprit.spring.khaddem.services.IDepartementService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class DepartementControllerTest {
    private MockMvc mockMvc;

    @InjectMocks
    private DepartementRestController departementController;

    @Mock
    private IDepartementService departementService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(departementController).build();
    }

    @Test
    public void testGetDepartements() throws Exception {
        List<Departement> departements = Arrays.asList(new Departement(), new Departement());

        when(departementService.retrieveAllDepartements()).thenReturn(departements);

        mockMvc.perform(MockMvcRequestBuilders.get("/departement/retrieve-all-departements")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testRetrieveDepartement() throws Exception {
        Departement departement = new Departement();
        departement.setIdDepartement(1);

        when(departementService.retrieveDepartement(1)).thenReturn(departement);

        mockMvc.perform(MockMvcRequestBuilders.get("/departement/retrieve-departement/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idDepartement").value(1))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAddDepartement() throws Exception {
        Departement departement = new Departement();
        departement.setIdDepartement(1);

        // Serialize the 'departement' object to JSON and set it as the request content
        String jsonDepartement = new ObjectMapper().writeValueAsString(departement);

        when(departementService.addDepartement(any(Departement.class))).thenReturn(departement);

        mockMvc.perform(MockMvcRequestBuilders.post("/departement/add-departement")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonDepartement))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idDepartement").value(1))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void testUpdateDepartement() throws Exception {
        Departement departement = new Departement();
        departement.setIdDepartement(1);

        when(departementService.updateDepartement(any(Departement.class))).thenReturn(departement);

        // Serialize the 'departement' object to JSON and set it as the request content
        String jsonDepartement = new ObjectMapper().writeValueAsString(departement);

        mockMvc.perform(MockMvcRequestBuilders.put("/departement/update-departement")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonDepartement))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idDepartement").value(1)) // Check the updated ID
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
