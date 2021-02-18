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

import commands.PrintWorkingDirectory;
import mockobjects.MockFileSystem;


public class PrintWorkingDirectoryTest {

  private PrintWorkingDirectory pwd;
  private ArrayList<String> args;
  private MockFileSystem fs;

  @Before
  public void setUp() throws Exception {
    pwd = new PrintWorkingDirectory();
    args = new ArrayList<>();
    fs = new MockFileSystem(MockFileSystem.Environment.MOCK);
    pwd.setFileSystem(fs);
  }

  @Test
  public void testRoot() {
    pwd.setArgs(args);
    assertTrue(pwd.run().compareTo("/") == 0);
  }

  @Test
  public void testInDir() {
    pwd.setArgs(args);
    fs.goToChildDirOfCurrentDir("dir1");
    assertTrue(pwd.run().compareTo("/dir1") == 0);
  }

}
