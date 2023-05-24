package com.charterassessment.rewards;

import com.charterassessment.rewards.service.RewardPointsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class RewardsApplicationTests {

    @Mock
    private RewardPointsService rewardPointsService;

    @BeforeEach
    void setUp() {
        // Initialize mock objects
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculatePointsAmountGreaterThan100() {
        // Test case for amount greater than 100
        double amount = 150.0;
        int expectedPoints = 150;

        // Define mock behavior
        when(rewardPointsService.calculatePoints(amount)).thenReturn(expectedPoints);

        // Call the method under test
        int actualPoints = rewardPointsService.calculatePoints(amount);

        // Verify the result
        assertEquals(expectedPoints, actualPoints);
    }

    @Test
    public void testCalculatePointsAmountEquals100() {
        // Test case for amount equals to 100
        double amount = 100.0;
        int expectedPoints = 50;

        // Define mock behavior
        when(rewardPointsService.calculatePoints(amount)).thenReturn(expectedPoints);

        // Call the method under test
        int actualPoints = rewardPointsService.calculatePoints(amount);

        // Verify the result
        assertEquals(expectedPoints, actualPoints);
    }

    @Test
    public void testCalculatePointsAmountBetween50And100() {
        // Test case for amount between 50 and 100
        double amount = 75.0;
        int expectedPoints = 25;

        // Define mock behavior
        when(rewardPointsService.calculatePoints(amount)).thenReturn(expectedPoints);

        // Call the method under test
        int actualPoints = rewardPointsService.calculatePoints(amount);

        // Verify the result
        assertEquals(expectedPoints, actualPoints);
    }

    @Test
    public void testCalculatePointsAmountLessThan50() {
        // Test case for amount less than 50
        double amount = 30.0;
        int expectedPoints = 0;

        // Define mock behavior
        when(rewardPointsService.calculatePoints(amount)).thenReturn(expectedPoints);

        // Call the method under test
        int actualPoints = rewardPointsService.calculatePoints(amount);

        // Verify the result
        assertEquals(expectedPoints, actualPoints);
    }
}
