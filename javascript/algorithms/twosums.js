var twoSum = function(nums, target) {
    console.log("Target: " + target + " | Input: " + nums); 
    const map = {};
    for (let i = 0; i < nums.length; i++) {
        const key = target - nums[i];
        if (map[key] !== undefined) {
            const results = [map[key], i];
            console.log("Output: " + results);
            return results;
        }
        map[nums[i]] = i;
    }
    return [];
};

twoSum([3,2,4], 6);
twoSum([2,7,11,15], 9);
twoSum([3,3], 6);


