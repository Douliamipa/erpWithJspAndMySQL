package gr.aueb.cf.erpProjectWithSQLAndJsp;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/hello-servlet")
public class HelloController extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("    <title>Invoice</title>");
        out.println("    <style>");
        // Include your CSS styles here
        out.println("    </style>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <div class=\"invoice-header\">");
        out.println("        <h1>Invoice</h1>");
        out.println("        <p>Issued on: August 17, 2023</p>");
        out.println("        <p>Due date: September 1, 2023</p>");
        out.println("    </div>");
        out.println("    <div class=\"invoice-details\">");
        out.println("        <h2>Bill To:</h2>");
        out.println("        <p>Client Name: John Doe</p>");
        out.println("        <p>Address: 123 Main Street, Cityville</p>");
        out.println("        <p>Email: john@example.com</p>");
        out.println("    </div>");
        out.println("    <div class=\"company-details\">");
        out.println("        <h2>From:</h2>");
        out.println("        <p>Company Name: </p>");
        out.println("        <p>Address: </p>");
        out.println("        <p>Email: </p>");
        out.println("    </div>");
        out.println("    <table class=\"invoice-table\">");
        out.println("        <thead>");
        out.println("            <tr>");
        out.println("                <th>Service Description</th>");
        out.println("                <th>Quantity</th>");
        out.println("                <th>Rate</th>");
        out.println("                <th>Total</th>");
        out.println("            </tr>");
        out.println("        </thead>");
        out.println("        <tbody>");
        out.println("            <tr>");
        out.println("                <td>Consulting Services</td>");
        out.println("                <td>5 hours</td>");
        out.println("                <td>$100.00 per hour</td>");
        out.println("                <td>$500.00</td>");
        out.println("            </tr>");
        out.println("            <tr>");
        out.println("                <td>Design and Development</td>");
        out.println("                <td>10 hours</td>");
        out.println("                <td>$75.00 per hour</td>");
        out.println("                <td>$750.00</td>");
        out.println("            </tr>");
        out.println("            <tr>");
        out.println("                <td colspan=\"3\"><strong>Total</strong></td>");
        out.println("                <td>$1,250.00</td>");
        out.println("            </tr>");
        out.println("        </tbody>");
        out.println("    </table>");
        out.println("    <div class=\"invoice-total\">");
        out.println("        <p><strong>Total Amount Due:</strong> $1,250.00</p>");
        out.println("    </div>");
        out.println("</body>");
        out.println("</html>");


    }

    public void destroy() {
    }
}