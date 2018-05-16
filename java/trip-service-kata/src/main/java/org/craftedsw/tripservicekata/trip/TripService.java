package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
        throwIfGuest();
        return user.isFriendOf(getLoggedUser()) ?  findTripsFor(user) : noTrips();
	}

    private ArrayList<Trip> noTrips() {
        return new ArrayList<Trip>();
    }

    private void throwIfGuest() {
        if (getLoggedUser() == null) {
            throw new UserNotLoggedInException();
        }
    }

    protected List<Trip> findTripsFor(User user) {
		return TripDAO.findTripsByUser(user);
	}

	protected User getLoggedUser() {
		return UserSession.getInstance().getLoggedUser();
	}

}
