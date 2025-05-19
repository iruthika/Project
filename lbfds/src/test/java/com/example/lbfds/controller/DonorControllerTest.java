//package com.example.lbfds.controller;
//
//import com.example.lbfds.model.Donor;
//import com.example.lbfds.service.DonorService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.List;
//import java.util.ArrayList;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//class DonorControllerTest {
//
//    private MockMvc mockMvc;
//
//    @Mock
//    private DonorService donorService;
//
//    @InjectMocks
//    private DonorController donorController;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//
//        mockMvc = MockMvcBuilders.standaloneSetup(donorController).build();
//    }
//
//    @Test
//    void testGetDonation() throws Exception {
//        Donor donor = new Donor(1L, "Vegetables", 5, null, "New York", "Pending");
//
//        doNothing().when(donorService).getDonationDetail(Mockito.any(Donor.class));
//
//        mockMvc.perform(post("/donation/DonateFood")
//                        .contentType("application/json")
//                        .content("{\"foodAvailable\":\"Vegetables\", \"no_of_servings\":5, \"location\":\"New York\", \"Status\":\"Pending\"}"))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.foodAvailable").value("Vegetables"))
//                .andExpect(jsonPath("$.no_of_servings").value(5))
//                .andExpect(jsonPath("$.location").value("New York"));
//
//        verify(donorService, times(1)).getDonationDetail(Mockito.any(Donor.class));
//    }
//
//    @Test
//    void testGetFoodDonation() throws Exception {
//        Donor donor = new Donor(1L, "Vegetables", 5, null, "New York", "Pending");
//        List<Donor> donors = new ArrayList<>();
//        donors.add(donor);
//
//        when(donorService.searchFoodByLocation("New York")).thenReturn(donors);
//
//        mockMvc.perform(get("/donation/search/New York"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].foodAvailable").value("Vegetables"))
//                .andExpect(jsonPath("$[0].location").value("New York"));
//
//        verify(donorService, times(1)).searchFoodByLocation("New York");
//    }
//
//    @Test
//    void testUpdateDonationStatus() throws Exception {
//        when(donorService.updateDonationStatus(1L, "Accepted")).thenReturn(true);
//
//        mockMvc.perform(patch("/donation/updateStatus/1")
//                        .param("status", "Accepted"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Status updated successfully."));
//
//        verify(donorService, times(1)).updateDonationStatus(1L, "Accepted");
//    }
//
//    @Test
//    void testUpdateDonationStatus_NotFound() throws Exception {
//        when(donorService.updateDonationStatus(999L, "Accepted")).thenReturn(false);
//
//        mockMvc.perform(patch("/donation/updateStatus/999")
//                        .param("status", "Accepted"))
//                .andExpect(status().isNotFound())
//                .andExpect(content().string("Donation not found."));
//
//        verify(donorService, times(1)).updateDonationStatus(999L, "Accepted");
//    }
//}
