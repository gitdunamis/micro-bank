package com.microbank.transaction.infrastructure.db.repository;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class Repository<T> {
    protected final Map<Long, T> database;

    protected Repository(Map<Long, T> database) {
        Objects.requireNonNull(database);
        this.database = database;
    }

    protected long getLastId() {
        return database.keySet().stream().max(Long::compareTo).orElse(0L);
    }

    protected Optional<T> find(Predicate<T> predicate) {
        return database.values().stream().filter(predicate).findFirst();
    }

    protected <R> Optional<R> findMap(Predicate<T> predicate, Function<T, R> mapper) {
        return database.values().stream().filter(predicate).map(mapper).findFirst();
    }
}
