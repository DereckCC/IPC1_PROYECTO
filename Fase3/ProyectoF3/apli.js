const inputJson = document.getElementById('inputJson');
const divTodosLosUsuarios = document.getElementById('todosLosUsuarios')

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

function crearTarjetas(usuarios){
    let html = ''
    for (const usuario of usuarios) {
        html += crearTarjeta(usuario)
    }

    divTodosLosUsuarios.innerHTML = html
}

function crearTarjeta(usuario){
    let html = `

    <div class="card mt-5" style="width: 18rem;">
            <img src="Usuario.png" class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">Usuario</h5>
            </div>
            <ul class="list-group list-group-flush">
              <li class="list-group-item">Username: ${usuario.username}</li>
              <li class="list-group-item">Password: ${usuario.password}</li>
            </ul>
          </div>`
          return html
}

inputJson.addEventListener('change', leerJSON)

