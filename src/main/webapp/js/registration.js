$(document).ready(function() {
    $("#register").click(function(e) {
        e.preventDefault();

        var firstName = $("#firstName").val();
        var lastName = $("#lastName").val();
        var email = $("#email").val();
        var password = $("#password").val();
        if (firstName == '' || lastName == '' || email == '' || password == '') {
            $(".alert").html("Заповніть всі поля");
            $(".alert").addClass("alert-show");
            setTimeout(function (){
                $(".alert").removeClass("alert-show");
            },5000);
        } else if ((password.length) < 8) {
            $(".alert").html("Пароль повинен містити не менше 8 символів");
            $(".alert").addClass("alert-show");
            setTimeout(function (){
                $(".alert").removeClass("alert-show");
            },5000);
        }  else {
            $.post("registrationServlet", {
                firstName: firstName,
                lastName: lastName,
                email: email,
                password: password
            }, function(data) {
                if (data.trim() === 'success') {
                    window.location.href = "login.jsp";
                }else{
                    $("form")[0].reset();
                }
            });
        }
    });
});



