function validateMoney() {
    var amount = document.forms["innerTrans-form"]["amount"].value;

    var regex = new RegExp("[0-9,]+");
    var flag = true;

    if(!regex.test(amount)) {
        document.getElementById("amount").style.backgroundColor = 'RED';
        flag = false;
    } else {
        document.getElementById("amount").style.backgroundColor = 'WHITE';
    }

    return flag;
}