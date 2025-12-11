# CS1180 – Project 3  
##  Spelling Bee – Java Word Validation Game

This project was created for **CS1180 – Computer Science I** at **Wright State University**.  
It is a Java console-based Spelling Bee game where the user enters words and the program checks them against a list of valid words stored in a text file.

---

## Overview
The game loads a word list from an external file (`words.txt`) and allows the user to enter words.  
If the input matches any word in the file, it is counted as a correct answer.

---

##  Project Files

Both files **must be placed in the same folder**:

SpellingBee/
├── SpellingBee.java
├── words.txt


`words.txt` contains all possible valid words that the program uses to verify the user's input.

---

##  Program Features

### 🔹 External Word Loading
The program reads all valid words from `words.txt` when it starts.

### 🔹 Word Validation
- User enters a word  
- Program checks if the word exists in the list  
- If found → correct  
- If not → incorrect

### 🔹 Simple and Fast Lookups
All words are stored in memory for quick comparison.

---

##  How It Works
1. Load all words from `words.txt`
2. Prompt the user for a word
3. Compare input with the list
4. Display whether the word is valid or not

---

##  Program Structure

- `loadWords()` – Reads words from the file  
- `isValidWord()` – Checks if the user’s input matches a valid word  
- `main()` – Runs the full program  

---

##  How to Run

```bash
javac SpellingBee.java
java SpellingBee
