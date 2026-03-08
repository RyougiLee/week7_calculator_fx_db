public class CalculatorAutoTest {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  Calculator Auto Test Started");
        System.out.println("========================================");

        // Wait for database
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double[][] testCases = {
            {10, 5}, {7, 3}, {100, 25}, {-5, 2},
            {15.5, 2.5}, {0, 100}, {50, 0}, {-10, -5}
        };

        int passed = 0;
        for (int i = 0; i < testCases.length; i++) {
            double num1 = testCases[i][0];
            double num2 = testCases[i][1];

            try {
                double sum = num1 + num2;
                double product = num1 * num2;
                double subtract = num1 - num2;
                double division = num1 / num2;

                System.out.println("Test " + (i+1) + ": " + num1 + ", " + num2 +
                    " → Sum=" + sum + ", Product=" + product +
                    ", Subtract=" + subtract + ", Division=" + division);

                ResultService.saveResult(num1, num2, sum, product, subtract, division);
                passed++;
            } catch (Exception e) {
                System.err.println("Test " + (i+1) + " FAILED");
                e.printStackTrace();
            }
        }

        System.out.println("========================================");
        System.out.println("Total: " + testCases.length + ", Passed: " + passed);
        System.out.println(passed == testCases.length ? "✅ All tests passed" : "❌ Some tests failed");
        System.exit(passed == testCases.length ? 0 : 1);
    }
}

