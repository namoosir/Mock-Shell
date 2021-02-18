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
import commands.ListDirectory;
import error.StandardError;
import mockobjects.MockFileSystem;

public class ListDirectoryTest {
  public MockFileSystem fs;
  private ListDirectory ls;
  private ArrayList<String> args;

  @Before
  public void setUp() throws Exception {
    fs = new MockFileSystem(MockFileSystem.Environment.MOCK);
    ls = new ListDirectory();
    StandardError.allErrors = new ArrayList<String>();
    args = new ArrayList<String>();
  }

  @Test
  public void noParam() {
    ls.setFileSystem(fs);
    ls.setArgs(args);
    String expect = "/:\ndir1\ndir2\nroot_file1\ndir3\n";
    assertEquals(expect, ls.run());
  }

  @Test
  public void relPath() {
    ls.setFileSystem(fs);
    args.add("dir2");
    ls.setArgs(args);
    String expect = "dir2:\ndir4\n";
    assertEquals(expect, ls.run());
  }

  @Test
  public void relFile() {
    ls.setFileSystem(fs);
    args.add("dir1/file2");
    ls.setArgs(args);
    String expect = "dir1/file2\n";
    assertEquals(expect, ls.run());
  }

  @Test
  public void multiErrPath() {
    ls.setFileSystem(fs);
    args.add("dir2");
    args.add("dir3");
    args.add("\\Invalid");
    args.add("dir3");
    ls.setArgs(args);
    String expect = "dir2:\ndir4\n\ndir3:\n";
    ls.run();
    assertEquals(expect, ls.run());
  }

  @Test
  public void recurs() {
    ls.setFileSystem(fs);
    args.add("-R");
    ls.setArgs(args);
    String expect = "/:\ndir1:\n     file2\ndir2:\n     dir4:\nroot_file1\ndir3:\n";
    assertEquals(expect, ls.run());
  }

  @Test
  public void recursParam() {
    ls.setFileSystem(fs);
    args.add("-R");
    args.add("dir2");
    ls.setArgs(args);
    String expect = "dir2:\ndir4:\n";
    assertEquals(expect, ls.run());
  }

  @Test
  public void multiErrRecurs() {
    ls.setFileSystem(fs);
    args.add("-R");
    args.add("dir2");
    args.add("/");
    args.add("Invalid");
    args.add("dir2");
    ls.setArgs(args);
    String expect = "dir2:\ndir4:\n\n/:\ndir1:\n     file2\ndir2:\n     dir4:\nroot_file1\ndir3:\n";
    assertEquals(expect, ls.run());
  }

}
