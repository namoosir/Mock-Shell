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

/**
 * Allows a user to create files, set content and also inherits from the Node class.
 */
public class File extends Node {
  /**
   * Required for serialization 
   */
  private static final long serialVersionUID = -3815874957464904274L;
  /**
   * String representing the contents of a file
   */
  private String contents;

  /**
   * Constructor for file object
   * 
   * @param name of the file
   */
  public File(String name) {
    this.setName(name);
  }

  /**
   * Getter for contents of file
   * 
   * @return String Current state of the contents of the string
   */
  public String getContents() {
    return contents;
  }

  /**
   * Setter for the contents of file
   * 
   * @param contents new contents of file
   */
  public void setContents(String contents) {
    this.contents = contents;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((contents == null) ? 0 : contents.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    File other = (File) obj;
    if (contents == null) {
      if (other.contents != null)
        return false;
    } else if (!contents.equals(other.contents))
      return false;
    return true;
  }
}
