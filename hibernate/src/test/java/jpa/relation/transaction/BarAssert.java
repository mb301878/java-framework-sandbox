package jpa.relation.transaction;

import jpa.relation.Bar;
import jpa.relation.User;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import static jpa.relation.transaction.IdComparator.userHasId;
import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class BarAssert {

    private final Bar bar;

    public static BarAssert then(Bar bar) {
        return new BarAssert(bar);
    }

    void containsUsersWithIds(int... ids) {
        assertThat(bar.getUsers()
                .stream()
                .allMatch(user -> userHasOneOfIds(user, ids)))
                .isTrue();
    }

    boolean userHasOneOfIds(User user, int[] ids) {
        for (int id : ids) {
            if (userHasId(user, id)) {
                return true;
            }
        }
        return false;
    }

}
