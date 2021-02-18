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

import commands.MakeDirectory;
import filesystem.Directory;
import mockobjects.MockFileSystem;

public class MakeDirectoryTest {
  MockFileSystem fs;
  MockFileSystem fs2;
  MakeDirectory mkdir;
  ArrayList<String> args;

  @Before
  public void setUp() throws Exception {
    fs = new MockFileSystem(MockFileSystem.Environment.MOCK);
    fs2 = new MockFileSystem(MockFileSystem.Environment.MOCK);
    mkdir = new MakeDirectory();
    args = new ArrayList<>();
    mkdir.setFileSystem(fs);
  }

  @Test
  public void testOneDirRun() {
    args.add("a");
    mkdir.setArgs(args);
    fs2.getCurrentDir().addChild(new Directory("a"));

    assertEquals(mkdir.run(), null);
    assertEquals(fs, fs2);
  }

  @Test
  public void testRoot() {
    args.add("/");
    mkdir.setArgs(args);

    assertEquals(mkdir.run(), null);
    assertEquals(fs, fs2);
  }

  @Test
  public void testMultipleDirectories() {
    args.add("a");
    args.add("b");
    mkdir.setArgs(args);
    fs2.getCurrentDir().addChild(new Directory("a"));
    fs2.getCurrentDir().addChild(new Directory("b"));

    assertEquals(mkdir.run(), null);
    assertEquals(fs, fs2);
  }

  /*
   * @Test public void testFurtherPath() { args.add("a"); args.add("a/b"); mkdir.setArgs(args);
   * fs2.getCurrentDir().addChild(new Directory("a")); fs2.goToChildDirOfCurrentDir("a");
   * fs2.getCurrentDir().addChild(new Directory("b")); fs2.goToParentOfCurrentDir();
   * 
   * assertEquals(mkdir.run(), null); assertEquals(fs, fs2); }
   */

  @Test
  public void testFurtherPath() {
    args.add("dir1/a");
    mkdir.setArgs(args);

    assertEquals(mkdir.run(), null);
    assertTrue(fs.goToPath("dir1/a"));
  }

}
