/* 
 * File:   search_algorithms.h
 * Author: Joakim
 *
 * Created on den 8 januari 2017, 20:54
 */

#ifndef SEARCH_ALGORITHMS_H
#define SEARCH_ALGORITHMS_H

//Linear search
template <typename IT>
bool linear_search(IT begin, IT end, int find) {
    for (IT i = begin; i < end; i++) {
        if (find == *i) {
            return (true);
        }
    }
    return (false);
}

//Binary search
template <typename IT>
bool binary_search(IT begin, IT end, int find) {
    if (begin >= end) {
        if (*begin == find) return (true);
        else return (false);
    }
    IT mid = begin + (end - begin)/2;
        
    if (*mid == find) return (true);
    if (*mid>find) return (binary_search(begin, mid-1, find));
    if (*mid<find) return (binary_search(mid+1, end, find));
}

#endif /* SEARCH_ALGORITHMS_H */

