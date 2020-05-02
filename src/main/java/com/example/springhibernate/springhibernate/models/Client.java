package com.example.springhibernate.springhibernate.models;

import org.jooq.Field;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client_table")
public class Client {


    @Id
    @Column(name = "id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String name;

    public String getName2() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
