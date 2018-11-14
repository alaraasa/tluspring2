$(document).ready(function() {
    getAllTexts();
});

function getAllTexts(){
    var params = new URLSearchParams(window.location.search);
    $.ajax({
        url: "http://localhost:8080/lepa",
        data: { id: params.get("id") },
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
    var div = "<div id='result'>";
    for( var i = 0; i < data.length; i++) {
        div += "<p> Pair: " + data[i].pair + " Amount: " + data[i].amount + "</p>";
    }
    div += "</div>";
    $("body").append( div );
}