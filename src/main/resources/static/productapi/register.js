    // Función para manejar el clic en el botón
function enviarFormulario() {
    const formulario = document.getElementById('miFormulario');
    const formData = new FormData(formulario);

    // Convertir los datos del formulario a un objeto JSON
            const jsonData = {};
            formData.forEach((value, key) => {
                jsonData[key] = value;
            });

    // Obtener el valor seleccionado del rol (customer_id) del select
        const categoriesIdSelect = document.getElementById('product-categories');
        const selectedCategoryId = categoriesIdSelect.value;

        // Obtener el texto del rol seleccionado (customer_name) del select
        const selectedCategoryName = categoriesIdSelect.options[categoriesIdSelect.selectedIndex].text;

        // Agregar tanto el ID como el nombre del rol al objeto JSON
        jsonData['category_id'] = {
            "id": selectedCategoryId,
            "name": selectedCategoryName
        };

    fetch('http://localhost:4000/product/new', {
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


    //Obtener las categorías de productos

    // Hacer la petición GET y procesar los datos
    fetch('http://localhost:4000/category/categories')
       .then(response => response.json())
       .then(data => {
       // Obtener el select por su ID
       const select = document.getElementById('product-categories');

       // Iterar sobre los datos recibidos y crear las opciones
       data.forEach(category => {
          const option = document.createElement('option');
          option.value = category.id; // Asigna el valor que desees a la opción
          option.textContent = category.name; // El texto que se mostrará en la opción
          select.appendChild(option);
          });
       })
          .catch(error => console.error('Error al obtener los datos:', error));







