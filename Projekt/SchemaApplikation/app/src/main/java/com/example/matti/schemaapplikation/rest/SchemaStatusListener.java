package com.example.matti.schemaapplikation.rest;

/**
 * Created by Joakim on 17-02-27.
 */

public interface SchemaStatusListener {
    void schemaListRecived(SchemaEntities se);
    void schemaUpdated();
}
