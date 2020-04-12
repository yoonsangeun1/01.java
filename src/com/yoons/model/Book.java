package com.yoons.model;

/**
 * ���� ������ ���� �⺻ ������ Ŭ����

 * 
 * @author 		������
 * @version 	% I %, % G %
 * @since 		JDK 1.8
 */
public class Book {
	/** ISBN(���� ǥ�� ���� ��ȣ) */
	private String isbn;
	
	/** å���� */
	private String title;
	
	/** ���� */
	private String author;
	
	/** ���� */
	private int price;
	
	/** ���� */
	private int amount;
	
	
	/** �⺻ ������ */
	public Book() {}
	
	/**
	 * �Է¹��� �� ��ȿ�� ���� �� �ʼ� ���� �ʱ�ȭ ������
	 * 
	 * @param isbn		ISBN(���� ǥ�� ���� ��ȣ)
	 * @param title		å����
	 * @param author	����
	 * @param price		����
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
	 * �Է¹��� �� ��ȿ�� ���� �� ��ü ���� �ʱ�ȭ ������
	 * 
	 * @param isbn		ISBN(���� ǥ�� ���� ��ȣ)
	 * @param title		å����
	 * @param author	����
	 * @param price		����
	 * @param amount	����
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
	 * �Է¹��� ������ ISBN ���Ŀ� �´��� �Ǻ� �� ��������� ������ ����
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
	 * �Է¹��� ������ ISBN ���Ŀ� �´��� �Ǻ���
	 * 
	 * @param isbn		ISBN(���� ǥ�� ���� ��ȣ)
	 * @return			isbn�� ���Ŀ� ������ true, �ƴϸ� false ��ȯ
	 * @see				com.yoons.model.Book#isString(String)
	 */
	private boolean isIsbn(String isbn) {
		isbn = isbn.trim();
		if(isString(isbn) == true) {
			if(isbn.length() == 17 || isbn.length() == 13) {
				return true;
			} else {
				System.out.println("[����] ISBN ���Ŀ� �°� �Է��ϼ���!");
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
	 * �Է¹��� ������ �� ���� �̻����� �Ǻ� �� ��������� ������ ����
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
	 * �Է¹��� ���ڸ��� �� ���� �̻����� �Ǻ� �� ��������� ������ ����
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
	 * �Է��� ������ ������� �Ǻ� �� ��������� ������ ����
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
	 * �Է��� ������ ������� �Ǻ� �� ��������� ������ ����
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
	 * �Է��� ���ڿ��� null�� �ƴϰ�, �� ���� �̻����� ���� �Ǻ���
	 * 
	 * @param str		�Է��� ���ڿ�
	 * @return			str�� �� ���� �̻��̸� true, �ƴϸ� false ��ȯ
	 */
	private boolean isString(String str) {
		str = str.trim();
		if(str != null && str.length() > 0) {
			return true;
		} else {
			System.out.println("[����] �� ���� �̻� �Է��ϼ���!");
			return false;
		}
	}
	
	/**
	 * ���, ���� ���� �Ǻ���
	 * 
	 * @param number	������� �������� �Ǻ��� ��� ����
	 * @return			����̸� true, �����̸� false ��ȯ
	 */
	private boolean isPositiveNumber(int number) {
		if(number > 0) {
			return true;
		} else {
			System.out.println("[����] 0���� ū ���� �Է��ϼ���!");
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
