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
package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import filesystem.Directory;
import filesystem.File;
import filesystem.Node;

public class DirectoryTest {

  Directory testDir;
  Directory childDir;
  File childFile;

  @Before
  public void setUp() throws Exception {
    childDir = new Directory("childDir");
    childFile = new File("childFile");
    testDir = new Directory("parent");
    testDir.addChild(childFile);
    testDir.addChild(childDir);
  }

  @Test
  public void testAddChild() {
    Directory newDir = new Directory("newDir");
    Directory newChild = new Directory("newChild");
    File newChild2 = new File("newFile");

    assertTrue(newDir.addChild(newChild));
    assertTrue(newDir.addChild(newChild2));

    assertEquals(2, newDir.getChildren().size());
  }

  @Test
  public void testHasChildAlreadyExists() {
    Node testNode = testDir.getChildren().get(0);

    assertTrue(testDir.hasChild(testNode));
  }

  @Test
  public void testHasChildDoesNotExist() {
    Directory invalidChild = new Directory("invalid");

    assertFalse(testDir.hasChild(invalidChild));
  }

  @Test
  public void testHasChildAlreadyExistsWithStringParameter() {
    assertTrue(testDir.hasChild("childDir"));
  }

  @Test
  public void testHasChildDoesNotExistWithStringParameter() {
    assertFalse(testDir.hasChild("invalid"));
  }

  @Test
  public void testGetChildFileByNameValidChild() {
    assertEquals(childFile, testDir.getFileChildByName("childFile"));
  }

  @Test
  public void testGetChildFileByNameInvalidChild() {
    assertEquals(null, testDir.getFileChildByName("invalidFile"));
  }

  @Test
  public void testGetChildDirByNameValidChild() {
    assertEquals(childDir, testDir.getDirChildByName("childDir"));
  }

  @Test
  public void testGetChildDirByNameInvalidChild() {
    assertEquals(null, testDir.getDirChildByName("invalidDir"));
  }
}
