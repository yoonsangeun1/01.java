package com.yoons.model;

/**
 * 도서 관리를 위한 기본 도메인 클래스

 * 
 * @author 		윤상은
 * @version 	% I %, % G %
 * @since 		JDK 1.8
 */
public class Book {
	/** ISBN(국제 표준 도서 번호) */
	private String isbn;
	
	/** 책제목 */
	private String title;
	
	/** 저자 */
	private String author;
	
	/** 가격 */
	private int price;
	
	/** 수량 */
	private int amount;
	
	
	/** 기본 생성자 */
	public Book() {}
	
	/**
	 * 입력받은 값 유효성 검증 후 필수 정보 초기화 생성자
	 * 
	 * @param isbn		ISBN(국제 표준 도서 번호)
	 * @param title		책제목
	 * @param author	저자
	 * @param price		가격
	 * 
	 * @see #setIsbn(String)
	 * @see #setTitle(String)
	 * @see #setAuthor(String)
	 * @see #setPrice(int)
	 */
	public Book(String isbn, String title, String author, int price) {
		this.setIsbn(isbn);
		this.setTitle(title);
		this.setAuthor(author);
		this.setPrice(price);
	}
	
	/**
	 * 입력받은 값 유효성 검증 후 전체 정보 초기화 생성자
	 * 
	 * @param isbn		ISBN(국제 표준 도서 번호)
	 * @param title		책제목
	 * @param author	저자
	 * @param price		가격
	 * @param amount	수량
	 */
	public Book(String isbn, String title, String author, int price, int amount) {
		this(isbn, title, author, price);
		this.setAmount(amount);
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * 입력받은 제목이 ISBN 형식에 맞는지 판별 후 멤버변수에 데이터 저장
	 * 
	 * @param isbn 		the isbn to set
	 * @see				com.yoons.model.Book#isIsbn(String)
	 */
	public void setIsbn(String isbn) {
		if(isIsbn(isbn) == true) {
			this.isbn = isbn.trim();
		}
	}
	
	/**
	 * 입력받은 제목이 ISBN 형식에 맞는지 판별식
	 * 
	 * @param isbn		ISBN(국제 표준 도서 번호)
	 * @return			isbn이 형식에 맞으면 true, 아니면 false 반환
	 * @see				com.yoons.model.Book#isString(String)
	 */
	private boolean isIsbn(String isbn) {
		isbn = isbn.trim();
		if(isString(isbn) == true) {
			if(isbn.length() == 17 || isbn.length() == 13) {
				return true;
			} else {
				System.out.println("[오류] ISBN 형식에 맞게 입력하세요!");
				return false;
			}
		}
		return false;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * 입력받은 제목이 한 글자 이상인지 판별 후 멤버변수에 데이터 저장
	 * 
	 * @param title 	the title to set
	 * @see				com.yoons.model.Book#isString(String)
	 */
	public void setTitle(String title) {
		if(isString(title) == true) {
			this.title = title.trim();
		}
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * 입력받은 저자명이 한 글자 이상인지 판별 후 멤버변수에 데이터 저장
	 * 
	 * @param author 	the author to set
	 * @see				com.yoons.model.Book#isString(String)
	 */
	public void setAuthor(String author) {
		if(isString(author) == true) {
			this.author = author.trim();
		}
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 입력한 가격이 양수인지 판별 후 멤버변수에 데이터 저장
	 * 
	 * @param price 	the price to set
	 * @see				com.yoons.model.Book#isPositiveNumber(int)
	 */
	public void setPrice(int price) {
		if(isPositiveNumber(price) == true) {
			this.price = price;
		}
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * 입력한 수량이 양수인지 판별 후 멤버변수에 데이터 저장
	 * 
	 * @param amount 	the amount to set
	 * @see				com.yoons.model.Book#isPositiveNumber(int)
	 */
	public void setAmount(int amount) {
		if(isPositiveNumber(amount) == true) {
			this.amount = amount;
		}
	}
	
	/**
	 * 입력한 문자열이 null이 아니고, 한 글자 이상인지 여부 판별식
	 * 
	 * @param str		입력한 문자열
	 * @return			str이 한 글자 이상이면 true, 아니면 false 반환
	 */
	private boolean isString(String str) {
		str = str.trim();
		if(str != null && str.length() > 0) {
			return true;
		} else {
			System.out.println("[오류] 한 글자 이상 입력하세요!");
			return false;
		}
	}
	
	/**
	 * 양수, 음수 여부 판별식
	 * 
	 * @param number	양수인지 음수인지 판별할 대상 숫자
	 * @return			양수이면 true, 음수이면 false 반환
	 */
	private boolean isPositiveNumber(int number) {
		if(number > 0) {
			return true;
		} else {
			System.out.println("[오류] 0보다 큰 수를 입력하세요!");
			return false;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		/*int maxLength = 10;
		if(title.length() > maxLength) {
			title = title.substring(0, maxLength-1) + "..";
		}
		try {
			return isbn.substring(0,8) + "..\t" //String.format("%-15s", isbn) + "\t"
			+ String.format("%-13s", title) + "\t" 
			+ String.format("%-15s", author) + "\t" 
			+ price + "\t" 
			+ amount;
		} catch (NullPointerException e) {
		} catch (IndexOutOfBoundsException ee) {
			//throw e;
		}*/
		
		return isbn + "\t" //String.format("%-15s", isbn) + "\t"
		+ title + "\t\t\t" 
		+ author + "\t" 
		+ price + "\t" 
		+ amount;
	}
	
}
