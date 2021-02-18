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
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import commands.Copy;
import error.StandardError;
import filesystem.Directory;
import filesystem.File;
import mockobjects.MockFileSystem;



public class CopyTest {

  public MockFileSystem fs;
  public MockFileSystem fsExpected;
  private Copy cp;
  private ArrayList<String> args;

  @Before
  public void setUp() throws Exception {
    fs = new MockFileSystem(MockFileSystem.Environment.MOCK);
    fsExpected = new MockFileSystem(MockFileSystem.Environment.MOCK);
    cp = new Copy();
    cp.setFileSystem(fs);
    StandardError.allErrors = new ArrayList<String>();
    args = new ArrayList<String>();
  }

  @Test
  public void testWithInvalidPath() {

    args.add("invalid/path");
    args.add("invalid/path2");
    cp.setFileSystem(fs);
    cp.setArgs(args);
    cp.run();

    assertEquals(fsExpected, fs);
  }

  @Test
  public void testEmptyDir() {
    Directory dirToBeAdded = new Directory("dir3");
    fsExpected.goToChildDirOfCurrentDir("dir1");
    fsExpected.getCurrentDir().addChild(dirToBeAdded);
    fsExpected.goToPath("/");

    args.add("dir3");
    args.add("dir1");
    cp.setFileSystem(fs);
    cp.setArgs(args);
    cp.run();

    assertEquals(fsExpected, fs);
  }

  @Test
  public void testNonEmptyDir() {
    Directory dirToBeAdded = new Directory("dir1");
    File fileToBeAdded = new File("file2");
    fileToBeAdded.setContents("MOCK: file2 contents");
    dirToBeAdded.addChild(fileToBeAdded);
    fsExpected.goToChildDirOfCurrentDir("dir2");
    fsExpected.getCurrentDir().addChild(dirToBeAdded);
    fsExpected.goToPath("/");

    args.add("dir1");
    args.add("dir2");
    cp.setFileSystem(fs);
    cp.setArgs(args);
    cp.run();

    assertEquals(fsExpected, fs);
  }

  @Test
  public void testNonEmptyDirFullPath() {
    Directory dirToBeAdded = new Directory("dir1");
    File fileToBeAdded = new File("file2");
    fileToBeAdded.setContents("MOCK: file2 contents");
    dirToBeAdded.addChild(fileToBeAdded);
    fsExpected.goToChildDirOfCurrentDir("dir2");
    fsExpected.getCurrentDir().addChild(dirToBeAdded);
    fsExpected.goToPath("/");

    fs.goToChildDirOfCurrentDir("dir1");
    args.add(".");
    args.add("../dir2");
    cp.setFileSystem(fs);
    cp.setArgs(args);
    cp.run();
    fs.goToPath("/");

    assertEquals(fsExpected, fs);
  }

  @Test
  public void testFileToDir() {
    File fileToBeAdded = new File("file2");
    fileToBeAdded.setContents("MOCK: file2 contents");
    fsExpected.goToChildDirOfCurrentDir("dir2");
    fsExpected.getCurrentDir().addChild(fileToBeAdded);
    fsExpected.goToPath("/");

    args.add("dir1/file2");
    args.add("dir2");
    cp.setFileSystem(fs);
    cp.setArgs(args);
    cp.run();
    fs.goToPath("/");

    assertEquals(fsExpected, fs);
  }

  @Test
  public void testOverwriteFile() {
    File fileToBeAdded = new File("file2");
    fileToBeAdded.setContents("MOCK: new file2 contents");
    File fileToBeAdded2 = new File("file2");
    fileToBeAdded2.setContents("MOCK: new file2 contents");

    fsExpected.getCurrentDir().addChild(fileToBeAdded);
    fsExpected.goToPath("/");
    fsExpected.goToChildDirOfCurrentDir("dir1");
    fsExpected.getCurrentDir().getFileChildByName("file2").setContents("MOCK: new file2 contents");
    fsExpected.goToPath("/");

    fs.getCurrentDir().addChild(fileToBeAdded2);
    fs.goToPath("/");

    args.add("file2");
    args.add("dir1");
    cp.setFileSystem(fs);
    cp.setArgs(args);
    cp.run();

    assertEquals(fsExpected, fs);
  }

  @Test
  public void testParenttoChild() {

    args.add("dir2/dir4");
    args.add("dir2");
    cp.setFileSystem(fs);
    cp.setArgs(args);
    cp.run();

    assertEquals(fsExpected, fs);
  }

  @Test
  public void testParenttoChild2() {

    args.add("/");
    args.add("dir1");
    cp.setFileSystem(fs);
    cp.setArgs(args);
    cp.run();

    assertEquals(fsExpected, fs);
  }

}
