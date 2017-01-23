/* 
 * File:   is_prime.h
 * Author: Joakim
 *
 * Created on den 11 januari 2017, 11:22
 */

#ifndef IS_PRIME_H
#define IS_PRIME_H

#include "search_algorithms.h"

template <typename IT>
int isPrime(IT begin, IT end, int integerToCheck) {
    if (binary_search(begin, end, integerToCheck)) return integerToCheck;
    //if (linear_search(begin, end, integerToCheck)) return integerToCheck;
    else return -1;
}



#endif /* IS_PRIME_H */

