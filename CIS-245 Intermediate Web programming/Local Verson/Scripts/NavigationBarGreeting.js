
window.addEventListener("load", function() {
    if (sessionStorage.getItem("name")) {
        const name = sessionStorage.getItem("name");
        document.getElementById("Greeting").textContent = `Welcome back, ${name}!`;
    }
});
