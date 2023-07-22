<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Stylesheet.css">
    <title>Genesis Book store</title>
</head>
<body>
<div id="logo"></div>
      <nav>
        <div class="navbar">
            <a href="Index.html">Home</a> 
            <a href="Products.html"> Products</a> 
            <a class="active" href="Contact.html"> Contact</a> 
        </div>
    </nav>
  </div>
    <h2> Contact us</h2>
    <?php
    $ContName = $_POST["ContName"];
    $ContEmail = $_POST["ContEmail"];
    $SelectOption = $_POST["SelectOption"];
    

    if ($SelectOption == "Request"){
            $OptionChoice = "requesting a book from us. we will get back to you with an ETA and pricing when we have it available";}
        elseif ($SelectOption =="Inquiry"){
            $OptionChoice = "inquiring about your order, we will get back to you with your order status";}
            elseif ($SelectOption =="Contact"){
                $OptionChoice="getting in contact with us, we will get back to you at the email address you provided in 1-4 business days";}
    $message ="$ContName, Thank you for reaching out to us, we will contact you in 1-4 business days";


    print "Thank you for contacting us $ContName, We will get contact to you at $ContEmail, about $OptionChoice";
    mail($ContEmail, 'Genesis Bookstore', $message);
    
    ?>
    <br>
    <a href="Contact.html"><button class="ReturnButton">Return to page.</button></a>
    <!-- This needs to have a form with 3 input types
    PHP script must be used to handle all the form data (provide output/send to email)-->
</body>
</html>