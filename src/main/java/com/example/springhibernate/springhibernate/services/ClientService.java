package com.example.springhibernate.springhibernate.services;

import com.example.springhibernate.springhibernate.dao.ClientDao;
import com.example.springhibernate.springhibernate.models.Client;
import com.example.springhibernate.springhibernate.repositories.ClientRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static javax.persistence.Persistence.createEntityManagerFactory;

@Service
public class ClientService implements ClientDao<Client> {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Stream<List<Client>> getAllClients() {
        return Stream.of(clientRepository.findAll());
    }

    @Override
    public Optional<Client> getClient(int id) {
        return clientRepository.findById(id);
    }

    @Override
    public boolean addNewClient(int id, String name) {
        Client client = new Client();
        client.setId(id);
        client.setName(name);
        clientRepository.saveAndFlush(client);
        return clientRepository.existsById(client.getId());
    }

    @Override
    public boolean removeById(int id) {
        clientRepository.deleteById(id);
        return !clientRepository.existsById(id);
    }
}
