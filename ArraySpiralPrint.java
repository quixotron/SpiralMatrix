package com.app.java.study.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Samarjit
 * 
 *         Program to read a matrix from file and print it in clockwise spiral
 */
public class ArraySpiralPrint {
	public static void main(String args[]) {
		String filename = "F:\\Eclipse Workspace\\MyApp\\src\\com\\app\\java\\study\\test\\Matrix.txt";
		try {
			List<String[]> matrix = readMatrixFromFile(filename);
			printOriginalMatrix(matrix);
			printSpiral(matrix);
		} catch (FileNotFoundException e) {
			System.out.println("Error loading file");
			e.printStackTrace();
		}
	}

	private static List<String[]> readMatrixFromFile(String filename)
			throws FileNotFoundException {
		String[] rowArr = null;

		/*
		 * Representing the matrix as a List of String[] - can be easily
		 * transformed to String[][] but since the internal representation is
		 * not the primary objective, we leave this as a List
		 */
		List<String[]> matrix = new ArrayList<String[]>();
		BufferedReader buffer = new BufferedReader(new FileReader(filename));

		String line;
		int row = 0;
		int size = 0;

		try {
			while ((line = buffer.readLine()) != null) {
				String[] vals = line.trim().split("\\s+");

				size = vals.length;
				rowArr = new String[size];

				for (int col = 0; col < size; col++) {
					rowArr[col] = vals[col];
				}
				matrix.add(rowArr);
				row++;
			}
		} catch (IOException e) {
			System.out.println("Error reading file");
			e.printStackTrace();
		}

		return matrix;
	}

	private static void printOriginalMatrix(List<String[]> matrix) {
		String[] rowArr = null;
		if (matrix != null) {
			for (int row = 0; row < matrix.size(); row++) {
				rowArr = matrix.get(row);
				for (int col = 0; col < rowArr.length; col++)
					System.out.print(" " + rowArr[col]);
				System.out.println();
			}
		}
	}

	private static void printSpiral(List<String[]> matrix) {
		{
			if (matrix.size() != 0) {
				int top = 0;
				int down = matrix.size() - 1;
				int left = 0;
				int right = matrix.get(0).length - 1;

				while (true) {
					// Print top row
					for (int j = left; j <= right; ++j)
						System.out.print(matrix.get(top)[j] + " ");
					top++;
					if (top > down || left > right)
						break;
					// Print right column
					for (int i = top; i <= down; ++i)
						System.out.print(matrix.get(i)[right] + " ");
					right--;
					if (top > down || left > right)
						break;
					// Print bottom row
					for (int j = right; j >= left; --j)
						System.out.print(matrix.get(down)[j] + " ");
					down--;
					if (top > down || left > right)
						break;
					// Print left column
					for (int i = down; i >= top; --i)
						System.out.print(matrix.get(i)[left] + " ");
					left++;
					if (top > down || left > right)
						break;
				}
			}
		}
	}
}