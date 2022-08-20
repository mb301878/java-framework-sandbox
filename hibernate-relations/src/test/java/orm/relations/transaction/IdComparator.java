package orm.relations.transaction;

import orm.relations.Bar;
import orm.relations.User;
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
