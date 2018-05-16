package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {



	public List<Trip> getTripsByUser(User user, User loggedUser) throws UserNotLoggedInException {
        throwIfGuest(loggedUser);
        return user.isFriendOf(loggedUser) ?  tripsFor(user) : noTrips();
	}

    private ArrayList<Trip> noTrips() {
        return new ArrayList<Trip>();
    }

    private void throwIfGuest(User loggedUser) {
        if (loggedUser == null) {
            throw new UserNotLoggedInException();
        }
    }

    protected List<Trip> tripsFor(User user) {
		return TripDAO.findTripsByUser(user);
	}

}
