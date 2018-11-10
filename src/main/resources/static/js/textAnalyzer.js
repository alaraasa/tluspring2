function doPostRequestWithText () {
    var text = $("input[id='userText']").val();
    $.ajax({
        url: "http://localhost:8080/lepa",
        data: { text: text },
        type: "POST",
        success: function (response) {
            showResults(response);
        },
        error: function (response) {
            console.log(response);
        }
    });
}

function showResults(data) {
    $('#resultBox').innerText = data;
}