package com.qa.databases.controller;

/**
 * Create, Read, Update and Delete controller.
 * Takes in inputs for each action to be sent to a service class
 */

public interface CrudController {
    
    void readAll();
     
    void create();
     
    void update();
     
    void delete();

}