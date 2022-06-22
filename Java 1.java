package com.assignment1;

import java.io.File;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Resumefilterpdf {
	public static void main(String[] args) throws Exception {

		File file = new File("C:\\Users\\rubalasa\\Java\\Resume.pdf");

		PDDocument document = PDDocument.load(file);

		PDFTextStripper pdfStripper = new PDFTextStripper();

		String[] text = pdfStripper.getText(document).toLowerCase().split(" |,");
		ArrayList<String> words = new ArrayList<String>();
		//System.out.println(Arrays.toString(text));

		for (int i = 0; i < text.length; i++) {
			if (text[i] != " ") {
				words.add(text[i]);
			}
		}
		document.close();

		String[] keywords = {"oops", "agile", "java", "yaml", "python", "javascript", "sql", "computer",
				"maths", "fresher", "selenium", "cucumber" };
		int keywordMatch = 0;
		for (int i = 0; i < keywords.length; i++) {
			if (words.contains(keywords[i])) {
				System.out.println(keywords[i]);
				keywordMatch = keywordMatch + 1;

			}

		}
		keywordMatch = keywordMatch * 100 / keywords.length;
		System.out.println(keywordMatch + "%" + " of keywords match in the resume from the list of given keywords");
	}
}
