import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringOperationsTest {
    @DataProvider
    public Object[][] getDataTestMultiplication() {
        return new Object[][]{{4, 4, 4, 64}, {5, 5, 5, 125}};
    }

    @Test
    public void testGetSum() {
        StringOperations stringOperations = new StringOperations();
        int actual = stringOperations.getSum(2, 2);
        int expected = 4;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGetSubstraction() {
        StringOperations stringOperations = new StringOperations();
        int actual = stringOperations.getSubstraction(5, 2);
        int expected = 3;
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "getDataTestMultiplication")
    public void testGetMultiplication(int a, int b, int c, int expected) {
        StringOperations stringOperations = new StringOperations();
        int actual = stringOperations.getMultiplication(a, b, c);
        Assert.assertEquals(actual, expected);
    }

    @Test(timeOut = 7000)
    public void testGetDivision() {
        StringOperations stringOperations = new StringOperations();
        int actual = stringOperations.getDivision(10, 2);
        int expected = 5;
        Assert.assertEquals(actual, expected);
    }

    @Test(enabled = false)
    public void testGetSquareArea() {
        StringOperations stringOperations = new StringOperations();
        double actual = stringOperations.getSquareArea(10);
        double expected = 100;
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = {ArithmeticException.class})
    public void testGetDivisionException() {
        StringOperations stringOperations = new StringOperations();
        int a = 10;
        int b = 0;
        int actual = stringOperations.getDivision(a, b);
        int expected = 10000;
        Assert.assertEquals(actual, expected);
    }
}
