"use strict";
/**
 * @author Francesc Roca
 * @author Sergio Fernandez
 * @param {type} e
 * @returns {undefined}
 * Funció per comprovar els camps del formulari són correctes, si no, evitem que es pugui enviar el formulari.
 */
function formulariConfiguracio(){
    var codisMin = document.getElementById('codisMin').value;
    var alumnesAula = document.getElementById("alumnesAula").value;
    var direccioCorreu = document.getElementById("direccioCorreu").value;
    var contrasenyaCorreu = document.getElementById("contrasenyaCorreu").value;
    var correuEnviaCodis = document.getElementById("correuEnviaCodis").value;
    var correuEnviaAlertaCodis = document.getElementById("correuEnviaAlertaCodis").value;
    
    if(isNaN(codisMin) || codisMin < 0){
        alert("Els codis mínims no són correctes.");
        location.reload();
        return false;
    }
    
    if(isNaN(alumnesAula) || alumnesAula < 0){
        alert("La quantitat d'alumnes no és correcte.");
       location.reload();
        return false;
    }
    
    if(!validateEmail(direccioCorreu)){
        alert("El correu escrit no és correcte.");
        location.reload();
        return false;
    }
    
    return true; 
}

/**
 * Funció per validar el correu
 * @author Francesc Roca
 * @author Sergio Fernández
 * @param {type} e
 * @returns {Boolean}
 */
function validarCorreuCodisAdmin(){
    var direccioCorreu = document.getElementById("direccioCorreu").value;
    if(!validateEmail(direccioCorreu)){
        alert("El correu escrit no és correcte.");
        location.reload();
        return false;
    }
}

/**
 * @author Francesc Roca
 * @author Sergio Fernandez
 * @param {type} email
 * @returns {Boolean}
 * Funció que retorna true o false depent de si el correu inserit és correcte o no.
 */
function validateEmail(email) {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}