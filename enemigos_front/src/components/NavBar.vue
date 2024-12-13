<template>
     <div class="navbar">
      <div class="menu-container">
        <input type="checkbox" id="toggle-menu" class="toggle-menu">
        <label for="toggle-menu" class="menu-icon">☰ Menú</label>
        
        <nav class="menu">
          <ul>
            <li><router-link to = "/" class="nav-link">Inicio</router-link></li>
            <li><router-link to = "/profile" class="nav-link">Mi Perfil</router-link></li>
            <li><router-link to = "/biblioteca" class="nav-link">Biblioteca</router-link></li>
          </ul>
          <button class="btn-icon" @click="closeMenu()">
          <i class="fas fa-user">Cerrar</i>
        </button>
        </nav>
        <div class="boton-derecha">
            <li><router-link to = "/login" class="nav-link">Login</router-link></li>
            <li><router-link to = "/registro" class="nav-link">Registro</router-link></li>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'NavBar',
    data() {
      return {
        submenuVisible: true,
      };
    },
    methods: {
      toggleMenu() {
        this.submenuVisible = !this.submenuVisible;
      },
      closeMenu() {
      const toggleCheckbox = document.getElementById('toggle-menu');
      if (toggleCheckbox) {
        toggleCheckbox.checked = false;
      }
    },
      
    },
  };
  </script>
  
  <style scoped>
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #333;
    color: rgb(221, 217, 217);
}

.anuncio {
    text-align: center;
}

.navbar {
    display: flex;
    justify-content: space-between; 
    align-items: center;
    padding: 10px;
    background-color: #000000;
    z-index: 1000;
}

.menu-container {
    display: flex;
    align-items: center;
    position: relative;
}

.toggle-menu {
    display: none;
}

.menu-icon {
    font-size: 30px;
    padding: 10px;
    background-color: #000000;
    color: white;
    cursor: pointer;
    display: block;
}

.menu {
    background-color: #000000;
    position: fixed;
    top: 0;
    left: -100%;
    width: 250px;
    height: 100%;
    transition: left 0.3s ease-in-out;
    z-index: 999;
}

.menu ul {
    list-style: none;
    padding: 0;
    margin: 0;
}

.menu li {
    text-align: left;
}

.menu a {
    color: white;
    text-decoration: none;
    display: block;
    padding: 15px;
    border-top: 1px solid #444;
}

.toggle-menu:checked + .menu-icon + .menu {
    left: 0;
}

.boton-derecha {
    display: flex;
}

.usuario-menu {
    position: relative;
}

.submenu-usuario {
    display: none;
    position: absolute;
    top: 40px; 
    right: 0;
    background-color: #fff;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    width: 160px;
    z-index: 100;
}

.submenu-usuario ul {
    list-style-type: none;
    padding: 0;
    margin: 0;
}

.submenu-usuario li {
    padding: 10px;
}

.submenu-usuario li a {
    text-decoration: none;
    color: #333;
    display: block;
}

.submenu-usuario li a:hover {
    background-color: #f0f0f0;
}

.submenu-usuario.mostrar {
    display: block;
}

.btn-icon {
    background-color: #000000;
    border: none;
    padding: 10px;
    color: white;
    font-size: 20px;
    cursor: pointer;
    border-radius: 5px;
    transition: background-color 0.3s ease;
}

.btn-icon:hover {
    background-color: #555;
}

@media (max-width: 768px) {
    .menu {
        position: fixed;
        top: 0;
        left: -100%;
        width: 250px;
        height: 100%;
    }

    .menu li {
        width: 100%;
        text-align: left;
    }

    .boton-derecha {
        display: flex; 
    }
}
  </style>