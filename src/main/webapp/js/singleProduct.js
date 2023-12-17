$(document).ready(function (){

    var value = JSON.parse(localStorage.getItem("product"));
    var cardContent = "";
    cardContent += '<div class="row justify-content-center">\n' +
        '      <img src="'+ value.imagePath +'" alt="" class="product-img">\n' +
        '    </div>\n' +
        '    <div class="text-center mt-5">\n' +
        '      <h4>'+ value.name +'</h4>\n' +
        '      <h6 class="text-primary">&#8372;'+ value.price +'</h6>\n' +
        '    </div>\n' +
        '    <div class="text-center">\n' +
        '      <p>\n' +
        '        '+ value.description +'\n' +
        '      </p>\n' +
        '    </div>\n' +
        '    <div class="d-flex flex-row justify-content-center">\n' +
        '      <button class="btn btn-danger flex-fill ms-1 card-buy-button" data-product-id = "'+ value.id +'">Купити</button>\n' +
        '    </div>';

    $(".single-product .container").html(cardContent);

    $(document).on("click", ".card-buy-button", function(e){
        e.preventDefault();
        var productId = $(this).data("product-id");
        $.post("buyProduct", {productIdAdd:productId},function (data){
            if (data === 'success'){
                alert("Продукт додано до корзини");
            }else{
                window.location.href = "login.jsp";
            }

        });
    });
});