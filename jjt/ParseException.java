/* Generated By:JavaCC: Do not edit this line. ParseException.java Version 5.0 */
/* JavaCCOptions:KEEP_LINE_COL=null */

import java.io.BufferedReader;
import java.util.stream.IntStream;
import java.io.FileReader;
import java.io.IOException;

public class ParseException extends Exception {
  /**
   * The version identifier for this Serializable class.
   * Increment only if the <i>serialized</i> form of the
   * class changes.
   */
  private static final long serialVersionUID = 1L;

  /**
   * This constructor is used by the method "generateParseException"
   * in the generated parser.  Calling this constructor generates
   * a new object of this type with the fields "currentToken",
   * "expectedTokenSequences", and "tokenImage" set.
   */
  public ParseException(Token currentTokenVal, int[][] expectedTokenSequencesVal,
                        String[] tokenImageVal) {
    super(initialise(currentTokenVal, expectedTokenSequencesVal, tokenImageVal));
    currentToken = currentTokenVal;
    expectedTokenSequences = expectedTokenSequencesVal;
    tokenImage = tokenImageVal;
  }

  /**
   * The following constructors are for use by you for whatever
   * purpose you can think of.  Constructing the exception in this
   * manner makes the exception behave in the normal way - i.e., as
   * documented in the class "Throwable".  The fields "errorToken",
   * "expectedTokenSequences", and "tokenImage" do not contain
   * relevant information.  The JavaCC generated code does not use
   * these constructors.
   */

  public ParseException() {
    super();
  }

  /** Constructor with message. */
  public ParseException(String message) {
    super(message);
  }

  /**
   * This is the last token that has been consumed successfully.  If
   * this object has been created due to a parse error, the token
   * followng this token will (therefore) be the first error token.
   */
  public Token currentToken;

  /**
   * Each entry in this array is an array of integers.  Each array
   * of integers represents a sequence of tokens (by their ordinal
   * values) that is expected at this point of the parse.
   */
  public int[][] expectedTokenSequences;

  /**
   * This is a reference to the "tokenImage" array of the generated
   * parser within which the parse error occurred.  This array is
   * defined in the generated ...Constants interface.
   */
  public String[] tokenImage;

  /**
   * It uses "currentToken" and "expectedTokenSequences" to generate a parse
   * error message and returns it.  If this object has been created
   * due to a parse error, and you do not catch it (it gets thrown
   * from the parser) the correct error message gets displayed.
   */
  public static String file;

  private static String initialise(Token currentToken, int[][] expectedTokenSequences,
                                   String[] tokenImage) {
    String eol = System.getProperty("line.separator", "\n");
    StringBuffer expected = new StringBuffer();
    int maxSize = 0;
    for (int i = 0; i < expectedTokenSequences.length; i++) {
      if (maxSize < expectedTokenSequences[i].length) {
        maxSize = expectedTokenSequences[i].length;
      }
      for (int j = 0; j < expectedTokenSequences[i].length; j++) {
        expected.append(tokenImage[expectedTokenSequences[i][j]]);
      }
      if (i != expectedTokenSequences.length - 1) expected.append(", ");
    }

    Token tok = currentToken.next;
    String retval = file + ": at line " + currentToken.next.beginLine + ", column "
                    + currentToken.next.beginColumn + "." + eol + "\t Syntactic error: ";

    try {
      String line = "";
      int lineNo = 1;
      FileReader fr = new FileReader(ParseException.file);
      BufferedReader br = new BufferedReader(fr);
      while ((line = br.readLine()) != null) {
        if (lineNo == currentToken.next.beginLine) {
          retval += line;
          break;
        } else
          lineNo++;
      }
    } catch (IOException e) {
    }

    retval += "    Found: ";
    for (int i = 0; i < maxSize; i++) {
      if (i != 0) retval += " ";
      if (tok.kind == 0) {
        retval += tokenImage[0];
        break;
      }
      retval += "\"";
      retval += add_escapes(tok.image);
      retval += "\"";
      tok = tok.next;
    }
    retval += "." + eol + "\t";

    String offset=" Syntactic error: ";//without \t
    for (int i = 0; i < offset.length() + currentToken.next.beginColumn - 1; i++) {
      retval += " ";
    }
    retval += "^" + eol;

    if (expectedTokenSequences.length == 1) {
      retval += "\t Was expecting:" + eol;
    } else {
      retval += "\t Was expecting one of:" + eol;
    }
    retval += "\t " + expected.toString();
    return retval + eol;
  }

  /**
   * The end of line string for this machine.
   */
  protected String eol = System.getProperty("line.separator", "\n");

  /**
   * Used to convert raw characters to their escaped version
   * when these raw version cannot be used as part of an ASCII
   * string literal.
   */
  static String add_escapes(String str) {
    StringBuffer retval = new StringBuffer();
    char ch;
    for (int i = 0; i < str.length(); i++) {
      switch (str.charAt(i)) {
      case 0:
        continue;
      case '\b':
        retval.append("\\b");
        continue;
      case '\t':
        retval.append("\\t");
        continue;
      case '\n':
        retval.append("\\n");
        continue;
      case '\f':
        retval.append("\\f");
        continue;
      case '\r':
        retval.append("\\r");
        continue;
      case '\"':
        retval.append("\\\"");
        continue;
      case '\'':
        retval.append("\\\'");
        continue;
      case '\\':
        retval.append("\\\\");
        continue;
      default:
        if ((ch = str.charAt(i)) < 0x20 || ch > 0x7e) {
          String s = "0000" + Integer.toString(ch, 16);
          retval.append("\\u" + s.substring(s.length() - 4, s.length()));
        } else {
          retval.append(ch);
        }
        continue;
      }
    }
    return retval.toString();
  }

  // Debugging
  private static boolean ECHO_TOKENS = false;
  private boolean explained = false;

  private void printToken(Token t) {
    if (!ECHO_TOKENS) return;
    if (t == null)
      System.out.printf("Token null\n");
    else if (t.next == null)
      System.out.printf("Token %s %d:%d null\n", tokenImage[t.kind], t.beginLine, t.beginColumn);
    else
      System.out.printf("Token %s %d:%d - %s %d:%d\n", tokenImage[t.kind], t.beginLine,
                        t.beginColumn, tokenImage[t.next.kind], t.next.beginLine,
                        t.next.beginColumn);
  }

  private void printToken(int i, Token t) {
    if (!ECHO_TOKENS) return;
    if (t == null)
      System.out.printf("Token null\n");
    else if (t.next == null)
      System.out.printf("Token#%d %s %d:%d null\n", i, tokenImage[t.kind], t.beginLine,
                        t.beginColumn);
    else
      System.out.printf("Token#%d %s %d:%d - %s %d:%d\n", i, tokenImage[t.kind], t.beginLine,
                        t.beginColumn, tokenImage[t.next.kind], t.next.beginLine,
                        t.next.beginColumn);
  }

  // A fix for the implementation of jmm.getNextToken()
  // it does: A1 null -> A2 null  OR  A1 A2 -> A2 null
  // what we want: A1 null -> A2 A3  OR  A1 A2 -> A2 A3
  private Token jmmSkip() {
    Token a2 = jmm.getNextToken();
    Token a3 = jmm.getNextToken();
    a2.next = a3;
    jmm.token = a2;
    return a2;
  }

  public ParseException skipto(int kind) {
    explain();
    int count = 0;
    while (currentToken.next.kind != kind) {
      printToken(count++, currentToken);
      currentToken = jmmSkip();
    }
    printToken(100, currentToken);
    return this;
  }

  public ParseException skipto(int[] kinds) {
    explain();
    int count = 0;
    while (!IntStream.of(kinds).anyMatch(x -> x == currentToken.next.kind)) {
      printToken(count++, currentToken);
      currentToken = jmmSkip();
    }
    printToken(200, currentToken);
    return this;
  }

  public ParseException skipn(int n) {
    explain();
    int count = 0;
    while (count < n) {
      printToken(count++, currentToken);
      currentToken = jmmSkip();
    }
    printToken(300, currentToken);
    return this;
  }

  public ParseException skip(int n, int kind) {
    explain();
    int count = 0;
    while (count < n && currentToken.next.kind != kind) {
      printToken(count++, currentToken);
      currentToken = jmmSkip();
    }
    printToken(400, currentToken);
    return this;
  }

  public ParseException skip(int n, int[] kinds) {
    explain();
    int count = 0;
    while (count < n && !IntStream.of(kinds).anyMatch(x -> x == currentToken.next.kind)) {
      printToken(count++, currentToken);
      currentToken = jmmSkip();
    }
    printToken(500, currentToken);
    return this;
  }

  public ParseException skiptoif(int is, int kind) {
    if (currentToken.next.kind == is) skipto(kind);
    return this;
  }

  public ParseException skiptoif(int is, int[] kinds) {
    if (currentToken.next.kind == is) skipto(kinds);
    return this;
  }

  public ParseException skipnif(int is, int n) {
    if (currentToken.next.kind == is) skipn(n);
    return this;
  }

  public ParseException skipif(int is, int n, int kind) {
    if (currentToken.next.kind == is) skip(n, kind);
    return this;
  }

  public ParseException skipif(int is, int n, int[] kinds) {
    if (currentToken.next.kind == is) skip(n, kinds);
    return this;
  }

  public ParseException advance() {
    return skipn(0);
  }

  public ParseException consume() {
    return skipn(1);
  }

  public ParseException consumeif(int is) {
    return skipnif(is, 1);
  }

  public void explain() {
    if (!explained) {
      System.err.println(toString());
    }
    explained = true;
    jmm.has_error = true;
    // handle number of recoveries here
    // if (too many recoveries) throw this;
  }

  @Override
  public String toString() {
    return initialise(currentToken, expectedTokenSequences, tokenImage);
  }
}
/* JavaCC - OriginalChecksum=c5a983a229aa877dc2b3b3b9933cdd6b (do not edit this line) */
