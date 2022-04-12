package domain.util;

import java.util.Random;

public class RandomGenerator {

    private static Random rnd;

    static {
        rnd = new Random();
    }

    private static String[] names = {
            "Dewey Fuentes", "Kody Brook", "Dakota Dunlop", "Tiya Mercado",
            "Ceri Odling", "Gracie-Mae Ewing", "Joao Marsh", "Safiya Croft",
            "Parker Santana", "Hector Trujillo", "Beverley Daniels", "Amisha Garrett",
            "Sophia Cassidy", "Joyce Hardin", "Ruby-Mae Garner", "Lynsey Benton",
            "Lorraine George", "Omar Knox", "Aneesa Almond", "Kamile Jacobs",
            "Izabella Dawson", "Lochlan Wood", "Delia Davis", "Howard Plant",
            "Kieron Nelson", "Abida Young", "Joely Guerra", "Francis Mccaffrey", "Lee Ellis",
            "Amal Cortes", "Dominique Park", "Keri Jarvis", "Gianni Barber",
            "Marc Monroe", "Ellie Macgregor", "Nazim Simmons", "Atif Greer",
            "Angel Kent", "Shanaya Lim", "Herbert Bannister", "Paddy Turnbull", "Haleema Green",
            "Adele Tran", "Fern Weeks", "Danica Estrada", "Laurie Cook", "Nevaeh Cullen",
            "Eliza Chen", "Eddie Horn", "Arthur Mill", "Sheena Ball",
            "Anthony Whitehead", "Saarah Woodcock", "Berat Winters", "Amelia-Rose Steele",
            "Asher Li", "Alexander Rivas", "Romy Xiong", "Jayden-James Keller",
            "Lorena Mitchell", "Harvie Goldsmith", "Julius Leblanc", "Nicola Ruiz",
            "Jibril Norris", "Azaan Dennis", "Vickie Drew", "Dilan Miranda",
            "Matylda Castro", "Emir Coulson", "Izaac Bonner", "Brody Hastings",
            "Musab Cousins", "Dominick Robertson", "Zi Wicks", "Adyan Gilmour",
            "Aedan Hutchinson", "King Bryant", "Manav Dougherty", "Darren Smyth",
            "Nayan Marsden", "Violet Worthington", "Saba Connelly", "Pia Mills",
            "Nicole Foster", "Tadhg Gamble", "Miguel Hunter", "Isabel Cornish",
            "Frazer Spooner", "Eloise Navarro", "Manisha Moss", "Neve Houston",
            "Shakir Webber", "Jae Sanderson", "Alice Russo", "Javan Huang",
            "Ollie Lindsey", "Waleed Hewitt", "Bhavik Hail", "Jameel Farrington"};

    private RandomGenerator() {}

    public static int getRandomWithExclusion(int start, int end, int... exclude) {

        int random = start + rnd.nextInt(end - start + 1 - exclude.length);
        for (int ex : exclude) {
            if (random < ex) {
                break;
            }
            random++;
        }
        return random;
    }

    public static int getRandom(int floor, int ceil) {
        return floor + rnd.nextInt(ceil - floor);
    }

    public static String getRandomName() {
        int nameIndex = rnd.nextInt(names.length);
        return names[nameIndex];
    }

}
