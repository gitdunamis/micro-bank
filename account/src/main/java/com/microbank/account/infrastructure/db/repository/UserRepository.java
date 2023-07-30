package com.microbank.account.infrastructure.db.repository;

import com.microbank.account.domain.entity.User;
import com.microbank.account.domain.repository.IUserRepository;
import com.microbank.account.domain.valueobject.Id;
import com.microbank.account.domain.valueobject.Name;
import com.microbank.account.infrastructure.db.repository.entity.UserEntity;

import java.util.Map;
import java.util.Optional;

public class UserRepository implements IUserRepository {

    private final Map<Long, UserEntity> database;

    public UserRepository(Map<Long, UserEntity> database) {
        this.database = database;
    }

    @Override
    public Optional<User> find(Id id) {
        return database.values()
                .stream()
                .filter(entity -> entity.getId() == id.id())
                .map(entity -> new User(id, new Name(entity.getName())))
                .findFirst();
    }

    @Override
    public void create(User user) {
        long id = database.keySet().stream().max(Long::compareTo).orElse(0L);

        long entityId = ++id;
        UserEntity entity = new UserEntity(user.getId().id(), user.getName().name());
        database.put(entityId, entity);
    }
}
