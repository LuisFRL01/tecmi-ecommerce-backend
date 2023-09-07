package com.sena.tecmiecommercebackend.mock;

import com.sena.tecmiecommercebackend.repository.entity.User;

public class UserMock {

    public static User buildUser() {
        var user = new User("Luís", "Fernando", "luis@email.com", "123");
        user.setId(1L);
        return user;
    }
}
