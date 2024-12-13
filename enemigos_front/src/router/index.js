import { createRouter, createWebHistory } from 'vue-router'
import Catalogo from '@/components/MiCatalogo.vue';
import Biblioteca from '@/components/MiBiblioteca.vue';
import Login from '@/components/IniciarSesion.vue';
import Registro from '@/components/CrearCuenta.vue';
import Profile from '@/components/MiProfile.vue';

const routes = [
  { path: '/', name: Catalogo , component: Catalogo },
  { path: '/biblioteca',name: Biblioteca, component: Biblioteca },
  { path: '/login',name: Login, component: Login },
  { path: '/registro',name:Registro, component: Registro },
  { path: '/profile', name: Profile , component: Profile },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
