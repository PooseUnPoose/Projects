
const express = require('express');
const path = require('path');
const app = express();
var nodemailer = require('nodemailer');
const port = 9999;

app.get('/favicon.ico', (req, res) => res.status(204).end());


var mailOptions = {
    from: 'JoshWStudentBurner@gmail.com',
    to: 'Joshwhitehead30@gmail.com',
    subject: 'Sending Email using Node.js',
    text: 'Thank you for your interest in our company. We will be in touch shortly.'
};

  
  transporter.sendMail(mailOptions, function(error, info){
    if (error) {
      console.log(error);
    } else {
      console.log('Email sent: ' + info.response);
    }
  }); 
  
  
  
// Basic route
app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, 'Index.html'));
  });
  
// Route with query string
// Redirect to another route
app.get('/redirect', (req, res) => {
  res.redirect('/');
});

// Serve static HTML file
app.get('/Contact', (req, res) => {
  res.sendFile(path.join(__dirname, 'Contact.html'));
});

app.get('/Portfolio', (req, res) => {
  res.sendFile(path.join(__dirname, 'Portfolio.html'));
});

app.get('/Estimates', (req, res) => {
  res.sendFile(path.join(__dirname, 'Estimates.html'));
});

// 404 handling
app.use((req, res) => {
  res.status(404).send('Page not found');
});

app.listen(port, '0.0.0.0', () => {
  console.log(`Server running on http://0.0.0.0:${port}`);
});
