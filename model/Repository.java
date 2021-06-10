package model;

import java.util.List;

public interface Repository<T> {
    List<T> getAll();
    T getById(int id);
    void add(T item);
    void update(T item);
    void delete(int id);
}
