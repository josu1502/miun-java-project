/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   skip_list.h
 * Author: Joakim
 *
 * Created on den 12 januari 2017, 20:17
 */

#ifndef SKIP_LIST_H
#define SKIP_LIST_H

#include <list>
#include <vector>
#include <stdlib.h>

class skip_list {
public:
    skip_list();
    void insert(int value);
    int find(int integerToFind);
private:

    struct node_t {
        node_t();
        node_t(int value);
        int value;
        node_t* next;
        node_t* prev;
        node_t* below;
        node_t* above;
    };
    
    node_t* insert_above(node_t* &start, int value);

    std::size_t height;
    node_t* begin;

};

#endif /* SKIP_LIST_H */

