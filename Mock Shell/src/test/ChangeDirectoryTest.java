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
import commands.ChangeDirectory;
import error.StandardError;
import filesystem.Directory;
import mockobjects.MockFileSystem;

public class ChangeDirectoryTest {

  public MockFileSystem fs;
  private ChangeDirectory cd;
  private ArrayList<String> args;

  @Before
  public void setUp() throws Exception {
    fs = new MockFileSystem(MockFileSystem.Environment.MOCK);
    cd = new ChangeDirectory();
    StandardError.allErrors = new ArrayList<String>();
    args = new ArrayList<String>();
  }

  @Test
  public void testWithInvalidPath() {
    Directory startingDir = fs.getCurrentDir();

    args.add("invalid/path");
    cd.setFileSystem(fs);
    cd.setArgs(args);
    cd.run();

    assertEquals(startingDir, fs.getCurrentDir());
  }

  @Test
  public void testCdRootFromRoot() {
    args.add("/");
    cd.setFileSystem(fs);
    cd.setArgs(args);
    cd.run();

    assertEquals(fs.getRoot(), fs.getCurrentDir());
  }

  @Test
  public void testFullPath() {
    args.add("/dir2/dir4");
    cd.setFileSystem(fs);
    cd.setArgs(args);
    cd.run();

    assertEquals(fs.dir4, fs.getCurrentDir());
  }

  @Test
  public void testRelativePath() {
    args.add("dir1");
    cd.setFileSystem(fs);
    cd.setArgs(args);
    cd.run();

    assertEquals(fs.dir1, fs.getCurrentDir());
  }

  @Test
  public void testParentDirShorthand() {
    args.add("/dir2/dir4/../..");
    cd.setFileSystem(fs);
    cd.setArgs(args);
    cd.run();

    assertEquals(fs.getRoot(), fs.getCurrentDir());
  }

  @Test
  public void testCurrentDirShorthand() {
    args.add("/dir2/dir4/./.");
    cd.setFileSystem(fs);
    cd.setArgs(args);
    cd.run();

    assertEquals(fs.dir4, fs.getCurrentDir());
  }
}
