package main;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import dataset.DataSet;
import sortings.*;

import javax.imageio.plugins.tiff.FaxTIFFTagSet;

public class Main {
    public static void main(String[] args) {
        int n = 100000;

        int[] ascendingArray = createAscendingArray(n);
        int[] descendingArray = createDescendingArray(n);
        int[] randomArray = createRandomArray(n);

        String[] type = {"Crescente", "Decrescente", "Aleatorio"};

        System.out.println("\t\t\tBig O(n log n)");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        MakeDataSetNlogN(ascendingArray, type[0]).printDataSet();
        System.out.println();
        MakeDataSetNlogN(descendingArray, type[1]).printDataSet();
        System.out.println();
        MakeDataSetNlogN(randomArray, type[2]).printDataSet();
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println();
        /*
        System.out.println("\t\t\tBig O(n²)");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        MakeDataSetN2(ascendingArray, type[0]).printDataSet();
        System.out.println();
        MakeDataSetN2(descendingArray, type[1]).printDataSet();
        System.out.println();
        MakeDataSetN2(randomArray, type[2]).printDataSet();
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        */
    }

    public static int[] createAscendingArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public static int[] createDescendingArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = n - i;
        }
        return array;
    }

    public static int[] createRandomArray(int n) {
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int num;
            boolean exists;
            do {
                num = random.nextInt(n) + 1;
                exists = false;
                for (int j = 0; j < i; j++) {
                    if (array[j] == num) {
                        exists = true;
                        break;
                    }
                }
            } while (exists);
            array[i] = num;
        }
        return array;
    }

    public static long calculateAverage(long[] times) {
        long sum = 0;
        for (long time : times) {
            sum += time;
        }
        return sum / times.length;
    }

    public static DataSet TesterTimeNLogN(int[] array) {
        //O(n log n) ==> ArraySort,MergeSort, QuickSort
        DataSet ds = new DataSet();
        ds.addColumn("TipoDeOrdenacao");
        ds.addColumn("Tempos");
        long[] times = new long[3];
        long[] temp = new long[5];

        for (int i = 0; i < 5; i++) {
            int[] copy = array.clone();
            long start = System.nanoTime();
            Arrays.sort(copy);
            long end = System.nanoTime();
            long time = end - start;
            temp[i] = time;
        }
        times[0] = calculateAverage(temp);
        Map<String, Object> row1 = new HashMap<>();
        row1.put("TipoDeOrdenacao", "ArraySort");
        row1.put("Tempos", times[0]);
        ds.addRow(row1);
        Arrays.fill(temp, 0);

        for (int i = 0; i < 5; i++) {
            int[] copy = array.clone();
            long start = System.nanoTime();
            MergeSort.mergeSort(copy);
            long end = System.nanoTime();
            long time = end - start;
            temp[i] = time;
        }
        times[1] = calculateAverage(temp);
        Map<String, Object> row2 = new HashMap<>();
        row2.put("TipoDeOrdenacao", "MergeSort");
        row2.put("Tempos", times[1]);
        ds.addRow(row2);
        Arrays.fill(temp, 0);

        for (int i = 0; i < 5; i++) {
            int[] copy = array.clone();
            long start = System.nanoTime();
            QuickSort.quickSort(copy, 0, copy.length - 1);
            long end = System.nanoTime();
            long time = end - start;
            temp[i] = time;
        }
        times[2] = calculateAverage(temp);
        times[2] = calculateAverage(temp);
        Map<String, Object> row3 = new HashMap<>();
        row3.put("TipoDeOrdenacao", "QuickSort");
        row3.put("Tempos", times[2]);
        ds.addRow(row3);
        Arrays.fill(temp, 0);

        return ds;
    }

    public static DataSet TesterTimeN2(int[] array) {
        // O(n²) ==> SelectionSort, InsertionSort, BubbleSort
        DataSet ds = new DataSet();
        ds.addColumn("TipoDeOrdenacao");
        ds.addColumn("Tempos");
        long[] times = new long[3];
        long[] temp = new long[5];

        for (int i = 0; i < 5; i++) {
            int[] copy = array.clone();
            long start = System.nanoTime();
            SelectionSort.selectionSort(copy);
            long end = System.nanoTime();
            long time = end - start;
            temp[i] = time;
        }
        times[0] = calculateAverage(temp);
        Map<String, Object> row1 = new HashMap<>();
        row1.put("TipoDeOrdenacao", "SelectionSort");
        row1.put("Tempos", times[0]);
        ds.addRow(row1);
        Arrays.fill(temp, 0);

        for (int i = 0; i < 5; i++) {
            int[] copy = array.clone();
            long start = System.nanoTime();
            InsertionSort.insertionSort(copy);
            long end = System.nanoTime();
            long time = end - start;
            temp[i] = time;
        }
        times[1] = calculateAverage(temp);
        Map<String, Object> row2 = new HashMap<>();
        row2.put("TipoDeOrdenacao", "InsertionSort");
        row2.put("Tempos", times[1]);
        ds.addRow(row2);
        Arrays.fill(temp, 0);

        for (int i = 0; i < 5; i++) {
            int[] copy = array.clone();
            long start = System.nanoTime();
            BubbleSort.bubbleSort(copy);
            long end = System.nanoTime();
            long time = end - start;
            temp[i] = time;
        }
        times[2] = calculateAverage(temp);
        times[2] = calculateAverage(temp);
        Map<String, Object> row3 = new HashMap<>();
        row3.put("TipoDeOrdenacao", "BubbleSort");
        row3.put("Tempos", times[2]);
        ds.addRow(row3);
        Arrays.fill(temp, 0);

        return ds;
    }

    public static DataSet MakeDataSetNlogN(int[] array, String tipo) {
        DataSet dataset = new DataSet();

        dataset.addColumn("Ordenacoes");
        dataset.addColumn("Tempos");
        dataset.addColumn("Base de Dados");

        DataSet times = TesterTimeNLogN(array);

        for (Map<String, Object> row : times.getRows()) {
            Map<String, Object> newRow = new HashMap<>();
            String tipoDeOrdenacao = (String) row.get("TipoDeOrdenacao");
            long tempo = (Long) row.get("Tempos");
            newRow.put("Ordenacoes", tipoDeOrdenacao);
            newRow.put("Tempos", tempo);
            newRow.put("Base de Dados", tipo);
            dataset.addRow(newRow);
        }

        return dataset;
    }

    public static DataSet MakeDataSetN2(int[] array, String tipo) {
        DataSet dataset = new DataSet();

        dataset.addColumn("Ordenacoes");
        dataset.addColumn("Tempos");
        dataset.addColumn("Base de Dados");

        DataSet times = TesterTimeN2(array);

        for (Map<String, Object> row : times.getRows()) {
            Map<String, Object> newRow = new HashMap<>();
            String tipoDeOrdenacao = (String) row.get("TipoDeOrdenacao");
            long tempo = (Long) row.get("Tempos");
            newRow.put("Ordenacoes", tipoDeOrdenacao);
            newRow.put("Tempos", tempo);
            newRow.put("Base de Dados", tipo);
            dataset.addRow(newRow);
        }

        return dataset;
    }
}