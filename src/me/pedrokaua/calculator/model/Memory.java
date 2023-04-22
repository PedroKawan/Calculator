package me.pedrokaua.calculator.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Memory {
	// Calculator's Memory
	
	private static final Memory instance = new Memory();
	
	private CommandType operation = null;
	private boolean substring = false;
	private String textCurrent = "";
	private String valueMemory;
	
	// Observers list
	private final List<MemoryObserver> observers 
		= new ArrayList<>();
	
	private Memory() {}
	
	
	public void addObserver(MemoryObserver observer) {
		observers.add(observer);
	}
	
	// Get 'Memory' instance itself
	public static Memory getInstance() {
		return instance;
	}

	// Get numbers of display
	public String getTextCurrent() {
		return textCurrent.isEmpty() ? "0" : textCurrent;
	}

	// Button commands
	public void processCommands(String text) {
		CommandType commandType = verifyCommand(text);
		
		
		if (commandType == CommandType.RESET) {
			textCurrent = "";
			valueMemory = "";
			substring = false;
			operation = null;
		} else if (commandType == CommandType.RESETCURRENT) {
			textCurrent = "";
		} else if (commandType == CommandType.BACKSPACE) {
			textCurrent = textCurrent.substring(0, textCurrent.length() - 1);
		} else if (commandType == CommandType.NP) {
			if (textCurrent.charAt(0) == '-') {
				textCurrent = textCurrent.substring(1);
			} else {
				textCurrent = "-" + textCurrent;
			} 
		} else if (commandType == CommandType.NUMBER
					|| commandType == CommandType.COMMA){
			textCurrent = substring ? text : textCurrent + text;
			substring = false;
		} else {
			substring = true;
			textCurrent = operationResult();
			valueMemory = textCurrent;
			operation = commandType;
		}
		if (textCurrent.equals("00")) textCurrent = "";
		observers.forEach(o -> o.auteredValue(getTextCurrent()));
	}
	
	
	// Math operations
	private String operationResult() {
		if (operation == null || 
					operation == CommandType.EQUALS) {
			return textCurrent;
		}
		
		BigDecimal value = new BigDecimal(textCurrent.replace(',', '.'));
		BigDecimal valueM = new BigDecimal(valueMemory.replace(',', '.'));
		BigDecimal result = new BigDecimal("0");
		
		if (operation  == CommandType.SUM) {
			result = value.add(valueM);
		} else if (operation  == CommandType.SUB) {
			result = valueM.subtract(value);
		}else if (operation  == CommandType.MULT) {
			result = valueM.multiply(value);
		} else if (operation == CommandType.DIV) {
			result = valueM.divide(value);
		}
		
		String resultString = result.toString().replace('.', ',');
		
		boolean isInteger = resultString.endsWith(",0");
		return isInteger ? resultString.replace(",0", "") 
				: resultString;
	}


	//Verify of 'ENUM' commandType
	private CommandType verifyCommand(String text) {
		
		if (text == "0") return CommandType.NUMBER;
		
		try {
			Integer.parseInt(text);
			return CommandType.NUMBER;
		} catch (NumberFormatException e) {
			if (text.equals("C")) return CommandType.RESET;
			if (text.equals("CE")) return CommandType.RESETCURRENT;
			if (text.equals("+/-")) return CommandType.NP;
			
			if (text.equals("🔙") &&
					!textCurrent.isEmpty()) return CommandType.BACKSPACE;
			if (text.equals(",") &&
					!textCurrent.contains(",")) return CommandType.COMMA;
			
			if (text.equals("/")) return CommandType.DIV;
			if (text.equals("*")) return CommandType.MULT;
			if (text.equals("-")) return CommandType.SUB;
			if (text.equals("+")) return CommandType.SUM;
			if (text.equals("=")) return CommandType.EQUALS;		
		}
		
		return null;
	}

	//Commands
	private enum CommandType {
		RESET, RESETCURRENT, BACKSPACE,
		NUMBER, NP,
		DIV, MULT, SUB, SUM,
		EQUALS, COMMA;
	}
}
