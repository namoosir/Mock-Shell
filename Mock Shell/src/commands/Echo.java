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
package commands;

import error.ErrorChecker;

/**
 * Repeats the string to standard output or file where the string can overwrite or append to the
 * contents of the file
 */

public class Echo extends Command {

  /**
   * Runs the echo command, and returns the requested string
   * 
   * @return String - the string inputted is returned back
   */
  public String run() {
    String s = super.getRawUserInput();
    if (s.matches("\\s*(echo)\\s*")) {
      super.addNewError("Err: echo: check arguments");
      return null;
    }
    s = s.trim().substring(5).trim();
    if (ErrorChecker.checkValidString(s)) {
      return s.substring(1, s.length() - 1);
    } else
      return null;
  }
}
