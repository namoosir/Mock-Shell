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
package interfaces;

import filesystem.Directory;

/**
 * Interface for filesystem
 *
 */
public interface IFileSystem {

  /**
   * Gets the root directory of the file system
   * 
   * @return Directory holding state of root directory
   */
  public Directory getRoot();

  /**
   * Gets the current working directory in the file system
   * 
   * @return Directory
   */
  public Directory getCurrentDir();

  /**
   * Sets the current working directory in the file system
   * 
   * @param dir new directory that needs to be set as the working directory
   */
  public void setCurrentDir(Directory dir);

  /**
   * Updates currentDir to a child of the current currentDir
   * 
   * @param reqChild string representing a name of a directory
   * @return boolean operation success
   */
  public boolean goToChildDirOfCurrentDir(String reqChild);

  /**
   * Set currentDir to the parent of the current currentDir
   * 
   * @return boolean operation success
   */
  public boolean goToParentOfCurrentDir();

  /**
   * Traverses to the given path, and sets the currentDir to the resulting directory
   * 
   * @param path String representing a path to traverse to
   * @return boolean operation success
   */
  public boolean goToPath(String path);

  /**
   * Returns the full path of the current working directory
   * 
   * @return String the full path of the current working directory
   */
  public String getPath();

  /**
   * Removes the current directory from the filesystem
   * 
   * @return boolean true upon successfull deletion and false otherwise
   */
  public boolean removeCurrentDirectory();
}
