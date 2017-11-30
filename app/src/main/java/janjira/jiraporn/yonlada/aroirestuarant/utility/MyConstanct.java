package janjira.jiraporn.yonlada.aroirestuarant.utility;

/**
 * Created by ASUS on 10/16/2017.
 */

public class MyConstanct {

    //    URL
    private String urlPromotionString = "http://androidthai.in.th/mua/getAllData.php";


    //    Array
    private String[] columnUSER = new String[]{
            "id",
            "Category",
            "NameFood",
            "Price",
            "Detail",
            "ImagePath",
            "NameReview",
            "DetailReview",
            "ScoreReview"};

    private String[] categoryStrings = new String[]{
            "โปรโมชั่น",
            "อาหารจานด่วน",
            "แกง",
            "ปิ้ง/ย่าง/ทอด",
            "อาหารชุด",
            "เส้น",
            "นำ้พริก",
            "นึ่ง", "อาหารว่าง/ขนม", "ผลไม้", "เครื่องดื่ม"};

    //    Method


    public String[] getCategoryStrings() {
        return categoryStrings;
    }

    public String[] getColumnUSER() {
        return columnUSER;
    }

    public String getUrlPromotionString() {
        return urlPromotionString;
    }
}   // Main Class
