// Get the active filter button from localStorage, or default to "all"
var activeFilter = localStorage.getItem("activeFilter") || "all";

// Apply the active filter on page load
filterSelection(activeFilter);
document.querySelector(`#myBtnContainer .btn[data-filter="${activeFilter}"]`).classList.add("active");

function filterSelection(c) {
  var Column, i;
  Column = document.getElementsByClassName("column");
  if (c == "all") c = "";
  for (i = 0; i < Column.length; i++) {
    RemoveClass(Column[i], "show");
    if (Column[i].className.indexOf(c) > -1) AddClass(Column[i], "show");
  }

  // Store the active filter in localStorage
  localStorage.setItem("activeFilter", c);
}

function AddClass(element, name) {
  var i, arr1, arr2;
  arr1 = element.className.split(" ");
  arr2 = name.split(" ");
  for (i = 0; i < arr2.length; i++) {
    if (arr1.indexOf(arr2[i]) == -1) {element.className += " " + arr2[i];}
  }
}

function RemoveClass(element, name) {
  var i, arr1, arr2;
  arr1 = element.className.split(" ");
  arr2 = name.split(" ");
  for (i = 0; i < arr2.length; i++) {
    while (arr1.indexOf(arr2[i]) > -1) {
      arr1.splice(arr1.indexOf(arr2[i]), 1);     
    }
  }
  element.className = arr1.join(" ");
}


// Add click event listener to filter buttons
var btnContainer = document.getElementById("myBtnContainer");
var btns = btnContainer.getElementsByClassName("btn");
for (var i = 0; i < btns.length; i++) {
  btns[i].addEventListener("click", function(){
    var current = document.getElementsByClassName("active");
    current[0].className = current[0].className.replace(" active", "");
    this.classList.add("active");
    var filter = this.getAttribute("data-filter");
    filterSelection(filter);
  });
}