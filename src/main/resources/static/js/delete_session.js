function sendDeleteSession(url) {
    if (confirm("Delete this session?")) {
        var xhttp = new XMLHttpRequest();
        xhttp.open("DELETE", url, true);
        xhttp.onload = function () {
            let responseURL = xhttp.responseURL;
            console.log("Redirecting to:", responseURL);
            window.location.replace(responseURL);
        };
        xhttp.send();
    }
}