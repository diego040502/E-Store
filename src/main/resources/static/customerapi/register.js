function enviarFormulario() {
    const formulario = document.getElementById('miFormulario');
    const formData = new FormData(formulario);

    // Convertir los datos del formulario a un objeto JSON
    const jsonData = {};
    formData.forEach((value, key) => {
        jsonData[key] = value;
    });

    // Obtener el valor seleccionado del rol (customer_id) del select
    const rolesIdSelect = document.getElementById('roles-id');
    const selectedRoleId = rolesIdSelect.value;

    // Obtener el texto del rol seleccionado (customer_name) del select
    const selectedRoleName = rolesIdSelect.options[rolesIdSelect.selectedIndex].text;

    // Agregar tanto el ID como el nombre del rol al objeto JSON
    jsonData['role_id'] = {
        "id": selectedRoleId,
        "name": selectedRoleName
    };

    fetch('http://localhost:4000/customer/new', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(jsonData)
    })
    .then(response => response.json())
    .then(data => {
        // Aquí puedes manejar la respuesta del servidor
        console.log('Respuesta del servidor:', data);
    })
    .catch(error => console.error('Error al enviar los datos:', error));
}

// Agregar un escuchador de eventos para el clic en el botón
const botonEnviar = document.getElementById('submit');
botonEnviar.addEventListener('click', enviarFormulario);




    //Obtener los roles de cus

        // Hacer la petición GET y procesar los datos
        fetch('http://localhost:4000/role/roles')
           .then(response => response.json())
           .then(data => {
           // Obtener el select por su ID
           const select = document.getElementById('roles-id');
            // Filtrar los datos para obtener solo el rol de "customer"
                       const customerRole = data.find(role => role.role === "customer");
                       if (customerRole) {
                           const option = document.createElement('option');
                           option.value = customerRole.id;
                           option.textContent = customerRole.role;
                           select.appendChild(option);
                       } else {
                           console.error('No se encontró el rol de "customer" en la base de datos.');
                       }

           // Iterar sobre los datos recibidos y crear las opciones
           /*data.forEach(role => {
              const option = document.createElement('option');
              option.value = role.id; // Asigna el valor que desees a la opción
              option.textContent = role.role; // El texto que se mostrará en la opción
              select.appendChild(option);
              });*/
           })
              .catch(error => console.error('Error al obtener los datos:', error));

