package jpa;

import lombok.experimental.UtilityClass;

import java.util.Date;

@UtilityClass
class AccountObjectMother {

    public static Account simpleAccount() {
        Account account = new Account();
        account.setId(1);
        account.setUsername("user");
        account.setPassword("pass");
        account.setEmail("email@inbox.pl");
        account.setCreatedOn(new Date(0L));
        account.setLastLogin(new Date(10000L));
        return account;
    }

    public static Account simpleAccountUpdated() {
        Account account = new Account();
        account.setId(1);
        account.setUsername("userupdated");
        account.setPassword("pass");
        account.setEmail("email@inbox.pl");
        account.setCreatedOn(new Date(0L));
        account.setLastLogin(new Date(10000L));
        return account;
    }
}
