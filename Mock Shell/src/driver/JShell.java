// **********************************************************
// Assignment2:
// Student1: Mutasem Kharsa
// UTORID user_name: Kharsamu
// UT Student #: 1006211083
// Author: Mutasem Kharsa
//
// Student2: Nazmus Saqeeb
// UTORID user_name: saqeebna
// UT Student #: 1006306007
// Author: Nazmus Saqeeb
//
// Student3: Salik Chodhary
// UTORID user_name: chodhary
// UT Student #: 1006115892
// Author: Salik Chodhary
//
// Student4: Andy Yuen
// UTORID user_name: yuenand4
// UT Student #: 1006399247
// Author: Andy Yuen
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences.
// *********************************************************
package driver;

import parser.Parser;
import java.util.Scanner;
import error.StandardError;

/**
 * Shell that interacts with a Mock File System by the use of various commands
 */
public class JShell {
  /**
   * Continuously asks user for input and calls on Parser class to parse user input
   * 
   * @param args command line arguments sent by user
   */
  public static void main(String[] args) {
    Parser parser = new Parser();

    @SuppressWarnings("resource")
    Scanner scan = new Scanner(System.in);

    while (true) {
      System.out.print("/#:");
      String input = scan.nextLine();
      parser.parse(input);
      StandardError.printAllErrors();
    }
  }
}
