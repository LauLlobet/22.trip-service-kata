package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.trip.UserBuilder;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserTest {

    private User SOME_OTHER_USER = new User();

    @Test
    public void
    tell_if_is_not_friend_of_another_user() {
        User notAFriend = new User();
        User user = UserBuilder.aUser()
                .withFriends(SOME_OTHER_USER)
                .build();

        boolean isFriend = user.isFriendOf(notAFriend);
        assertThat(isFriend,is(false));
    }
    
    @Test
    public void
    tell_if_is_friend_of_another_user() {
        User aFriend = new User();
        User user = UserBuilder.aUser().withFriends(aFriend).build();

        Boolean isFriend = user.isFriendOf(aFriend);

        assertThat(isFriend,is(true));
    }

}
