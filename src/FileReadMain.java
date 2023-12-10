import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class FileReadMain {
    public static void main(String[] args) {
        // Input file as a variable to pass to Scanner
        File inputFile = new File("metamorphosis.txt");
        String content = readFromFile(inputFile);

        // Call method for counting and printing word stats
        outputStatistics(content);

        // this one's just for me
//        createWordFrequencyList(content);
    }
    // -------- file reader method --------------
    private static String readFromFile(File file) {
        StringBuilder content = new StringBuilder();

        // try-catch block to ensure a FileNotFoundException gets thrown. Necessary for I/O operations
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
            }
        } catch (Exception e) {
            System.err.println("File not found: " + e.getMessage());
        }

        return content.toString();
    }

    private static void outputStatistics(String content) {
        // Calculate statistics using appropriate methods
        int charCount = content.length();
        int wordCount = countWords(content);
        int sentenceCount = countSentences(content);
        int paragraphCount = countParagraphs(content);

        // Output statistics :D
        System.out.println("Length in characters: " + charCount);
        System.out.println("Number of words: " + wordCount);
        System.out.println("Number of sentences: " + sentenceCount);
        System.out.println("Number of paragraphs: " + paragraphCount);
    }

    private static int countWords(String text) {
        Scanner wordScanner = new Scanner(text);
        int wordCount = 0;

        // count da words
        while (wordScanner.hasNext()) {
            wordScanner.next();
            wordCount++;
        }

        return wordCount;
    }

    private static int countSentences(String text) {
        Scanner sentenceScanner = new Scanner(text);
        // delimiter set to tokenize characters between sentence-ending punctuation
        sentenceScanner.useDelimiter("[.!?]");

        // count da sentences
        int sentenceCount = 0;
        while (sentenceScanner.hasNext()) {
            sentenceScanner.next();
            sentenceCount++;
        }

        return sentenceCount;
    }

    private static int countParagraphs(String text) {
        Scanner paragraphScanner = new Scanner(text);
        // delimiter set to tokenize characters between line breaks
        paragraphScanner.useDelimiter("\n\n(I{1,3})\n\n|\n+");

        // count da paragraphs
        int paragraphCount = 0;
        while (paragraphScanner.hasNext()) {
            paragraphScanner.next();
            paragraphCount++;
        }

        return paragraphCount;
    }

    // the method I used to give me word frequencies
    private static void createWordFrequencyList(String content) {
        Scanner wordScanner = new Scanner(content);
        // Delimiter set to tokenize characters between non-word characters
        wordScanner.useDelimiter("\\W+");

        // ArrayList to store words and their frequencies
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> frequencies = new ArrayList<>();

        while (wordScanner.hasNext()) {
            String word = wordScanner.next().toLowerCase();
            int index = words.indexOf(word);

            // Check if the word is already in the ArrayList.
            if (index == -1) {
                // If the word is not in the ArrayList, add it
                words.add(word);
                frequencies.add(1);
            } else {
                // If the word is already in the ArrayList, increment its frequency
                frequencies.set(index, frequencies.get(index) + 1);
            }
        }

        // quicksort algorithm to sort words from most frequent to least frequent
        quickSortByFrequency(words, frequencies, 0, words.size() - 1);

        // Print word frequencies
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i) + ": " + frequencies.get(i));
        }
    }
    private static void quickSortByFrequency(ArrayList<String> words, ArrayList<Integer> frequencies, int low, int high) {
        if (low < high) {
            // Partition the arrays and get the pivot index
            int pivotIndex = partition(words, frequencies, low, high);

            // Recursively sort the two halves
            quickSortByFrequency(words, frequencies, low, pivotIndex - 1);
            quickSortByFrequency(words, frequencies, pivotIndex + 1, high);
        }
    }
    private static int partition(ArrayList<String> words, ArrayList<Integer> frequencies, int low, int high) {
        int pivotFrequency = frequencies.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (frequencies.get(j) > pivotFrequency) {
                i++;
                // Swap words
                String tempWord = words.get(i);
                words.set(i, words.get(j));
                words.set(j, tempWord);

                // Swap frequencies
                int tempFrequency = frequencies.get(i);
                frequencies.set(i, frequencies.get(j));
                frequencies.set(j, tempFrequency);
            }
        }

        // Swap the pivot element with the element at (i + 1)
        String tempWord = words.get(i + 1);
        words.set(i + 1, words.get(high));
        words.set(high, tempWord);

        int tempFrequency = frequencies.get(i + 1);
        frequencies.set(i + 1, frequencies.get(high));
        frequencies.set(high, tempFrequency);

        return i + 1;
    }
}

