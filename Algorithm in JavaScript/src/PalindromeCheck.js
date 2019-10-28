//reference: https://blog.csdn.net/Blue___Ocean/article/details/81063806

/**
   * @param {string} string - the string which we want to test: about whether it is a palidrome or not
   */
//only consider the alphanumeric characters and ignoring cases
function PalindromeCheck(string){
    var str=string.toLowerCase();
    var left=0,right=str.length-1;
    //string with only one character
    if(left===right){
      console.log("This string is a palindrome.");
      return true;
    }
    //consider the empty string 
    if(right===-1){
      console.log("This string is not a palindrome.");
      return false;
    }
    //the normal situation
    while(left<right){
      //check for the difference, once happened, return false.
      if(str[left]!==str[right]){
         console.log("This string is not a palindrome.");
      return false;
      }
      left++;
      right--;
    }
     console.log("This string is a palindrome.");
    return true;
 
 }
 
  //test the output of this function
  /** @test {PalindromeCheck} */
  var testString='AmanaplanacanalPanama';
  PalindromeCheck(testString);