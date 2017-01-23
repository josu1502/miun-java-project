/* 
 * File:   sieve.h
 * Author: Joakim
 *
 * Created on den 9 januari 2017, 09:22
 */

#ifndef SIEVE_H
#define SIEVE_H
#include <vector>
#include <cmath>
#include <algorithm>

std::vector<int> generate_prime_vector(size_t init_size)
{
    std::vector<int> return_me;
    if (init_size < 3) return(return_me);
    
    for (int i = 2; i < init_size; i+=1) {
        return_me.push_back(i);
    }
    
    for (int i = 0; i < std::sqrt(init_size); i++)
    {
        if (return_me[i] == 0) continue;
        
        int devisor = return_me[i];
        for (int j = i; j < return_me.size(); j+=devisor)
        {
            if (devisor==return_me[j]) continue;
            return_me[j] = 0;
            //if (return_me[j] % devisor == 0) return_me.erase(return_me.begin()+j);
        }
    }
    
    return_me.erase(std::remove(return_me.begin(), return_me.end(), 0), return_me.end());
    
    return (return_me);
}
#endif /* SIEVE_H */

