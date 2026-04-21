import java.util.Arrays;

public class Experiment {
    private Sorter sorter = new Sorter();
    private Searcher searcher = new Searcher();

    public long measureSortTime(int[] arr, String type) {
        int[] copy = arr.clone();
        long start = System.nanoTime();
        if (type.equals("basic")) sorter.basicSort(copy);
        else sorter.advancedSort(copy);
        return System.nanoTime() - start;
    }

    public long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();
        searcher.search(arr, target);
        return System.nanoTime() - start;
    }

    public void runAllExperiments() {
        int[] sizes = {10, 100, 1000};
        for (int size : sizes) {
            System.out.println("Size: " + size);
            int[] randomArr = sorter.generateRandomArray(size);

            // Тест на случайных данных
            System.out.println("Random Data:");
            System.out.println("Basic: " + measureSortTime(randomArr, "basic") + " ns");
            System.out.println("Advanced: " + measureSortTime(randomArr, "advanced") + " ns");

            // Тест на отсортированных данных
            int[] sortedArr = randomArr.clone();
            Arrays.sort(sortedArr);
            System.out.println("Sorted Data:");
            System.out.println("Basic: " + measureSortTime(sortedArr, "basic") + " ns");
            System.out.println("Advanced: " + measureSortTime(sortedArr, "advanced") + " ns");

            // Тест поиска
            System.out.println("Search Time: " + measureSearchTime(sortedArr, -1) + " ns");
            System.out.println("-------------------------");
        }
    }
}