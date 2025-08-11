public class Main {
    public static void main(String[] args) {
        try {
            EmailService emailService = new EmailService();
            PDFGenerator pdfGenerator = new PDFGenerator();
            SecureDataExchange secureData = new SecureDataExchange();

            // Step 1: Encrypt customer data
            String customerData = "Customer ID: 12345, Name: John Doe, Email: john@example.com";
            String encryptedData = secureData.encrypt(customerData);
            System.out.println("Encrypted Data: " + encryptedData);

            // Step 2: Generate PDF with customer data summary
            pdfGenerator.generatePDF("Customer Data: " + customerData, "Customer_12345_Report.pdf");

            // Step 3: Send notification email
            emailService.sendEmail("john@example.com", "Your Report is Ready", "Dear John, your report is attached.");

            // Step 4: Decrypt data to verify
            String decryptedData = secureData.decrypt(encryptedData);
            System.out.println("Decrypted Data: " + decryptedData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

