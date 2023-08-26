package positive_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.ListProductsPage;
import pages.MainPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckAddFruitTest extends BaseTest {

    private ListProductsPage objListProductsPage;

    @BeforeEach
    public void prepare() {
        MainPage objMainPage = new MainPage(driver);
        objListProductsPage = new ListProductsPage(driver);

        objMainPage.openListProductsPage();
    }

    @Test
    public void testAddExoticFruit() {

        String name = "Ананас";
        String type = "Фрукт";
        boolean isExotic = true;

        objListProductsPage.clickButtonAdd();
        objListProductsPage.addName(name);
        objListProductsPage.clickOptionTypeFruit();
        objListProductsPage.clickCheckboxExotic();
        objListProductsPage.clickButtonSave();

        boolean isFruitAdded = objListProductsPage.hasTableRow(name, type, isExotic);

        assertTrue(isFruitAdded, "Ошибка! Экзотический фрукт не добавлен.");
    }
}
