package orm.relations.transaction;

import orm.relations.Bar;
import orm.relations.User;
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
