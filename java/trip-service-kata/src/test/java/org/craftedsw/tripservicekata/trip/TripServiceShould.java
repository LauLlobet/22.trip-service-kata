package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TripServiceShould {
    @Test(expected = UserNotLoggedInException.class)
    public void
    launch_an_exception_if_user_is_not_logged() {
        TripService tripService = new TripServiceTest();
        User user = new User();

        List<Trip> tripList = tripService.getTripsByUser(user);
    }


    private class TripServiceTest extends  TripService {
        @Override
        protected User getLoggedUser() {
            return null;
        }
    }

}
