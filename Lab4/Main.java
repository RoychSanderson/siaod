//package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args){
		//1 задание
		//
		try {
			int flag = 0;
			MyDeque first = new MyDeque();
			MyDeque second = new MyDeque();
			String alphabet = "АБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЭЮЯабвгдеёжзиклмнопрстуфхцчшщъыьэюя";
			String alph, cop;
			int col = 0;
			int poz = 1;
			File books = new File("C:\\FilesForCheck", "Books.txt");
			BufferedReader reader = new BufferedReader(new FileReader(books));
			String line = reader.readLine();
			while (line != null){
				alph = line.substring(poz-1, poz);
				cop = line;
				if (second.isVoid()){
					second.pushT(cop);
				} else {
					String palph = second.getTop().substring(poz-1, poz);
					if (alphabet.indexOf(alph) < alphabet.indexOf(palph)){
						second.pushT(cop);
						flag = 1;
					} else {
						while (alphabet.indexOf(alph) == alphabet.indexOf(palph)){
							poz +=1;
							alph = cop.substring(poz-1, poz);
							palph = second.getTop().substring(poz-1, poz);
							while (alphabet.indexOf(alph) > alphabet.indexOf(palph)){
								first.pushT(second.popT());
								col += 1;
								palph = second.getTop().substring(poz-1, poz);
							}
						}
						if (alphabet.indexOf(alph) < (alphabet.indexOf(palph))){
							second.pushT(cop);
							flag = 1;
							for (int i = 0; i<col; i++){
								second.pushT(first.popT());
							}

						}
						col = 0;
						poz = 1;
					}
					if (flag == 0){
						palph = second.getBottom().substring(poz-1, poz);
						if (alphabet.indexOf(alph) > alphabet.indexOf(palph)){
							second.pushB(cop);
						} else {
							while (alphabet.indexOf(alph) < alphabet.indexOf(palph)){
								first.pushT(second.popB());
								col += 1;
								palph = second.getBottom().substring(poz-1, poz);
							}
							while (alphabet.indexOf(alph) == alphabet.indexOf(palph)){
								poz +=1;
								alph = cop.substring(poz-1, poz);
								palph = second.getBottom().substring(poz-1, poz);
								while (alphabet.indexOf(alph) < alphabet.indexOf(palph)){
									first.pushT(second.popB());
									col += 1;
									palph = second.getBottom().substring(poz-1, poz);
								}
							}
							if (alphabet.indexOf(alph) > (alphabet.indexOf(palph))){
								second.pushB(cop);
								for (int i = 0; i<col; i++){
									second.pushB(first.popT());
								}
							}
							col = 0;
							poz = 1;
						}
					}
				}
				line = reader.readLine();
				flag = 0;
			}
		reader.close();
			FileOutputStream fos = new FileOutputStream("C:\\FilesForCheck\\Result.txt");
			String oi = "1-ое задание\n";
			fos.write(oi.getBytes());
			while (!second.isVoid()){
				oi = second.popT() + "\n";
				fos.write(oi.getBytes());
			}
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
		//
		//2 задание
		//
		try {
			MyDeque pas = new MyDeque();
			String alphabet = "абвгдеёжзиклмнопрстуфхцчшщъыьэюя";
			for (int i = 1; i<alphabet.length(); i++){
				pas.pushT(alphabet.substring(i-1, i));
			}
			BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\FilesForCheck",
					"Shifr.txt")));
			FileOutputStream fos = new FileOutputStream("C:\\FilesForCheck\\Result.txt", true);
			String message = reader.readLine();
			String[] word = new String[message.length()];
			for (int i = 0; i<message.length()-1; i++){
				word[i] = message.substring(i,i+1);
			}
			int schet = 0;
			while (schet < message.length()){
				String tmp = pas.popT();
				if (message.contains(tmp)){
					int in = message.indexOf(tmp);
					pas.pushB(tmp);
					pas.pushB(pas.popT());
					word[in] = pas.getTop();
					schet += 1;
				}
			}
			String oi = "2-ое задание\n";
			fos.write(oi.getBytes());
			oi = "Изначальное сообщение - ";
			fos.write(oi.getBytes());
			for (int i = 0; i < word.length; i++){
				oi = word[i];
				fos.write(oi.getBytes());
			}
			oi = "\n";
			fos.write(oi.getBytes());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		//
		//3 задание
		//
		try {
			MyStack A = new MyStack(1);
			MyStack B = new MyStack(2);
			MyStack C = new MyStack(3);
			FileOutputStream fos = new FileOutputStream("C:\\FilesForCheck\\Result.txt", true);
			BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\FilesForCheck",
					"Disk.txt")));
			int kol = Integer.parseInt(reader.readLine());
			for (int i = kol; i > 0; i--){
				A.push(Integer.toString(i));
			}
			Perenos(kol, A, C, B);
			String oi = "3-ое задание\n";
			fos.write(oi.getBytes());
			oi = "Первый стержень:";
			fos.write(oi.getBytes());
			while (!A.isVoid()){
				oi = A.popout();
				fos.write(oi.getBytes());
			}
			oi = "\n";
			fos.write(oi.getBytes());
			oi = "Второй стержень:";
			fos.write(oi.getBytes());
			while (!B.isVoid()){
				oi = B.popout();
				fos.write(oi.getBytes());
			}
			oi = "\n";
			fos.write(oi.getBytes());
			oi = "Третий стержень:";
			fos.write(oi.getBytes());
			while (!C.isVoid()){
				oi = C.popout();
				fos.write(oi.getBytes());
			}
			oi = "\n";
			fos.write(oi.getBytes());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		//
		//4 задание
		//
		try {
			MyStack tmp = new MyStack(0);
			FileOutputStream fos = new FileOutputStream("C:\\FilesForCheck\\Result.txt", true);
			BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\FilesForCheck",
					"Circle.txt")));
			String line = reader.readLine();
			while (line != null){
				if (line.contains("(")){
					tmp.push("(");
				}
				if (line.contains(")")){
					if (tmp.isVoid()) {
						System.out.println("Баланс нарушен");
						return;
					} else {
						tmp.popout();
					}
				}
				line = reader.readLine();
			}
			String oi = "4-ое задание\n";
			fos.write(oi.getBytes());
			if (tmp.isVoid()){
				oi = "Баланс соблюден\n";
				fos.write(oi.getBytes());
			} else {
				oi = "Баланс нарушен\n";
				fos.write(oi.getBytes());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		//
		//5 задание
		//
		try {
			MyDeque tmp = new MyDeque();
			FileOutputStream fos = new FileOutputStream("C:\\FilesForCheck\\Result.txt", true);
			BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\FilesForCheck","Circle.txt")));
			String line = reader.readLine();
			while (line != null){
				if (line.contains("[")){
					tmp.pushT("[");
				}
				if (line.contains("]")){
					tmp.pushB("]");
				}
				if ((tmp.getTop() == "[")&&(tmp.getBottom() == "]")){
					tmp.popB();
					tmp.popT();
				}
				line = reader.readLine();
			}
			String oi = "5-ое задание\n";
			fos.write(oi.getBytes());
			if (tmp.isVoid()){
				oi = "Баланс соблюден\n";
				fos.write(oi.getBytes());
			} else {
				oi = "Баланс нарушен\n";
				fos.write(oi.getBytes());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		//
		//6 задание
		//
		try {
			FileOutputStream fos = new FileOutputStream("C:\\FilesForCheck\\Result.txt", true);
			BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\FilesForCheck",
					"Symbols.txt")));
			MyStack stack = new MyStack(0);
			String numbers = "0123456789";
			String alp = "АБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзиклмнопрстуфхцчшщъыьэюя";
			String oi = "6-ое задание\n";
			fos.write(oi.getBytes());
			String line = reader.readLine();
			stack.push("");
			stack.push("");
			while (line != null){
				for (int i = 0; i< line.length()-1; i++){
					String tp = line.substring(i, i+1);
					char[] yu = tp.toCharArray();
					if (numbers.contains(tp)){
						oi = tp;
						fos.write(oi.getBytes());
					} else {
						if (Character.isLetter(yu[0])){
							stack.push(stack.popout() + tp);
						} else {
							String temp = stack.popout();
							stack.push(stack.popout() + tp);
							stack.push(temp);
						}
					}
				}
				line = reader.readLine();
			}
			while (!stack.isVoid()){
				oi = stack.popout();
				fos.write(oi.getBytes());
			}
			oi = "\n";
			fos.write(oi.getBytes());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		//
		//7 задание
		//
		try {
			FileOutputStream fos = new FileOutputStream("C:\\FilesForCheck\\Result.txt", true);
			BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\FilesForCheck",
					"Numbers.txt")));
			MyDeque numbers = new MyDeque();
			String oi = "7-ое задание\n";
			fos.write(oi.getBytes());
			String line = reader.readLine();
			while (line != null){
				String[] subline = line.split(" ");
				for (int i = 0; i < subline.length; i++){
					if (subline[i].contains("-")){
						numbers.pushB(subline[i]);
					} else {
						numbers.pushT(subline[i]);
					}
				}
				line = reader.readLine();
			}
			while (numbers.getBottom().contains("-")){
				numbers.pushT(numbers.popB());
			}
			while (!numbers.getBottom().contains("-")){
				oi = numbers.popB() + " ";
				fos.write(oi.getBytes());
			}
			while (!numbers.isVoid()){
				oi = numbers.popT() + " ";
				fos.write(oi.getBytes());
			}
			oi = "\n";
			fos.write(oi.getBytes());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		//
		//8 задание
		//
		try {
			FileOutputStream fos = new FileOutputStream("C:\\FilesForCheck\\Result.txt", true);
			BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\FilesForCheck",
					"Strings.txt")));
			MyStack stack = new MyStack(0);
			String oi = "8-ое задание\n";
			fos.write(oi.getBytes());
			String line = reader.readLine();
			while (line != null){
				stack.push(line);
				line = reader.readLine();
			}
			while (!stack.isVoid()){
				oi = stack.popout() + "\n";
				fos.write(oi.getBytes());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		//
		//9 задание
		//
		try {
			FileOutputStream fos = new FileOutputStream("C:\\FilesForCheck\\Result.txt", true);
			BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\FilesForCheck",
					"9.txt")));
			MyStack oper = new MyStack(0);
			MyStack znach = new MyStack(0);
			String line = reader.readLine();
			String toperators = "NAXO";
			char[] chars = line.toCharArray();
			for (char aChar : chars) {
				if ((aChar == 'T') || (aChar == 'F')) {
					znach.push(String.valueOf(aChar));
				}
				if (toperators.contains(String.valueOf(aChar))) {
					oper.push(String.valueOf(aChar));
				}
				if (aChar == '(') {
					oper.push(String.valueOf(aChar));

				}
				if (aChar == ')') {
					while (!oper.getTop().equals("(")) {
						char[] tmp = oper.popout().toCharArray();
						Operate(tmp[0], znach);
					}
					oper.popout();
				}
			}
			while (!oper.isVoid()) {
				char[] tmp = oper.popout().toCharArray();
				Operate(tmp[0], znach);
			}
			String oi = "9-ое задание\n";
			fos.write(oi.getBytes());
			oi = znach.popout() + "\n";
			fos.write(oi.getBytes());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		//
		//10 задание
		//
		try {
			FileOutputStream fos = new FileOutputStream("C:\\FilesForCheck\\Result.txt", true);
			BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\FilesForCheck",
					"10.txt")));
			MyStack oper = new MyStack(0);
			MyStack znach = new MyStack(0);
			String operators = "0123456789";
			String line = reader.readLine();
			char[] chars = line.toCharArray();
			for (char aChar : chars) {
				if (operators.contains(String.valueOf(aChar))){
					znach.push(String.valueOf(aChar));
				}
				if ((aChar == 'M') || (aChar == 'N')) {
					oper.push(String.valueOf(aChar));
				}
				if (aChar == ')') {
					char[] tmp = oper.popout().toCharArray();
					MathOperate(tmp[0], znach);
				}
			}
			String oi = "10-ое задание\n";
			fos.write(oi.getBytes());
			while (!oper.isVoid()){
				char[] tmp = oper.popout().toCharArray();
				MathOperate(tmp[0], znach);
			}
			oi = znach.popout() + "\n";
			fos.write(oi.getBytes());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		//
		//11 задание
		//
		try {
			FileOutputStream fos = new FileOutputStream("C:\\FilesForCheck\\Result.txt", true);
			BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\FilesForCheck",
					"11.txt")));
			boolean check = true;
			int flag = 1;
			int kol = 0;
			MyStack oper = new MyStack(0);
			MyStack znach = new MyStack(0);
			String line = reader.readLine();
			char[] chars = line.toCharArray();
			for (char aChar : chars) {
				if ((aChar == '+') || (aChar == '-')) {
					if (flag == 1){
						check = false;
						break;
					} else {
						oper.push(String.valueOf(aChar));
						flag = 1;
					}
				}
				if (aChar == '(') {
					kol += 1;
					flag = 1;
				}
				if (aChar == ')') {
					kol -= 1;
					if (kol < 0){
						check = false;
						break;
					}
					flag = 0;
				}
				if ((aChar == 'x') || (aChar == 'y') || (aChar == 'z')){
					if (flag == 0){
						check = false;
						break;
					} else {
						znach.push(String.valueOf(aChar));
						flag = 0;
					}
				}
			}
			String oi = "10-ое задание\n";
			fos.write(oi.getBytes());
			oi = check + "\n";
			fos.write(oi.getBytes());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	//Для задания 3
	public static void Perenos(int N, MyStack i, MyStack k, MyStack tmp){
    	if (N == 1){
    		k.push(i.popout());
    		//System.out.println("Диск " + N + " переносим с " + i.number + " на стержень " + k.number);
		} else {
			Perenos(N-1, i, tmp, k);
			k.push(i.popout());
			//System.out.println("Диск " + N + " переносим с " + i.number + " на стержень " + k.number);
			Perenos(N-1, tmp, k, i);
		}
	}
	//Для задания 9
	public static void Operate(char op, MyStack z){
		String tmp = z.popout();
    	if (op == 'N'){
    		if (tmp.equals("T"))
    			tmp = "F";
    		else
    			tmp = "T";
    		z.push(tmp);
    		return;
		}
    	String tmp2 = tmp + z.popout();
    	char[] tmpa = tmp2.toCharArray();
		if (op == 'A'){
			if ((tmpa[0] == 'T')&&(tmpa[1] == 'T')){
				z.push("T");
			} else {
				z.push("F");
			}
			return;
		}
		if (op == 'O'){
			if ((tmpa[0] == 'F')&&(tmpa[1] == 'F')){
				z.push("F");
			} else {
				z.push("T");
			}
			return;
		}
		if (op == 'X'){
			if (tmpa[0] == tmpa[1]){
				z.push("F");
			} else
				z.push("T");
			return;
		}

	}
	//Для задания 10
	public static void MathOperate(char op, MyStack z){
		String tmp = z.popout();
		String tmp2 = z.popout();
		int od = Integer.parseInt(tmp);
		int yo = Integer.parseInt(tmp2);
		if (op == 'M'){
			if (od >= yo)
				z.push(tmp);
			else
				z.push(tmp2);
		}
		if (op == 'N'){
			if (od <= yo)
				z.push(tmp);
			else
				z.push(tmp2);
		}
	}
}
