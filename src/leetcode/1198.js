/**
 * @param {character[]} s
 * @return {void} Do not return anything, modify s in-place instead.
 */
var reverseString = function(s) {
  	p1 = 0;
  	p2 = s.length - 1;
  	while(p1<p2){
    	t = s[p1];
      	s[p1] = s[p2];
      	s[p2] = t;
      	p1++;
      	p2--;
    }
};
