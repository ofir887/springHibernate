package com.example.springhibernate.springhibernate.dao;


import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface ClientDao<T> {

    Stream<List<T>> getAllClients();

    Optional<T> getClient(int id);

    boolean addNewClient(int id,String name);

    boolean removeById(int id);
}
