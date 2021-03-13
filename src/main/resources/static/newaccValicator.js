function validateAcc() {
    var login = document.forms["newacc-form"]["login"].value;

    var regex = new RegExp("[A-Za-z0-9]{5}.*");
    var flag = true;

    if(!regex.test(login)) {
        document.getElementById("login").style.backgroundColor = 'RED';
        flag = false;
    } else {
        document.getElementById("login").style.backgroundColor = 'WHITE';
    }


    return flag;
}