package positive_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.ListProductsPage;
import pages.MainPage;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class CheckAddProductsParameterizedTest extends BaseTest{

    private ListProductsPage objListProductsPage;

    @BeforeEach
    public void prepare() {
        MainPage objMainPage = new MainPage(driver);
        objListProductsPage = new ListProductsPage(driver);

        objMainPage.openListProductsPage();
    }

    public static Stream<Arguments> getProductsData() {
        return Stream.of(
                Arguments.of("Ананас", "Фрукт", true),
                Arguments.of("Редис", "Овощ", false)
        );
    }

    @ParameterizedTest
    @MethodSource("getProductsData")
    public void AddProduct(String name, String type, boolean isExotic) {

        objListProductsPage.clickButtonAdd();
        objListProductsPage.addName(name);

        if (type.equals("Фрукт")) {
            objListProductsPage.clickOptionTypeFruit();
        } else {
            objListProductsPage.clickOptionTypeVegetable();
        }

        if (isExotic) {
            objListProductsPage.clickCheckboxExotic();
        }

        objListProductsPage.clickButtonSave();

        boolean isProductAdded = objListProductsPage.hasTableRow(name, type, isExotic);
        assertTrue(isProductAdded, "Ошибка! " + type + " \"" + name + "\"" + " не добавлен.");
    }

}
