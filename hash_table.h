/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   hash_table.h
 * Author: Joakim
 *
 * Created on den 9 januari 2017, 22:18
 */

#ifndef HASH_TABLE_H
#define HASH_TABLE_H

#include <algorithm>
#include <vector>

class hash_table {
public:
    hash_table();
    void resize(std::size_t size);
    void insert(std::size_t numberOfElements, std::vector<int> vectorToInsert);
    int find(int numberToFind);
private:
    std::size_t hash(int number);
    std::vector<std::vector<int> > table; //Unecessary pointers in vector. One way directed nodes is enough
};

#endif /* HASH_TABLE_H */

