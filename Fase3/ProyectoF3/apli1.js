const inputJson = document.getElementById('inputJson');
const divTodosLosClientes = document.getElementById('todoslosClientes')

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

function crearTarjetas(Clientes){
    let html = ''
    for (const cliente of Clientes) {
        html += crearTarjeta(cliente)
    }

    divTodosLosClientes.innerHTML = html
}

function crearTarjeta(cliente){
    let html = `
 
    <div class="card mt-5" style="width: 18rem;">
            <img src="Cliente.jpg" class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">Cliente: ${cliente.id}</h5>
            </div>
            <ul class="list-group list-group-flush">
              <li class="list-group-item">Name: ${cliente.name}</li>
              <li class="list-group-item">Address: ${cliente.address}</li>
              <li class="list-group-item">Phone: ${cliente.phone}</li>
              <li class="list-group-item">Nit: ${cliente.nit}</li>
              <div class="card-body">
              <a href="#" class="card-link">Ver</a>
            </div>
            </ul>
          </div>
 `
 return html
}


inputJson.addEventListener('change', leerJSON)