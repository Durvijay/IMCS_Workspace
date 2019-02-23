package trng.polymorphism;

import java.util.List;

public interface GenericDAO<T> {
    public boolean add(T t);
    public boolean update(int index, T t);
    public boolean remove(int index);
    public T getByIndex(int index);
    public List<T> getAll();

    // I want to add search method here if it's possible to search by any multiple object specs
}