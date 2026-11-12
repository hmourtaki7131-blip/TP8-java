
package com.tp8.application;

import com.tp8.payment.*;
import com.tp8.notification.*;

public class Main {

    public static void main(String[] args) {

        // ===== TESTS DU SYSTEME DE PAIEMENT =====

        System.out.println("===== TESTS PAIEMENT =====");

        // Test avec carte bancaire
        PaymentProcessor cardProcessor =
                new CreditCardProcessor("4111-1111-1111-1111");

        PaymentService cardService =
                new PaymentService(cardProcessor);

        cardService.pay(50.0);

        System.out.println("\n========================================\n");

        // Test avec virement bancaire
        PaymentProcessor transferProcessor =
                new BankTransferProcessor("FR76-3000-6000-0112-3456");

        PaymentService transferService =
                new PaymentService(transferProcessor);

        transferService.pay(150.0);


        // ===== TESTS DU SYSTEME DE NOTIFICATION =====

        System.out.println("\n========================================");
        System.out.println("===== TESTS NOTIFICATIONS =====\n");

        // Test Email
        NotificationSender emailSender =
                new EmailNotificationSender();

        NotificationService emailService =
                new NotificationService(emailSender);

        emailService.sendWelcomeMessage("user@example.com");

        System.out.println();

        // Test SMS
        NotificationSender smsSender =
                new SmsNotificationSender();

        NotificationService smsService =
                new NotificationService(smsSender);

        smsService.sendWelcomeMessage("+33612345678");

        System.out.println("\n===== FIN DES TESTS =====");
    }
}

