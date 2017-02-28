package com.example.matti.schemaapplikation.rest;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Joakim on 17-02-16.
 */
@Root (name = "scheduleentities")
public class SchemaEntities {
    @ElementList(entry="scheduleentity", inline=true)
    public List<SchemaEntity> schemaEntity;
}
