import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ordena {

    public static long[] lerArquivo(String caminho) {
        List<Long> numbersList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                long number = Long.parseLong(linha);
                numbersList.add(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long[] arrayLido = new long[numbersList.size()];
        for (int i = 0; i < numbersList.size(); i++) {
            arrayLido[i] = numbersList.get(i);
        }

        return arrayLido;
    }


    public static void bubbleSort(long[] array) {
        int tam = array.length;
        for (int i = 0; i < tam - 1; i++) {
            for (int j = 0; j < tam - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    long aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
    }

    public static void selectionSort(long[] array) {
        int tam = array.length;
        for (int i = 0; i < tam - 1; i++) {
            int minimo = i;
            for (int j = i + 1; j < tam; j++) {
                if (array[j] < array[minimo]) {
                    minimo = j;
                }
            }
            long aux = array[minimo];
            array[minimo] = array[i];
            array[i] = aux;
        }
    }

    public static void insertionSort(long[] array) {
        int tam = array.length;
        for (int i = 1; i < tam; i++) {
            long key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void mergeSort(long[] array, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;
            mergeSort(array, esquerda, meio);
            mergeSort(array, meio + 1, direita);
            merge(array, esquerda, meio, direita);
        }
    }

    public static void merge(long[] array, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;
        long[] arrayEsquerda = new long[n1];
        long[] arrayDireita = new long[n2];
        System.arraycopy(array, esquerda, arrayEsquerda, 0, n1);
        for (int j = 0; j < n2; ++j) {
            arrayDireita[j] = array[esquerda + 1 + j];
        }
        int i = 0, j = 0;
        int k = esquerda;
        while (i < n1 && j < n2) {
            if (arrayEsquerda[i] <= arrayDireita[j]) {
                array[k] = arrayEsquerda[i];
                i++;
            } else {
                array[k] = arrayDireita[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = arrayEsquerda[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = arrayDireita[j];
            j++;
            k++;
        }
    }

    public static void quickSort(long[] array, int inicio, int fim) {
        if (inicio < fim) {
            int pi = partition(array, inicio, fim);
            quickSort(array, inicio, pi - 1);
            quickSort(array, pi + 1, fim);
        }
    }

    public static int partition(long[] array, int inicio, int fim) {
        long pivot = array[fim];
        int i = (inicio - 1);
        for (int j = inicio; j < fim; j++) {
            if (array[j] <= pivot) {
                i++;
                long aux = array[i];
                array[i] = array[j];
                array[j] = aux;
            }
        }
        long aux = array[i + 1];
        array[i + 1] = array[fim];
        array[fim] = aux;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha o vetor que deseja utilizar:\n" +
                " 1-num.1000.1.in\n" +
                " 2-num.1000.2.in\n" +
                " 3-num.1000.3.in\n" +
                " 4-num.1000.4.in\n" +
                " 5-num.10000.1.in\n" +
                " 6-num.10000.2.in\n" +
                " 7-num.10000.3.in\n" +
                " 8-num.10000.4.in\n" +
                " 9-num.100000.1.in\n" +
                " 10-num.100000.2.in\n" +
                " 11-num.100000.3.in\n" +
                " 12-num.100000.4.in\n");
        int escolha = sc.nextInt();
        long[] array = {};
        switch (escolha) {
            case 1 -> array = lerArquivo("num.1000.1.in");
            case 2 -> array = lerArquivo("num.1000.2.in");
            case 3 -> array = lerArquivo("num.1000.3.in");
            case 4 -> array = lerArquivo("num.1000.4.in");
            case 5 -> array = lerArquivo("num.10000.1.in");
            case 6 -> array = lerArquivo("num.10000.2.in");
            case 7 -> array = lerArquivo("num.10000.3.in");
            case 8 -> array = lerArquivo("num.10000.4.in");
            case 9 -> array = lerArquivo("num.100000.1.in");
            case 10 -> array = lerArquivo("num.100000.2.in");
            case 11 -> array = lerArquivo("num.100000.3.in");
            case 12 -> array = lerArquivo("num.100000.4.in");
            default ->  System.exit(1);
        }
        System.out.println("escolha o algoritmo de ordenacao:\n" +
                " 1- SelectionSort\n" +
                " 2- BubbleSort\n" +
                " 3- InsertionSort\n" +
                " 4- MergeSort\n" +
                " 5- QuickSort\n");
        escolha = sc.nextInt();
        switch(escolha) {
            case 1:
                // Selection Sort
                long[] selectionSortArray = Arrays.copyOf(array, array.length);
                long start = System.currentTimeMillis();
                selectionSort(selectionSortArray);
                long end = System.currentTimeMillis();
                long tempo = end - start;
                System.out.println("Selection Sort: " + Arrays.toString(selectionSortArray));
                System.out.println("Tempo: " + tempo + " milisegundos");
                break;
            case 2:
                // Bubble Sort
                long[] bubbleSortArray = Arrays.copyOf(array, array.length);
                start = System.currentTimeMillis();
                bubbleSort(bubbleSortArray);
                end = System.currentTimeMillis();
                tempo = end - start;
                System.out.println("Bubble Sort: " + Arrays.toString(bubbleSortArray));
                System.out.println("Tempo: " + tempo + " milisegundos");
                break;
            case 3:
                // Insertion Sort
                long[] insertionSortArray = Arrays.copyOf(array, array.length);
                start = System.currentTimeMillis();
                insertionSort(insertionSortArray);
                end = System.currentTimeMillis();
                tempo = end - start;
                System.out.println("Insertion Sort: " + Arrays.toString(insertionSortArray));
                System.out.println("Tempo: " + tempo + " milisegundos");
                break;
            case 4:
                // Merge Sort
                long[] mergeSortArray = Arrays.copyOf(array, array.length);
                start = System.currentTimeMillis();
                mergeSort(mergeSortArray, 0, mergeSortArray.length - 1);
                end = System.currentTimeMillis();
                tempo = end - start;
                System.out.println("Merge Sort: " + Arrays.toString(mergeSortArray));
                System.out.println("Tempo: " + tempo + " milisegundos");
                break;
            case 5:
                // Quick Sort
                long[] quickSortArray = Arrays.copyOf(array, array.length);
                start = System.currentTimeMillis();
                quickSort(quickSortArray, 0, quickSortArray.length - 1);
                end = System.currentTimeMillis();
                tempo = end - start;
                System.out.println("Quick Sort: " + Arrays.toString(quickSortArray));
                System.out.println("Tempo: " + tempo + " milisegundos");
                break;
            default:
                System.exit(0);
        }
    }
}
