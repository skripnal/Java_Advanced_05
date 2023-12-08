var products = null;
var product;
$(document).ready(function (){
    $.get("addProductServlet",function (data){
        if (data !== ""){
            products = data;
        }
    }).done(function (){
        var cardsContent = "";
        jQuery.each(products,function (i,value){
            cardsContent +=
                '       <div class="col">\n' +
                '          <div class="card">\n' +
                '            <div class="card-body">\n' +
                '              <h5 class="card-title">' + value.name + '</h5>\n' +
                '              <p class="card-text">'+ value.description +'</p>\n' +
                '              <a href="#" class="card-link card-single" data-product-id="'+ value.id +'">Переглянути продукт</a>\n' +
                '              <a href="#" class="card-link card-buy-button" data-product-id="'+ value.id +'">Додати до кошика &#8372;'+ value.price +'</a>\n' +
                '            </div>\n' +
                '          </div>\n' +
                '        </div>\n';

        });
        $("main .row").html(cardsContent);
        $(".card-buy-button").click(function (e){
            e.preventDefault();
            var productId = $(this).data("product-id");
            $.post("buyProduct", {productIdAdd:productId},function (){
                alert("Продукт додано до корзини");
            });
        });
        $(".card-single").click(function(e) {
            e.preventDefault();
            var productId = $(this).data("product-id");
            $.get("singleProduct", { id: productId }, function(data) {
                product = data;
            }).done(function (){
                localStorage.setItem("product", JSON.stringify(product));
                window.location.href = "singleProduct.jsp";
            });
        });

    });
});







