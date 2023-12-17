$(document).ready(function() {
    $("#addProduct").click(function(e) {
        e.preventDefault();

        var name = $("#name").val();
        var description = $("#description").val();
        var price = $("#price").val();
        var category = $("#category").val();
        var sub_category = $("#sub_category").val();
        var image_path = $("#image_path").val();

        if (name == '' || description == '' || price == '' || category == '' || sub_category == '' || image_path == '') {
            alert("Будь ласка заповніть всі поля!");
        }  else {
            $.post("addProductServlet", {
                name: name,
                description: description,
                price: price,
                category: category,
                sub_category: sub_category,
                image_path:image_path
            }, function(data) {
                if (data === 'success') {
                    $("form")[0].reset();
                    alert("Товар додано");
                }else{
                    $("form")[0].reset();
                    alert("Товар не додано");
                }
            });
        }
    });
});