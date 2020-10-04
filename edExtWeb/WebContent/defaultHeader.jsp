<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="styles/style.css">
  <!-- Compiled and minified CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
  <!--https://coolors.co/ba1200-5e0035-020202-023618-005c69 -->
  <!-- Compiled and minified JavaScript -->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>

  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <title>edExt</title>
</head>

<body>
  <div class="navbar-fixed">
    <nav class="rojo">
      <div class="container">
        <div class="nav-wrapper">
          <a href="#!" class="brand-logo">edExt</a>
          <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
          <ul class="right hide-on-med-and-down">
            <li>
              <a href="#home">Inicio</a>
            </li>
            <li>
              <a href="#popular">Programas</a>
            </li>
            <li>
              <a href="#gallery">Cursos</a>
            </li>
            <li>
              <a href="#contact">Contacto</a>
            </li>
            <li><a href="mobile.html"><i class="material-icons left">account_circle</i>Login</a></li>
          </ul>
        </div>
      </div>
    </nav>
  </div>
  <ul class="sidenav" id="mobile-demo">
    <li><a href="mobile.html"><i class="material-icons">account_circle</i>Login</a></li>
    <li>
      <a href="#home">Home</a>
    </li>
    <li>
      <a href="#popular">Programas</a>
    </li>
    <li>
      <a href="#gallery">Cursos</a>
    </li>
    <li>
      <a href="#contact">Contact</a>
    </li>
  </ul>