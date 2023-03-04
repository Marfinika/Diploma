package data;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.Value;

import java.util.Random;

public class DataHelper {
    private DataHelper(){

    }

    private static String getCardNumber(String card){
        switch (card.toLowerCase()){
            case ("approved"):
                return "4444 4444 4444 4441";

            case ("rejected"):
                return "4444 4444 4444 4442";

            default:
                return "4444 4444 4444 4444";
        }
    }

    private static String getFullName(){
        return new Faker().name().firstName().toUpperCase() + "" + new Faker().name().firstName().toUpperCase();
    }

    private static String getCvc(){
        Random Cvv = new Random();
        return String.valueOf(Cvv.nextInt(10)) + Cvv.nextInt(10 ) + Cvv.nextInt(10);

    }
    @Value
    public static class  RequiredFields {
        String cardNumber;
        String month;
        String year;
        String owner;
        String cvc;
    }
    public static RequiredFields getValidApproved(){
        return new RequiredFields(getCardNumber("APPROVED"), "12","26", getFullName(),getCvc());
    }
    public static RequiredFields getValidDeclinedFields() {
        return new RequiredFields(getCardNumber("DECLINED"), "12", "26", getFullName(), getCvc());
    }
    public static RequiredFields getInvalidOwnerFields() {
        return new RequiredFields(getCardNumber("APPROVED"), "12", "26", "ъ", getCvc());
    }
    public static RequiredFields getInvalidCardFields() {
        return new RequiredFields(getCardNumber("INVALID"), "12", "26", getFullName(), getCvc());
    }

    @Data
    public class Fields {
        private String id;
        private int amount;
        private String status;
        private String created;
        private String bank_id;
        private String credit_id;
        private String payment_id;
        private String transaction_id;
    }
}
