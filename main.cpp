/* 
 * File:   main.cpp
 * Author: Joakim
 *
 * Created on den 8 januari 2017, 20:19
 */

#include <cstdlib>
#include <iostream>
#include <vector>
#include <chrono>
#include "sieve.h"
#include "is_prime.h"
#include "hash_table.h"
#include "skip_list.h"

int main() {

    //Initialize
    std::vector<int> vector_to_search = generate_prime_vector(10000000); //Generates a vector filled with prime numbers up to given number (100000000)=good number
    std::cout << vector_to_search.size() << std::endl; //To find out recomenden N elements to search for below

    //Find prime numbers time measure

    for (int N = 10000; N <= 50000; N += 10000) // alla mätpunkter
    {
        int NRND = 100;
        int NTEST = 5;

        //Create hash
        /*hash_table table;
        //Calcualte recomended hash size
        std::size_t hash_size = N * 2; //First: double the size
        while (isPrime(vector_to_search.begin(), vector_to_search.end(), hash_size) == -1) { //Second: round up to nearest prime
            hash_size++;
        }
        table.resize(hash_size);
        table.insert(N, vector_to_search);*/

        //Create skip
        skip_list skip;
        for (int i = 0; i < N; i++) {
            skip.insert(vector_to_search[i]);
        }

        //Time measure
        auto start = std::chrono::system_clock::now();
        for (int i = 0; i < NRND; i++) {
            int find = 1 + rand() % vector_to_search[N];
            for (int j = 0; j < NTEST; j++) {

                //Regular search example
                //isPrime(vector_to_search.begin(), vector_to_search.begin() + N, find);

                //Hash search example
                //table.find(find);

                //Skip search example
                skip.find(find);
            }
        }
        auto end = std::chrono::system_clock::now();
        auto elapsed = std::chrono::duration_cast<std::chrono::microseconds>(end - start);
        double time = elapsed.count() / (NRND * NTEST);
        std::cout << "Time: " << time << "microseconds" << std::endl;
    }

    /*//Print the vector with primes
    for (auto e : vector_to_search) {
        std::cout << e << " ";
    }
    std::cout << std::endl;*/

    return 0;
}

