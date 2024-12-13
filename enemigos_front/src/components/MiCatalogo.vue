<template>
  <div class="MiCatalogo">
    <NavBar/>

    <section class="juegos">
      <h2>Juegos Disponibles</h2>
      <h3>
        <input type="text" v-model="searchQuery" placeholder="Buscar juego..." @keyup="buscarJuego">
        <i class="fas fa-search"></i>
      </h3>

      <!-- Contenedor que usa Flexbox -->
      <div class="juego-lista">
        <div v-for="juego in paginatedGames" :key="juego.name" class="juego-item">
          <img :src="juego.image" :alt="juego.name">
          <h3>{{ juego.name }}</h3>
          <a :href="juego.link" class="btn-jugar">+info</a>
          <button class="btn-biblioteca" @click="addToLibrary(juego)">Agregar a mi biblioteca</button>
        </div>
      </div>

      <!-- Paginación -->
      <div class="pagination">
        <button @click="changePage('previous')">Anterior</button>
        <button @click="changePage('next')">Siguiente</button>
      </div>
    </section>
  </div>
</template>

<script>
import NavBar from './NavBar.vue';
export default {
  name: "MiCatalogo",
  components: {
    NavBar, 
  },
  data() {
    return {
      games: [
        { name: 'Star Wars Outlaws', image: 'https://gaming-cdn.com/images/products/14344/616x353/star-wars-outlaws-pc-juego-ubisoft-connect-cover.jpg', link: '#' },
        { name: 'Juego 2', image: 'https://gaming-cdn.com/images/products/14344/616x353/star-wars-outlaws-pc-juego-ubisoft-connect-cover.jpg', link: '#' },
        { name: 'Juego 3', image: 'https://gaming-cdn.com/images/products/14344/616x353/star-wars-outlaws-pc-juego-ubisoft-connect-cover.jpg', link: '#' },
        { name: 'Juego 4', image: 'https://gaming-cdn.com/images/products/14344/616x353/star-wars-outlaws-pc-juego-ubisoft-connect-cover.jpg', link: '#' },
        { name: 'Juego 5', image: 'https://gaming-cdn.com/images/products/14344/616x353/star-wars-outlaws-pc-juego-ubisoft-connect-cover.jpg', link: '#' },
        { name: 'Juego 6', image: 'https://gaming-cdn.com/images/products/14344/616x353/star-wars-outlaws-pc-juego-ubisoft-connect-cover.jpg', link: '#' },
        { name: 'Juego 7', image: 'https://gaming-cdn.com/images/products/14344/616x353/star-wars-outlaws-pc-juego-ubisoft-connect-cover.jpg', link: '#' },
        { name: 'Juego 8', image: 'https://gaming-cdn.com/images/products/14344/616x353/star-wars-outlaws-pc-juego-ubisoft-connect-cover.jpg', link: '#' },
        { name: 'Juego 9', image: 'https://gaming-cdn.com/images/products/14344/616x353/star-wars-outlaws-pc-juego-ubisoft-connect-cover.jpg', link: '#' },
        { name: 'Juego 10', image: 'https://gaming-cdn.com/images/products/14344/616x353/star-wars-outlaws-pc-juego-ubisoft-connect-cover.jpg', link: '#' },
        { name: 'Juego 11', image: 'https://gaming-cdn.com/images/products/14344/616x353/star-wars-outlaws-pc-juego-ubisoft-connect-cover.jpg', link: '#' },
        { name: 'Juego 12', image: 'https://gaming-cdn.com/images/products/14344/616x353/star-wars-outlaws-pc-juego-ubisoft-connect-cover.jpg', link: '#' },
        { name: 'Juego 13', image: 'https://gaming-cdn.com/images/products/14344/616x353/star-wars-outlaws-pc-juego-ubisoft-connect-cover.jpg', link: '#' },
        { name: 'Juego 14', image: 'https://gaming-cdn.com/images/products/14344/616x353/star-wars-outlaws-pc-juego-ubisoft-connect-cover.jpg', link: '#' },
        { name: 'Juego 15', image: 'https://gaming-cdn.com/images/products/14344/616x353/star-wars-outlaws-pc-juego-ubisoft-connect-cover.jpg', link: '#' },
      ],
      searchQuery: '',
      page: 0,
      gamesPerPage: 12,
    };
  },
  computed: {
    filteredGames() {
      return this.games.filter(game => game.name.toLowerCase().includes(this.searchQuery.toLowerCase()));
    },
    totalPages() {
      return Math.ceil(this.filteredGames.length / this.gamesPerPage);
    },
    // Paginación de juegos
    paginatedGames() {
      const start = (this.page - 1) * this.gamesPerPage;
      const end = start + this.gamesPerPage;
      return this.filteredGames.slice(start, end);
    }
  },
  methods: {
  
    addToLibrary(game) {
      let library = JSON.parse(localStorage.getItem('library')) || [];
      library.push(game);
      localStorage.setItem('library', JSON.stringify(library));
      alert(game.name + ' ha sido agregado a tu biblioteca!');
    },
    changePage(direction) {
      if (direction === 'previous' && this.page > 1) {
        this.page--;
      } else if (direction === 'next' && this.page < this.totalPages) {
        this.page++;
      }
    }
  },
  mounted() {
    this.changePage('next');
  }
};
</script>

<style scoped>
.juegos {
  min-height: 100vh; /* Asegura que el contenedor principal ocupe al menos toda la altura de la pantalla */
}
.juego-lista {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
  gap: 20px;
}
html, body {
  margin: 0;
  padding: 0;
  height: 100%; /* Asegura que el cuerpo ocupe toda la altura disponible */
}
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #333;
    color: rgb(221, 217, 217);
    box-sizing: border-box;
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
    z-index: 1000;
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
}


.juegos {
    padding: 20px;
    text-align: center;
    background-color: #444;
}

.juegos h2 {
    font-size: 2rem;
    margin-bottom: 20px;
    color: rgb(255, 255, 255);
}

.juego-lista {
    display: flex;
    justify-content: space-around;
    flex-wrap: wrap;
}

.juego-item {
    background-color: #1255226e;
    width: 250px;
    margin: 15px;
    padding: 10px;
    border-radius: 8px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    text-align: center;
}

.juego-item img {
    width: 100%;
    height: 150px;
    object-fit: cover;
    border-radius: 5px;
}

.juego-item h3 {
    margin: 15px 0;
    font-size: 1.2rem;
}

.btn-jugar {
    display: inline-block;
    padding: 10px 20px;
    background-color: #b90606;
    color: white;
    text-decoration: none;
    border-radius: 5px;
    font-size: 1rem;
}

.btn-jugar:hover {
    background-color: #0056b3;
}

.btn-biblioteca {
    background-color: #2939c4; 
    color: #fff;
    border: none;
    padding: 10px 20px;
    margin-top: 10px;
    cursor: pointer;
    border-radius: 5px;
    font-size: 16px;
    transition: background-color 0.3s;
}

.btn-biblioteca:hover {
    background-color: #45a049; 
}


.pagination {
    text-align: center;
    margin-top: 20px;
}

.pagination button {
    padding: 10px 15px;
    margin: 0 5px;
    cursor: pointer;
    background-color: #000000;
    color: white;
    border: none;
    border-radius: 5px;
}

.pagination button:hover {
    background-color: #45a049;
}

.pagination button:disabled {
    background-color: #d3d3d3;
    cursor: not-allowed;
}

.busqueda-container {
    display: flex;
    align-items: center;
    margin-bottom: 20px;
}

.busqueda-container input {
    padding: 8px;
    width: 250px;
    border-radius: 5px;
    border: 1px solid #ccc;
    margin-right: 10px;
}

.busqueda-container i {
    font-size: 18px;
    color: #333;
}
  </style>