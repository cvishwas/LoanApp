/**
 * The LoanApp project in the com.loanapp.beans package.
 *
 * @author Anthony Jaghab, (c) Quintrix Training, all rights reserved.
 */
package com.loanapp.beans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The <strong>LoanQuestion</strong> type.
 * <p>
 * Contains questions for the loan app.
 * Reads in from a file.
 * </p>
 * 
 * @author Anthony Jaghab
 * @since Jun 15, 2019
 */
public final class LoanQuestion {

	
	private HashMap<String, String> questions;
	private char questionChar;
	
	private static String defaultRelativePath = "src//main//resources//loan_questions.txt";
	private static final Logger LOGGER = LoggerFactory.getLogger(LoanQuestion.class);

	public LoanQuestion() {
		this(defaultRelativePath);
		LOGGER.info("Attempting to load question file from " + defaultRelativePath);
	}
	
	public LoanQuestion(String questionsFile) {
		questions = new HashMap<String, String>();
		questionChar = 'Q';
		loadQuestions(questionsFile);
	}

	/**
	 * Attempts to load questions from a specified
	 * filepath into the hashmap.
	 * 
	 * @return		Whether the file was present and loading the questions.
	 */
	private boolean loadQuestions(String filepath) {
		File file;
		BufferedReader br;

		try {
			file = new File(filepath);
			br = new BufferedReader(new FileReader(file));

			LOGGER.info("Question file to load " + file.getAbsolutePath());
			
			int i = 0;

			String line = br.readLine();

			while (line != null) {
				questions.put(String.valueOf(questionChar) + String.valueOf(i), line);
				i++;
				line = br.readLine();
			}

			br.close();
	      LOGGER.info("The number of questions " + getNumberOfQuestions() + "\n\nQuestion 1 = " + getQuestion(0));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Gets a particular question.
	 * 
	 * @return		Returns null if the question doesn't exist.
	 * @see         If needed.
	 */
	public String getQuestion(int index) {
		return questions.get(String.valueOf(questionChar) + String.valueOf(index));
	}
	
	/**
	 * Returns the number of questions in this instance.
	 * 
	 * @return		The return.
	 * @see         If needed.
	 */
	public int getNumberOfQuestions() {
		return questions.size();
	}

	/**
	 * Removes a question from this instance.
	 * <p>
	 * Additional information 
	 * </p>
	 * @return		The return.
	 * @see         If needed.
	 */
	public String removeQuestion(int index) {
		return questions.remove(String.valueOf(questionChar) + String.valueOf(index));
	}

}
