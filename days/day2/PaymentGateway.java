package day2;
// intitilize our interface payment gateway with method
public interface PaymentGateway{
    void initiatePayment(double amount);
}
class StripePayment implements PaymentGateway{
    public void initiatePayment(double amount){
        System.out.println("processing payment via Stripe: " +amount);
    }
}
class RazorpayPayment implements PaymentGateway{
    public void initiatePayment(double amount){
        System.out.println("processing payment via Razor: " +amount);
    }
}

//checkout service 
class CheckoutService{
    private PaymentGateway paymentGateway;
    // constructor injection of dependency
    public CheckoutService(PaymentGateway paymentGateway){
        this.paymentGateway=paymentGateway;
    }
    // setter injection of dependency
    public void setPaymentGateway(PaymentGateway paymentGateway){
        this.paymentGateway=paymentGateway;
    }
    public void checkout(double amount){
        paymentGateway.initiatePayment(amount);
    }

}

class Main {
    public static void main(String[] args) {
        PaymentGateway stripeGateway = new StripePayment();
        CheckoutService service = new CheckoutService(stripeGateway);
        service.checkout(120.50);  // Output: Processing payment via Stripe: $120.5

       // Switch to Razorpay
        PaymentGateway razorpayGateway = new RazorpayPayment();
        service.setPaymentGateway(razorpayGateway);
        service.checkout(150.50);  // Output: Processing payment via Razorpay: ₹150.5        
    }
}

