package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
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
    provide_no_trips_for_unrelated_firends() {
        TripService tripService = new TripService();
        User user = new User();
        List<Trip> listOfTrips = tripService.getTripsByUser(user, new UserSession(){
            public UserSession setUp(){
                userSession = this;
                return this;
            }
            public User getLoggedUser() {
                return new User();
            }
        }.setUp());
        assertThat(listOfTrips.size(), is(0));
    }


	
}
