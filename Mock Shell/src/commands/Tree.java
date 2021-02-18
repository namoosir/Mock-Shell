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
import filesystem.*;
import interfaces.IFileSystem;

/**
 * Provides the ability to perform the "tree" command
 */
public class Tree extends Command {

  /**
   * Runs the tree command
   * @return String - tree visualization of filesystem
   */
  public String run() {

    String output = "";
    IFileSystem fileSystem = super.getFileSystem();
    Directory root = fileSystem.getRoot();
    output = getOutput(root, 1, output);
    return output;

  }

  /**
   * Gets the string representation of the tree
   * 
   * @param dir - current dir
   * @param depth - number of recursive calls
   * @param output - string to be returned
   * @return String - tree visualization of filesystem
   */
  public String getOutput(Directory dir, int depth, String output) {
    ArrayList<Node> children = dir.getChildren();
    output += ("     ".repeat(Math.max(depth - 1, 0)) + dir.getName() + "\n");

    for (Node child : children) {
      if (child.getClass() == File.class) {
        output += ("     ".repeat(depth) + child.getName() + "\n");
      } else {
        output = getOutput((Directory) child, depth + 1, output);
      }
    }
    return output;
  }

}
