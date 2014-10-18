/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function() {

    $("#topInfo").addClass("nodisplay");
    
    $("#searchLink").click(function () {
        var search = $("#searchContent").val();
        if (search === null || search.length === 0) {
            alert("请输入搜索条件");
            return false;
        }
        else {
            baiduSearch(search);
            //GooleSearch
            //$(this).prop("href", "/WJS-war/faces/search.xhtml?q=" + search);

        }
    });
    
    $("#toDoPrevImg").click(function() {
        $("#toDoList ul").append($("#toDoList ul li:first"));
    });
    $("#toDoNextImg").click(function() {
        $("#toDoList ul li:last").insertBefore($("#toDoList ul li:first"));
    });
    $(document.getElementById("formNotice:topNoticeList_content")).addClass("topListContent");
    $(document.getElementById("formKB:topKBList_content")).addClass("topListContent");
    $(document.getElementById("formRight:topSupervisionList_content")).addClass("topListContent");
    $(document.getElementById("formContent:topContentList1_content")).addClass("topListContent");
    $(document.getElementById("formContent:topContentList2_content")).addClass("topListContent");
    $(document.getElementById("formContent:topContentList3_content")).addClass("topListContent");

    $("#topNavMenu li.menu").hover(function() {
        $(this).parent(0).find(".menu div").removeClass("menuDropdownShow").addClass("menuDropdownHide");
        $(this).find("div").removeClass("menuDropdownHide").addClass("menuDropdownShow");
        $(this).find("div").mouseleave(function() {
            $(this).removeClass("menuDropdownShow");
            $(this).addClass("menuDropdownHide");
        });
    }, function() {

    });

    $("#leftNavMenu li.menu").hover(function() {
        $("#active").removeClass("menuActive").addClass("menu");
        $(this).parent(0).find("li").removeClass("menuActive").addClass("menu");
        $(this).removeClass("menu").addClass("menuActive");
    }, function() {
        $(this).removeClass("menuActive").addClass("menu");
        $("#active").removeClass("menu").addClass("menuActive");
    });

    $(".leftNavMenu li.inactive").hover(function() {
        $(".leftNavMenu #active").removeClass("active").addClass("inactive");
        $(this).parent(0).find("li").removeClass("active").addClass("inactive");
        $(this).removeClass("inactive").addClass("active");
    }, function() {
        $(this).removeClass("active").addClass("inactive");
        $(".leftNavMenu #active").removeClass("inactive").addClass("active");
    });

    //重新设定列表字符串长度，避免浏览器兼容问题引起的CSS失效
    $(document.getElementById("formContent:topSupervisionList_list")).find("li.ui-datalist-item a").each(function() {
        if ($(this).html().length > 28) {
            var html = $(this).html().substr(0, 22);
            $(this).html(html);
        }
        ;
    });

    $("#bottomLinkTitle1").mouseover(function() {
        $(this).parent(0).find("li").removeClass("selected").addClass("unselected");
        $(this).parent(0).find("li a").removeClass("selected").addClass("unselected");
        $(this).find("a").removeClass("unselected").addClass("selected");
        $(this).removeClass("unselected").addClass("selected");
        $("#bottomLink2").removeClass("selected").addClass("unselected");
        $("#bottomLink1").removeClass("unselected").addClass("selected");

    });

    $("#bottomLinkTitle2").mouseover(function() {
        $(this).parent(0).find("li").removeClass("selected").addClass("unselected");
        $(this).parent(0).find("li a").removeClass("selected").addClass("unselected");
        $(this).find("a").removeClass("unselected").addClass("selected");
        $(this).removeClass("unselected").addClass("selected");
        $("#bottomLink1").removeClass("selected").addClass("unselected");
        $("#bottomLink2").removeClass("unselected").addClass("selected");
    });

    publish(3000);
//    alert('321');

});

function baiduSearch(word) {
    var link = "http://www.baidu.com/s?si=www.jswjs.com.cn&cl=3&ct=2097152&tn=baidulocal&word=" + word;
    window.open(link);
}

function publish(t) {

    $(".publish ul").append($(".publish ul li:first"));
    setTimeout("publish(" + t + ")", t);

}