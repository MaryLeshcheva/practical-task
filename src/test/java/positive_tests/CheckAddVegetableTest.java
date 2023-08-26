package positive_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.ListProductsPage;
import pages.MainPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckAddVegetableTest extends BaseTest {

    private ListProductsPage objListProductsPage;


    @BeforeEach
    public void prepare() {
        MainPage objMainPage = new MainPage(driver);
        objListProductsPage = new ListProductsPage(driver);

        objMainPage.openListProductsPage();
    }

    @Test
    public void testAddVegetable() {

        String name = "Редис";
        String type = "Овощ";
        boolean isExotic = false;

        objListProductsPage.clickButtonAdd();
        objListProductsPage.addName(name);
        objListProductsPage.clickOptionTypeVegetable();
        objListProductsPage.clickButtonSave();

        boolean isVegetableAdded = objListProductsPage.hasTableRow(name, type, isExotic);

        assertTrue(isVegetableAdded, "Ошибка! Овощ не добавлен.");
    }
}
