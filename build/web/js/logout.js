/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function () {

     $("#logout").on("click", function () {
        cerrarSesion();
    });
});
function cerrarSesion() {
    swal({
        title: "Correcto",
        text: "Sesion cerrada correctamente",
        icon: "success",
        buttons: false
    }).then(setTimeout(function () {
        window.location = "Logout";
    }, 2000));
}