function validatePass() {
    var oldpass = document.forms["newpass-form"]["oldpass"].value;
    var newpass = document.getElementById("newpass").value;
    var newpass2 = document.getElementById("newpass2").value;

    var regex = new RegExp("[A-Za-z0-9]{5}.*");
    var flag = true;

    if(!regex.test(oldpass)) {
        document.getElementById("oldpass").style.backgroundColor = 'RED';
        flag = false;
    } else {
        document.getElementById("oldpass").style.backgroundColor = 'WHITE';
    }

    if(!regex.test(newpass)) {
        document.getElementById("newpass").style.backgroundColor = 'RED';
        flag = false;
    } else {
        document.getElementById("newpass").style.backgroundColor = 'WHITE';
    }

    if(!regex.test(newpass2)) {
        document.getElementById("newpass2").style.backgroundColor = 'RED';
        flag = false;
    } else {
        document.getElementById("newpass2").style.backgroundColor = 'WHITE';
    }

    if(newpass != newpass2) {
        document.getElementById("newpass").style.backgroundColor = 'RED';
        document.getElementById("newpass2").style.backgroundColor = 'RED';
        flag = false;
    } else {
        if(flag) {
            document.getElementById("newpass").style.backgroundColor = 'WHITE';
            document.getElementById("newpass2").style.backgroundColor = 'WHITE';
        }
    }

    return flag;
}