package com.miun.appguestbook.josu1502.appguestbook.rest;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Joakim on 17-02-16.
 */
@Root
public class LunchEntities {
    @ElementList(entry="lunchEntity", inline=true)
    public List<LunchEntity> lunchEntity;
}
