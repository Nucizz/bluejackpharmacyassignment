package com.example.bluejackpharmacy;

import com.example.bluejackpharmacy.object.Medicine;
import com.example.bluejackpharmacy.object.Transaction;
import com.example.bluejackpharmacy.object.User;

import java.util.ArrayList;
public class Data {
    public static ArrayList<User> userList = new ArrayList<>();
    public static final String USER_FILE = "user.txt";

    public static ArrayList<Medicine> medicineList = new ArrayList<>();
    public static final String MEDICINE_FILE = "medicine.txt";

    public static ArrayList<Transaction> transactionList = new ArrayList<>();
    public static final String TRANSACTION_FILE = "transaction.txt";

    public static void quickInit() {
        Data.userList.add(new User(-1, "admin debug test", "admin", User.hashPassword("admin"), "0"));

        medicineList.add(new Medicine(1, "Promag Suspensi 60ml", "Kalbe Farma", 11400.00, "PROGMAG merupakan obat sakit maag yang mengandung Hydrococo.", "https://d2qjkwm11akmwu.cloudfront.net/products/881948_2-12-2021_16-26-6-1665834167.webp"));
        medicineList.add(new Medicine(2, "Promag Suspensi 120ml", "Kalbe Farma", 16300.00, "PROGMAG merupakan obat sakit maag yang mengandung Hydrococo.", "none"));
        medicineList.add(new Medicine(1, "Promag Suspensi 60ml", "Kalbe Farma", 11400.00, "PROGMAG merupakan obat sakit maag yang mengandung Hydrococo.", "none"));
        medicineList.add(new Medicine(2, "Promag Suspensi 120ml", "Kalbe Farma", 16300.00, "PROGMAG merupakan obat sakit maag yang mengandung Hydrococo.", "none"));
        medicineList.add(new Medicine(1, "Promag Suspensi 60ml", "Kalbe Farma", 11400.00, "PROGMAG merupakan obat sakit maag yang mengandung Hydrococo.", "none"));
        medicineList.add(new Medicine(2, "Promag Suspensi 120ml", "Kalbe Farma", 16300.00, "PROGMAG merupakan obat sakit maag yang mengandung Hydrococo.", "none"));
        medicineList.add(new Medicine(1, "Promag Suspensi 60ml", "Kalbe Farma", 11400.00, "PROGMAG merupakan obat sakit maag yang mengandung Hydrococo.", "none"));
        medicineList.add(new Medicine(2, "Promag Suspensi 120ml", "Kalbe Farma", 16300.00, "PROGMAG merupakan obat sakit maag yang mengandung Hydrococo.", "none"));
        medicineList.add(new Medicine(1, "Promag Suspensi 60ml", "Kalbe Farma", 11400.00, "PROGMAG merupakan obat sakit maag yang mengandung Hydrococo.", "none"));
        medicineList.add(new Medicine(2, "Promag Suspensi 120ml", "Kalbe Farma", 16300.00, "PROGMAG merupakan obat sakit maag yang mengandung Hydrococo.", "none"));
        medicineList.add(new Medicine(1, "Promag Suspensi 60ml", "Kalbe Farma", 11400.00, "PROGMAG merupakan obat sakit maag yang mengandung Hydrococo.", "none"));
        medicineList.add(new Medicine(2, "Promag Suspensi 120ml", "Kalbe Farma", 16300.00, "PROGMAG merupakan obat sakit maag yang mengandung Hydrococo.", "none"));
        medicineList.add(new Medicine(1, "Promag Suspensi 60ml", "Kalbe Farma", 11400.00, "PROGMAG merupakan obat sakit maag yang mengandung Hydrococo.", "none"));
        medicineList.add(new Medicine(2, "Promag Suspensi 120ml", "Kalbe Farma", 16300.00, "PROGMAG merupakan obat sakit maag yang mengandung Hydrococo.", "none"));
        medicineList.add(new Medicine(1, "Promag Suspensi 60ml", "Kalbe Farma", 11400.00, "PROGMAG merupakan obat sakit maag yang mengandung Hydrococo.", "none"));
        medicineList.add(new Medicine(2, "Promag Suspensi 120ml", "Kalbe Farma", 16300.00, "PROGMAG merupakan obat sakit maag yang mengandung Hydrococo.", "none"));

        transactionList.add(new Transaction(1, userList.get(0), medicineList.get(0), 3, "20 Apr 2003 17:24"));
    }

}
