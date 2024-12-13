<template>
    <div class="container">
      <NavBar/>
      <div class="main-body">
        <nav aria-label="breadcrumb" class="main-breadcrumb">
          <ol class="breadcrumb">
            <li class="breadcrumb-item"><router-link to="/">Inicio</router-link></li>
            <li class="breadcrumb-item active" aria-current="page">Mi Perfil</li>
          </ol>
        </nav>
  
        <div class="row gutters-sm">
          <div class="col-md-4 mb-3">
            <div class="card">
              <div class="card-body">
                <div class="d-flex flex-column align-items-center text-center">
                  <img src="Img\TIO.png" alt="Usuario" width="200">
                  <div class="mt-3">
                    <h4>Mi perfil</h4>
                    <p class="text-secondary mb-1">"Un tio chill de cojones"</p>
                    <p class="text-muted font-size-sm">Ubicación: New York, San Bernardo, CL</p>
                    <button class="btn btn-outline-primary btn-sm">Cambiar Foto</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
  
          <div class="col-md-8">
            <div class="card mb-3">
              <div class="card-body">
                <div class="row mb-3" v-for="(value, key) in userProfile" :key="key">
                  <div class="col-sm-3">
                    <h6 class="mb-0">{{ key }}</h6>
                  </div>
                  <div class="col-sm-7">
                    <span v-if="!editMode[key]" class="view-mode">{{ value }}</span>
                    <input v-if="editMode[key]" type="text" class="form-control edit-mode" v-model="editProfile[key]" />
                  </div>
                  <div class="col-sm-2 text-right">
                    <button v-if="!editMode[key]" class="btn btn-sm btn-outline-primary" @click="toggleEditMode(key)">Editar</button>
                    <button v-if="editMode[key]" class="btn btn-sm btn-success" @click="saveProfile">Guardar</button>
                  </div>
                </div>
              </div>
            </div>
  
            <!-- Lista de Deseados -->
            <div class="card mt-4">
              <div class="card-body">
                <h5 class="card-title">Mi Lista de Deseados</h5>
                <ul class="list-group">
                  <li v-for="(game, index) in wishlist" :key="index" class="list-group-item d-flex justify-content-between align-items-center">
                    {{ game }}
                    <button class="btn btn-sm btn-danger" @click="removeFromWishlist(index)">Quitar</button>
                  </li>
                </ul>
                <div class="mt-3">
                  <input type="text" v-model="newGame" class="form-control" placeholder="Nombre del juego">
                  <button class="btn btn-primary mt-2" @click="addToWishlist">Añadir a Deseados</button>
                </div>
              </div>
            </div>
  
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import NavBar from './NavBar.vue';
  export default {
    components: {
    NavBar, 
  },
    data() {
      return {
        userProfile: {
          name: 'Elvio Lado Perez',
          email: 'wuaj4j4j4j4@gmail.com',
          phone: '666 727 696969',
          genres: 'Action, RPG, Adventure'
        },
        editProfile: { ...this.userProfile },
        editMode: { name: false, email: false, phone: false, genres: false },
        wishlist: JSON.parse(localStorage.getItem('wishlist')) || [],
        newGame: ''
      };
    },
    methods: {
      toggleEditMode(field) {
        this.editMode[field] = !this.editMode[field];
      },
      saveProfile() {
        this.userProfile = { ...this.editProfile };
        localStorage.setItem('userProfile', JSON.stringify(this.userProfile));
        this.toggleEditMode('name');
        this.toggleEditMode('email');
        this.toggleEditMode('phone');
        this.toggleEditMode('genres');
      },
      addToWishlist() {
        if (this.newGame.trim()) {
          this.wishlist.push(this.newGame.trim());
          localStorage.setItem('wishlist', JSON.stringify(this.wishlist));
          this.newGame = '';
        }
      },
      removeFromWishlist(index) {
        this.wishlist.splice(index, 1);
        localStorage.setItem('wishlist', JSON.stringify(this.wishlist));
      }
    }
  };
  </script>
  
  <style scoped>
  /* Tu estilo aquí */
  </style>