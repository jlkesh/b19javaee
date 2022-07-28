<%--
  Created by IntelliJ IDEA.
  User: jlkesh
  Date: 26/07/22
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Book List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
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
                <a class="nav-link" href="/books">Books<span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<div class="row">
    <div class="col-10 offset-1">
        <button type="button" class="btn btn-success" data-toggle="modal" data-target=".bd-example-modal-lg">
            Add Book
        </button>

        <div class="modal fade bd-example-modal-lg" id="exampleModal" tabindex="-1" role="dialog"
             aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Add Bok</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form method="post" action="/books/add" enctype="multipart/form-data">
                        <div class="modal-body">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-6">

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

                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="genre">Genre</label>
                                            <select class="form-control" id="genre" name="genre">
                                                <option value="HORROR">Horror</option>
                                                <option value="ROMANCE">Romance</option>
                                                <option value="DRAMA">Drama</option>
                                                <option value="ROMANCE_DRAMA">Romance Drama</option>
                                                <option value="SUPER_NATURAL_HORROR">Super natural horror</option>
                                                <option value="SCI_FI">Sci-Fi</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="language">Language</label>
                                            <select class="form-control" id="language">
                                                <option value="UZ">Uz</option>
                                                <option value="RU">Ru</option>
                                                <option value="EN">En</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="file">Upload</label>
                                            <input type="file" name="file" class="form-control" id="file"/>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="row">
            <c:forEach items="${books}" var="book">
                <%--            <ul>--%>
                <%--                <li>${book.name}</li>--%>
                <%--                <li>${book.author}</li>--%>
                <%--                <li>${book.pageCount}</li>--%>
                <%--                <li>${book.genre}</li>--%>
                <%--                <li>${book.language}</li>--%>
                <%--            </ul>--%>
                <div class="col-2">
                    <div class="card mt-5">
                        <img class="card-img-top" src="/download?filename=${book.cover.generatedName}"
                             alt="Card image cap">
                        <div class="card-body">

                            <a href="/download?filename=${book.file.generatedName}"
                               class="card-title">${book.name}(${book.file.size}B)</a>

                            <p class="card-text">Author : ${book.author}</p>
                            <p class="card-text">Pages : ${book.pageCount}</p>
                            <p class="card-text">Genre : ${book.genre}</p>
                            <p class="card-text">Language : ${book.language}</p>
                            <p class="card-text">Language : ${book.language}</p>
                            <a href="/download?filename=${book.file.generatedName}" class="btn btn-outline-primary">Download</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>


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
