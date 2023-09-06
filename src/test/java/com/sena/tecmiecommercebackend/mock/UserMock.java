package com.sena.tecmiecommercebackend.mock;

import com.sena.tecmiecommercebackend.repository.entity.User;

public class UserMock {

    public static User buildUser() {
        return new User("Luís", "Fernando", "luis@email.com", "123");
    }
}
