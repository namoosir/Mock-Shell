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

import java.util.ArrayList;
import interfaces.IFileSystem;
import interfaces.IDirStack;

/*
 * This class adds current directory to a stack then changes working directory to specified path
 *
 */

public class PushDirectory extends Command {
  /**
   * Stack containing directories 
   */
  private IDirStack stack;

  /**
   * Constructor for PushDirectory
   * 
   * @param stack - the instance of stack
   */

  public PushDirectory(IDirStack stack) {
    this.stack = stack;
  }

  /**
   * Runs the command PushDirectory
   * 
   * @return output - output string
   */

  public String run() {
    // Creates a list to hold arguments for the command
    ArrayList<String> args = super.getArgs();


    // Create instance of Filesystem
    IFileSystem fileSystem = super.getFileSystem();
    if (args.size() > 1) {
      super.addNewError("Err: too many args");
      return null;
    }

    // Path of the that filesytem sets to
    String Path = args.get(0);

    // Get full path name of the current directory
    String curPath = fileSystem.getPath();

    if (fileSystem.goToPath(Path) == false) {
      super.addNewError("Err: pushd: Invalid Path");
      // super.output("Err: pushd: no such directory");
    } else {

      // Get instance of stack to push current directory to
      stack.pushOnStack(curPath);
    }

    return null;


  }
}
