package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    static Faker enOption = new Faker(new Locale("en"));
    static Faker faker = new Faker(new Locale("ru"));
    static DataGenerator dataGenerator = new DataGenerator();

    public static class CardNumber {
        public static String getApprovedCardNumber() {
            return "4444444444444441";
        }

        public static String getDeclinedCardNumber() {
            return "4444444444444442";
        }

        public static String getInvalidCardNumber() {
            return "44444444";
        }
    }

    public static CardInformation getValidCard() {
        return new CardInformation(
                CardNumber.getApprovedCardNumber(),
                dataGenerator.shiftYear(1).getYear(),
                dataGenerator.shiftMonth(1).getMonth(),
                enOption.name().fullName(),
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getCurrentMonthAndYear() {
        return new CardInformation(CardNumber.getApprovedCardNumber(),
                dataGenerator.shiftYear(0).getYear(),
                dataGenerator.shiftMonth(0).getMonth(),
                enOption.name().fullName(),
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getDeclinedCard() {
        return new CardInformation(
                CardNumber.getDeclinedCardNumber(),
                dataGenerator.shiftYear(1).getYear(),
                dataGenerator.shiftMonth(1).getMonth(),
                enOption.name().fullName(),
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getAllFieldsEmpty() {
        return new CardInformation(
                " ",
                " ",
                " ",
                " ",
                " ");
    }

    public static CardInformation getCardNumberEmpty() {
        return new CardInformation(
                " ",
                dataGenerator.shiftYear(1).getYear(),
                dataGenerator.shiftMonth(1).getMonth(),
                enOption.name().fullName(),
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getYearEmpty() {
        return new CardInformation(
                CardNumber.getApprovedCardNumber(),
                " ",
                dataGenerator.shiftMonth(1).getMonth(),
                enOption.name().fullName(),
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getMonthEmpty() {
        return new CardInformation(
                CardNumber.getApprovedCardNumber(),
                dataGenerator.shiftYear(2).getYear(),
                " ",
                enOption.name().fullName(),
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getHolderEmpty() {
        return new CardInformation(
                CardNumber.getApprovedCardNumber(),
                dataGenerator.shiftYear(2).getYear(),
                dataGenerator.shiftMonth(2).getMonth(),
                " ",
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getCVVEmpty() {
        return new CardInformation(
                CardNumber.getApprovedCardNumber(),
                dataGenerator.shiftYear(3).getYear(),
                dataGenerator.shiftMonth(2).getMonth(),
                enOption.name().fullName(),
                "");
    }

    public static CardInformation getExpiredYear() {
        return new CardInformation(
                CardNumber.getApprovedCardNumber(),
                dataGenerator.shiftYear(-1).getYear(),
                dataGenerator.shiftMonth(0).getMonth(),
                enOption.name().fullName(),
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getExpiredMonth() {
        return new CardInformation(CardNumber.getApprovedCardNumber(),
                dataGenerator.shiftYear(0).getYear(),
                dataGenerator.shiftMonth(-1).getMonth(),
                enOption.name().fullName(),
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getInvalidNumber() {
        return new CardInformation(
                CardNumber.getInvalidCardNumber(),
                dataGenerator.shiftYear(1).getYear(),
                dataGenerator.shiftMonth(2).getMonth(),
                enOption.name().fullName(),
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getWrongYear() {
        return new CardInformation(
                CardNumber.getApprovedCardNumber(),
                dataGenerator.wrongYear().getYear(),
                dataGenerator.shiftMonth(2).getMonth(),
                enOption.name().fullName(),
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getWrongMonth() {
        return new CardInformation(
                CardNumber.getApprovedCardNumber(),
                dataGenerator.shiftYear(3).getYear(),
                dataGenerator.wrongMonth().getMonth(),
                enOption.name().fullName(),
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getNumericName() {
        return new CardInformation(
                CardNumber.getApprovedCardNumber(),
                dataGenerator.shiftYear(5).getYear(),
                dataGenerator.shiftMonth(2).getMonth(),
                Integer.toString(enOption.number().numberBetween(1, 999)),
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getInvalidCVV() {
        return new CardInformation(
                CardNumber.getApprovedCardNumber(),
                dataGenerator.shiftYear(5).getYear(),
                dataGenerator.shiftMonth(2).getMonth(),
                faker.name().fullName(),
                Integer.toString(enOption.number().numberBetween(0, 99)));
    }

    public static CardInformation getZeroCard() {
        return new CardInformation(
                "0000000000000000",
                dataGenerator.shiftYear(5).getYear(),
                dataGenerator.shiftMonth(2).getMonth(),
                faker.name().fullName(),
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getZeroMonth() {
        return new CardInformation(
                "0000000000000000",
                dataGenerator.shiftYear(0).getYear(),
                "00",
                faker.name().fullName(),
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getZeroCVV() {
        return new CardInformation(
                CardNumber.getApprovedCardNumber(),
                dataGenerator.shiftYear(5).getYear(),
                dataGenerator.shiftMonth(2).getMonth(),
                faker.name().fullName(),
                "000");
    }

    @Value
    public static class CardInformation {
        private String cardNumber;
        private String year;
        private String month;
        private String holder;
        private String CVV;
    }
}