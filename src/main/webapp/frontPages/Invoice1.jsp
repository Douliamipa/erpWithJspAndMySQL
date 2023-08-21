<%@ page contentType="text/html;charset=UTF-8"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Invoice</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .invoice-header {
            text-align: center;
            margin-bottom: 20px;
        }
        .invoice-details, .company-details {
            margin-top: 20px;
        }
        .invoice-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        .invoice-table th, .invoice-table td {
            border: 1px solid #000;
            padding: 8px;
        }
        .invoice-total {
            margin-top: 20px;
            text-align: right;
        }
    </style>
</head>
<body>
<div class="invoice-header">
    <h1>Invoice</h1>
    <p>Issued on: August 17, 2023</p>
    <p>Due date: September 1, 2023</p>
</div>

<div class="invoice-details">
    <h2>Bill To:</h2>
    <p>Client Name: John Doe</p>
    <p>Address: 123 Main Street, Cityville</p>
    <p>Email: john@example.com</p>
</div>

<div class="company-details">
    <h2>From:</h2>
    <p>Company Name: ${companyName}</p>
    <p>Address: ${companyAddress}</p>
    <p>Email: ${companyEmail}</p>
</div>

<table class="invoice-table">
    <thead>
    <tr>
        <th>Service Description</th>
        <th>Quantity</th>
        <th>Rate</th>
        <th>Total</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>Consulting Services</td>
        <td>5 hours</td>
        <td>$100.00 per hour</td>
        <td>${5 * 100}</td>
    </tr>
    <tr>
        <td>Design and Development</td>
        <td>10 hours</td>
        <td>$75.00 per hour</td>
        <td>${10 * 75}</td>
    </tr>
    <tr>
        <td colspan="3"><strong>Total</strong></td>
        <td>${(5 * 100) + (10 * 75)}</td>
    </tr>
    </tbody>
</table>

<div class="invoice-total">
    <p><strong>Total Amount Due:</strong> $<span>${((5 * 100) + (10 * 75))}</span></p>
</div>
</body>
</html>

