/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function () {
    $('div img').click(function () {
        showImg($(this).attr('src'));
    });
    $('a.shutdown').click(function () {
        $('#showImg').addClass('nodisplay');
    }
    );
})

function showImg(src) {
    //alert(src);
    $('#imgDetail').attr('src', src);
    $('#showImg').removeClass('nodisplay');

}


