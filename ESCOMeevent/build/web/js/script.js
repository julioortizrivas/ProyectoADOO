
var ip = 'http://10.100.77.47:8080/';


function traePortafolios(){
    $.ajax({
        url: ip+'portafolios',
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
                opt.id = data[i]['idUsuario']+" "+data[i]['idPortafolio'];
                sel.appendChild(opt);
            });
            $('#portf').html(data.msg);
        }
    });
}

function asociarPortafolio(gestor){
    
    array = $("select#portf option:selected").attr('id').split(" ");
    
    var data1 = {
        idEvento: $("#clvEvento").val(),
        idPortafolio: array[1],
        idGestor: gestor,
        idUsuario: array[0]
    };

    $.ajax({
        url: ip+'middleware',
        type: 'post',
        /*Tipo de dato de respuesta del servidor*/
        dataType: 'json',
        contentType: 'application/json',
        success: function (data) {
            alert(data.msg);
        },
        data: JSON.stringify(data1)
    });
    
    $('#asignarPort').attr("disabled", true);
}




function conseguirPortafolio(evento){
    console.log("osdfkfsdofj");
    array = $('.eventCard');
    $.each(array, function( index, value ) {
     
        var children = $(array[index]);
        var aux = children.children();
        $.each(aux, function( i, v ) {
            val = $(aux[i]);
             $.ajax({
                url: ip+'middleware/194Even',
                type: 'get',
                /*Tipo de dato de respuesta del servidor*/
                dataType: 'json',
                contentType: 'application/json',
                success: function (data) {
                    console.log(data);
                    $('#user194Even').val(data['userName']);
                    $('#cont194Even').val(data['contrasena']);
                    $('#port194Even').val(data['idPortafolio']);
                }
            });    
        });
    });
}