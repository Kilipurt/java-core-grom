package lesson8.ads.test;

import lesson8.ads.HouseAd;

public class DemoHouseAdTestClass {
    public static void main(String[] args) {

        //checkOwnerOfAd()
        //проверяет есть имя владельца в списке владельцев +

        HouseAd houseAd = new HouseAd(12, 1000, "Vadim", "wefewf", 123, 2);
        HouseAd houseAd1 = new HouseAd(12, 1000, "Vadim123", "wefewf", 123, 2);

        System.out.println(houseAd.checkOwnerOfAd());

        System.out.println(houseAd1.checkOwnerOfAd());
    }
}
