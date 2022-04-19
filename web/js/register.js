function $(id) {
    return document.getElementById(id);
}

function click_register() {
    var ID = $("username").value;
    var pw = $("password").value;
    var rpw = $("re_password").value;
    if (!ID && !pw && !rpw) {
        $("warningBox").style.display = "block";
        $("warningText").innerHTML = "Please enter your ID, password!";
    } else if (!ID && pw) {
        $("warningBox").style.display = "block";
        $("warningText").innerHTML = "Please enter your ID!";
    } else if (ID && !pw) {
        $("warningBox").style.display = "block";
        $("warningText").innerHTML = "Please enter your password!";
    } else {
        if (pw != rpw) {
            $("warningBox").style.display = "block";
            $("warningText").innerHTML = "The passwords are inconsistent!";
        } else {
            $("warningBox").style.display = "none";
        }
    }
}