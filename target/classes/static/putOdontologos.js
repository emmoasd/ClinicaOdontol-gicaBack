document.addEventListener('DOMContentLoaded', function () {
    const odontologoNombreApellidoSpan = document.getElementById('odontologoNombreApellido');
    const nombreInput = document.getElementById('nombre');
    const apellidoInput = document.getElementById('apellido');
    const matriculaInput = document.getElementById('matricula');
    const modificarOdontologoForm = document.getElementById('modificarOdontologoForm');

    // carga los datos
    function cargarDatosOdontologo(odontologoId) {
        fetch(`/odontologos/${odontologoId}`)
            .then(response => response.json())
            .then(odontologo => {
                odontologoNombreApellidoSpan.textContent = `${odontologo.nombre} ${odontologo.apellido}`;

                // rellenar form
                nombreInput.value = odontologo.nombre;
                apellidoInput.value = odontologo.apellido;
                matriculaInput.value = odontologo.numeroMatricula;
            })
            .catch(error => console.error('Error al cargar datos del odontólogo:', error));
    }

    modificarOdontologoForm.addEventListener('submit', function (event) {
        event.preventDefault();

        const nombre = nombreInput.value;
        const apellido = apellidoInput.value;
        const matricula = matriculaInput.value;

        const data = {
            id: parseInt(odontologoId),
            nombre: nombre,
            apellido: apellido,
            numeroMatricula: parseInt(matricula)
        };

        fetch(`/odontologos/actualizar/${odontologoId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
            .then(response => {
                if (response.ok) {
                    alert('Odontólogo modificado con éxito');
                    window.location.href = '/odontologosListado.html';
                } else {
                    throw new Error('Error al modificar odontólogo');
                }
            })
            .catch(error => console.error('Error al modificar odontólogo:', error));
    });

    // así carga los datos al cargar la página
    const urlParams = new URLSearchParams(window.location.search);
    const odontologoId = urlParams.get('id');
    cargarDatosOdontologo(odontologoId);
});