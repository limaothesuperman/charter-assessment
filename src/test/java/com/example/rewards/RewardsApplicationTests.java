package com.example.rewards;

import com.example.rewards.service.RewardPointsService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RewardsApplicationTests {

    private final RewardPointsService rewardPointsService =
            new RewardPointsService(null, null);

    @Test
    public void testCalculatePointsAmountGreaterThan100() {
        double amount = 150.0;
        int expectedPoints = 150;

        int actualPoints = rewardPointsService.calculatePoints(amount);

        assertEquals(expectedPoints, actualPoints);
    }

    @Test
    public void testCalculatePointsAmountEquals100() {
        double amount = 100.0;
        int expectedPoints = 50;

        int actualPoints = rewardPointsService.calculatePoints(amount);

        assertEquals(expectedPoints, actualPoints);
    }

    @Test
    public void testCalculatePointsAmountBetween50And100() {
        double amount = 75.0;
        int expectedPoints = 25;

        int actualPoints = rewardPointsService.calculatePoints(amount);

        assertEquals(expectedPoints, actualPoints);
    }

    @Test
    public void testCalculatePointsAmountLessThan50() {
        double amount = 30.0;
        int expectedPoints = 0;

        int actualPoints = rewardPointsService.calculatePoints(amount);

        assertEquals(expectedPoints, actualPoints);
    }
}

