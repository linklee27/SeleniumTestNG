package LinhTester.B29_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {
    //chạy tuần tự
    @DataProvider(name = "dataProviderLogin1")       //tạo kho để điều hướng dữ liệu
    public Object[][] dataLogin1() {
        return new Object[][]{
                {"super_admin", "12345678", 123},    //các dòng dữ liệu, chứa các tham số
                {"super_admin", "123456789", 123},
                {"super_adminsai", "12345678", 123}
        };
    }

    //chạy song song
    @DataProvider(name = "dataProviderLogin2", parallel = true)
    public Object[][] dataLogin2() {
        return new Object[][]{
                {"super_admin", "12345678", 123},
                {"super_admin", "123456789", 123},
                {"super_adminsai", "12345678", 123}
        };
    }

    @Test(dataProvider = "dataProviderLogin1")        //để nhận được kho ở trên thì cần phải gọi lại (có 1 thuộc tính = với name ở kho)
    //@Test(dataProvider = "dataProviderLogin1", dataProviderClass = DataLogin.class) - cách để gọi dataprovider từ class khác)
    public void testLoginCRM1(String name, String pass, int number) {
        System.out.println(name + " - " + pass + " - " + number);

    }

    @Test(dataProvider = "dataProviderLogin2")
    public void testLoginCRM2(String name, String pass, int number) {
        System.out.println(name + " - " + pass + " - " + number);
    }

}
