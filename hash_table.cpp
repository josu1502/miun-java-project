/* 
 * File:   hash_table.cpp
 * Author: Joakim
 * 
 * Created on den 9 januari 2017, 22:18
 */

#include "hash_table.h"

hash_table::hash_table() {
    table.resize(0);
}

void hash_table::resize(std::size_t size) {
    table.resize(size);
}

void hash_table::insert(std::size_t numberOfElements, std::vector<int> vectorToInsert) { //NumberOfElements is laboration-specific
    for (int i = 0; i < numberOfElements; i++) {
        std::size_t pos = hash(vectorToInsert[i]);
        table[pos].push_back(vectorToInsert[i]);
    }
}

int hash_table::find(int numberToFind) {
    //Hash number and see if it is there
    std::size_t pos = hash(numberToFind);
    for (int i = 0; i < table[pos].size(); i++) {
        if (table[pos][i] == numberToFind) {
            return (numberToFind);
        }
    }
    return -1;
}

std::size_t hash_table::hash(int number) {
    //Calcualte numbers position
    return (number % table.size());
}