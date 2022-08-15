package jpa.relation.transaction;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static jpa.relation.transaction.BarUserTransactionAssert.then;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BarUserTransactionBuilderTest {

    @Test
    void Relate_users_to_bar() {
        BarUserTransaction barUserTransaction = BarUserTransaction.builder()
                .bar(10)
                .users(List.of(1, 2, 3))
                .build();

       then(barUserTransaction)
               .eachUserHasBarWithId(10)
               .barIsRelatedToUsers(1, 2, 3);
    }

}