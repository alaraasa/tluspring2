$(document).ready(function() {
    getAllTexts();
});

function getAllTexts(){
    // var text = $("input[id='userText']").val();
    $.ajax({
        url: "http://localhost:8080/text",
        // data: { text: text },
        type: "GET",
        success: function (response) {
            clearResults();
            showResults( response );
        },
        error: function (response) {
            console.log(response);
        }
    });
}

function clearResults() {
    if( $("#result") !== undefined ){
        $("#result").remove();
    }
}

function showResults( data ) {
    console.log(data);
    var div = "<div id='result'>";
    for( var i = 0; i < data.length; i++) {
        div += "<p> " + data[i].text +
            "<a href='textPair.html?id= " + data[i].id + "'> - <b>GET PAIRS</b></a>" +
            "</p>";
    }
    div += "</div>";
    $("body").append( div );
}