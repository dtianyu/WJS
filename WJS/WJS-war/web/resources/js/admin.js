/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function() {


//    $("#container").addClass("topHeight");

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

});


