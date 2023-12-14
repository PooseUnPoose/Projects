const Form = document.querySelector('form');
const $ = selector => document.querySelector(selector);
const EmailInput = document.getElementById('Email');
const FNameInput = document.getElementById('Name');
const MessageInput = document.getElementById('Message');
const OptionInput = document.getElementById('Options');

document.addEventListener("DOMContentLoaded", () => {
    const savedName = localStorage.getItem('name');
    if (savedName) {
        FNameInput.value = savedName;
    }

    Form.addEventListener('submit', (event) => {
        EmailError.textContent = '';
        NameError.textContent = '';
        MessageError.textContent = '';

        event.preventDefault();
        if (FNameInput.value === '') {
            NameError.textContent = ' Please enter your name';
            $('#Name').focus();
            return;
        }
        const EmailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!EmailRegex.test(EmailInput.value)) {
            EmailError.textContent = ' Please enter a valid email address';
            $('#Email').focus();
            return;
        }
        if (OptionInput.value != 'Inquiry' && OptionInput.value != 'Request' && OptionInput.value != 'Sales' && OptionInput.value != 'Other') {
            alert('Please do not change the selection options');
            $('#Options').focus();
            return;
        }
        if (MessageInput.value === '') {
            MessageError.textContent = ' Please enter enter a message';
            $('#Message').focus();
            return;
        }
        sessionStorage.setItem('name', FNameInput.value);

        Reply.textContent = 'Thank you ' + FNameInput.value + ', we will get back to you as soon as we can!';
                
                document.getElementById('Submit').disabled = true;
                //This is where you would send the data to a database
                localStorage.setItem('name' , FNameInput.value);
                localStorage.setItem ('Email', EmailInput.value);
                localStorage.setItem ('Option', OptionInput.value);
                localStorage.setItem ('Message', MessageInput.value);
                $('#Reply').text = 'Thank you, we will get back to you as soon as we can!';
                document.getElementById('myForm').reset();
        });
});
