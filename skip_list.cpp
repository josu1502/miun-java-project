/* 
 * File:   skip_list.cpp
 * Author: Joakim
 * 
 * Created on den 12 januari 2017, 20:17
 */

#include "skip_list.h"

skip_list::skip_list() {
    height = 4; //4 layers set as standard
    begin = new node_t();

    for (int i = 0; i < height - 1; i++) {
        node_t* count = begin;
        node_t* tmp = new node_t();
        while (count->below != nullptr) {
            count = count->below;
        }
        count->below = tmp;
        tmp->above = count;
    }
}

void skip_list::insert(int value) {
    node_t* count = begin;
    node_t* tmp = new node_t(value);

    //Go down and inwards
    while (count->below != nullptr) {
        if (count->next != nullptr) {
            if ((count->next->value) < value) {
                count = count->next;
            } else {
                count = count->below;
            }
        } else {
            count = count->below;
        }
    }

    //Go inwards
    while (count->next != nullptr) {
        if ((count->next->value) < value) {
            count = count->next;
        } else {
            break;
        }
    }

    //Insert value bottom layer
    if (count->next != nullptr) {
        tmp->next = count->next;
        tmp->prev = count;
        count->next->prev = tmp;
        count->next = tmp;
    } else {
        count->next = tmp;
        tmp->prev = count;
    }


    //flip coin and go backwards
    if (rand() % 2) { //50% chance
        node_t * one = insert_above(tmp, value);
        if (rand() % 2) { //50% chance
            node_t * two = insert_above(one, value);
            if (rand() % 2) { //50% chance
                node_t * three = insert_above(two, value);
            }
        }
    }
}

int skip_list::find(int integerToFind) {
    node_t* count = begin;

    //Go down and inwards
    while (count->below != nullptr) {
        if (count->next != nullptr) {
            if ((count->next->value) <= integerToFind) {
                count = count->next;
                if ((count->value) == integerToFind) return integerToFind;
            } else {
                count = count->below;
            }
        } else {
            count = count->below;
        }
    }

    //Go inwards
    while (count->next != nullptr) {
        if ((count->next->value) <= integerToFind) {
            count = count->next;
            if ((count->value) == integerToFind) return integerToFind;
        } else {
            break;
        }
    }

    return -1;
}

skip_list::node_t::node_t() {
    this->value = 0;
    this->next = 0;
    this->prev = 0;
    this->below = 0;
    this->above = 0;
}

skip_list::node_t::node_t(int value) {
    this->value = value;
    this->next = 0;
    this->prev = 0;
    this->below = 0;
    this->above = 0;
}

skip_list::node_t *skip_list::insert_above(node_t* &start, int value) {
    node_t* count = start;
    node_t* tmp = new node_t(value);

    //Go back until you can go up
    while (count->above == nullptr) {
        count = count->prev;
    }

    count = count->above; //Go up

    //Go inwards
    while (count->next != nullptr) {
        if ((count->next->value) < value) {
            count = count->next;
        } else {
            break;
        }
    }

    //Insert value, one above bottom layer
    if (count->next != nullptr) {
        tmp->next = count->next;
        tmp->prev = count;
        count->next->prev = tmp;
        count->next = tmp;
    } else {
        count->next = tmp;
        tmp->prev = count;
    }

    tmp->below = start;
    start->above = tmp;

    return tmp;
}