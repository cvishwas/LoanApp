/**
 * The LoanApp project in the com.loanapp.beans package.
 *
 * @author Anthony Jaghab, (c) Quintrix Training, all rights reserved.
 */
package com.loanapp.beans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The <strong>LoanQuestion</strong> type.
 * <p>
 * Contains questions for the loan app. Reads in from a file.
 * </p>
 * 
 * @author Anthony Jaghab
 * @since Jun 15, 2019
 */
public final class LoanQuestion {

	private static String defaultRelativePath = "src//main//resources//loan_questions.txt";
	private static final Logger LOGGER = LoggerFactory.getLogger(LoanQuestion.class);
	private HashMap<String, String> questions;

	private char questionChar;
	private boolean enableLogger;

	/**
	 * Loads the default loan questions from the project
	 * <p><b>path:</b> <i>src/main/java/resources/loan_questions.txt</i></p>
	 * 
	 * <b>Questions format:</b>
	 * Each line in the file is considered a question.
	 */
	public LoanQuestion() {
		this(LoanQuestion.defaultRelativePath);
		LoanQuestion.LOGGER.info("Attempting to load question file from " + LoanQuestion.defaultRelativePath);
	}

	/**
	 * Specify a particular file on the filesystem to load the questions.
	 * 
	 * <b>Questions format:</b>
	 * Each line in the file is considered a question.
	 */
	public LoanQuestion(String questionsFile) {
		this.questions = new HashMap<String, String>();
		this.questionChar = 'Q';
		this.enableLogger = true;
		loadQuestions(questionsFile);
	}

	/**
	 * Returns the number of questions in this instance.
	 * 
	 * @return The number of questions.
	 */
	public int getNumberOfQuestions() {
		return this.questions.size();
	}

	/**
	 * Gets a particular question.
	 * 
	 * @return Returns null if the question doesn't exist.
	 */
	public String getQuestion(int index) {
		return this.questions.get(String.valueOf(this.questionChar) + String.valueOf(index));
	}

	/**
	 * Gets all the questions from the current instances and returns a string array.
	 * 
	 * @return The questions in a String array.
	 */
	public String[] getQuestions() {
		String[] strArr = new String[this.questions.size()];
		int index = 0;
		for (String s : this.questions.values()) {
			strArr[index] = s;
			index++;
		}

		return strArr;
	}

	/**
	 * Gets all the questions from the starting index to the end in the current
	 * instances and returns a string array.
	 * 
	 * @return The return.
	 * @see If needed.
	 */
	public String[] getQuestions(int startIndex) {
		String[] strArr = new String[this.questions.size()];
		int index = startIndex;

		// Index is out of bounds.
		if (startIndex >= this.questions.size()) {
			return null;
		}

		for (String s : this.questions.values()) {
			strArr[index] = s;
			index++;
		}

		return strArr;
	}

	/**
	 * Attempts to load questions from a specified filepath into the hashmap.
	 * 
	 * @return Whether the file was present and loading the questions.
	 */
	private boolean loadQuestions(String filepath) {
		File file;
		BufferedReader br;

		try {
			file = new File(filepath);
			br = new BufferedReader(new FileReader(file));

			if (this.enableLogger) {
				LoanQuestion.LOGGER.info("Question file to load " + file.getAbsolutePath());
			}
			int index = 0;

			String line = br.readLine();

			while (line != null) {
				this.questions.put(String.valueOf(this.questionChar) + String.valueOf(index), line);
				index++;
				line = br.readLine();
			}

			br.close();

			if (this.enableLogger) {
				LoanQuestion.LOGGER
						.info("The number of questions " + getNumberOfQuestions() + "\n\nQuestion 1 = " + getQuestion(0));
			}
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Print questions line by line to PrintWriter object.
	 * 
	 * @see PrintWriter
	 */
	public void printlnQuestions(PrintWriter p) {
		for (String s : this.questions.values()) {
			p.println(s);
		}
	}

	/**
	 * Print questions to PrintWriter object.
	 * 
	 * @see PrintWriter
	 */
	public void printQuestions(PrintWriter p) {
		for (String s : this.questions.values()) {
			p.print(s);
		}
	}

	/**
	 * Print questions to PrintWriter object using a specific delimiter.
	 * 
	 * @see PrintWriter
	 */
	public void printQuestions(PrintWriter p, char delimiter) {
		int index = 0;
		for (String s : this.questions.values()) {
			p.print(index != this.questions.size() - 1 ? s + delimiter : s);
			index++;
		}
	}

	/**
	 * Removes a question from this instance.
	 * 
	 * @return The question that was removed.
	 * @param index The index of the question.
	 * @see If needed.
	 */
	public String removeQuestion(int index) {
		return this.questions.remove(String.valueOf(this.questionChar) + String.valueOf(index));
	}

	/**
	 * Toggle the logger for the console output.
	 * <p>
	 * The logger prints information about what file was passed in and whether it
	 * was loaded or not.
	 * </p>
	 * 
	 * @param flag Enable or disable the logger.
	 */
	public void toggleLogger(boolean flag) {
		this.enableLogger = flag;
	}
}
