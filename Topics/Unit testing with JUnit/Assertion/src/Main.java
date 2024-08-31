class CalculatorTest {
    void testAddition() {
        // implement a test case
        Calculator calculator = new Calculator();
        int result = calculator.add(1,1);
        Assertions.assertEquals(2, result);
    }
}