/*
 * Run in a terminal: node mergesort.js <space separated numbers representing the array>
 * Example: node mergesort.js 4 3 2 1
 */
const sortMe = process.argv.slice(2);

console.log("Unsorted: " + sortMe); 
mergeSort(sortMe);
console.log("Sorted: " + sortMe);


function mergeSort(arr) { 
    sort(arr, 0, arr.length - 1); 
}

function sort(arr, left, right) { 
	if (left < right) {         
        let middle = parseInt( (left + right) / 2); 

        sort(arr, left, middle); 
        sort(arr, middle + 1, right); 
        
        merge(arr, left, middle, right); 
    } 
} 

function merge(arr, left, middle, right) { 
	let l1 = middle - left + 1; 
	let l2 = right - middle; 
    
	let arr1 = new Array(l1); 
	let arr2 = new Array(l2); 
	
	for (let i = 0; i < l1; ++i) { 
		arr1[i] = arr[left + i]; 
	} 
	for (let i = 0; i < l2; ++i) { 
		arr2[i] = arr[middle + 1 + i]; 
	} 

	let i = 0, 
		j = 0, 
		k = left; 
		
	while (i < l1 && j < l2) { 
		if (arr1[i] < arr2[j]) { 
			arr[k] = arr1[i]; 
			i++; 
		} else { 
			arr[k] = arr2[j]; 
			j++; 
		} 
		k++; 
	} 

	while (i < l1) { 
		arr[k] = arr1[i]; 
		i++; 
		k++; 
	} 
	while (j < l2) { 
		arr[k] = arr2[j]; 
		j++; 
		k++; 
	} 
} 