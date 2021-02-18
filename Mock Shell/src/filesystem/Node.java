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
package filesystem;

import java.io.Serializable;

/**
 * Parent class of the File and Directory class
 */
public class Node implements Serializable {
  /**
   * Needed for serialization
   */
  private static final long serialVersionUID = 1661371888708561021L;
  /**
   * Stores the name of the Node
   */
  private String name;
  /**
   * Stores the parent directory of the node
   */
  private Directory parent;

  /**
   * Gets the parent of the node
   * 
   * @return Directory Parent directory of node
   */
  public Directory getParent() {
    return parent;
  }

  /**
   * Sets the parent of the node
   * 
   * @param parent New parent of node
   */
  public void setParent(Directory parent) {
    this.parent = parent;
  }

  /**
   * Gets the name of the node
   * 
   * @return String name of the node
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the node
   * 
   * @param name new name of the node
   */
  public void setName(String name) {
    this.name = name;
  }
}
