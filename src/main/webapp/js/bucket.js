var bucket;
$(document).ready(function (){
    updateBucket();
    function updateBucket(){
        $.get("bucket",function (data){
            bucket = data;
        }).done(function (){
            var bucketContent = "";
            var bucketPrice = 0;
            var deliveryCost = 100;
            jQuery.each(bucket, function (i, value){
                bucketPrice += value.price;
                bucketContent += '<div class="row border-top border-bottom">\n' +
                    '                        <div class="row main align-items-center">\n' +
                    '                            <div class="col-2"><img class="img-fluid" src="'+ value.imagePath +'"></div>\n' +
                    '                            <div class="col">\n' +
                    '                                <div class="row">'+value.name+'</div>\n' +
                    '                            </div>\n' +
                    '                            <div class="col" style="text-align: right">&#8372; '+value.price+' <a class="delete-product" href="" data-bucket-product-id="'+value.bucketId+'">&#10005;</a></div>\n' +
                    '                        </div>\n' +
                    '                    </div>'
            });
            $(".bucket-products").html(bucketContent);
            $(".product-count").html("Товарів "+bucket.length);
            $(".bucket-price").html("&#8372;" + bucketPrice);
            $(".delivery-price").html("Доставка - &#8372;" + deliveryCost);
            $(".bucket-delivery-price").html("&#8372;" + (bucketPrice+deliveryCost));

            $(".delete-product").click(function (e){
                e.preventDefault();
                var productId = $(this).data("bucket-product-id");
                $.post("bucket", {productId:productId}, function (){
                    updateBucket();
                });
            });
        });
    }

});