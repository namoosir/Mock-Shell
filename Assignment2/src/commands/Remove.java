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
 * Removes directory given from the filesystem
 */
public class Remove extends Command {

  /**
   * Runs the rm command
   * 
   * @return String null
   */
  public String run() {
    if (super.getArgs().get(0).equals("/")) {
      super.addNewError("Err: rm: cannot remove '/'");
      return null;
    }

    IFileSystem currFileSystem = super.getFileSystem();
    String currentPath = currFileSystem.getPath();

    if (!currFileSystem.goToPath(super.getArgs().get(0))) {
      super.addNewError("Err: rm: argument must be an existing directory");
      return null;
    }
    currFileSystem = super.getFileSystem();
    String newPath = currFileSystem.getPath();

    if (currentPath.contains(newPath)) {
      super.addNewError("Err: rm: cannot delete a parent directory or current directory");
      return null;
    }

    if (!currFileSystem.removeCurrentDirectory()) {
      super.addNewError("Err: rm: failed to delete " + super.getArgs().get(0));
      return null;
    }

    currFileSystem.goToPath(currentPath);
    return null;
  }
}
