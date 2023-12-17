$(document).ready(function() {
    $("#login").click(function(e) {
        e.preventDefault();

        var email = $("#email").val();
        var password = $("#password").val();
        if (email == '' || password == '') {
            $(".alert").html("Заповніть всі поля");
            $(".alert").addClass("alert-show");
            setTimeout(function (){
                $(".alert").removeClass("alert-show");
            },5000);
        } else {
            $.post("loginServlet", {
                email: email,
                password: password
            }, function(data) {
                if (data === 'user' || data === 'admin') {
                    window.location.href = "shop.jsp";
                }else {
                    $(".alert").html("Некоректні данні для входу");
                    $(".alert").addClass("alert-show");
                    setTimeout(function (){
                        $(".alert").removeClass("alert-show");
                    },5000);
                }
            });
        }
    });
});