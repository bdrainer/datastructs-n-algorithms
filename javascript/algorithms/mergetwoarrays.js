var mergeTwoArrays = function(list1, list2) {

    const size1 = list1.length;
    const size2 = list2.length;

    const results = [];

    let i = 0, j = 0, k = 0; 

    while (i < size1 && j < size2) { 
		if (list1[i] < list2[j]) { 
            // console.log("i = " + i);
			results[k] = list1[i]; 
			i++; 
		} else { 
            // console.log("j = " + j);
			results[k] = list2[j]; 
			j++; 
		} 
		k++; 
	} 

	while (i < size1) { 
		results[k] = list1[i]; 
		i++; 
		k++; 
	} 
	while (j < size2) { 
		results[k] = list2[j]; 
		j++; 
		k++; 
	} 

    return results;
};

console.log(mergeTwoArrays([], []));
console.log(mergeTwoArrays([], [0]));
console.log(mergeTwoArrays([1,2,4], [1,3,4]));
console.log(mergeTwoArrays([1,2,4], [1,3,4,5,6]));
console.log(mergeTwoArrays([1,2,4,5,6], [1,3,4]));