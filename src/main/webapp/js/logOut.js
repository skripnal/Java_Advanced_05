$( document ).ready(function() {
    $('#logOut').on('click', function(e) {
        e.preventDefault();
        $.get("logOutServlet", function (data){
            if (data.trim() === 'success') {
                window.location.href = "index.jsp";
            }
        });
    });
});