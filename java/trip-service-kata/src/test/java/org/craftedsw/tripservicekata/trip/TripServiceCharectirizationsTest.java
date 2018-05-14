package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class TripServiceCharectirizationsTest {

    @Test
    public void
    x() {
        TripService tripService = new TripService();
        User user = null;
        List<Trip> listOfTrips = tripService.getTripsByUser(user);
        assertNull(listOfTrips);
    }

	
}
