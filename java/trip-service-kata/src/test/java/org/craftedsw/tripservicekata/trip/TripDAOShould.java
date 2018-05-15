package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.junit.Test;

public class TripDAOShould {

    @Test(expected = CollaboratorCallException.class)
    public void
    should_return_an_exception() {
        TripDAO.findTripsByUser(null);
    }


}
