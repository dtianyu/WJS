/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function() {
    display();
});

function display() {
    var content = $("#detailContent").val();
    $(document.getElementById("formDetail:contentDetail")).html(content);
}

