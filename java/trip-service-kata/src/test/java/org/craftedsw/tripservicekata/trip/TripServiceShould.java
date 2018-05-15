package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TripServiceShould {

    private static final User UNUSED_USER = new User();
    private static final User REGISTERED_USER = new User();
    private static final User GUEST_USER = null;
    private static final Trip TO_BRAZIL = new Trip();
    private static final Trip TO_ST_PETERSBURG = new Trip();

    private User loggedUser = new User();
    private User UNRELATED_OTHER_USER = new User();

    @Test(expected = UserNotLoggedInException.class)
    public void
    launch_an_exception_if_user_is_not_logged() {
        TripService tripService = new TripServiceTest();

        loggedUser = GUEST_USER;

        tripService.getTripsByUser(UNUSED_USER);
    }

    @Test
    public void
    return_no_trips_if_users_are_unrelated() {
        TripService tripService = new TripServiceTest();

        loggedUser = REGISTERED_USER;
        User unrelatedUser = UserBuilder.aUser()
                .withTrips(TO_BRAZIL)
                .withFriends(UNRELATED_OTHER_USER)
                .build();

        List<Trip> tripList = tripService.getTripsByUser(unrelatedUser);
        assertThat(tripList.size(),is(0));
    }

    @Test
    public void
    provide_friends_trips() {
        TripService tripService = new TripServiceTest();

        loggedUser = REGISTERED_USER;

         User friend = UserBuilder.aUser()
                 .withFriends(loggedUser)
                 .withTrips(TO_BRAZIL,TO_ST_PETERSBURG)
                 .build();

        List<Trip> tripList = tripService.getTripsByUser(friend);

        assertThat(tripList.size(),is(2));
    }

    private class TripServiceTest extends  TripService {
        @Override
        protected User getLoggedUser() {
            return loggedUser;
        }

        @Override
        protected List<Trip> findTripsByUser(User user) {
            return user.trips();
        }
    }

}
