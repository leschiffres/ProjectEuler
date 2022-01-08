import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem59 {
	
	static String candidateLetters ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 1234567890().!,;'";
	/* We start by considering a set of letters that the message might contain.*/
	

	static ArrayList<String> ciphers = new ArrayList<String>();

	/*
	 * By problem description we know that the key has 3 letters, all with small
	 * letters.
	 */
	static char[] key = new char[3];

	public static void main(String[] args) {
		loadFile("./Data/problem0059.txt");
		String key = "zzz";
		String message = decryptedMessage(key);
		System.out.println(message);
	}

	
	
	static String decryptedMessage( String key){
		String message = "";
		char keyChar, decryptedChar;
		String keyCharBinary = "", cipherBinary = "", XORvalue = "";
		int XORnumber = 0;
		int sumAscii = 0;
		for(int i = 0; i < ciphers.size();i++){
			/*Find the character of the key to do the decryption*/
			keyChar = key.charAt(i % key.length());
			/*Take the binary form of the char and the cipher in the decrypted message
			 * and apply their XOR function.*/
			keyCharBinary = intToBinary((int)keyChar);
			cipherBinary = intToBinary(Integer.parseInt(ciphers.get(i)));
			XORvalue = xor(keyCharBinary, cipherBinary);
			/*Now we have the binary form of a number which corresponds to a specific
			 * letter in the initial message.
			 * 
			 * Thus, first we need to find the number and then find the corresponding character.*/
			XORnumber = binaryToInt(XORvalue);
			sumAscii += XORnumber;
			decryptedChar = (char)XORnumber;
			message += decryptedChar;
			if(!candidateLetters.contains(String.valueOf(decryptedChar))){
				System.out.println(keyChar + " at position " + (i % key.length()) + " is not valid " + " char : " + decryptedChar);
			}
		}
		
		System.out.println("The total sum of ASCII values in the initial message is : " + sumAscii);
		return message;
	}
	
	static void print(int N) {

		System.out.println("N : " + N);
		System.out.println("Binary form : " + intToBinary(N));
		System.out.println(binaryToInt("Integer form : " + intToBinary(N)));
	}

	static void produceDecryptedFile(String filename, String message) {
		// Enter name of the file on which you want to write.
		BufferedWriter bw = null;
		File f = null;
		try {
			f = new File(filename);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
		} catch (FileNotFoundException e) {
			System.err.println("Error opening file for writing!");
		}
		// write word str into file
		for (;;) {
			try {
				bw.write(message);
				bw.flush();
			} catch (IOException e) {
				System.err.println("Write error!");
			}
		}
	}

	static void loadFile(String filename) {
		BufferedReader br = null;
		File f = null;
		String line = "";

		try {
			f = new File(filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			br = new BufferedReader(new InputStreamReader(
					new FileInputStream(f)));
		} catch (FileNotFoundException e) {
			System.err.println("Error opening file for writing!");
		}
		while (line != null) {
			try {
				line = br.readLine();
				// After the last line of the file, the variable "line" will
				// have as value null
			} catch (IOException e) {
				System.err.println("Error reading line .");
			}
			if (line != null) {
				StringTokenizer st = new StringTokenizer(line, ",");
				while (st.hasMoreTokens()) {
					ciphers.add(st.nextToken());
				}
			}

		}
	}
	/*Converts a number given in its form in the 10 basis to its binary. */
	static String intToBinary(int N) {
		String s = "";
		// 7 is the number of bits in the binary form
		for (int i = 7; i >= 0; i--) {
			s += N / pow(2, i);
			N = N % pow(2, i);
		}
		return s;
	}
	/*Converts a number written in binary form to the 10 basis.*/
	static int binaryToInt(String s) {
		int N = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				N += pow(2, s.length() - 1 - i);
			}
		}
		return N;
	}

	/*Calculates the power a^b = a*a....*a (b times) */
	static int pow(int base, int exponent) {
		int result = 1;
		for (int i = 0; i < exponent; i++) {
			result *= base;
		}
		return result;
	}
	/*Returns the xor function of two given bitstrings*/
	static String xor(String seq1, String seq2) {
		String s = "";
		for (int i = 0; i < seq1.length(); i++) {
			if (seq1.charAt(i) == seq2.charAt(i)) {
				s += "0";
			} else {
				s += "1";
			}
		}
		return s;
	}

}
