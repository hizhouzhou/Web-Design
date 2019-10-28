
// crop funtion
window.onload = function() {
    document.onselectstart=new Function('event.returnValue=false;');
  
    //show or hide the clipline
    var bottom=document.getElementById("crop_image_bottom");
    var cropLine = document.getElementById("cropLine");
    var btn=document.getElementById("btn");
     bottom.addEventListener('click',function(){
           display();
        });

    function display(){
            if(cropLine.style.display=="none"){
                cropLine.style.display='block';
                setChoice();
                btn.style.color="white";
                btn.style.backgroundColor="darkorange";
                btn.innerText="Finish!";
            }else{
                cropLine.style.display='none';
                var cropimg2 = document.getElementById("img2");
                cropimg2.style.clip = "rect(0px,0px,0px,0px)";
                btn.style.color="black";
                btn.style.backgroundColor="white";
                btn.innerText="Click here to crop!";
            }
            return false;
        }
   
    //--------------------------------------------------------------------------------------------------------------------
    
    // 获取裁剪框移动范围
    // Get the clipping range of the crop frame
    var cropimgElem = document.getElementById("img1");
    var cropimgElemWidth = cropimgElem.clientWidth;
    var cropimgElemHeight = cropimgElem.clientHeight;
    var cropimgElemPosition = getPosition(cropimgElem);
    var minX = cropimgElemPosition.left;// 待裁剪的图片最小x坐标 Minimum x coordinate of the image to be cropped
    var maxX = cropimgElemPosition.left + cropimgElemWidth;// Maximum x coordinate of the image to be cropped
    var minY = cropimgElemPosition.top;// 待裁剪的图片最小y坐标 Minimum y coordinate of the image to be cropped
    var maxY = cropimgElemPosition.top + cropimgElemHeight;// 待裁剪的图片最大y坐标 Maximum y coordinate of the image to be cropped
    
    // Set the width and height of the parent control dynamically
    var cropBox = document.getElementById("cropBox");
    cropBox.style.width = cropimgElemWidth + "px";
    cropBox.style.height = cropimgElemHeight + "px";

    
    // 裁剪框内相关元素 Crop related elements in the box
    var cropLine = document.getElementById("cropLine");// 裁剪框 
    var rightElem = document.getElementById("right");
    var upElem = document.getElementById("up");
    var leftElem = document.getElementById("left");
    var downElem = document.getElementById("down");
    var leftUpElem = document.getElementById("left-up");
    var rightUpElem = document.getElementById("right-up");
    var leftDownElem = document.getElementById("left-down");
    var rightDownElem = document.getElementById("right-down");
    
    var ifKeyDown = false;// 鼠标按下事件
    var contact = "";// 表示被按下触点 the position of the evnet occur

    // 鼠标按下事件
    rightElem.addEventListener("mousedown",right);
    upElem.addEventListener("mousedown",up);
    downElem.addEventListener("mousedown",down);
    leftElem.addEventListener("mousedown",left);
    leftUpElem.addEventListener("mousedown",leftup);
    rightUpElem.addEventListener("mousedown",rightup);
    leftDownElem.addEventListener("mousedown",leftdown);
    rightDownElem.addEventListener("mousedown",rightdown);

    function right(e){
        e.stopPropagation();
        ifKeyDown = true;
        contact = "right";
    }
    function left(e){
        e.stopPropagation();
        ifKeyDown = true;
        contact = "left";
    }
    function up(e){
        e.stopPropagation();
        ifKeyDown = true;
        contact = "up";
    }
    function down(e){
        e.stopPropagation();
        ifKeyDown = true;
        contact = "down";
    }
    function leftup(e){
        e.stopPropagation();
        ifKeyDown = true;
        contact = "left-up";
    }
    function leftdown(e){
        e.stopPropagation();
        ifKeyDown = true;
        contact = "left-down";
    }
    function rightup(e){
        e.stopPropagation();
        ifKeyDown = true;
        contact = "right-up";
    }
    function rightdown(e){
        e.stopPropagation();
        ifKeyDown = true;
        contact = "right-down";
    }
   
    // 鼠标松开事件 mouse up event 
    window.addEventListener("mouseup",myMouseUp);
    function myMouseUp(e) {
        ifKeyDown = false;
        contact = "";
         setPreview();
    };

    // 鼠标移动事件 mouse move event 
    window.addEventListener("mousemove",myMouseMove);
    function myMouseMove(e){
        e.stopPropagation();
        if (ifKeyDown == true) {
            switch (contact) {
                case "right":
                    rightMove(e);
                    break;
                case "up":
                    upMove(e);
                    break;
                case "left":
                    leftMove(e);
                    break;
                case "down":
                    downMove(e);
                    break;
                case "left-up":
                    leftMove(e);
                    upMove(e);
                    break;
                case "right-up":
                    rightMove(e);
                    upMove(e);
                    break;
                case "left-down":
                    leftMove(e);
                    downMove(e);
                    break;
                case "right-down":
                    rightMove(e);
                    downMove(e);
                    break;
                default:
                    break;
            }
            setChoice();
        }
    }

    
    setChoice();// 初始化选择区域可见
    
    // 右边移动
    function rightMove(e) {
        var x = e.clientX;// 鼠标x坐标
//      if(x > getPosition(cropimgElem).left + cropimgElem.offsetWidth){
//          x = getPosition(cropimgElem).left + cropimgElem.offsetWidth;
//      }
        if (x > maxX || x < minX) {
            return;
        }
        var widthBefore = cropLine.offsetWidth -2;// 裁剪框变化前的宽度
        var addWidth = x - getPosition(cropLine).left - widthBefore;// 鼠标移动后，裁剪框增加的宽度
        var width = widthBefore + addWidth;
        if (width < 1) {
            return;
        }
        cropLine.style.width = width + "px";// 裁剪框变化后，设置宽度
    };

    // 上边移动
    function upMove(e) {
        var y = e.clientY;// 鼠标y坐标
//      if(y < getPosition(cropimgElem).top){
//          y = getPosition(cropimgElem).top;
//      }
        if (y > maxY || y < minY) {
            return;
        }
        var mainY = getPosition(cropLine).top;// 裁剪框相对于屏幕上边的距离
        var addHeight = mainY - y;// 增加的高度
        var heightBefore = cropLine.offsetHeight - 2;// 裁剪框变化前的高度
        var height = heightBefore + addHeight;
        if (height < 1) {
            return;
        }
        cropLine.style.height = height + "px";// 裁剪框变化后，设置高度
        cropLine.style.top = cropLine.offsetTop - addHeight + "px";// 裁剪框相对于父控件的距离
    };

    // 左边移动
    function leftMove(e) {
        var x = e.clientX;// 鼠标x坐标
        if (x > maxX || x < minX) {
            return;
        }
        var mainX = getPosition(cropLine).left;
        var widthBefore = cropLine.offsetWidth -2;// 裁剪框变化前的宽度
        var addWidth = mainX - x;// 鼠标移动后，裁剪框增加的宽度
        var width = widthBefore + addWidth;
        if (width < 1) {
            return;
        }
        cropLine.style.width = width + "px";// 裁剪框变化后，设置宽度
        cropLine.style.left = cropLine.offsetLeft - addWidth + "px";// 裁剪框变化后，设置到父元素左边的距离
    };

    // 下边移动
    function downMove(e) {
        var y = e.clientY;// 鼠标y坐标
        if (y > maxY || y < minY) {
            return;
        }
        var heightBefore = cropLine.offsetHeight - 2;// 裁剪框变化前的高度
        var mainY = getPosition(cropLine).top;// 裁剪框相对于屏幕上边的距离
        var addHeight = y - heightBefore - mainY;// 增加的高度
        var height = heightBefore + addHeight;
        if (height < 1) {
            return;
        }
        cropLine.style.height = height + "px";// 裁剪框变化后，设置高度
    };
    
    // 设置裁剪框的位置 Set the position of crop line
    function setChoice() {
        var top = cropLine.offsetTop;
        var right = cropLine.offsetLeft + cropLine.offsetWidth;
        var bottom = cropLine.offsetTop + cropLine.offsetHeight;
        var left = cropLine.offsetLeft;
        var cropimg2 = document.getElementById("img2");
        cropimg2.style.clip = "rect(" + top + "px, " + right + "px, " + bottom + "px, " + left + "px)";
        //ensure the position of clipline is the same as img2.
    
        setPreview();
    };
    
    // 预览函数 preview function 
    function setPreview() {
        var top = cropLine.offsetTop*3/4;
        var right = cropLine.offsetLeft*3/4 + cropLine.offsetWidth*3/4;
        var bottom = cropLine.offsetTop*3/4 + cropLine.offsetHeight*3/4;
        var left = cropLine.offsetLeft*3/4;
        var previewImg = document.getElementById("cropimg3");
        previewImg.style.clip = "rect(" + top + "px, " + right + "px, " + bottom + "px, " + left + "px)";
    }
    
};



// 获取元素相对于屏幕左边的距离 offsetLeft，offsetTop
function getPosition(node) {
    var left = node.offsetLeft;
    var top = node.offsetTop;
    var parent = node.offsetParent;
    while (parent != null) {
        left += parent.offsetLeft;
        top += parent.offsetTop;
        parent = parent.offsetParent;
    }
    return {"left":left,"top":top};
};

//remove the eventlistener when the page unload
window.onunload=function(){
    // display part
    var bottom=document.getElementById("crop_image_bottom");
    bottom.removeEventListener("click",display);

    //mousedown part
    var rightElem = document.getElementById("right");
    var upElem = document.getElementById("up");
    var leftElem = document.getElementById("left");
    var downElem = document.getElementById("down");
    var leftUpElem = document.getElementById("left-up");
    var rightUpElem = document.getElementById("right-up");
    var leftDownElem = document.getElementById("left-down");
    var rightDownElem = document.getElementById("right-down");

    rightElem.removeEventListener("mousedown",right);
    upElem.removeEventListener("mousedown",up);
    downElem.removeEventListener("mousedown",down);
    leftElem.removeEventListener("mousedown",left);
    leftUpElem.removeEventListener("mousedown",leftup);
    rightUpElem.removeEventListener("mousedown",rightup);
    leftDownElem.removeEventListener("mousedown",leftdown);
    rightDownElem.removeEventListener("mousedown",rightdown);

    //mouseup part
    window.removeEventListener("mouseup",myMouseUp);

    //mousemove part
    window.removeEventListener("mousemove",myMouseMove);
}
