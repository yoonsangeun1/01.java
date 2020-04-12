package com.yoons.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.yoons.model.Book;

/** 
 * 도서 관리 시스템
 * for example: 
 * <pre>
 * 
 * </pre>
 * @author yoons
 * @author 		윤상은
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

	/** Book 타입 참조변수 배열 */
	static Book[] books = { new Book("741-245-7532-86-1", "삼국지", "홍길동", 10000, 3),
			new Book("978-89-94492-04-9", "Java의 정석", "남궁성", 25000, 5),
			new Book("789-81-4510-102-0", "편하게 읽는 자바 프로그래밍", "박용우", 40000, 1),
			new Book("978-89-255-6858-4", "작은 아씨들", "루이자 메이올컷", 16500, 1),
			new Book("979-11-6224-048-9", "이것이 오라클이다", "우재남", 30000, 5), };

	/**
	 * 책을 관리하는 메인 메서드
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
					System.out.println("### 검색하시려는 항목 번호를 입력하세요.");
					System.out.println("1. ISBN");
					System.out.println("2. 제목");
					System.out.println("3. 저자");
					System.out.println("4. 가격");
					System.out.println("5. 수량");
					System.out.print("번호 입력 >> ");
					int category = getInputInt();

					if (!(1 <= category && category <= 5)) {
						System.out.println("[오류] 잘못 입력하셨습니다. 메인메뉴로 돌아갑니다.");
						break;
					}

					System.out.print("검색어를 입력하세요 >> ");
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
					System.out.println("[종료] Bye~");
					break;

				default:
					System.out.println("[오류] 잘못 입력하셨습니다!");
				}
			} catch (NumberFormatException e) {
				System.out.println("[오류] 숫자 형식에 맞게 입력하세요!");
			}
		}
	}
	
	/**
	 * 책 정보 검색 및 출력 메서드
	 * : 전달인자 category의 값에 따라 다른 항목에서 input값을 검색하여 일치하는 값이 있을 경우 출력
	 * 
	 * @param category		항목
	 * @param input			검색어
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
			System.out.printf(" 검색 결과 : %d건, 평균 금액 : %6.0f원\n", count, getAveragePrice(sum, count));
		} else {
			System.out.println("[알림] 일치하는 검색 결과가 없습니다.");
		}
		printLine();

	}
	
	//public static int getLength() { return 0; }
	
	/**
	 * 책 정보 등록 메서드
	 * 
	 * @see		#getInputString()
	 * @see		#getInputInt()
	 * @see		#selectBookInfo(int, String)
	 * @see		java.util.Arrays#copyOf(Object[], int)
	 */
	public static void insertBookInfo() {
		Book newBook = new Book();

		System.out.print("ISBN을 입력하세요 (10글자 혹은 13글자 숫자, '-'를 넣어 입력해주세요) >> ");
		newBook.setIsbn(getInputString());

		System.out.print("책 제목을 입력하세요 (한 글자 이상 문자열) >> ");
		newBook.setTitle(getInputString());

		System.out.print("저자명을 입력하세요 (한 글자 이상 문자열) >> ");
		newBook.setAuthor(getInputString());

		System.out.print("가격을 입력하세요 (1 이상 숫자) >> ");
		newBook.setPrice(getInputInt());

		/* System.out.print("ISBN을 입력하세요 (10글자 혹은 13글자 숫자, '-'를 넣어 입력해주세요) >> ");
		String isbn = getInputString();

		System.out.print("책 제목을 입력하세요 (한 글자 이상 문자열) >> ");
		String title = getInputString();

		System.out.print("저자명을 입력하세요 (한 글자 이상 문자열) >> ");
		String author = getInputString();

		System.out.print("가격을 입력하세요 (1 이상 숫자) >> ");
		int price = getInputInt();

		Book newBook = new Book(isbn, title, author, price); */
		
		if ((newBook.getIsbn() != null && newBook.getTitle() != null && newBook.getAuthor() != null
				&& newBook.getPrice() != 0)) {
			Book[] tmp = Arrays.copyOf(books, books.length + 1);
			tmp[tmp.length - 1] = newBook;
			books = Arrays.copyOf(tmp, tmp.length);

			System.out.println("[성공] 저장 완료했습니다.");
		} else {
			System.out.println("[오류] 저장 형식에 맞지 않아 저장 실패했습니다.");
		}

		selectBookInfo(0, "");
	}
	
	/**
	 * 책 정보 수정 메서드
	 * 
	 * @see		#getInputString()
	 * @see		#getInputInt()
	 * @see		#selectBookInfo(int, String)
	 */
	public static void updateBookInfo() {
		System.out.print("수정하시려는 도서 번호를 입력하세요 >> ");
		int index = getInputInt();
		boolean isSuccess = false;

		if (index > books.length) {
			System.out.println("[오류] 입력하신 번호에 해당하는 도서가 없습니다. ");
		} else {
			System.out.println("### 수정하시려는 항목 번호를 입력하세요.");
			System.out.println("2. 제목");
			System.out.println("3. 저자");
			System.out.println("4. 가격");
			System.out.println("5. 수량");
			System.out.print("번호 입력 >> ");
			int category = getInputInt();

			System.out.print("수정 내용을 입력하세요 >> ");
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
					System.out.println("[오류] 항목 번호를 잘못 입력하셨습니다.");
				}

			} else {
				System.out.println("[오류] 적어도 한 글자 이상 입력하세요.");
			}
		}

		if (isSuccess == true) {
			System.out.println("[성공] 수정 성공하였습니다.");
		}
		selectBookInfo(0, "");
	}

	/**
	 * 책 정보 삭제 메서드
	 * @see		#getInputInt()
	 * @see		#selectBookInfo(int, String)
	 * @see		java.util.Arrays#copyOf(Object[], int)
	 */
	public static void deleteBookInfo() {
		System.out.print("삭제하시려는 도서 번호를 입력하세요 >> ");
		int index = getInputInt();

		if (index > books.length) {
			System.out.println("[오류] 입력하신 번호에 해당하는 도서가 없습니다. ");

		} else {
			for (int i = index - 1; i + 1 < books.length; i++) {
				books[i] = books[i + 1];
			}

			books = Arrays.copyOf(books, books.length - 1);
			System.out.println("[성공] 삭제 완료되었습니다.");
		}
		selectBookInfo(0, "");
	}

	/**
	 * 평균값 구하는 메서드
	 * 
	 * @param sum		총 합
	 * @param count		개수
	 * @return			count가 0보다 클 경우 평균값 구하여 반환, 0과 같거나 적을 경우 0.0 반환
	 */
	public static double getAveragePrice(double sum, int count) {
		if (count > 0) {
			return sum / count;
		}
		return 0.0;

	}

	/**
	 * 메뉴 출력 메서드
	 */
	public static void printMenu() {
		System.out.println("============= 도서관리시스템 =============");
		System.out.println("1. 도서 전체 목록 조회");
		System.out.println("2. 도서 정보 검색 조회");
		System.out.println("3. 도서 정보 등록");
		System.out.println("4. 도서 정보 변경");
		System.out.println("5. 도서 정보 삭제");
		System.out.println("0. 종료");
		System.out.println("=====================================");
		System.out.print("원하시는 기능을 숫자로 입력해주세요 >> ");
	}

	/**
	 * 서브 메뉴 출력 메서드
	 */
	public static void printSubMenu() {
		System.out.println("============= ### 추가 메뉴 =============");
		System.out.println("1. 도서 평균 가격 조회");
		System.out.println("2. 도서 수량 조회");
		System.out.println("0. 메인 메뉴로 돌아가기");
		System.out.println("=====================================");
		System.out.print("원하시는 기능을 숫자로 입력해주세요 >> ");
	}

	/**
	 * 책 목록을 출력하기 전, 헤더 출력 메서드
	 */
	public static void printBookHeader() {
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.printf(" %s\t%-13s\t\t%-15s\t\t%-15s\t%s\t%s\n", "No.", "ISBN", "책제목", "저자", "가격", "수량");
		System.out.println("---------------------------------------------------------------------------------------");
	}

	/**
	 * 구분선 출력 메서드
	 */
	public static void printLine() {
		System.out.println("---------------------------------------------------------------------------------------");
	}

	/**
	 * 책 정보 출력 메서드
	 * : 배열 인덱스값을 입력받아 해당 열만 출력
	 * 
	 * @param index 	배열 주소값
	 */
	public static void printBookInfo(int index) {
		System.out.println(" " + (index + 1) + "\t" + books[index]);
	}
	
	/**
	 * 책 정보 출력 메서드
	 * : Book타입 배열 참조변수를 입력받아 전체 출력
	 */
	public static void printBookInfo(Book[] books) {
		for(int i = 0; i <books.length; i++) {
			System.out.println(" " + (i + 1) + "\t" + books[i]);
		}
	}

	/**
	 * 사용자 입력값을 String타입으로 받아 반환하는 메서드
	 * @return 		사용자 입력값
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
	 * 사용자 입력값을 int타입으로 받아 반환하는 메서드
	 * @return 		사용자 입력값
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
			System.out.println("[오류] IOException이 발생하였습니다.");
		}
		return num;
	}
	
	/**
	 * 사용자 입력값을 Double타입으로 받아 반환하는 메서드
	 * @return 		사용자 입력값
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
			System.out.println("[오류] IOException이 발생하였습니다.");
		} 
		return num;
	}
	

}
