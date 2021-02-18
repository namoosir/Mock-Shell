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

/**
 * Allows traversing to an exiting directory in the filesystem
 */
public class ChangeDirectory extends Command {

  /**
   * This function provides the ability to execute the "cd" command
   * 
   * @return String - any user output
   */
  public String run() {
    IFileSystem fileSystem = super.getFileSystem();

    boolean res = fileSystem.goToPath(super.getArgs().get(0));

    if (!res)
      super.addNewError("Err: cd: path does not exist");

    return null;
  }
}
