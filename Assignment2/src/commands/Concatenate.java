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

import filesystem.*;
import interfaces.IFileSystem;

/**
 * This class is for the cat command which outputs the contents of a list of files
 */
public class Concatenate extends Command {

  /**
   * Executes the cat command
   * 
   * @return concatenated contents of a list of files to the user
   */
  public String run() {
    IFileSystem fileSystem = super.getFileSystem();
    Directory startingDir = fileSystem.getCurrentDir();
    String output = "";
    int test = 0;
    for (String arg : this.getArgs()) {
      if (arg.compareTo("/") == 0) {
        super.addNewError("Err: cat: / is not a file");
        continue;
      }
      String[] path = arg.split("/");
      String fileName = path[path.length - 1];
      String parent = path.length > 1 ? arg.substring(0, arg.length() - fileName.length() - 1) : "";
      if (path.length == 2 && path[0].isEmpty() && arg.startsWith("/"))
        parent = "/";
      if (!fileSystem.goToPath(parent)) { // check if parent is valid in current filesystem
        super.addNewError("Err: cat: directory path does not exist");
        continue;
      }
      Directory curr = fileSystem.getCurrentDir();
      File outputFile = curr.getFileChildByName(fileName);
      fileSystem.setCurrentDir(startingDir);
      if (outputFile != null) {
        if (test == 1)
          output += "\n\n\n";
        else
          test = 1;
        output += outputFile.getContents();
      } else {
        super.addNewError("Err: cat: file " + arg + " does not exist");
        if (test != 0)
          return output;
        return null;
      }
    }
    return output;
  }
}
