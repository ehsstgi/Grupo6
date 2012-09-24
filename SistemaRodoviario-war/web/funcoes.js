/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function Formatadata(Campo, teclapres)
{
    var tecla = teclapres.keyCode;
    var vr = new String(Campo.value);
    vr = vr.replace("/", "");
    vr = vr.replace("/", "");
    vr = vr.replace("/", "");
    tam = vr.length + 1;
    if (tecla != 8 && tecla != 8)
    {
        if (tam > 0 && tam < 2)
            Campo.value = vr.substr(0, 2) ;
        if (tam > 2 && tam < 4)
            Campo.value = vr.substr(0, 2) + '/' + vr.substr(2, 2);
        if (tam > 4 && tam < 7)
            Campo.value = vr.substr(0, 2) + '/' + vr.substr(2, 2) + '/' + vr.substr(4, 7);
    }
}

function SomenteNumero(e){
    var tecla=(window.event)?event.keyCode:e.which;   
    if((tecla>47 && tecla<58)) return true;
    else{
    	if (tecla==8 || tecla==0) return true;
	else  return false;
    }
}
