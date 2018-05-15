package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TripServiceCharectirizationsTest {

    @Test
    public void
    provide_no_trips_for_unrelated_firends() {
        TripService tripService = new TripService();
        User user = new User();
        User loggedUser = new User();

        List<Trip> listOfTrips = tripService.getTripsByUser(user, userSessionWithUser(loggedUser),null);


        assertThat(listOfTrips.size(), is(0));
    }

    @Test
    public void
    provide_no_trips_for_logged_user_that_is_befriended_by_user() {
        TripService tripService = new TripService();
        User user = new User();
        User loggedUser = new User();
        user.addFriend(loggedUser);

        List<Trip> listOfTrips = tripService.getTripsByUser(user, userSessionWithUser(loggedUser),null);

        assertThat(listOfTrips.size(),is(0));
    }

    @Test
    public void
    x() {
        TripService tripService = new TripService();
        User user = new User();
        User loggedUser = new User();
        loggedUser.addFriend(user);



        List<Trip> listOfTrips = tripService.getTripsByUser(user,userSessionWithUser(loggedUser));
        assertThat(listOfTrips.size(),is(0));
    }

    private UserSession userSessionWithUser(final User loggedUser) {
        return new UserSession(){
            public UserSession setUp(){
                userSession = this;
                return this;
            }
            public User getLoggedUser() {
                return loggedUser;
            }
        }.setUp();

    }


}
