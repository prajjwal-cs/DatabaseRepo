/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 25-07-2025
Time: 4:22 PM
File: DatabaseOperations.java */
package database;

import model.Customer;

public interface CrudOperations<T> {
    //create
    void create(T object);
    //read
    void read(int id);
    //update
    void update(int id, T object);
    //delete
    void delete(int id);
}