package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.List;

public class UsersUtil {

    public static final List<User> USERS = Arrays.asList(
            new User(1, "Vitalie", "vitalie.jurjiu@gmail.com", "1234", Role.ROLE_ADMIN, Role.ROLE_USER),
            new User(2, "Catalin", "catalin.jurjiu@gmail.com", "1234", Role.ROLE_USER),
            new User(3, "Bogdan", "bogdan.jurjiu@gmail.com", "1234", Role.ROLE_USER),
            new User(4, "Ira", "ira.jurjiu@gmail.com", "1234", Role.ROLE_ADMIN, Role.ROLE_USER)
    );
}
