document.addEventListener("DOMContentLoaded", () => {

    const checkedItemsList = document.getElementById("CheckedItems");
    const estimateItems = JSON.parse(sessionStorage.getItem("Estimate items"));

    if (estimateItems && estimateItems.length > 0) {
        let price = 0; 
        let tax = 0.12;
        let Total = 0; 
        estimateItems.forEach((item) => {
            const listItem = document.createElement("li");
            listItem.textContent = item;
            checkedItemsList.appendChild(listItem);

            let subprice = item.substring(item.indexOf("$") + 1);
            price = price + parseFloat(subprice); // Update the price variable
            console.log(price);
            let taxprice = price * tax;
            let Total = price + taxprice;
            console.log(Total);
            console.log(taxprice);

            sessionStorage.setItem("subtotal", price);
            sessionStorage.setItem("tax", taxprice);
            sessionStorage.setItem("Total", Total);

        });

        const SubPrice = document.getElementById("subtotal");
        const TaxPrice = document.getElementById("tax");
        const TotalPrice = document.getElementById("total");

        const subtotalValue = sessionStorage.getItem("subtotal");
        const taxValue = sessionStorage.getItem("tax");
        const totalValue = sessionStorage.getItem("Total");

        TotalPrice.textContent = totalValue;
        SubPrice.textContent = subtotalValue;
        TaxPrice.textContent = taxValue;


    }

    
});