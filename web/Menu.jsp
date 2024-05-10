<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin of menu-->
<style>
    .carousel-item img{
        height: 450px;
    }
</style>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="home" style="font-family: 'Arial Black', sans-serif; font-size: 24px;">Badminton Racket</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto" style="font-family: 'Arial', sans-serif; font-size: 18px;">
                <c:if test="${sessionScope.acc.isAdmin == 1}">
                    <li class="nav-item">
                        <a class="nav-link" href="#" style="color: #fff;">Manager Account</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.acc.isSell == 1}">
                    <li class="nav-item">
                        <a class="nav-link" href="manager" style="color: #fff;">Manager Product</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.acc != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="#" style="color: #fff;">Hello ${sessionScope.acc.user}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout" style="color: #fff;">Logout</a>
                    </li> 
                </c:if>
                <c:if test="${sessionScope.acc == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="login" style="color: #fff;">Login</a>
                    </li>
                </c:if>
            </ul>

            <form action="search" method="post" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input oninput="searchByName(this)" value="${txtS}" name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search..." style="font-family: 'Arial', sans-serif;">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <a class="btn btn-success btn-sm ml-3" href="show" style="font-family: 'Arial', sans-serif;">
                    <i class="fa fa-shopping-cart"></i> Cart
                    <span class="badge badge-light">3</span>
                </a>
            </form>
        </div>
    </div>
</nav>
                    
<div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner">
       <div class="carousel-item active">
            <img src="https://media.karousell.com/media/photos/products/2020/7/13/lining_aeronaut_9000_series_1594682098_658c534c_progressive.jpg" class="d-block w-100" alt="Lining Aeronaut 9000">
        </div>
        <div class="carousel-item">
            <img src="https://cdn.shopvnb.com//uploads/san_pham/vot-cau-long-yonex-nanoflare-1000z-1.webp" class="d-block w-100" alt="Yonex Nanoflare 1000z">
        </div>
        <div class="carousel-item">
            <img src="..." class="d-block w-100" alt="...">
        </div>
        </div>
  
</div>
<section class="jumbotron text-center" style="background-color: #f8f9fa; padding: 3rem;">
    <div class="container">
        <h1 class="jumbotron-heading">Siêu thị vợt cầu lông chất lượng cao</h1>
        <p class="lead text-muted mb-0" style="font-family: 'Arial', sans-serif; font-size: 20px;">Đa dạng hoá mọi sản phẩm với những dòng vợt mới nhất từ các hãng nổi tiếng</p>
    </div>
</section>
<!--end of menu-->
