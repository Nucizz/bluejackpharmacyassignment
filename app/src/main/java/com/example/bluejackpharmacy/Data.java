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

    public static ArrayList<Transaction> allTransactionList = new ArrayList<>();
    public static ArrayList<Transaction> transactionList = new ArrayList<>();
    public static final String TRANSACTION_FILE = "transaction.txt";

    public static void dataUpdate() {
        transactionList.clear();
        for (Transaction transaction : allTransactionList) {
            if(transaction.getEmail().equals(User.currentUser.getEmail())) {
                transactionList.add(transaction);
            }
        }
    }

    public static void quickInit() {
        userList.add(new User(
                0,
                "Calvin Anacia Suciawan",
                "admin",
                User.hashPassword("Admin"),
                "082183928088"
        ));

        medicineList.add(new Medicine(0,
                "Promag Suspensi 60 ml",
                "Sterling",
                11400.00,
                "PROMAG merupakan obat sakit maag yang mengandung Hydrotalcite, Magnesium Hydroxide, dan Simethicone. Obat ini diigunakan untuk meringankan gejala sakit maag akibat kelebihan asam lambung seperti perih, mual, kembung, dan nyeri ulu hati.",
                "https://d2qjkwm11akmwu.cloudfront.net/products/263045_23-3-2023_14-37-36.webp"));
        medicineList.add(new Medicine(1,
                "Panadol Flu & Batuk 3 Strip (10 Kaplet/Strip)",
                "Kalbe Farma",
                41000.00,
                "PANADOL FLU & BATUK merupakan obat batuk dan pereda flu dengan kandungan Paracetamol, Phenylephrine HCI, dan Dextromethorphan HBr. Bekerja sebagai analgesik-antipiretik, masal dekongestan, dan antitusif. Obat ini dapat digunakan untuk meredakan gejala flu seperti: demam, sakit kepala, hidung tersumbat dan batuk tidak berdahak.",
                "https://d2qjkwm11akmwu.cloudfront.net/products/331251_31-8-2022_13-9-16-1665822979.webp"));
        medicineList.add(new Medicine(2,
                "OBH Combi Anak Batuk Plus Flu Apel 60 ml",
                "Combiphar",
                12900.00,
                "OBH COMBI ANAK BATUK PLUS FLU mengandung zat aktif Extract Succus liquiritae, Paracetamol, Ammonium Chlorida, Pseudoephedrine HCl dan Chlorpheniramine Maleat. Obat ini digunakan untuk mengatasi gejala flu seperti demam, sakit kepala, bersin-bersin dan hidung tersumbat yang disertai batuk pada anak. Obat ini menyebabkan kantuk.",
                "https://d2qjkwm11akmwu.cloudfront.net/products/5388-1665772300.webp"));
        medicineList.add(new Medicine(3,
                "Entrostop 20 Tablet",
                "Kalbe Farma",
                111400.00,
                "\n" +
                        "NEO ENTROSTOP merupakan obat untuk mengatasi diare dengan kandungan Attapulgit dan Pektin. Obat ini dapat digunakan untuk mengobati diare non spesifik.",
                "https://d2qjkwm11akmwu.cloudfront.net/products/25186_11-1-2022_17-9-28-1665843978.webp"));
        medicineList.add(new Medicine(4,
                "Cendo Tobroson Minidose 0.6 ml",
                "Cendo Pharmaceutical",
                31400.00,
                "CENDO TOBROSON MINIDOSE adalah obat tetes mata yang mengandung tobramycin sebagai antibiotik aminoglikosida yang di gunakan untuk mengobati infeksi akibat bakteri. Dalam mengobati infeksi tobramycin bekerja dengan cara membunuh bakteri dan menekan pertumbuhannya agar tidak muncul kembali. Cendo tobroson juga mengandung dexamethasone yang bekerja dengan menghambat respon inflamasi sehingga dapat membantu dalam meredakan peradangan pada mata. Dalam penggunaan obat ini harus SESUAI DENGAN PETUNJUK DOKTER.",
                "https://d2qjkwm11akmwu.cloudfront.net/products/15679-1665788321.webp"));
        medicineList.add(new Medicine(5,
                "Insto Cool Eye Drops 7.5 ml",
                "Pharma Healthcare",
                14500.00,
                "INSTO COOL EYE DROPS mengandung Naphazoline Hydrochloride, digunakan untuk meredakan mata merah akibat iritasi ringan dengan memberikan sensasi dingin yang menyegarkan.",
                "https://d2qjkwm11akmwu.cloudfront.net/products/754158_26-6-2022_23-34-51-1665856662.webp"));
        medicineList.add(new Medicine(6,
                "Bye Bye Fever Anak 5 Lembar",
                "HISAMITSU",
                50000.00,
                "BYE BYE FEVER ANAK merupakan plester yang digunakan pada anak untuk meringankan efek tidak nyaman karena demam, sakit gigi, sakit kepala. Plester ini memberikan efek dingin bekerja sampai 10 jam.",
                "https://d2qjkwm11akmwu.cloudfront.net/products/298089_22-2-2023_15-38-5.webp"));
        medicineList.add(new Medicine(7,
                "Altamed Covid-19 Rapid Test Kit Antigen",
                "Sapta Sari Tama",
                18100.00,
                "Altamed Covid-19 Rapid Test Kit Antigen merupakan alat test visual immunoassay yang cepat untuk deteksi kualitatif, dugaan antigen COVID-19 dari swab nasofaring. Tes ini dimaksudkan untuk digunakan sebagai bantuan dalam diagnosis banding yang cepat untuk infeksi virus Covid-19.",
                "https://d2qjkwm11akmwu.cloudfront.net/products/171267_22-2-2022_15-5-4-1665850161.webp"));
        medicineList.add(new Medicine(8,
                "Redoxon Triple Action Effervescent 10 Tablet",
                "Bayer Indonesia",
                29900.00,
                "REDOXON TRIPLE ACTION EFFERVESCENT merupakan suplemen makanan yang mengandung Vitamin C dilengkapi dengan Vitamin D dan Zinc yang berfungsi untuk membantu menjaga daya tahan tubuh. Vitamin C bermanfaat membantu sistem imunitas tubuh. Vitamin D membantu menjaga fungsi daya tahan tubuh tetap normal. Zinc membantu kinerja vitamin C, sehingga menjadi lebih efektif dalam menjaga daya tahan tubuh, dan Zinc merupakan zat yang tidak diproduksi tubuh. Jika asupan dari makanan tidak mencukupi kebutuhan harian, bila perlu, dapat diberikan suplementasi.",
                "https://d2qjkwm11akmwu.cloudfront.net/products/334810_5-1-2023_15-9-34.webp"));
        medicineList.add(new Medicine(9,
                "Sido Muncul Vitamin D3 1000 IU 50 Soft Capsule",
                "Sido Muncul",
                143800.00,
                "Sido Muncul Vitamin D3 1000 IU merupakan suplemen untuk membantu memelihara kesehatan tulang dan fungsi imun agar tetap sehat sekaligus terjaga selama beraktivitas sehari-hari.",
                "https://d2qjkwm11akmwu.cloudfront.net/products/684657_6-4-2022_10-54-24-1665839742.webp"));
        medicineList.add(new Medicine(10,
                "Imboost Kids Sirup 60 ml Botol ",
                "Soho Industri Pharmasi",
                38500.00,
                "IMBOOST KIDS SIRUP merupakan suplemen daya tahan tubuh yang bersifat imunostimulan yang berfungsi untuk menjaga kesehatan tubuh agar tidak mudah sakit. Suplemen ini mengandung Echinacea purpurea herb dry extract dan Zn Piccolinate yang bekerja cepat mengaktifkan sistem daya tahan tubuh namun tetap aman untuk dikonsumsi. Imboost akan bekerja langsung di sistem pertahanan tubuh kita dengan memperbanyak antibodi sehingga daya tahan tubuh lebih kuat melawan serangan virus.",
                "https://d2qjkwm11akmwu.cloudfront.net/products/656627_29-11-2022_14-39-27.webp"));
    }

}
