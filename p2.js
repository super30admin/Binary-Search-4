// ## Problem2 
// Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)

// time O(n + m)
// space: O(min(n,m))

let map = new Map();
let resArr = [];
const intersection = function(num1, num2) {
    if(num1.length <= num2.length) {
        createMap(num1);
        iterateOverArr(num2);
    }
    else {
        createMap(num2);
        iterateOverArr(num1);
    }
    return resArr;
}

const iterateOverArr = function(arr) {
    for(let num of arr) {
        if(map.has(num)) {
            resArr.push(num);
            map.set(num, (map.get(num) - 1));
            if(map.get(num) === 0) map.delete(num);
        }
    }
}

const createMap = function(arr) {
    for(let el of arr) {
        map.set(el, (map.get(el) || 0) + 1 );
    }
}