document.addEventListener('DOMContentLoaded', function () {
    const agregarOdontologoForm = document.getElementById('agregarOdontologoForm');

    agregarOdontologoForm.addEventListener('submit', function (event) {
        event.preventDefault();

        const nombre = document.getElementById('nombre').value;
        const apellido = document.getElementById('apellido').value;
        const matricula = document.getElementById('matricula').value;

        const data = {
            nombre: nombre,
            apellido: apellido,
            numeroMatricula: parseInt(matricula)
        };

        fetch('/odontologos/agregar', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
        .then(response => {
            alert('Odontólogo guardado con éxito');
            window.location.href = '/odontologosListado.html';
        })
        .catch(error => console.error('Error al agregar odontólogo:', error));
    });
});