package jpa.relation.transaction;

import jpa.relation.Bar;
import jpa.relation.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class BarUserTransactionBuilder {

    private Collection<Integer> userIds;
    private int barId;

    public BarUserTransactionBuilder users(Collection<Integer> userIds) {
        this.userIds = userIds;
        return this;
    }

    public BarUserTransactionBuilder bar(int barId) {
        this.barId = barId;
        return this;
    }

    public BarUserTransaction build() {
        Set<User> users = userIds.stream()
                .map(User::newInstanceOfUserWithNoBar)
                .collect(Collectors.toSet());
        Bar bar = Bar.newInstanceOfBarWithNoUsers(barId);
        bar.setUsers(users);
        users.forEach(u -> u.setBar(bar));
        return new BarUserTransaction(users, bar);

    }

}
