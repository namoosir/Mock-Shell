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
import filesystem.Directory;
import interfaces.IFileSystem;

/**
 * Create new directory command
 */

public class MakeDirectory extends Command {

  /**
   * Helper for running mkdir
   * 
   * @param fileSystem current filesystem instance
   * @param startingDir current directory before starting mkdir operation (fallback purposes)
   */
  private void mkdirHelper(IFileSystem fileSystem, Directory startingDir) {
    for (String arg : this.getArgs()) {
      if (ErrorChecker.hasConsecutiveSlash(arg))
        return;

      if (arg.compareTo("/") == 0) {
        super.addNewError("Err: mkdir: root already exits");
        return;
      }

      String[] path = arg.split("/"); // /test -> [test]
      String name = path[path.length - 1]; // name of new dir will be the last item in a path
      // name = test
      Directory newDir = new Directory(name); // new dir object given name
      // get parent name from given path
      String parent = path.length > 1 ? arg.substring(0, arg.length() - name.length() - 1) : "";

      if (path.length == 2 && path[0].isEmpty() && arg.startsWith("/"))
        parent = "/";

      if (!fileSystem.goToPath(parent)) { // check if parent is valid in current filesystem
        super.addNewError("Err: mkdir: path does not exist");
        return;
      }

      if (!ErrorChecker.checkValidDirFileName(name))
        return;

      if (!(fileSystem.getCurrentDir().addChild(newDir))) {
        super.addNewError("Err: mkdir: that name is already taken");
        return;
      }

      fileSystem.setCurrentDir(startingDir);
    }
  }

  /**
   * This function provides the ability to execute the "mkdir" command
   * 
   * @return String null
   */
  public String run() {
    IFileSystem fileSystem = super.getFileSystem(); // singleton design
    Directory startingDir = fileSystem.getCurrentDir(); // keep track of starting dir
    this.mkdirHelper(fileSystem, startingDir);

    return null;
  }
}
