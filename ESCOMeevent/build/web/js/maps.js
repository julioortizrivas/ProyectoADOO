
function findMe()
{
    if(navigator.geolocation)
    {
        alert("Si acepta geolocalizacion");
    }
    else
    {
        alert("Sin soporte de Geolocalizacion");
    }
}

function localizacion(posicion)
{
    var latitude=posicion.coords.latitude;
    var longitud=posicion.coords.longitud;
}
function error()
{
    alert("Se produjo un error");
}

var map;
function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
    center: {lat: 19.504948, lng: -99.146009}, 
          zoom: 17
        });
}