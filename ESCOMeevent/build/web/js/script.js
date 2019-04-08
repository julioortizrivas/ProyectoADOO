
function traePortafolios(){
    $.ajax({
        url: 'http://10.100.65.229:8080/portafolios',
        type: 'get',
        /*Tipo de dato de respuesta del servidor*/
        dataType: 'json',
        contentType: 'application/json',
        success: function (data) {
            console.log(data);
            
            sel = document.getElementById('portf');
            $.each(data, function(i,v){
                opt = document.createElement('option');
                opt.innerHTML = data[i]['portafolio'];
                opt.value = data[i]['portafolio'];
                sel.appendChild(opt);
            });
            $('#portf').html(data.msg);
        }
    });
}

function asociarPortafolio(gestor){
    var data1 = {
        idEvento: $("#clvEvento").val(),
        nombrePortafolio: $("select#portf option:selected").val(),
        idGestor: gestor
    };

    $.ajax({
        url: 'http://10.100.65.229:8080/portafolios',
        type: 'post',
        /*Tipo de dato de respuesta del servidor*/
        dataType: 'json',
        contentType: 'application/json',
        success: function (data) {
            alert(data.msg);
        },
        data: JSON.stringify(data1)
    });
}

function conseguirUsuario(evento){
    cadena = "";
    evento_obj = {
        idEvento: evento
    };
     $.ajax({
        url: 'http://10.100.65.229:8080/usuario',
        type: 'get',
        data: evento_obj,
        /*Tipo de dato de respuesta del servidor*/
        dataType: 'json',
        contentType: 'application/json',
        success: function (data) {
            
        }
    });
    
    return cadena;
}

function conseguirPassword(evento){
    cadena = "";
    evento_obj = {
        idEvento: evento
    };
     $.ajax({
        url: 'http://10.100.65.229:8080/password',
        type: 'get',
        data: evento_obj,
        /*Tipo de dato de respuesta del servidor*/
        dataType: 'json',
        contentType: 'application/json',
        success: function (data) {
            
        }
    });
    
    return cadena;
}

function conseguirPortafolio(evento){
    cadena = "";
    evento_obj = {
        idEvento: evento
    };
     $.ajax({
        url: 'http://10.100.65.229:8080/portafolio',
        type: 'get',
        data: evento_obj,
        /*Tipo de dato de respuesta del servidor*/
        dataType: 'json',
        contentType: 'application/json',
        success: function (data) {
            
        }
    });
    
    return cadena;
}