"use strict";

/*************************************************
* EN AQUEST APARTAT POTS AFEGIR O MODIFICAR CODI *
*************************************************/

///////////////////////////////////////////////////////////
// ALUMNE: Sergio Fernández Aguilera
///////////////////////////////////////////////////////////

/********** ESDEVENIMENTS DELS BOTONS DE LES DADES DELS ARTICLES **********/

// Botó Afegir:
//	afegeix les dades de l'article en una línia nova (just abans del total)
//	afegeix les icones de les accions (editar, pujar, baixar i esborrar) en l'última columna
//	afegeix a cada icona el gestor de ''esdeveniment corresponent
//	la casella on van les icones ha de ser de classe "nonprintable"
//	recalcula l'import total dels articles i actualitza la fila del total dels articles
//	buida les dades de l'article que s'estava modificant
//	posa el focus en el camp "codi"
function afegir() {
	if(codi.value == "" || codi.value < 0 || !codi.value.match(/^[0-9]+$/)){
		alert("No és un codi correcte");
		return;
	}else if(unitats.value == "" || unitats.value < 1){
		alert("No és una unitat correcte");
		return;
	//és considera que el preu pot ser 0€ per els regals
	}else if(preu.value == "" || preu.value < 0){
		alert("No és un preu correcte");
		return;
	}
	//Seleccionem la taula
	var table = document.querySelector("table");
	//última fila de la taula (Total articles)
	var ultimaFila = table.lastElementChild;
	//nova fila
	var row = document.createElement("tr");
	//celes de la fila nova
	var cell1 = document.createElement("td");
	var cell2 = document.createElement("td");
	var cell3 = document.createElement("td");
	var cell4 = document.createElement("td");
	var cell5 = document.createElement("td");
	var cell6 = document.createElement("td");
	//afegim les celes a la fila
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	row.appendChild(cell4);
	row.appendChild(cell5);
	row.appendChild(cell6);
	//textos de cada camp
	var text1 = document.createTextNode(codi.value);
	var text2 = document.createTextNode(descripcio.value);
	var text3 = document.createTextNode(Number(unitats.value).toLocaleString('en-US',{minimumFractionDigits: 1, maximumFractionDigits: 1}));
	var text4 = document.createTextNode(Number(preu.value).toLocaleString('en-US',{minimumFractionDigits: 2, maximumFractionDigits: 2}));
	var text5 = document.createTextNode(Number(preu.value * unitats.value).toLocaleString('en-US',{minimumFractionDigits: 2, maximumFractionDigits: 2}));
	//icones que afegim a la última cela i el event de cadascuna
	var icon1 = document.createElement("img");
	icon1.src = "edit.svg";
	icon1.width = 16;
	icon1.height = 16;
	icon1.addEventListener("click", editar);
	var icon2 = document.createElement("img");
	icon2.src = "prev.svg";
	icon2.width = 16;
	icon2.height = 16;
	icon2.addEventListener("click", pujar);
	var icon3 = document.createElement("img");
	icon3.src = "next.svg";
	icon3.width = 16;
	icon3.height = 16;
	icon3.addEventListener("click", baixar);
	var icon4 = document.createElement("img");
	icon4.src = "delete.svg";
	icon4.width = 16;
	icon4.height = 16;
	icon4.addEventListener("click", esborrar);
	//afegim els textos i les icones a les files on ho necessitem
	cell1.appendChild(text1);
	cell2.appendChild(text2);
	cell3.appendChild(text3);
	cell4.appendChild(text4);
	cell5.appendChild(text5);
	cell6.appendChild(icon1);
	cell6.appendChild(icon2);
	cell6.appendChild(icon3);
	cell6.appendChild(icon4);
	//la columna de les icones no s'ha d'imprimir per tant l'afegim a la clase no printable
	cell6.setAttribute("class","nonprintable");
	//insertem la fila a sobre de l'última (totalArticles)
	table.insertBefore(row, ultimaFila);
	//Selecciona el camp del total de articles
	var actual = Number(ultimaFila.lastElementChild.lastElementChild.textContent);
	ultimaFila.lastElementChild.lastElementChild.textContent = Number(actual + preu.value * unitats.value).toLocaleString('en-US',{minimumFractionDigits: 2, maximumFractionDigits: 2});
	//Buidar camps i focus al camp codi
	codi.value = "";
	descripcio.value = "";
	unitats.value = "";
	preu.value = "";
	codi.focus();
}
//variable on és registra la fila del formulari seleccionada
var fila;
// Botó Modificar:
//	actualitza les dades de l'article en la fila corresponent de la taula
//	recalcula l'import total dels articles per si s'ha modificat la unitats o el preu per unitat
//	buida les dades de l'article que s'estava modificant
//	mostra el botó Afegir i amaga els botons Modificar i Cancel·lar
//	posa el focus en el camp "codi"
function modificar() {
	//actualitzar les dades a la taula
	fila.firstElementChild.textContent = codi.value;
	fila.firstElementChild.nextElementSibling.textContent = descripcio.value;
	var unitatAntiga = fila.firstElementChild.nextElementSibling.nextElementSibling.textContent;
	fila.firstElementChild.nextElementSibling.nextElementSibling.textContent = Number(unitats.value).toLocaleString('en-US',{minimumFractionDigits: 1, maximumFractionDigits: 1});
	var preuAntic = fila.firstElementChild.nextElementSibling.nextElementSibling.nextElementSibling.textContent;
	fila.firstElementChild.nextElementSibling.nextElementSibling.nextElementSibling.textContent = Number(preu.value).toLocaleString('en-US',{minimumFractionDigits: 2, maximumFractionDigits: 2});
	//recalcula l'import total dels articles
	fila.firstElementChild.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.textContent = Number(preu.value * unitats.value).toLocaleString('en-US',{minimumFractionDigits: 2, maximumFractionDigits: 2});
	var actual = Number(document.querySelector("table").lastElementChild.lastElementChild.lastElementChild.textContent);
	document.querySelector("table").lastElementChild.lastElementChild.lastElementChild.textContent = actual = actual - unitatAntiga * preuAntic;
	document.querySelector("table").lastElementChild.lastElementChild.lastElementChild.textContent = Number(actual + preu.value * unitats.value).toLocaleString('en-US',{minimumFractionDigits: 2, maximumFractionDigits: 2});
	//buidar les dades de l'article
	codi.value = "";
	descripcio.value = "";
	unitats.value = "";
	preu.value = "";
	//Amagem el botó modificar, cancel·lar i mostrem afegir
	document.getElementById('modificar').style = "display:none";
	document.getElementById('cancelar').style = "display:none";
	document.getElementById('afegir').style = "display:block";
	//focus al codi
	codi.focus();
}

// Botó Cancel·lar:
//	buida les dades de l'article que s'estava modificant
//	mostra el botó Afegir i amaga els botons Modificar i Cancel·lar
//	posa el focus en el camp "codi"
function cancelar() {
	//buidar les dades de l'article
	codi.value = "";
	descripcio.value = "";
	unitats.value = "";
	preu.value = "";
	//Amagem el botó modificar, cancel·lar i mostrem afegir
	document.getElementById('modificar').style = "display:none";
	document.getElementById('cancelar').style = "display:none";
	document.getElementById('afegir').style = "display:block";
	//focus al codi
	codi.focus();
}

/********** ESDEVENIMENTS DELS BOTONS (ICONES) DE LES ACCIONS EN CADA FILA **********/

// Botó Editar (icona):
//	copia les dades de la fila en l'apartat d'edició de les dades de l'article
//	mostra els botons Modificar i Cancel·lar
//	amaga el botó Afegir
//	posa el focus en el camp "codi"
function editar(ev) {
	//recerquem la posició de tr
	for(var i = 0; i < ev.path.length; i++){
		if(ev.path[i].localName == "tr"){
			fila = ev.path[i];
			break;
		}
	}
	//copia dels elements de la fila a el formulari inicial
	codi.value = fila.firstElementChild.textContent;
	descripcio.value = fila.firstElementChild.nextElementSibling.textContent;
	unitats.value = fila.firstElementChild.nextElementSibling.nextElementSibling.textContent;
	preu.value = fila.firstElementChild.nextElementSibling.nextElementSibling.nextElementSibling.textContent;
	//Mostrar botons Modificar i Cancel·lar
	document.getElementById('modificar').style = "display:block";
	document.getElementById('cancelar').style = "display:block";
	document.getElementById('afegir').style = "display:none";
	//focus al codi
	codi.focus();
}

// Botó Pujar (icona):
//	intercanvia la línia de la taula amb la línia de sobre (si no és la primera línia)
function pujar(ev) {
	var filaPujar;
	for(var i = 0; i < ev.path.length; i++){
		if(ev.path[i].localName == "tr"){
			filaPujar = ev.path[i];
			break;
		}
	}
	if(filaPujar.previousElementSibling.localName == "tr"){
		document.querySelector("table").insertBefore(filaPujar,filaPujar.previousElementSibling);
	}
}

// Botó Pujar (icona):
//	intercanvia la línia de la taula amb la línia de sota (si no és l'última línia)
function baixar(ev) {
	var filaBaixar;
	for(var i = 0; i < ev.path.length; i++){
		if(ev.path[i].localName == "tr"){
			filaBaixar = ev.path[i];
			break;
		}
	}
	if(filaPujar.nextElementSibling.localName == "tr"){
		document.querySelector("table").insertBefore(filaBaixar, filaBaixar.nextElementSibling.nextElementSibling);
	}
}

// Botó Esborrar (icona):
//	preguntar si es vol esborrar l'article, si no, no fer res
//	esborra la línia de la taula
//	recalcula el total
function esborrar(ev) {
	var filaEliminar;
	for(var i = 0; i < ev.path.length; i++){
		if(ev.path[i].localName == "tr"){
			filaEliminar = ev.path[i];
			break;
		}
	}
	if(confirm("Vols esborrar aquest article?")){
		var unitatAntiga = filaEliminar.firstElementChild.nextElementSibling.nextElementSibling.textContent;
		var preuAntic = filaEliminar.firstElementChild.nextElementSibling.nextElementSibling.nextElementSibling.textContent;
		var actual = document.querySelector("table").lastElementChild.lastElementChild.lastElementChild.textContent;
		document.querySelector("table").lastElementChild.lastElementChild.lastElementChild.textContent = Number(actual - unitatAntiga * preuAntic).toLocaleString('en-US',{minimumFractionDigits: 2, maximumFractionDigits: 2});
		filaEliminar.remove();
	}
}

/********** ESDEVENIMENTS DELS BOTONS DEL FINAL I D'ABANS D'IMPRIMIR **********/

// Botó Imprimir factura:
//	comprova que dte estigui entre 0 i 50
//		si és inferior a 0 o està buit, el posa a 0
//		si és superior a 50 el posa a 50
//	comprova que iva sigui 7, 10 o 21. Si no, alert(...) i retorna
//	reescriu el dte i el iva com a enters
//	crida la funció que mostra el diàleg del navegador per imprimir
function imprimir() {
	//dte entre 0 i 50
	if(dte.textContent == "" || parseInt(dte.textContent) < 0){
		dte.textContent = 0;
		dte.value= 0;
	}else if (parseInt(dte.textContent) > 50){
		dte.textContent = 50;
		dte.value = 50
	}else{
		dte.value = parseInt(dte.textContent);
	}
	//iva pot ser 7,10 o 21
	if(!(iva.textContent == 7 || iva.textContent == 10 || iva.textContent == 21)){
		iva.value = parseInt(iva.textContent);
		alert("El IVA només pot ser 7, 10 o 21");
		return;
	}
	//funció del navegador per imprimir
	if(comprovar()){
		window.print();
	}
}

// Botó Nova factura:
//	preguntar si es vol esborrar la factura actual, si no, retorna
//	elimina totes les files de la taula (excepte la del total)
//	buida les dades d'article
//	buida les dades finals de la factura
//	posar el focus en la data
function nova() {
	if(!confirm("Vols esborrar la factura actual?")){
		return;
	}
	var files = document.querySelector("table").getElementsByTagName("tr");
	while(files.length != 2){
		files[1].remove();
	}
	codi.value = "";
	descripcio.value = "";
	unitats.value = "";
	preu.value = "";
	document.querySelector("table").lastElementChild.lastElementChild.lastElementChild.textContent = '0.00';
	dte.textContent = "";
	iva.textContent = "";
	//focus a la data
	data.focus();
}

// Esdeveniment "beforeprint"
// Recalcular els totals de la factura a partir del total d'articles, dte i iva
//	S'han d'escriure en format local (coma, dos decimals i €)
function recalcularFinal() {
	var total = parseFloat(document.querySelector("table").lastElementChild.lastElementChild.lastElementChild.textContent);
	var baseImp;
	var quantiva;
	if(dte.value == 0){
		idte.textContent = Number(0).toLocaleString('es-ES', { style: "currency", currency: "EUR" });
		base.textContent = Number(baseImp = total).toLocaleString('es-ES', { style: "currency", currency: "EUR" });
	}else{
		idte.textContent =  Number(total/parseFloat(dte.value)).toLocaleString('es-ES', { style: "currency", currency: "EUR" });
		base.textContent =  Number(baseImp = total - total/parseFloat(dte.value)).toLocaleString('es-ES', { style: "currency", currency: "EUR" });
	}
	iiva.textContent = Number(quantiva = parseFloat(base.textContent) * parseFloat(iva.textContent) / 100).toLocaleString('es-ES', { style: "currency", currency: "EUR" });
	document.getElementById("total").textContent = Number(baseImp + quantiva).toLocaleString('es-ES', { style: "currency", currency: "EUR" });
}

function comprovar(){
	const _tl0 = "áàâäéèêëíìîïóòôöúùûüÁÀÂÄÉÈÊËÍÌÎÏÓÒÔÖÚÙÛÜ";
	const _tl1 = "aaaaeeeeiiiioooouuuuAAAAEEEEIIIIOOOOUUUU";
	var newname = "";
	var newpob = "";
	for(var c of nom.textContent){
        var ndx = _tl0.indexOf(c);
        newname += ndx < 0 ? c : _tl1.charAt(ndx);
	}
	for(var c of poblacio.textContent){
        var ndx = _tl0.indexOf(c);
        newpob += ndx < 0 ? c : _tl1.charAt(ndx);
	}
	if(data.value == ""){
		alert("Has d'especificar una data per a la factura");
		return false;
	}else if(numero.value == "" || numero.value < 0){
		alert("Has d'introduir un número de factura vàlid");
		return false;
	}else if(nif.textContent == "" || (!nif.textContent.match(/^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$/) && !nif.textContent.match(/^[XYZ][0-9]{7}[TRWAGMYFPDXBNJZSQVHLCKE]$/))){
		alert("Has d'introduir un document d'identitat DNI/NIE vàlid");
		return false;
	//No s'admeten números ni caràcters estranys al nom
	}else if(nom.textContent == "" || !newname.match(/^[A-Za-z ]+$/)){
		alert("Has d'introduir un nom vàlid");
		return false;
	}else if(adressa.textContent == ""){
		alert("Has d'dintroduir una adreça vàlida");
		return false;
	//No s'admeten números ni caràcters estranys a la població
	}else if(poblacio.textContent == "" || !newpob.match(/^[A-Za-z ]+$/)){
		alert("Has d'introduir una població vàlida");
		return false;
	//Ha d'haber-hi un producte a la factura
	}else if(document.querySelector("table").getElementsByTagName("tr").length == 2){
		alert("Ha d'haber-hi almenys un producte a la factura");
		return false;
	}
	return true;
}

function seleccionar(ev){
	var files = document.querySelector("table").getElementsByTagName("tr");
	for(var i = 0; i < ev.path.length; i++){
		if(ev.path[i].localName == "tr"){
			if(ev.path[i].nextElementSibling != null){
				for(var j = 1; j < files.length-1; j++){
					if(files[j].getAttribute("class") == "selected"){
						files[j].removeAttribute("class");
					}
				}
				ev.path[i].setAttribute("class","selected");
			}
		}
	}
	window.addEventListener("keydown", checkKeyPress);
}

function checkKeyPress(event){
	if(!event.repeat){
		var files = document.querySelector("table").getElementsByTagName("tr");
			for(var i = 1; i < files.length-1; i++){
			if(files[i].getAttribute("class") == "selected"){
				fila = files[i];
			}
		}
		//Per facilitar la interpretació amb el teclat convertim algunes tecles no utilitzades en unes altres
		switch (event.keyCode){
			case 13:
				codi.value = fila.firstElementChild.textContent;
				descripcio.value = fila.firstElementChild.nextElementSibling.textContent;
				unitats.value = fila.firstElementChild.nextElementSibling.nextElementSibling.textContent;
				preu.value = fila.firstElementChild.nextElementSibling.nextElementSibling.nextElementSibling.textContent;
				//Mostrar botons Modificar i Cancel·lar
				document.getElementById('modificar').style = "display:block";
				document.getElementById('cancelar').style = "display:block";
				document.getElementById('afegir').style = "display:none";
				//focus al codi
				codi.focus();
				break;
			case 38:
				document.querySelector("table").insertBefore(fila,fila.previousElementSibling);
				break;
			case 40:
				document.querySelector("table").insertBefore(fila, fila.nextElementSibling.nextElementSibling);
				break;
			case 46:
				if(confirm("Vols esborrar aquest article?")){
					var unitatAntiga = fila.firstElementChild.nextElementSibling.nextElementSibling.textContent;
					var preuAntic = fila.firstElementChild.nextElementSibling.nextElementSibling.nextElementSibling.textContent;
					var actual = document.querySelector("table").lastElementChild.lastElementChild.lastElementChild.textContent;
					document.querySelector("table").lastElementChild.lastElementChild.lastElementChild.textContent = Number(actual - unitatAntiga * preuAntic).toLocaleString('en-US',{minimumFractionDigits: 2, maximumFractionDigits: 2});
					fila.remove();
				}
				break;
			default:
				return;
		}
	}
}
/*
function quitarComa(str){
	var newStr;
	for(var c of str){
		if(c != ','){
			newStr = c;
		}
	}
	return newStr;
}
*/
/********** INICIALITZAR ATRIBUTS I CONTROLADORS **********/

// Inicialitza atributs
//	i afegeix controladors d'esdeveniments
function init() {
	//posa el focus a la data
	data.focus();
	//nif,nom,adressa,poblacio,dte,iva
	nif.setAttribute("contenteditable", true);
	nom.setAttribute("contenteditable", true);
	adressa.setAttribute("contenteditable", true);
	poblacio.setAttribute("contenteditable", true);
	dte.setAttribute("contenteditable", true);
	iva.setAttribute("contenteditable", true);
	//Numero no pot ser més petit que 0
	numero.min = 0;
	unitats.min = 0;
	preu.min = 0;
	//Events
	document.getElementById("afegir").addEventListener("click", afegir);
	document.getElementById("modificar").addEventListener("click", modificar);
	document.getElementById("cancelar").addEventListener("click", cancelar);
	document.getElementById("imprimir").addEventListener("click", imprimir);
	document.getElementById("nova").addEventListener("click", nova);
	document.querySelector("table").addEventListener("click", seleccionar);
	window.addEventListener("beforeprint", recalcularFinal);
}

/***********************************************
* FINAL DE L'APARTAT ON POTS FER MODIFICACIONS *
***********************************************/

function _init() {
	init();
	// L'element amb autofocus reb el focus després de carregar la pàgina.
	// En aquest cas, com l'atribut es posa després de carregar la pàgina,
	// s'ha de posar el focus manualment.
	var af = document.querySelector("[autofocus]");
	if (af) af.focus();
}

window.onload = _init;

