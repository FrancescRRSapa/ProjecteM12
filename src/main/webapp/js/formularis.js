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
    //lletra dni
    var posicio = nif.value.substring(0,8) % 23;
    var lletra = LLETRES.substring(posicio, posicio+1);
    if(nif.value.substring(8).toUpperCase() != lletra){
        e.preventDefault();
    }
    //edat
    var avui = new Date();
    var dataNaixement = new Date(dNaixement.value);
    var edat = avui.getFullYear() - dataNaixement.getFullYear();
    var mes = avui.getMonth() - dataNaixement.getMonth();
    if(mes < 0 || (mes == 0 && avui.getDate() < dataNaixement.getDate())){
        edat--;
    }
    if(edat < 15){
        e.preventDefault();
    }
    //alergies
    if(alergies.disabled == false && alergies.value != ""){
        e.preventDefault();
    }
    //matricula
    if(matricula.disabled == false){
        var reg_ex = new RegExp("[0-9]{4}-[A-Z]{3}|[A-Z]{1,2}-[1-9]{4}-[A-Z]{2}");
        if(!(reg_ex.test(matricula.value))){
            e.preventDefault();
        }
    }
    //targeta de credit 
    card = card0.value + card1.value + card2.value + card3.value;
    if(visa.checked){
        if(!card.match(/^4\d{3}-?\d{4}-?\d{4}-?\d{4}$/)){
            e.preventDefault();
        }
    }else if(mastercard.checked){
        if(!mastercard.match(/^5[1-5]\d{2}-?\d{4}-?\d{4}-?\d{4}$/)){
            e.preventDefault();
        }
    }
}