'use strict';

const euro = new Intl.NumberFormat('es-ES', {
    style: 'currency',
    currency: 'EUR',
    useGrouping: true
});

const URL = 'http://localhost:3001/productos/';

let form, table, tbody;

window.addEventListener('DOMContentLoaded', domCargado);

function domCargado() {
    form = document.querySelector('form');
    table = document.querySelector('table');
    tbody = document.querySelector('tbody');

    form.addEventListener('submit', guardar);

    console.log('LISTADO GLOBAL');
    listado();
}

async function guardar(e) {
    e.preventDefault();

    if(!form.checkValidity()) {
        form.classList.add('was-validated');
        return;
    }

    const producto = { nombre: form.nombre.value, precio: +form.precio.value };

    if (form.id.value) {
        producto.id = +form.id.value;

        console.log(producto);

        await fetch(URL + producto.id, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(producto)
        });
    } else {
        await fetch(URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(producto)
        });
    }

    console.log('LISTADO DESPUÉS DE SUBMIT');
    listado();
}
async function listado() {
    const respuesta = await fetch(URL);
    const productos = await respuesta.json();

    tbody.innerHTML = '';

    productos.sort((p1, p2) => p1.id - p2.id).forEach(p => {
        console.log(p);
        
        const tr = document.createElement('tr');
        tr.innerHTML = `<th class="text-end">${p.id}</th><td>${p.nombre}</td><td class="text-end">${euro.format(p.precio)}</td>
            <td>
                <a class="btn btn-sm btn-primary" href="javascript:formulario(${p.id})">Editar</a>
                <a class="btn btn-sm btn-danger" href="javascript:borrar(${p.id})">Borrar</a>
            </td>`;

        tbody.appendChild(tr);
    });

    form.style.display = 'none';
    table.style.display = null;
}

async function formulario(id) {
    if (id) {
        const respuesta = await fetch(URL + id);
        const p = await respuesta.json();

        form.id.value = p.id;
        form.nombre.value = p.nombre;
        form.precio.value = p.precio;
    } else {
        form.reset();
    }

    form.style.display = null;
    table.style.display = 'none';
}

function borrar(id) {
    fetch(URL + id, { method: 'DELETE' }).then(listado);
}