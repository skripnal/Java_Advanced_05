var products = null;
var product;
var cardsContent = "";
$(document).ready(function (){
    updateShop();

    $(document).on("click", ".to-single-card", function(e){
        e.preventDefault();
        var productId = $(this).data("product-id");
        $.get("singleProduct", { id: productId }, function(data) {
            product = data;
        }).done(function (){
            localStorage.setItem("product", JSON.stringify(product));
            window.location.href = "singleProduct.jsp";
        });
    });

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
    function getCards(category, subCategory){
        $.get("addProductServlet",{category:category,subCategory:subCategory},function (data){
            if (data !== ""){
                products = data;
            }
        }).done(function (){
            jQuery.each(products,function (i,value){
                cardsContent += '<div class="col-md-12 col-lg-4 mb-4 mb-lg-5">\n' +
                    '                <div class="card text-black">\n' +
                    '                    <a href="" class="mt-2 to-single-card" data-product-id = "'+ value.id +'">\n' +
                    '                        <img src="'+ value.imagePath +'"class="card-img-top" alt="Card" />\n' +
                    '                    </a>\n' +
                    '                    <div class="card-body">\n' +
                    '                        <div class="text-center mt-1">\n' +
                    '                            <h4 class="card-title">'+value.name+'</h4>\n' +
                    '                            <h6 class="text-primary mb-1 pb-3">Починається з &#8372;'+value.price+'</h6>\n' +
                    '                        </div>\n' +
                    '                        <div class="text-center">\n' +
                    '                            <div class="d-flex flex-column mb-4">\n' +
                    '                                <span class="card-description">'+value.description+'</span>\n' +
                    '                            </div>\n' +
                    '                        </div>\n' +
                    '                        <div class="d-flex flex-row">\n' +
                    '                            <button type="button" class="btn btn-primary flex-fill me-1 to-single-card" data-mdb-ripple-color="dark" data-product-id = "'+ value.id +'">\n' +
                    '                                Детальніше\n' +
                    '                            </button>\n' +
                    '                            <button type="button" class="btn btn-danger flex-fill ms-1 card-buy-button" data-product-id = "'+ value.id +'">Купити</button>\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                </div>\n' +
                    '            </div>';
            });
            $(".shop-cards .container .row").html(cardsContent);
        });
    }
    function updateShop(){
        cardsContent = "";
        var inputName = [];
        var inputValue = [];
        if ($(".filter-checkbox:checked").length>0){
            $(".filter-checkbox:checked").each(function (){
                inputName.push($(this).attr("name"));
                inputValue.push($(this).attr("value"));
            });
            getCards(inputName,inputValue);
        }else {
            getCards(inputName, inputValue);
        }

    }
    //
    $(".filter-checkbox").click(function (){
        updateShop();
    });
    //
});







