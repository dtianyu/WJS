/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function () {

    //左侧菜单动态样式
    var doc = $(document.getElementById("formLeft:kindList_content"));
    doc.removeClass("ui-widget-content");
    doc.find("ul").removeClass("ui-datalist-data").addClass("leftNavMenu");
    doc.find("ul li").removeClass("ui-datalist-item").addClass("inactive");
    doc.find("ul li:first").removeClass("inactive").addClass("active");

    $(".leftNavMenu li").hover(function () {
        $(".leftNavMenu li").removeClass("active").addClass("inactive");
        $(this).removeClass("inactive").addClass("active");
    });
    
    var p = getUrlParam('kind');
    if (p!==null){
        $(".leftNavMenu li a").each(function(){
            var href = $(this).attr('href');
            if (href.slice(href.length - 1 ,href.lenght)===p){
                $(this).parent(0).parent(0).find('li').removeClass("active").addClass("inactive");
                $(this).parent(0).removeClass("inactive").addClass("active");
            }
        });        
    }
});

//获取Url参数值
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var para = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (para !== null) {
        return unescape(para[2]);
    }
    return null; //返回参数值
}