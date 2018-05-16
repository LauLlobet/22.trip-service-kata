package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(MockitoJUnitRunner.class)
public class TripServiceShould {

    private static final User UNUSED_USER = new User();
    private static final User REGISTERED_USER = new User();
    private static final User GUEST_USER = null;
    private static final Trip TO_BRAZIL = new Trip();
    private static final Trip TO_ST_PETERSBURG = new Trip();

    private User loggedUser = new User();
    private User UNRELATED_OTHER_USER = new User();


    @Mock
    TripDAO tripDAO;

    @InjectMocks @Spy TripService realTripService = new TripService();

    @Test(expected = UserNotLoggedInException.class)
    public void
    launch_an_exception_if_user_is_not_logged() {
        TripService tripService = new TripServiceTest();

        tripService.getTripsByUser(UNUSED_USER, GUEST_USER);
    }

    @Test
    public void
    return_no_trips_if_users_are_unrelated() {
        TripService tripService = new TripServiceTest();

        User unrelatedUser = UserBuilder.aUser()
                .withTrips(TO_BRAZIL)
                .withFriends(UNRELATED_OTHER_USER)
                .build();

        List<Trip> tripList = tripService.getTripsByUser(unrelatedUser, REGISTERED_USER);
        assertThat(tripList.size(),is(0)); //
    }

    @Test
    public void
    provide_friends_trips() {
        TripService tripService = new TripServiceTest();

         User friend = UserBuilder.aUser()
                 .withFriends(REGISTERED_USER)
                 .withTrips(TO_BRAZIL,TO_ST_PETERSBURG)
                 .build();

        List<Trip> tripList = tripService.getTripsByUser(friend, REGISTERED_USER);

        assertThat(tripList.size(),is(2));
    }




    private class TripServiceTest extends  TripService {
        @Override
        protected List<Trip> tripsFor(User user) {
            return user.trips();
        }
    }

}