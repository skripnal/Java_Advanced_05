$(document).ready(function() {
    $("#addProduct").click(function() {
        event.preventDefault();

        var name = $("#name").val();
        var description = $("#description").val();
        var price = $("#price").val();

        if (name == '' || description == '' || price == '') {
            alert("Будь ласка заповніть всі поля!");
        }  else {
            $.post("addProductServlet", {
                name: name,
                description: description,
                price: price,
            }, function(data) {
                if (data.trim() === 'success') {
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