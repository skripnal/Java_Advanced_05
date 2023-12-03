$( document ).ready(function() {
    $('#logOut').on('click', function(e) {
        event.preventDefault();
        $.get("logOutServlet", function (data){
            if (data.trim() === 'success') {
                window.location.href = "index.jsp";
            }
        });
    });
});