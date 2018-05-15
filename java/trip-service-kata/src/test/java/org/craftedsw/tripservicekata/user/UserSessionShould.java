package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.junit.Test;

public class UserSessionShould {
    @Test(expected = CollaboratorCallException.class)
    public void
    throw_exception_at_any_usage() {
        UserSession.getInstance().getLoggedUser();
    }
}
