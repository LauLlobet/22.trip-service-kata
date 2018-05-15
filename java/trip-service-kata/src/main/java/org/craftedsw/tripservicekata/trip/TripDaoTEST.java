package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;

import java.util.List;

public class TripDaoTEST extends TripDAO{

    private static List<Trip> tripList;

    @Override
    public static List<Trip> findTripsByUser(User user) {
        return tripList;
    }

}
