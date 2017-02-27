package com.miun.appguestbook.josu1502.appguestbook.rest;

/**
 * Created by Joakim on 17-02-27.
 */

public interface LunchStatusListener {
    void lunchListRecived(LunchEntities le);
    void lunchUpdated();
}
