package validation_test;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SimpleChecker {
    public static void main(String[] args) {
        String maDon = "1234567890AB";
        String url = "https://donthuocquocgia.vn/";

        try {
            // Kết nối và lấy dữ liệu HTML từ trang tra cứu công khai
            Document doc = Jsoup.connect(url).get();
            
            // Tìm các element chứa thông tin thuốc (cần kiểm tra ID/Class thực tế trên web)
            Element thongTinDon = doc.select(".form-control ma").first();
            
            if (thongTinDon != null) {
                System.out.println("Tìm thấy đơn thuốc: " + thongTinDon.text());
            } else {
                System.out.println("Không tìm thấy thông tin đơn thuốc.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}