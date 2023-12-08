$(document).ready(function (){
    var value = JSON.parse(localStorage.getItem("product"));
    var cardContent = "";
    cardContent +=
        '       <div class="col">\n' +
        '          <div class="card">\n' +
        '            <div class="card-body">\n' +
        '              <h5 class="card-title">' + value.name + '</h5>\n' +
        '              <p class="card-text">'+ value.description +'</p>\n' +
        '              <a href="" class="card-link">'+ value.price +'</a>\n' +
        '            </div>\n' +
        '          </div>\n' +
        '        </div>\n';

    $(".single-page-product").html(cardContent);
});