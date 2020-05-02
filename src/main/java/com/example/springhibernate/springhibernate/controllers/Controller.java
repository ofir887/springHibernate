package com.example.springhibernate.springhibernate.controllers;

import com.example.springhibernate.springhibernate.dao.ClientDao;
import com.example.springhibernate.springhibernate.models.Bank;
import com.example.springhibernate.springhibernate.models.Client;
import com.example.springhibernate.springhibernate.models.ClientTable;
import com.example.springhibernate.springhibernate.repositories.BankRepository;
import org.jooq.DSLContext;
import org.jooq.Record2;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@org.springframework.stereotype.Controller
@RequestMapping(value = "/hibernate")
public class Controller {

    @Autowired
    ClientDao<Client> clientDao;
    @Autowired
    BankRepository bankRepository;
    @Autowired
    DSLContext dslContext;


    @GetMapping(value = "/getClients")
    public @ResponseBody
    String getClients() {
        Stream<List<Client>> clients = clientDao.getAllClients();
        System.out.println("got here");
        return clients.collect(Collectors.toList()).toString();
    }

    @GetMapping(value = "/getClientById/{id}")
    public @ResponseBody
    String getClientById(@PathVariable int id) {
        Optional<Client> client = clientDao.getClient(id);
        System.out.println("got: " + client);
        return client.get().toString();
    }

    @GetMapping(value = "/removeClientById/{id}")
    public @ResponseBody
    String removeClientById(@PathVariable int id) {
        return String.valueOf(clientDao.removeById(id));
    }

    @PostMapping(value = "/createClient")
    public @ResponseBody
    String removeClientById(@RequestParam int id, @RequestParam String name) {
        return String.valueOf(clientDao.addNewClient(id, name));
    }

    @GetMapping(value = "/jooq")
    public @ResponseBody
    String jooq(@RequestParam int id) {

        Result<Record2<Integer, String>> result = dslContext
                .select(ClientTable.CLIENT.client_id, ClientTable.CLIENT.client_name)
                .from(ClientTable.CLIENT)
                .where(ClientTable.CLIENT.client_id.greaterOrEqual(id))
                .fetch();

        return result.toString();
    }

    @PostMapping(value = "/createNewBank")
    public @ResponseBody
    String createNewBank(@RequestParam String name) {
        Bank bank = new Bank();
        bank.setName(name);
        Bank s = bankRepository.saveAndFlush(bank);
        System.out.println("saved: " + s);
        return "done";
    }

}
