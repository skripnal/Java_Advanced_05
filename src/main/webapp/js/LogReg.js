$(document).ready(function() {
    $("#register").click(function() {
        event.preventDefault();

        var firstName = $("#firstName").val();
        var lastName = $("#lastName").val();
        var email = $("#email").val();
        var password = $("#password").val();
        if (firstName == '' || lastName == '' || email == '' || password == '') {
            alert("Будь ласка заповніть всі поля!");
        } else if ((password.length) < 8) {
            alert("Пароль повинен містити 8 чи більше символів!");
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


$(document).ready(function() {
    $("#login").click(function() {
        event.preventDefault();

        var email = $("#email").val();
        var password = $("#password").val();
        if (email == '' || password == '') {
            alert("Будь ласка заповніть всі поля!");
        } else {
            $.post("loginServlet", {
                email: email,
                password: password
            }, function(data) {
                if (data.trim() === 'success') {
                    window.location.href = "userPage.jsp";
                }else{
                    $("form")[0].reset();
                }
            });
        }
    });
});