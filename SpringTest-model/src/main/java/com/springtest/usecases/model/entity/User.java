package com.springtest.usecases.model.entity;

import com.springtest.usecases.model.core.Role;
import org.springframework.stereotype.Component;

/**
 * Класс с данными пользователя в системе
 */
@Component("user")
public class User {

    /**
     * Данные пользователя (Фио и прочее)
     */
    private UserCard userCard;

    /**
     * Роль клиента в системе
     */
    private Role role;

    /**
     * Способы связаться с клиентом (контактные данные)
     */
    private UserContacts contacts;

    public UserCard getUserCard() {
        return userCard;
    }

    public void setUserCard(UserCard userCard) {
        this.userCard = userCard;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserContacts getContacts() {
        return contacts;
    }

    public void setContacts(UserContacts contacts) {
        this.contacts = contacts;
    }

}
