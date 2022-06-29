/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    let numsObj = {};
    let maxFrequency = 0;
    let maxElement = null;
    
    for(let num of nums) {
        numsObj[num] = numsObj[num] + 1 || 1
    }
    
    for(let num in numsObj) {
        if(numsObj[num] > maxFrequency) {
            maxFrequency = numsObj[num]
            maxElement = parseInt(num)
        }
    }
    return maxElement
};