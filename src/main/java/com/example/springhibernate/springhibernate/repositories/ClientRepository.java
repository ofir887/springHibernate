package com.example.springhibernate.springhibernate.repositories;

import com.example.springhibernate.springhibernate.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
}
