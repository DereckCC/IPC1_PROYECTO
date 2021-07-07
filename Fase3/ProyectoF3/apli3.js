const inputJson = document.getElementById('inputJson');
const DivTodasLasFactuas = document.getElementById('todosLasFacturas')

function leerJSON(){
    const fileReader = new FileReader();

        function miOnload(){
            const  json = JSON.parse(fileReader.result)
            crearTarjetas(json)
            console.log(json)
        }

    fileReader.readAsText(inputJson.files[0]);
    fileReader.onload = miOnload;
}

function crearTarjetas(Facturas){
    let html = ''
    for (const factura of Facturas) {
        html += crearTarjeta(factura)
    }

    DivTodasLasFactuas.innerHTML = html
}

function crearTarjeta(factura){
    let html = `
 
    <div class="card mt-5" style="width: 18rem;">
            <img src="Factura.png" class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">Factura ID: ${factura.id}</h5>
            </div>
            <ul class="list-group list-group-flush">
              <li class="list-group-item">Client: ${factura.client}</li>
              <li class="list-group-item">Date: ${factura.date}</li>
              <li class="list-group-item">Products Price: ${factura.products[0].price}</li>
              <div class="card-body">
              <a href="#" class="card-link">Ver</a>
            </div>
            </ul>
          </div>
 `
 return html
}


inputJson.addEventListener('change', leerJSON)