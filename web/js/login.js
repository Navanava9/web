function $(id) {
    return document.getElementById(id);
}

function click_login() {

    var ID = $("username").value;
    var pw = $("password").value;
    if (!ID && !pw) {
        $("warningBox").style.display = "block";
        $("warningText").innerHTML = "Please enter your ID, password!";
    } else if (!ID && pw) {
        $("warningBox").style.display = "block";
        $("warningText").innerHTML = "Please enter your ID!";
    } else if (ID && !pw) {
        $("warningBox").style.display = "block";
        $("warningText").innerHTML = "Please enter your password!";
    } else {
        $("warningBox").style.display = "none";
    }
}