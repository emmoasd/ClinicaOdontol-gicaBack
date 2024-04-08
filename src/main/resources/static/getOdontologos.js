document.addEventListener('DOMContentLoaded', function () {
    const odontologosList = document.getElementById('odontologosList');

    fetch('/odontologos/todos')
        .then(response => response.json())
        .then(data => {
            data.forEach(odontologo => {
                const listItem = document.createElement('li');

                //iconito ahora si
                const iconoPersona = document.createElement('i');
                iconoPersona.classList.add('fas', 'fa-user-circle', 'icon');

                const nombreApellido = document.createElement('span');
                nombreApellido.textContent = `${odontologo.nombre} ${odontologo.apellido}`;
                const matricula = document.createElement('span');
                matricula.textContent = `Matrícula: ${odontologo.numeroMatricula}`;

                const modificarButton = document.createElement('button');
                modificarButton.innerHTML = '<i class="fas fa-edit"></i> Modificar';
                modificarButton.setAttribute('data-id', odontologo.id); // Guardar el ID del odontólogo
                modificarButton.classList.add('btn-modificar');

                modificarButton.addEventListener('click', function() {
                    const odontologoId = this.getAttribute('data-id');
                    window.location.href = `/odontologosModificar.html?id=${odontologoId}`;
                });

                const eliminarButton = document.createElement('button');
                eliminarButton.innerHTML = '<i class="fas fa-trash-alt"></i> Eliminar';
                eliminarButton.classList.add('btn-eliminar');

                eliminarButton.addEventListener('click', () => {
                    const confirmar = confirm('¿Está seguro que desea eliminar este odontólogo?');
                    if (confirmar) {
                        fetch(`/odontologos/eliminar/${odontologo.id}`, { method: 'DELETE' })
                            .then(response => {
                                alert('Odontólogo eliminado con éxito');
                                window.location.reload();
                            })
                            .catch(error => console.error('Error al eliminar odontólogo:', error));
                    }
                });


                listItem.appendChild(iconoPersona);
                listItem.appendChild(nombreApellido);
                listItem.appendChild(document.createElement('br'));
                listItem.appendChild(matricula);
                listItem.appendChild(document.createElement('br'));
                listItem.appendChild(modificarButton);
                listItem.appendChild(eliminarButton);

                odontologosList.appendChild(listItem);
            });
        })
        .catch(error => console.error('Error al obtener la lista de odontólogos:', error));
});