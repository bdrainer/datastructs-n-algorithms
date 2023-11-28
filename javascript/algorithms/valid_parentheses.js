var isValid = function(s) {
    console.log("Input: " + s);

    const map = { "(":")", "{":"}", "[":"]" };

    const openers = [];

    for(let i = 0; i < s.length; i++){
        let char = s[i];
        if(map[char]) {
            openers.push(char);
        } else if(map[openers.pop()] !== char) {
            return false;
        }
    }
    return openers.length === 0;
};

// Expect True
console.log("Results : " + isValid("()"));
console.log("Results : " + isValid("()[]"));
console.log("Results : " + isValid("()[]{}"));
console.log("Results : " + isValid("([])"));
console.log("Results : " + isValid("([{}])"));

// Expect False
console.log("Results : " + isValid("(]"));
console.log("Results : " + isValid("("));
console.log("Results : " + isValid("(]"));
console.log("Results : " + isValid("({]})"));
console.log("Results : " + isValid("(("));
