// Obtener una referencia a la tabla
const customerTable = document.getElementById('mytable').getElementsByTagName('tbody')[0];

// URL de tu API donde se encuentran los datos de los customers
const apiUrl = 'http://localhost:4000/customer/customers';

// Realizar el fetch con el método GET
fetch(apiUrl)
  .then(response => response.json()) // Convertir la respuesta a formato JSON
  .then(customers => {
    // Iterar sobre los datos de los customers y agregarlos a la tabla
    customers.forEach(customer => {
      const row = customerTable.insertRow(); // Insertar una nueva fila

      // Insertar las celdas con los datos del customer
      const idCell = row.insertCell(0);
      idCell.textContent = customer.id;

      const first_nameCell = row.insertCell(1);
      first_nameCell.textContent = customer.first_name;

      const surnameCell = row.insertCell(2);
      surnameCell.textContent = customer.surname;

      const addressCell = row.insertCell(3);
      addressCell.textContent = customer.address;

      const emailCell = row.insertCell(4);
      emailCell.textContent = customer.email;

      const phoneCell = row.insertCell(5);
      phoneCell.textContent = customer.phone;

      // Puedes agregar más celdas para mostrar más información si lo deseas

      const actionsCell = row.insertCell(6);
      const editButton = createIconButton('Update', './update.html');
      const deleteButton = createIconButton('Delete', '');
      actionsCell.appendChild(editButton);
      actionsCell.appendChild(deleteButton);

    });
  })
  .catch(error => {
    console.error('Error al obtener los datos:', error);
  });




function createIconButton(text, linkUrl) {
  const button = document.createElement('button');
  button.type = 'button'; // Establece el tipo del botón para que no envíe el formulario si está dentro de uno

  // Agregar clase al botón
  button.classList.add('custom-button');

  const buttonText = document.createTextNode(text); // Crea el nodo de texto con el contenido del botón
    button.appendChild(buttonText);
  if(text === 'Delete'){
    button.classList.add('delete');
  }

    button.addEventListener('click', () => {
      // Si es un botón de edición, redirige a la página de actualización
          if (text === 'Update') {
            window.location.href = linkUrl;
          } else if (text === 'Delete') {
            // Si es un botón de eliminación, llama a la función deleteCustomer con el ID del cliente
            const customerId = button.parentElement.parentElement.cells[0].textContent;
            deleteCustomer(customerId);
            location.reload(); // Recargar la página después de eliminar el cliente
          }
    });

  return button;
}

function deleteCustomer(id) {
  const apiUrl = `http://localhost:4000/customer/${id}`;

  fetch(apiUrl, {
    method: 'DELETE',
  })
  .then(response => response.json())
  .then(data => {
    // Aquí puedes realizar alguna acción si lo deseas, por ejemplo, recargar la página para actualizar la tabla
    //window.location.reload();
  })
  .catch(error => {
    console.error('Error al eliminar el cliente:', error);
  });
}






