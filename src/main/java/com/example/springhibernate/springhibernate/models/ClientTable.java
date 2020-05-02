package com.example.springhibernate.springhibernate.models;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

public class ClientTable extends TableImpl<Record> {

    public static ClientTable CLIENT= new ClientTable("client_table");

    public final Field<Integer> client_id = createField("id", SQLDataType.INTEGER);
    public final Field<String> client_name = createField("name", SQLDataType.VARCHAR.length(50));

    public ClientTable(String name) {
        super(name);
    }
}
