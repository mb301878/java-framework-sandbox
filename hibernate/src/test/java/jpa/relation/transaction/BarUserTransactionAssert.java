package jpa.relation.transaction;

import jpa.relation.User;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import static jpa.relation.transaction.IdComparator.barHasId;
import static org.junit.Assert.*;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class BarUserTransactionAssert {

    private final BarUserTransaction barUserTransaction;

    public static BarUserTransactionAssert then(BarUserTransaction barUserTransaction) {
        return new BarUserTransactionAssert(barUserTransaction);
    }

    BarUserTransactionAssert eachUserHasBarWithId(int barId) {
        barUserTransaction
                .getUsers()
                .forEach(user -> hasBarWithId(user, barId));
        return this;
    }

    BarUserTransactionAssert barIsRelatedToUsers(int... ids) {
        BarAssert.then(barUserTransaction.getBar())
                .containsUsersWithIds(ids);
        return this;
    }

    private void hasBarWithId(User user, int barId) {
        assertTrue(barHasId(user.getBar(), barId));
    }

}
