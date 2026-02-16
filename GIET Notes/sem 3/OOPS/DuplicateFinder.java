public class DuplicateFinder {
    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 3, 2, 3, 5, 4, 1};

        int[] printed = new int[arr.length]; 
        int printedCount = 0;

        System.out.println("Duplicate values:");
        for (int i = 0; i < arr.length; i++) {
            boolean alreadyPrinted = false;
            for (int k = 0; k < printedCount; k++) {
                if (printed[k] == arr[i]) {
                    alreadyPrinted = true;
                    break;
                }
            }
            if (alreadyPrinted) continue;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println(arr[i]);
                    printed[printedCount++] = arr[i]; 
                    break;
                }
            }
        }
    }
}
