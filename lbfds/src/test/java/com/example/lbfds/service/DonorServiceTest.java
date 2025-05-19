//package com.example.lbfds.service;
//
//import com.example.lbfds.model.Donor;
//import com.example.lbfds.repo.DonorRepo;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.mockito.Mockito.*;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
//class DonorServiceTest {
//
//    @Mock
//    private DonorRepo donorRepo;
//
//    @InjectMocks
//    private DonorService donorService;
//
//    private Donor donor;
//
//    @BeforeEach
//    void setUp() {
//        donor = new Donor(1L, "Vegetables", 5, null, "New York", "Pending");
//    }
//
//    @Test
//    void testGetDonationDetail() {
//        donorService.getDonationDetail(donor);
//        verify(donorRepo, times(1)).save(donor);
//    }
//
//    @Test
//    void testSearchFoodByLocation() {
//        when(donorRepo.findByLocationContainingIgnoreCase("New York")).thenReturn(List.of(donor));
//
//        var result = donorService.searchFoodByLocation("New York");
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals("New York", result.get(0).getLocation());
//    }
//
//    @Test
//    void testUpdateDonationStatus_Success() {
//        when(donorRepo.findById(1L)).thenReturn(Optional.of(donor));
//
//        boolean result = donorService.updateDonationStatus(1L, "Accepted");
//        assertTrue(result);
//        assertEquals("Accepted", donor.getStatus());
//    }
//
//    @Test
//    void testUpdateDonationStatus_Failure() {
//        when(donorRepo.findById(999L)).thenReturn(Optional.empty());
//
//        boolean result = donorService.updateDonationStatus(999L, "Accepted");
//        assertFalse(result);
//    }
//}
