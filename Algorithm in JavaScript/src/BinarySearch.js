//reference: https://www.bbsmax.com/A/D8544e6W5E/

/**
   * @param {object} arr -  find the target element in this array
   *  @param {number} target - the target number which we try to locate in the array
   */
function binarysearch(arr,target){
    var start=0,end=arr.length-1,mid=0;

    //if the array only has one element
    if(start===end){
      if(target===arr[start])
        return 0;   
    }
   //normal situation
    while(start<end){
      //find the mid point
    mid=parseInt((start+end)/2);
    //check whether the target belongs to left side
       if(target<arr[mid]){
         end=mid;
       }
       //check whether the target belongs to right side
       if(target>arr[mid]){
         start=mid+1;
       }
       //catch the position of target
        if(target===arr[mid]){
        return mid;
       }
     }  
     console.log("this number is not exist");
     return -1;
 }
 
 
 //test the output of this function
 //this array must be sequential 
 /** @test {binarysearch} */
 var testArray=[1,3,5,7,9,30,58,99];
 console.log("the index of the target number is: "+binarysearch(testArray,1));
 