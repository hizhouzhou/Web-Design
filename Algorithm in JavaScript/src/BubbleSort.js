//reference: https://baike.baidu.com/item/冒泡排序/4602306?fromtitle=Bubble%20Sort&fromid=11353208&fr=aladdin

/**
   * @param {object} arr -  implement the bubblesort algorithm for this array
   */
//ascending order
function bubblesort(arr){
    var arr,len=arr.length-1,temp;
    //define the times that we should compare for the whole array)
  for(let j=0;j<len;j++){
    //compare all the element in array
    for(let i=0;i<len-j;i++){
//if the right element smaller than the left element, change their position
      if(arr[i+1]<arr[i]){
          temp=arr[i];
          arr[i]= arr[i+1];
          arr[i+1]=temp;
      }
    }
  }
  return arr;
  }

  /**
   * @param {object} arr -  implement the bubblesort algorithm for this array
   */
  //descending order
  function bubblesortDes(arr){
    var arr,len=arr.length-1,temp;
    //define the times that we should compare for the whole array)
  for(let j=0;j<len;j++){
    //compare all the element in array
    for(let i=0;i<len-j;i++){
      if(arr[i+1]>arr[i]){
          temp=arr[i];
          arr[i]= arr[i+1];
          arr[i+1]=temp;
      }
    }
  }
  return arr;
  }
  
   //test the output of this function
   /** @test {bubblesort} */
   /** @test {bubblesortDes} */
  var testArray=[45, 32, 8, 33, 12, 22, 19,2, 97];
  console.log("The right sort of testArray is （ascending order）: " +bubblesort(testArray));
  console.log("The right sort of testArray is （desscending order）: " +bubblesortDes(testArray));