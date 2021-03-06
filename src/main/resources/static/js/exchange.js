function updateRate() {
    var destination = $("[name=destination]").val();
    $.ajax({
        url: "/exchange-rate?source=USD&destination=" + destination,
        success : function(data) {
            $("#rate").text(data.ratePretty);
        }
    })
}
function validate(min, max) {
    var amountTag = $("[name=amount]");
    var amountValue = amountTag.val();

    if(!$.isNumeric(amountValue)) {
        alert("숫자만 입력이 가능합니다.")
        amountTag.focus();
        return false;
    }

    var amount = parseInt(amountValue);
    if(amount < min || amount > max) {
        alert("숫자는 " + min + " 이상 " + max + " 이하여야 합니다");
        amountTag.focus();
        return false;
    }
    return true;
}