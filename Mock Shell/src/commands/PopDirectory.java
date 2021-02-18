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

import interfaces.IFileSystem;
import interfaces.IDirStack;

/*
 * This class pops a directory path from stack class and moves current directory to poped directory
 * path
 *
 */

public class PopDirectory extends Command {
  /**
   * Stack containing directories 
   */
  private IDirStack stack;

  /**
   * Constructor for PopDirectory
   * @param stack - stack instance
   */
  public PopDirectory(IDirStack stack) {
    this.stack = stack;
  }

  /**
   * Runs the command PopDirectory
   * 
   * @return String - null
   */

  public String run() {

    // set path to eventually take value of path poped form stack
    String toCD;

    try {
      toCD = stack.popStack();

      // get instance of filesystem
      IFileSystem fileSystem = super.getFileSystem();
      fileSystem.goToPath(toCD);

    } catch (Exception EmptyStackException) {
      // super.output("Err: popd: empty stack");
      super.addNewError("Err: popd: empty stack");
    }
    return null;
  }


}
