/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function() {
    //图片滑动
    $("#slides").slidesjs({
        width: 345,
        height: 252,
        start: 1, //控制从第几张图开始播放
        //控制前后按钮 
        navigation: {
            active: false, //是否开启左右按钮
            effect: "fade"//触发按钮时，焦点图切换的特效，可选参数"slide"和"fade"
        },
        //控制播放效果
        play: {
            active: false,
            effect: "slide",
            interval: 5000,
            auto: true,
            swap: true,
            pauseOnHover: true,
            restartDelay: 2500
        }
    });
});