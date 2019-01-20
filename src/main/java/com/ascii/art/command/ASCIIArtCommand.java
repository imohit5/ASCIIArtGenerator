package com.ascii.art.command;

import java.util.Arrays;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ASCIIArtCommand {
	

//	@NotNull(message="Please enter text")
//	@Min(1)
	
	@NotBlank(message="text cannot be blank")
	private String textAscii;
	
	private String[][] textareaAscii;
	
	private String designPrintValue;
	
	
	
	
	public String getTextAscii() {
		return textAscii;
	}

	public void setTextAscii(String textAscii) {
		this.textAscii = textAscii;
	}

	public String[][] getTextareaAscii() {
		return textareaAscii;
	}

	public void setTextareaAscii(String[][] textareaAscii) {
		this.textareaAscii = textareaAscii;
	}

	
	
	public String getDesignPrintValue() {
		return designPrintValue;
	}

	public void setDesignPrintValue(String designPrintValue) {
		this.designPrintValue = designPrintValue;
	}

	@Override
	public String toString() {
		return "ASCIIArtCommand [textAscii=" + textAscii + ", textareaAscii=" + Arrays.toString(textareaAscii)
				+ ", designPrintValue=" + designPrintValue + "]";
	}
	

}
