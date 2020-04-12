package com.yoons.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.yoons.model.Book;

/** 
 * ���� ���� �ý���
 * for example: 
 * <pre>
 * 
 * </pre>
 * @author yoons
 * @author 		������
 * @version 	% I %, % G %
 * 
 * @see java.util.Arrays;
 * @see java.io.InputStreamReader;
 * @see java.io.BufferedReader
 * @see java.io.IOException;
 * @see com.yoons.model.Book
 * 
 * @since 		JDK 1.81
 */
public class BookManagementSystem {

	/** Book Ÿ�� �������� �迭 */
	static Book[] books = { new Book("741-245-7532-86-1", "�ﱹ��", "ȫ�浿", 10000, 3),
			new Book("978-89-94492-04-9", "Java�� ����", "���ü�", 25000, 5),
			new Book("789-81-4510-102-0", "���ϰ� �д� �ڹ� ���α׷���", "�ڿ��", 40000, 1),
			new Book("978-89-255-6858-4", "���� �ƾ���", "������ ���̿���", 16500, 1),
			new Book("979-11-6224-048-9", "�̰��� ����Ŭ�̴�", "���糲", 30000, 5), };

	/**
	 * å�� �����ϴ� ���� �޼���
	 * @param args
	 */
	public static void main(String[] args) {
		int input = -1;

		while (input != 0) {
			try {
				printMenu();
				input = getInputInt();

				switch (input) {
				case 1:
					selectBookInfo(0, "");
					break;

				case 2:
					System.out.println("### �˻��Ͻ÷��� �׸� ��ȣ�� �Է��ϼ���.");
					System.out.println("1. ISBN");
					System.out.println("2. ����");
					System.out.println("3. ����");
					System.out.println("4. ����");
					System.out.println("5. ����");
					System.out.print("��ȣ �Է� >> ");
					int category = getInputInt();

					if (!(1 <= category && category <= 5)) {
						System.out.println("[����] �߸� �Է��ϼ̽��ϴ�. ���θ޴��� ���ư��ϴ�.");
						break;
					}

					System.out.print("�˻�� �Է��ϼ��� >> ");
					String str = getInputString();

					selectBookInfo(category, str);
					break;

				case 3:
					insertBookInfo();
					break;

				case 4:
					updateBookInfo();
					break;

				case 5:
					deleteBookInfo();
					break;

				case 0:
					System.out.println("[����] Bye~");
					break;

				default:
					System.out.println("[����] �߸� �Է��ϼ̽��ϴ�!");
				}
			} catch (NumberFormatException e) {
				System.out.println("[����] ���� ���Ŀ� �°� �Է��ϼ���!");
			}
		}
	}
	
	/**
	 * å ���� �˻� �� ��� �޼���
	 * : �������� category�� ���� ���� �ٸ� �׸񿡼� input���� �˻��Ͽ� ��ġ�ϴ� ���� ���� ��� ���
	 * 
	 * @param category		�׸�
	 * @param input			�˻���
	 * 
	 * @see 				#printBookHeader()
	 * @see					#printBookInfo(int)
	 * @see					#printLine()
	 * @see					#getAveragePrice(double, int)
	 */
	public static void selectBookInfo(int category, String input) {
		int count = 0;
		double sum = 0.0;
		input = input.trim();

		printBookHeader();

		for (int i = 0; i < books.length; i++) {

			switch (category) {
			case 0:
				printBookInfo(i);
				count++;
				sum += books[i].getPrice();
				break;

			case 1:
				if (books[i].getIsbn().equals(input)) {
					printBookInfo(i);
					count++;
					sum += books[i].getPrice();
				}
				break;

			case 2:
				if (books[i].getTitle().equals(input)) {
					printBookInfo(i);
					count++;
					sum += books[i].getPrice();
				}
				break;

			case 3:
				if (books[i].getAuthor().equals(input)) {
					printBookInfo(i);
					count++;
					sum += books[i].getPrice();
				}
				break;

			case 4:
				if (books[i].getPrice() == Integer.parseInt(input)) {
					printBookInfo(i);
					count++;
					sum += books[i].getPrice();
				}
				break;

			case 5:
				if (books[i].getAmount() == Integer.parseInt(input)) {
					printBookInfo(i);
					count++;
					sum += books[i].getPrice();
				}
				break;
			}
		}

		if (count > 0) {
			printLine();
			System.out.printf(" �˻� ��� : %d��, ��� �ݾ� : %6.0f��\n", count, getAveragePrice(sum, count));
		} else {
			System.out.println("[�˸�] ��ġ�ϴ� �˻� ����� �����ϴ�.");
		}
		printLine();

	}
	
	//public static int getLength() { return 0; }
	
	/**
	 * å ���� ��� �޼���
	 * 
	 * @see		#getInputString()
	 * @see		#getInputInt()
	 * @see		#selectBookInfo(int, String)
	 * @see		java.util.Arrays#copyOf(Object[], int)
	 */
	public static void insertBookInfo() {
		Book newBook = new Book();

		System.out.print("ISBN�� �Է��ϼ��� (10���� Ȥ�� 13���� ����, '-'�� �־� �Է����ּ���) >> ");
		newBook.setIsbn(getInputString());

		System.out.print("å ������ �Է��ϼ��� (�� ���� �̻� ���ڿ�) >> ");
		newBook.setTitle(getInputString());

		System.out.print("���ڸ��� �Է��ϼ��� (�� ���� �̻� ���ڿ�) >> ");
		newBook.setAuthor(getInputString());

		System.out.print("������ �Է��ϼ��� (1 �̻� ����) >> ");
		newBook.setPrice(getInputInt());

		/* System.out.print("ISBN�� �Է��ϼ��� (10���� Ȥ�� 13���� ����, '-'�� �־� �Է����ּ���) >> ");
		String isbn = getInputString();

		System.out.print("å ������ �Է��ϼ��� (�� ���� �̻� ���ڿ�) >> ");
		String title = getInputString();

		System.out.print("���ڸ��� �Է��ϼ��� (�� ���� �̻� ���ڿ�) >> ");
		String author = getInputString();

		System.out.print("������ �Է��ϼ��� (1 �̻� ����) >> ");
		int price = getInputInt();

		Book newBook = new Book(isbn, title, author, price); */
		
		if ((newBook.getIsbn() != null && newBook.getTitle() != null && newBook.getAuthor() != null
				&& newBook.getPrice() != 0)) {
			Book[] tmp = Arrays.copyOf(books, books.length + 1);
			tmp[tmp.length - 1] = newBook;
			books = Arrays.copyOf(tmp, tmp.length);

			System.out.println("[����] ���� �Ϸ��߽��ϴ�.");
		} else {
			System.out.println("[����] ���� ���Ŀ� ���� �ʾ� ���� �����߽��ϴ�.");
		}

		selectBookInfo(0, "");
	}
	
	/**
	 * å ���� ���� �޼���
	 * 
	 * @see		#getInputString()
	 * @see		#getInputInt()
	 * @see		#selectBookInfo(int, String)
	 */
	public static void updateBookInfo() {
		System.out.print("�����Ͻ÷��� ���� ��ȣ�� �Է��ϼ��� >> ");
		int index = getInputInt();
		boolean isSuccess = false;

		if (index > books.length) {
			System.out.println("[����] �Է��Ͻ� ��ȣ�� �ش��ϴ� ������ �����ϴ�. ");
		} else {
			System.out.println("### �����Ͻ÷��� �׸� ��ȣ�� �Է��ϼ���.");
			System.out.println("2. ����");
			System.out.println("3. ����");
			System.out.println("4. ����");
			System.out.println("5. ����");
			System.out.print("��ȣ �Է� >> ");
			int category = getInputInt();

			System.out.print("���� ������ �Է��ϼ��� >> ");
			String input = getInputString();

			if (input != null) {
				switch (category) {
				case 1:
					books[index - 1].setIsbn(input);
					if (books[index - 1].getIsbn().equals(input)) {
						isSuccess = true;
					}
					break;
				case 2:
					books[index - 1].setTitle(input);
					if (books[index - 1].getTitle().equals(input)) {
						isSuccess = true;
					}
					break;
				case 3:
					books[index - 1].setAuthor(input);
					if (books[index - 1].getAuthor().equals(input)) {
						isSuccess = true;
					}
					break;
				case 4:
					books[index - 1].setPrice(Integer.parseInt(input));
					if (books[index - 1].getPrice() == Integer.parseInt(input)) {
						isSuccess = true;
					}
					break;
				case 5:
					books[index - 1].setAmount(Integer.parseInt(input));
					if (books[index - 1].getAmount() == Integer.parseInt(input)) {
						isSuccess = true;
					}
					break;
				default:
					System.out.println("[����] �׸� ��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
				}

			} else {
				System.out.println("[����] ��� �� ���� �̻� �Է��ϼ���.");
			}
		}

		if (isSuccess == true) {
			System.out.println("[����] ���� �����Ͽ����ϴ�.");
		}
		selectBookInfo(0, "");
	}

	/**
	 * å ���� ���� �޼���
	 * @see		#getInputInt()
	 * @see		#selectBookInfo(int, String)
	 * @see		java.util.Arrays#copyOf(Object[], int)
	 */
	public static void deleteBookInfo() {
		System.out.print("�����Ͻ÷��� ���� ��ȣ�� �Է��ϼ��� >> ");
		int index = getInputInt();

		if (index > books.length) {
			System.out.println("[����] �Է��Ͻ� ��ȣ�� �ش��ϴ� ������ �����ϴ�. ");

		} else {
			for (int i = index - 1; i + 1 < books.length; i++) {
				books[i] = books[i + 1];
			}

			books = Arrays.copyOf(books, books.length - 1);
			System.out.println("[����] ���� �Ϸ�Ǿ����ϴ�.");
		}
		selectBookInfo(0, "");
	}

	/**
	 * ��հ� ���ϴ� �޼���
	 * 
	 * @param sum		�� ��
	 * @param count		����
	 * @return			count�� 0���� Ŭ ��� ��հ� ���Ͽ� ��ȯ, 0�� ���ų� ���� ��� 0.0 ��ȯ
	 */
	public static double getAveragePrice(double sum, int count) {
		if (count > 0) {
			return sum / count;
		}
		return 0.0;

	}

	/**
	 * �޴� ��� �޼���
	 */
	public static void printMenu() {
		System.out.println("============= ���������ý��� =============");
		System.out.println("1. ���� ��ü ��� ��ȸ");
		System.out.println("2. ���� ���� �˻� ��ȸ");
		System.out.println("3. ���� ���� ���");
		System.out.println("4. ���� ���� ����");
		System.out.println("5. ���� ���� ����");
		System.out.println("0. ����");
		System.out.println("=====================================");
		System.out.print("���Ͻô� ����� ���ڷ� �Է����ּ��� >> ");
	}

	/**
	 * ���� �޴� ��� �޼���
	 */
	public static void printSubMenu() {
		System.out.println("============= ### �߰� �޴� =============");
		System.out.println("1. ���� ��� ���� ��ȸ");
		System.out.println("2. ���� ���� ��ȸ");
		System.out.println("0. ���� �޴��� ���ư���");
		System.out.println("=====================================");
		System.out.print("���Ͻô� ����� ���ڷ� �Է����ּ��� >> ");
	}

	/**
	 * å ����� ����ϱ� ��, ��� ��� �޼���
	 */
	public static void printBookHeader() {
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.printf(" %s\t%-13s\t\t%-15s\t\t%-15s\t%s\t%s\n", "No.", "ISBN", "å����", "����", "����", "����");
		System.out.println("---------------------------------------------------------------------------------------");
	}

	/**
	 * ���м� ��� �޼���
	 */
	public static void printLine() {
		System.out.println("---------------------------------------------------------------------------------------");
	}

	/**
	 * å ���� ��� �޼���
	 * : �迭 �ε������� �Է¹޾� �ش� ���� ���
	 * 
	 * @param index 	�迭 �ּҰ�
	 */
	public static void printBookInfo(int index) {
		System.out.println(" " + (index + 1) + "\t" + books[index]);
	}
	
	/**
	 * å ���� ��� �޼���
	 * : BookŸ�� �迭 ���������� �Է¹޾� ��ü ���
	 */
	public static void printBookInfo(Book[] books) {
		for(int i = 0; i <books.length; i++) {
			System.out.println(" " + (i + 1) + "\t" + books[i]);
		}
	}

	/**
	 * ����� �Է°��� StringŸ������ �޾� ��ȯ�ϴ� �޼���
	 * @return 		����� �Է°�
	 * 
	 * @see			java.io.InputStreamReader
	 * @see			java.io.BufferedReader
	 * @see			java.io.IOException
	 */
	public static String getInputString() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String str = "";

		try {
			str = br.readLine();
		} catch (IOException ie) {
			ie.printStackTrace();
		} 
		return str;
	}
	
	/**
	 * ����� �Է°��� intŸ������ �޾� ��ȯ�ϴ� �޼���
	 * @return 		����� �Է°�
	 * 
	 * @see			java.io.InputStreamReader
	 * @see			java.io.BufferedReader
	 * @see			java.io.IOException
	 */
	public static int getInputInt() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int num = 0;

		try {
			num = Integer.parseInt(br.readLine());
		} catch (IOException ie) {
			System.out.println("[����] IOException�� �߻��Ͽ����ϴ�.");
		}
		return num;
	}
	
	/**
	 * ����� �Է°��� DoubleŸ������ �޾� ��ȯ�ϴ� �޼���
	 * @return 		����� �Է°�
	 * 
	 * @see			java.io.InputStreamReader
	 * @see			java.io.BufferedReader
	 * @see			java.io.IOException
	 */
	public static Double getInputDouble() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		Double num = 0.0;

		try {
			num = Double.parseDouble(br.readLine());
		} catch (IOException ie) {
			System.out.println("[����] IOException�� �߻��Ͽ����ϴ�.");
		} 
		return num;
	}
	

}
