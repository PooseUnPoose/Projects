const ThemeMap ={
    Dark: "Light",
    Light: "Dark"
};
const Theme = localStorage.getItem("Theme") 
    || (tmp = Object.keys(ThemeMap)[0], localStorage.setItem("Theme", tmp), tmp);
const BodyClass = document.body.classList;
BodyClass.add(Theme);

function ToggleTheme(){
    const CurrentTheme = localStorage.getItem("Theme");
    const NextTheme = ThemeMap[CurrentTheme];
    BodyClass.replace(CurrentTheme, NextTheme);
    localStorage.setItem("Theme", NextTheme);
}
document.addEventListener("DOMContentLoaded", () => {   
    document.getElementById("ThemeButton").onclick = ToggleTheme;
});