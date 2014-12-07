/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {

    $("#searchLink").click(function () {
        var search = $("#searchContent").val();
        if (search === null || search.length === 0) {
            alert("请输入搜索条件");
            return false;
        }
        else {
            //BaiduSearch
            $(this).prop("href", "http://zhannei.baidu.com/cse/search?s=802091570132742987&entry=1&q=" + search);
            //GooleSearch
            //$(this).prop("href", "/WJS-war/faces/search.xhtml?q=" + search);
        }
    });

    $("#toDoPrevImg").click(function () {
        $("#toDoList ul").append($("#toDoList ul li:first"));
    });

    $("#toDoNextImg").click(function () {
        $("#toDoList ul li:last").insertBefore($("#toDoList ul li:first"));
    });

    //指定PanelList高度
    $(document.getElementById("formNotice:topNoticeList_content")).addClass("topListContent");
    $(document.getElementById("formKB:topKBList_content")).addClass("topListContent");
    $(document.getElementById("formContent:topSupervisionList_content")).addClass("topListContent");
    $(document.getElementById("formContent:topLicenseList_content")).addClass("topListContentNoRightBorder");
    $(document.getElementById("formContent:topInspectionList_content")).addClass("topListContent");
    $(document.getElementById("formContent:topPunishmentList_content")).addClass("topListContent");

//    $(document.getElementById("formContentList:topContentList1_content")).addClass("topListContentNoRightBorder");
//    $(document.getElementById("formContentList:topContentList2_content")).addClass("topListContentNoRightBorder");
//    $(document.getElementById("formContentList:topContentList3_content")).addClass("topListContentNoRightBorder");
//    $(document.getElementById("formContentList:topContentList4_content")).addClass("topListContent");
//    $(document.getElementById("formContentList:topContentList5_content")).addClass("topListContentNoRightBorder");
    $(document.getElementById("formContentList:topContentList6_content")).addClass("topListContentNoRightBorder");
    $(document.getElementById("formContentList:topContentList7_content")).addClass("topListContentNoRightBorder");


    $("#topNavMenu li.menu").hover(function () {
        $(this).parent(0).find(".menu div").removeClass("menuDropdownShow").addClass("menuDropdownHide");
        $(this).find("div").removeClass("menuDropdownHide").addClass("menuDropdownShow");
        $(this).find("div").mouseleave(function () {
            $(this).removeClass("menuDropdownShow");
            $(this).addClass("menuDropdownHide");
        });
    }, function () {

    });

    $("#publicLink").hover(function () {
        $("#licenseLink").removeClass("selected").addClass("unselected");
        $("#publicLink").removeClass("unselected").addClass("selected");
    }, function () {

    });

    $("#licenseLink").hover(function () {
        $("#publicLink").removeClass("selected").addClass("unselected");
        $("#licenseLink").removeClass("unselected").addClass("selected");
    }, function () {

    });

    $("#inspectionLink").hover(function () {
        $("#punishmentLink").removeClass("selected").addClass("unselected");
        $("#inspectionLink").removeClass("unselected").addClass("selected");
        $(document.getElementById("formContent:topPunishmentList")).addClass("nodisplay");
        $(document.getElementById("formContent:topInspectionList")).removeClass("nodisplay");
    }, function () {

    });

    $("#punishmentLink").hover(function () {
        $("#inspectionLink").removeClass("selected").addClass("unselected");
        $("#punishmentLink").removeClass("unselected").addClass("selected");
        $(document.getElementById("formContent:topInspectionList")).addClass("nodisplay");
        $(document.getElementById("formContent:topPunishmentList")).removeClass("nodisplay");
    }, function () {

    });

    //重新设定列表字符串长度，避免浏览器兼容问题引起的CSS失效
    $(document.getElementById("formContent:topSupervisionList_list")).find("li.ui-datalist-item a").each(function () {
        if ($(this).html().length > 20) {
            var html = $(this).html().substr(0, 20) + "...";
            $(this).html(html);
        }

    });

    //底部链接样式切换
    $("#bottomLinkTitle1").mouseover(function () {
        $(this).parent(0).find("li").removeClass("selected").addClass("unselected");
        $(this).parent(0).find("li a").removeClass("selected").addClass("unselected");
        $(this).find("a").removeClass("unselected").addClass("selected");
        $(this).removeClass("unselected").addClass("selected");
        $("#bottomLink2").removeClass("selected").addClass("unselected");
        $("#bottomLink1").removeClass("unselected").addClass("selected");

    });

    //底部链接样式切换
    $("#bottomLinkTitle2").mouseover(function () {
        $(this).parent(0).find("li").removeClass("selected").addClass("unselected");
        $(this).parent(0).find("li a").removeClass("selected").addClass("unselected");
        $(this).find("a").removeClass("unselected").addClass("selected");
        $(this).removeClass("unselected").addClass("selected");
        $("#bottomLink1").removeClass("selected").addClass("unselected");
        $("#bottomLink2").removeClass("unselected").addClass("selected");
    });

    publish(3000);

    $("#add1").hover(function () {
        showMap($(this).attr("id"));
    });

    $("#add2").hover(function () {
        showMap($(this).attr("id"));
    });

    $("#add3").hover(function () {
        showMap($(this).attr("id"));
    });

    $("#add4").hover(function () {
        showMap($(this).attr("id"));
    });
    
    $("#addmap img").click(function () {
        $("#addmap").removeClass("display").addClass("nodisplay");
    }).hover(function () {
    }, function () {
        $("#addmap").removeClass("display").addClass("nodisplay");
    });

});

function publish(t) {

    $(".publish ul").append($(".publish ul li:first"));
    setTimeout("publish(" + t + ")", t);

}

//投诉举报提交成功后屏蔽表单
function submitComplaint() {
    $(".newComplaint").addClass("nodisplay");
    $("#afterSubmitComplaint").removeClass("nodisplay");
}

function showMap(address) {
    //alert(address);
    $("#addmap").removeClass("nodisplay").addClass("display");
    $("#addmap img").attr("src", "resources/img/" + address + ".png");
}

