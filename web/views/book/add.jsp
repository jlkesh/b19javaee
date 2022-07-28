<%--
  Created by IntelliJ IDEA.
  User: jlkesh
  Date: 26/07/22
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">LibGen</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/books/">Books<span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<div class="row">
    <div class="col-6 offset-3">
        <form method="post">
            <div class="form-group">
                <label for="name">Book Name</label>
                <input type="text" name="name" class="form-control" id="name"/>
            </div>
            <div class="form-group">
                <label for="author">Book Author</label>
                <input type="text" name="author" class="form-control" id="author"/>
            </div>
            <div class="form-group">
                <label for="pageCount">Page count</label>
                <input type="number" name="pageCount" class="form-control" id="pageCount"/>
            </div>
            <div class="form-group">
                <label for="genre">Genre</label>
                <select class="form-control" id="genre">
                    <option value="HORROR">HORROR</option>
                    <option value="ROMANCE">ROMANCE</option>
                    <option value="DRAMA">DRAMA</option>
                    <option value="ROMANCE_DRAMA">ROMANCE_DRAMA</option>
                    <option value="SUPER_NATURAL_HORROR">SUPER_NATURAL_HORROR</option>
                    <option value="SCI_FI">SCI_FI</option>
                </select>
            </div>
            <div class="form-group">
                <label for="language">Language</label>
                <select class="form-control" id="language" name="genre">
                    <option value="UZ">Uz</option>
                    <option value="RU">Ru</option>
                    <option value="EN">En</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
