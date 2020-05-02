package com.example.springhibernate.springhibernate.repositories;

import com.example.springhibernate.springhibernate.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank,Integer> {
}
