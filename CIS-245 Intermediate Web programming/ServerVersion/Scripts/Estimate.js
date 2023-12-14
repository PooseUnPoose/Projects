function GetEstimate() {
  const checkboxes = document.querySelectorAll('input[type="checkbox"]');
  const checkedCheckboxes = [];
  checkboxes.forEach(checkbox => {
    if (checkbox.checked) {
      checkedCheckboxes.push(checkbox.value);
    }
  });

  sessionStorage.setItem('Estimate items', JSON.stringify(checkedCheckboxes));
}
const button = document.getElementById('GetEstimate');
button.addEventListener('click', GetEstimate);

