const inputJson = document.getElementById('inputJson');
const DivtodosLosProductos = document.getElementById('todoslosProductos')

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

function crearTarjetas(Productos){
    let html = ''
    for (const producto of Productos) {
        html += crearTarjeta(producto)
    }

    DivtodosLosProductos.innerHTML = html
}

function crearTarjeta(producto){
    let html = `
 
    <div class="card mt-5" style="width: 18rem;">
            <img src="Producto.jpg" class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">Product: ${producto.id}</h5>
            </div>
            <ul class="list-group list-group-flush">
              <li class="list-group-item">Name: ${producto.name}</li>
              <li class="list-group-item">description: ${producto.description}</li>
              <li class="list-group-item">Cost: ${producto.cost}</li>
              <li class="list-group-item">Price: ${producto.price}</li>
              <li class="list-group-item">Quantity: ${producto.ingredients.length}</li>
              <div class="card-body">
              <a href="#" class="card-link">Ver</a>
            </div>
            </ul>
          </div>
 `
 return html
}


inputJson.addEventListener('change', leerJSON)