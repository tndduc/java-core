package bap.jp.b4;

import java.io.*;
import java.util.*;

public class B4 {
    public static void main(String[] args) throws IOException {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Nhập đoạn văn bản hoặc đường dẫn file:");
	String input = scanner.nextLine();
	String text;
	File file = new File(input);
	if (file.exists() && file.isFile()) {
	    text = readFile(input);
	} else {
	    text = input;
	}

	Map<String, Integer> wordCount = countWords(text);
	displayResults(wordCount);
    }

    private static String readFile(String filePath) throws IOException {
	StringBuilder content = new StringBuilder();
	try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	    String line;
	    while ((line = br.readLine()) != null) {
		content.append(line).append(" ");
	    }
	}
	return content.toString();
    }

    private static Map<String, Integer> countWords(String text) {
	Map<String, Integer> wordCount = new HashMap<>();
	String[] words = text.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "").split("\\s+");

	for (String word : words) {
	    if (!word.isEmpty()) {
		wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
	    }
	}
	return wordCount;
    }

    private static void displayResults(Map<String, Integer> wordCount) {
	System.out.println("\nThống kê theo số lần xuất hiện:");
	wordCount.entrySet().stream()
		.sorted((a, b) -> b.getValue().compareTo(a.getValue()))
		.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

	System.out.println("\nThống kê theo thứ tự bảng chữ cái:");
	new TreeMap<>(wordCount).forEach((word, count) ->
		System.out.println(word + ": " + count));
    }
}

