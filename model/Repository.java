package model;

import java.util.List;

public interface Repository<K, T> {
    List<T> getAll();
    T getById(K id);
    void add(T item);
    void update(T item);
    void delete(K id);
}
