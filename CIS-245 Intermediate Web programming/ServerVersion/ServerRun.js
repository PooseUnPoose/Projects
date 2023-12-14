
const express = require('express');
const path = require('path');
const app = express();
const port = 8888;

app.get('/favicon.ico', (req, res) => res.status(204).end());

// Basic route
app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'Index.html'));
});
app.get('/Estimate', (req, res) => {
  res.sendFile(path.join(__dirname, 'Estimate.html'));
});
app.get('/Estimate/Total', (req, res) => {
  res.sendFile(path.join(__dirname, 'EstimateCalc.html'));
});
app.get('/Contact', (req, res) => {
  res.sendFile(path.join(__dirname, 'Contact.html'));
});
app.get('/Portfolio', (req, res) => {
  res.sendFile(path.join(__dirname, 'Portfolio.html'));
});
// Redirect to another route
app.get('/redirect', (req, res) => {
  res.redirect('/');
});
// 404 handling
app.use((req, res) => {
  res.status(404).send('Page not found');
});
app.use(express.static(public));

app.listen(port, '0.0.0.0', () => {
  console.log(`Server running on http://0.0.0.0:${port}`);
});
