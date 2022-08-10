package jpa.relation.transaction;

import jpa.relation.Bar;
import jpa.relation.User;
import lombok.Value;

import java.util.Set;

@Value
public class BarUserTransaction {

    Set<User> users;
    Bar bar;

    public static BarUserTransactionBuilder builder() {
        return new BarUserTransactionBuilder();
    }

}
