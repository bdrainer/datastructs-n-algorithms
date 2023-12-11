class ListNode {
	constructor(val, next) {
		this.val = (val === undefined ? 0 : val)
		this.next = (next === undefined ? null : next)
	}
}

var mergeTwoLists = function(list1, list2) {
	if (!list1 || !list2) return list1 || list2

    let head
    
    if (list1.val < list2.val) { 
        head = list1 
        head.next = mergeTwoLists(list1.next, list2)
    } else { 
        head = list2
        head.next = mergeTwoLists(list1, list2.next)  
    }

    return head
}

// the two lists should be sorted
let list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
let list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

let merged = mergeTwoLists(list1, list2);

while(merged.next != null) {
	console.log(merged.val);
	merged = merged.next;
} 

