package mql.java.exam.models;

public class Note {
	
	private double note;
	private int coefficient;
	
	public Note(double note,int coefficient) {
		this.note = note;
		this.coefficient = coefficient;
	}
	
	public double getNote() {
		return note;
	}
	
	public int getCoefficient() {
		return coefficient;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+note;
	}

}
