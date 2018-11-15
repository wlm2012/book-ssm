package com.book.controller;

public class page {

	int start;
	int count;
	int total;

	public page(int start, int count) {
		// TODO Auto-generated constructor stub
		this.start = start;
		this.count = count;
	}

	public boolean isHasPreviouse() {
		if (start == 0)
			return false;
		return true;
	}

	public boolean isHasNext() {
		if (start == getLast())
			return false;
		return true;
	}

	public int getTotalPage() {
		if (0 == total)
			return 1;
		else if (0 == total % count) {
			return total / count;
		} else {
			return total / count + 1;
		}
	}

	public int getLast() {
		if (count >= total) {
			return 0;
		} else if (0 == total % count) {
			return total - count;
		} else {
			return total - total % count;
		}
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
