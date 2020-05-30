"use strict";
/**
 * @author Francesc Roca
 * @returns {undefined}
 * Funció que torna a la pàgina anterior.
 */
function returnToPreviousPage() {
    window.history.back();
}

/**
 * @author Francesc Roca
 * @param {type} e
 * @returns {undefined}
 * Funció per comprovar els camps del formulari són correctes, si no, evitem que es pugui enviar el formulari.
 */
function formulariConfiguracio(){
    console.log("He entrat!");
    console.log(document.getElementById('codisMin').value);
    var codisMin = document.getElementById('codisMin').value;
    var alumnesAula = document.getElementById("alumnesAula").value;
    var direccioCorreu = document.getElementById("direccioCorreu").value;
    var contrasenyaCorreu = document.getElementById("contrasenyaCorreu").value;
    var correuEnviaCodis = document.getElementById("correuEnviaCodis").value;
    var correuEnviaAlertaCodis = document.getElementById("correuEnviaAlertaCodis").value;
    
    if(isNaN(codisMin) || codisMin < 0){
        alert("Els codis mínims no són correctes.");
        returnToPreviousPage();
        return false;
    }
    
    if(isNaN(alumnesAula) || alumnesAula < 0){
        alert("La quantitat d'alumnes no és correcte.");
        returnToPreviousPage();
        return false;
    }
    
    if(!validateEmail(direccioCorreu)){
        alert("El correu escrit no és correcte.");
        returnToPreviousPage();
        return false;
    }
    
    return true; 
}

/**
 * @author Francesc Roca
 * @param {type} email
 * @returns {Boolean}
 * Funció que retorna true o false depent de si el correu inserit és correcte o no.
 */
function validateEmail(email) {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}