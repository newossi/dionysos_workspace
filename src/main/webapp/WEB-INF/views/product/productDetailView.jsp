<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <title></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
   <script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/resources/js/jquery-3.6.3.min.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Spectral:ital,wght@0,200;0,300;0,400;0,500;0,700;0,800;1,200;1,300;1,400;1,500;1,700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"	href="${pageContext.servletContext.contextPath}/resources/css/animate.css">
<link rel="stylesheet"	href="${pageContext.servletContext.contextPath}/resources/css/owl.carousel.min.css">
<link rel="stylesheet"	href="${pageContext.servletContext.contextPath}/resources/css/owl.theme.default.min.css">
<link rel="stylesheet"	href="${pageContext.servletContext.contextPath}/resources/css/magnific-popup.css">
<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">
<link rel="stylesheet"	href="${pageContext.servletContext.contextPath}/resources/css/flaticon.css">
<link rel="stylesheet"	href="${pageContext.servletContext.contextPath}/resources/css/style.css">
  </head>
  <body>

    <c:import url="/WEB-INF/views/common/menubar.jsp" />

    <section class="ftco-section">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-end justify-content-center">
          <div class="col-md-9 ftco-animate mb-5 text-center">
             <p class="breadcrumbs mb-0"><span class="mr-2"><a href="main.do">Home <i class="fa fa-chevron-right"></i></a></span> <span><a href="plist.do">Products <i class="fa fa-chevron-right"></i></a></span></p>
            <h2 class="mb-0 bread">상세정보</h2>
          </div>
        </div>
      </div>
      &nbsp;
       <div class="container">
          <div class="row">
             <div class="col-lg-6 mb-5 ftco-animate">
                <a href="${ product.product_image }" class="image-popup prod-img-bg"><img src="${ product.product_image }" class="img-fluid" alt="Colorlib Template"></a>
             </div>
             <div class="col-lg-6 product-details pl-md-5 ftco-animate">
                <h1>pp${ product.product_name }</h1>
                <h5>pp</h5>
                <div class="rating d-flex">
                     <p class="text-left mr-4">
                        <a href="#" class="mr-2">5.00${ review.review_score }</a>
                        <a href="#"><span class="fa fa-star"></span></a>
                        <a href="#"><span class="fa fa-star"></span></a>
                        <a href="#"><span class="fa fa-star"></span></a>
                        <a href="#"><span class="fa fa-star"></span></a>
                        <a href="#"><span class="fa fa-star"></span></a>
                     </p>
                  </div>
                <p class="price"><span>가격 : ${ product.product_price } 원</span></p>
 
 				 <table>
				      <tr align="center">
				         <th>당도</th>
				         <th>바디</th>
				         <th>산도</th>
				         <th>타닌</th>
				      </tr>
				      <tr>
				       <td><img src="resources/images/graph_${ wdt.sweetness }.png" width="50" height="50">&nbsp;</td>
			           <td><img src="resources/images/graph_${ wdt.body }.png" width="50" height="50">&nbsp;</td>
			           <td><img src="resources/images/graph_${ wdt.acidity }.png" width="50" height="50">&nbsp;</td>
			           <td><img src="resources/images/graph_${ wdt.tannin }.png" width="50" height="50">&nbsp;</td>
				      </tr> 
				       <!-- <tr>
				            <td><img src="resources/images/graph_0.png" width="50" height="50">&nbsp;</td> 
				            <td><img src="resources/images/graph_1.png" width="50" height="50">&nbsp;</td>
				            <td><img src="resources/images/graph_2.png" width="50" height="50">&nbsp;</td>
				            <td><img src="resources/images/graph_3.png" width="50" height="50">&nbsp;</td>
				         </tr>  -->
				   </table>
				 					
 				
 				<!--  <div><label>산도 : </label><img src="resources/images/graph_0.png" alt="산도" height="50" width="50"></div>
                <div><label>당도 : </label><span> 6.00%</span></div>
                <div><label>바디 : </label><span> 6.00%</span></div>
                <div><label>타닌 : </label><span> 6.00%</span></div> -->
                  <div class="row mt-4">
                     <div class="input-group col-md-6 d-flex mb-3">
                   <span class="input-group-btn mr-2">
                      <button type="button" class="quantity-left-minus btn"  data-type="minus" data-field="">
                      <i class="fa fa-minus"></i>
                      </button>
                     </span>
                   <input type="text" id="quantity" name="quantity" class="quantity form-control input-number" value="1" min="1" max="100">
                   <span class="input-group-btn ml-2">
                      <button type="button" class="quantity-right-plus btn" data-type="plus" data-field="">
                        <i class="fa fa-plus"></i>
                    </button>
                   </span>
                </div>
                <div class="w-100"></div>
                <div class="col-md-12">
                   <p style="color: #000;">재고 : ${ stock.stock_amount }</p>
                </div>
             </div>
             <p><a href="clistView.do" class="btn btn-primary py-3 px-5 mr-2">장바구니</a><a href="cart.html" class="btn btn-primary py-3 px-5">바로 구매</a></p>
             </div>
          </div>




          <div class="row mt-5">
          <div class="col-md-12 nav-link-wrap">
            <div class="nav nav-pills d-flex text-center" id="v-pills-tab" role="tablist" aria-orientation="vertical">
              <a class="nav-link ftco-animate active mr-lg-1" id="v-pills-1-tab" data-toggle="pill" href="#v-pills-1" role="tab" aria-controls="v-pills-1" aria-selected="true">상세정보</a>

              <a class="nav-link ftco-animate mr-lg-1" id="v-pills-2-tab" data-toggle="pill" href="#v-pills-2" role="tab" aria-controls="v-pills-2" aria-selected="false">판매처</a>

              <a class="nav-link ftco-animate" id="v-pills-3-tab" data-toggle="pill" href="#v-pills-3" role="tab" aria-controls="v-pills-3" aria-selected="false">리 뷰</a>

            </div>
          </div>
          <div class="col-md-12 tab-wrap">
            
            <div class="tab-content bg-light" id="v-pills-tabContent">

              <div class="tab-pane fade show active" id="v-pills-1" role="tabpanel" aria-labelledby="day-1-tab">
                 <div class="p-4">
                    <h3 class="mb-4">pp${ product.product_name }</h3>
                    <p>pp${ product.product_detail }
                    </div>
              </div>

              <div class="tab-pane fade" id="v-pills-2" role="tabpanel" aria-labelledby="v-pills-day-2-tab">
                 <div class="p-4">
                   <!--  <h3 class="mb-4">Manufactured By Liquor Store</h3> -->
                   <table>
					    <tr align="center">
					        <th>매장명</th>
					        <th>주소</th>
					        <th>전화번호</th>
					        <th>재고량</th>
					    </tr>
					    <tr th:each="stock : ${stockList}">
					        <td th:text="${stock.storeName}">한국</td>
					        <td th:text="${stock.address}">서울시 마포구</td>
					        <td th:text="${stock.phone}">01099998888</td>
					        <td th:text="${stock.stockAmount}">22</td>
					    </tr>
					</table>
                 </div>
              </div>
              <div class="tab-pane fade" id="v-pills-3" role="tabpanel" aria-labelledby="v-pills-day-3-tab">
                 <div class="row p-4">
                           <div class="col-md-7">
                              <h3 class="mb-4">23 Reviews</h3>
                              <div class="review">
                                 <div class="user-img" style="background-image: url(images/person_1.jpg)"></div>
                                 <div class="desc">
                                    <h4>
                                       <span class="text-left">Jacob Webb</span>
                                       <span class="text-right">25 April 2020</span>
                                    </h4>
                                    <p class="star">
                                       <span>
                                          <i class="fa fa-star"></i>
                                          <i class="fa fa-star"></i>
                                          <i class="fa fa-star"></i>
                                          <i class="fa fa-star"></i>
                                          <i class="fa fa-star"></i>
                                       </span>
                                       <span class="text-right"><a href="#" class="reply"><i class="icon-reply"></i></a></span>
                                    </p>
                                    <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrov</p>
                                 </div>
                              </div>
                              <div class="review">
                                 <div class="user-img" style="background-image: url(images/person_2.jpg)"></div>
                                 <div class="desc">
                                    <h4>
                                       <span class="text-left">Jacob Webb</span>
                                       <span class="text-right">25 April 2020</span>
                                    </h4>
                                    <p class="star">
                                       <span>
                                          <i class="fa fa-star"></i>
                                          <i class="fa fa-star"></i>
                                          <i class="fa fa-star"></i>
                                          <i class="fa fa-star"></i>
                                          <i class="fa fa-star"></i>
                                       </span>
                                       <span class="text-right"><a href="#" class="reply"><i class="icon-reply"></i></a></span>
                                    </p>
                                    <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrov</p>
                                 </div>
                              </div>
                              <div class="review">
                                 <div class="user-img" style="background-image: url(images/person_3.jpg)"></div>
                                 <div class="desc">
                                    <h4>
                                       <span class="text-left">Jacob Webb</span>
                                       <span class="text-right">25 April 2020</span>
                                    </h4>
                                    <p class="star">
                                       <span>
                                          <i class="fa fa-star"></i>
                                          <i class="fa fa-star"></i>
                                          <i class="fa fa-star"></i>
                                          <i class="fa fa-star"></i>
                                          <i class="fa fa-star"></i>
                                       </span>
                                       <span class="text-right"><a href="#" class="reply"><i class="icon-reply"></i></a></span>
                                    </p>
                                    <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrov</p>
                                 </div>
                              </div>
                           </div>
                           <div class="col-md-4">
                              <div class="rating-wrap">
                                 <h3 class="mb-4">Give a Review</h3>
                                 <p class="star">
                                    <span>
                                       <i class="fa fa-star"></i>
                                       <i class="fa fa-star"></i>
                                       <i class="fa fa-star"></i>
                                       <i class="fa fa-star"></i>
                                       <i class="fa fa-star"></i>
                                       (98%)
                                    </span>
                                    <span>20 Reviews</span>
                                 </p>
                                 <p class="star">
                                    <span>
                                       <i class="fa fa-star"></i>
                                       <i class="fa fa-star"></i>
                                       <i class="fa fa-star"></i>
                                       <i class="fa fa-star"></i>
                                       <i class="fa fa-star"></i>
                                       (85%)
                                    </span>
                                    <span>10 Reviews</span>
                                 </p>
                                 <p class="star">
                                    <span>
                                       <i class="fa fa-star"></i>
                                       <i class="fa fa-star"></i>
                                       <i class="fa fa-star"></i>
                                       <i class="fa fa-star"></i>
                                       <i class="fa fa-star"></i>
                                       (98%)
                                    </span>
                                    <span>5 Reviews</span>
                                 </p>
                                 <p class="star">
                                    <span>
                                       <i class="fa fa-star"></i>
                                       <i class="fa fa-star"></i>
                                       <i class="fa fa-star"></i>
                                       <i class="fa fa-star"></i>
                                       <i class="fa fa-star"></i>
                                       (98%)
                                    </span>
                                    <span>0 Reviews</span>
                                 </p>
                                 <p class="star">
                                    <span>
                                       <i class="fa fa-star"></i>
                                       <i class="fa fa-star"></i>
                                       <i class="fa fa-star"></i>
                                       <i class="fa fa-star"></i>
                                       <i class="fa fa-star"></i>
                                       (98%)
                                    </span>
                                    <span>0 Reviews</span>
                                 </p>
                              </div>
                           </div>
                        </div>
              </div>
            </div>
          </div>
        </div>
       </div>
    </section>

    
    
  

 
  <script>
      $(document).ready(function(){

      var quantitiy=0;
         $('.quantity-right-plus').click(function(e){
              
              // Stop acting like a button
              e.preventDefault();
              // Get the field name
              var quantity = parseInt($('#quantity').val());
              
              // If is not undefined
                  
                  $('#quantity').val(quantity + 1);

                
                  // Increment
              
          });

           $('.quantity-left-minus').click(function(e){
              // Stop acting like a button
              e.preventDefault();
              // Get the field name
              var quantity = parseInt($('#quantity').val());
              
              // If is not undefined
            
                  // Increment
                  if(quantity>0){
                  $('#quantity').val(quantity - 1);
                  }
          });
          
      });
   </script>
   
			<c:import url="/WEB-INF/views/common/footer.jsp" />
		
     <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="${pageContext.servletContext.contextPath}/resources/js/jquery.min.js"></script>
  <script src="${pageContext.servletContext.contextPath}/resources/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="${pageContext.servletContext.contextPath}/resources/js/popper.min.js"></script>
  <script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
  <script src="${pageContext.servletContext.contextPath}/resources/js/jquery.easing.1.3.js"></script>
  <script src="${pageContext.servletContext.contextPath}/resources/js/jquery.waypoints.min.js"></script>
  <script src="${pageContext.servletContext.contextPath}/resources/js/jquery.stellar.min.js"></script>
  <script src="${pageContext.servletContext.contextPath}/resources/js/owl.carousel.min.js"></script>
  <script src="${pageContext.servletContext.contextPath}/resources/js/jquery.magnific-popup.min.js"></script>
  <script src="${pageContext.servletContext.contextPath}/resources/js/jquery.animateNumber.min.js"></script>
  <script src="${pageContext.servletContext.contextPath}/resources/js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="${pageContext.servletContext.contextPath}/resources/js/google-map.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
  <script src="${pageContext.servletContext.contextPath}/resources/js/main.js"></script>
    
  </body>
</html>