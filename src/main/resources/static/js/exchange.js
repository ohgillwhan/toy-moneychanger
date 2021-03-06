function updateRate() {
    var destination = $("[name=destination]").val();
    $.ajax({
        url: "/exchange-rate?source=USD&destination=" + destination,
        success : function(data) {
            $("#rate").text(data.ratePretty);
        }
    })
}