"use strict";

/**
 * @author Sergio Fernandez
 * @author Francesc Roca
 * @param {type} e
 * @returns {undefined}
 * Funció per comprovar els camps del formulari són correctes, si no, evitem que es pugui enviar el formulari
 */
function formulariConfiguracio(e){
    console.log("He entrat!");
    var codisMin = document.getElementById("codisMin").value();
    var alumnesAula = document.getElementById("alumnesAula").value;
    var direccioCorreu = document.getElementById("direccioCorreu").value;
    var contrasenyaCorreu = document.getElementById("contrasenyaCorreu").value;
    var correuEnviaCodis = document.getElementById("correuEnviaCodis").value;
    var correuEnviaAlertaCodis = document.getElementById("correuEnviaAlertaCodis").value;
    
    if(isNaN(codisMin) || codisMin < 0){
        console.log("No pot ser!");
        e.preventDefault();
    }
    
    if(isNaN(alumnesAula) || alumnesAula < 0){
        e.preventDefault();
    }
    
    if(!validateEmail(direccioCorreu)){
        e.preventDefault();
    }
    
    
    
    
    //PER EVITAR QUE REALITZI EL SUBMIT
    //e.preventDefault();
}

function validateEmail(email) {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}