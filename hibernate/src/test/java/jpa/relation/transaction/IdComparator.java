package jpa.relation.transaction;

import jpa.relation.Bar;
import jpa.relation.User;
import lombok.experimental.UtilityClass;

@UtilityClass
class IdComparator {

    static boolean userHasId(User user, int id) {
        return user.getUserId().equals((long) id);
    }

    static boolean barHasId(Bar bar, int id) {
        return bar.getBarId().equals((long) id);
    }
}
