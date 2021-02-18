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
package helpers;

/**
 * Class allows the creation of immutable pairs, in the form of (object, object)
 * 
 * @param <S> Type of first object in pair
 * @param <T> Type of second object in pair
 */
public class Pair<S, T> {
  /**
   * First item in pair
   */
  public final S first;
  /**
   * Second item in pair
   */
  public final T second;

  /**
   * Constructor for creating pair, values cannot be changed after creation
   * 
   * @param first - first object in pair, i.e pair.first
   * @param second - second object in pair, i.e. pair.second
   */
  public Pair(S first, T second) {
    this.first = first;
    this.second = second;
  }

}
