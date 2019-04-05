
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

function conseguirinfoPortf(evento){
    cadena = "";
    data = {
        idEvento: evento
    };
     $.ajax({
        url: '/traerInfoPortafolios',
        type: 'get',
        data: evento,
        /*Tipo de dato de respuesta del servidor*/
        dataType: 'json',
        contentType: 'application/json',
        success: function (data) {
            array = $.parseJSON(data);
            $.each(array, function(i,v){
                cadena += v + "\t";
            });
            $('#portf').html(data.msg);
        }
    });
    
    return cadena;
}

function zonaprueba(){
    console.log();
}