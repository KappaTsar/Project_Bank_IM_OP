function validateTransfer() {
    var title = document.forms["trans-form"]["title"].value;
    var accNumber = document.forms["trans-form"]["accNumber"].value;
    var amount = document.forms["trans-form"]["amount"].value;

    var regexTxt = new RegExp("[A-Za-z0-9,.]{3}.*");
    var regexNum = new RegExp("[0-9]{26}");
    var regexCrd = new RegExp("[0-9,]+");
    var flag = true;

    if(!regexTxt.test(title)) {
        document.getElementById("title").style.backgroundColor = 'RED';
        flag = false;
    } else {
        document.getElementById("title").style.backgroundColor = 'WHITE';
    }
    if(!regexNum.test(accNumber)) {
        document.getElementById("accNumber").style.backgroundColor = 'RED';
        flag = false;
    } else {
        document.getElementById("accNumber").style.backgroundColor = 'WHITE';
    }

    if(!regexCrd.test(amount)) {
        document.getElementById("amount").style.backgroundColor = 'RED';
        flag = false;
    } else {
        document.getElementById("amount").style.backgroundColor = 'WHITE';
    }

    return flag;
}