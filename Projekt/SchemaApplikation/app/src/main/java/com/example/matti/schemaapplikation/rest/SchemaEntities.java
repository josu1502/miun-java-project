package com.example.matti.schemaapplikation.rest;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Joakim on 17-02-16.
 */
@Root (name = "schemaEntities")
public class SchemaEntities {
    @ElementList(entry="schemaEntity", inline=true)
    public List<SchemaEntity> schemaEntity;
}
