class TestEverything extends Something {
  SomeClassType type;
  int i;
  int j;
  int k;
  boolean checked;
  boolean verified;
  boolean both;
  long counter;
  int[] input;

  TestEverything that;

  public int testExpressions() {
    both = checked && verified;
    both = j < k;
    i = j + k;
    i = j - k;
    i = j * k;
    i = j / k;
    input[1 + 2 * 3 - 4 / 5 * 6 + 7 - 8 * (9 + 10)] = 0;
    checked = true;
    checked = false;
    checked = both;
    that = this;
    that = new TestEverything();
    that = new TestEverything().something().another().length[10];
    input = new int[50 + this.length * 2];
    both = !checked && !(verified && !checked);

    type.get().length[1][2].put(a, b.get(), 3 * (c + 2));
    type.length.length.length.get(j)[i].get().length.get()[2];

    return 0;
  }

  public int testPrecedence() {
    n = (a + !b) * c + d / !!e && f + g < h + i / (j + !l);
    n = a.length[0].call() + b.get() * c.what(a, b + c.length);

    return 0;
  }

  public int testStatements() {
    {
      a = b;
      b = c;
      c = a;
    }

    {
      a = b;
      {
        b = c;
        { c = a; }
      }
    }

    if (a < b) {
      min = a;
    } else if (b < a) {
      min = b;
    } else {
      min = equal;
    }

    while (true && false) a = a + 1;

    while (1 < 2) {
      if (a < b) {
      } else {
        a = 1;
      }
    }

    a;
    a.length;
    a.length.get();
    a.get().length;

    a = 1;
    a[1] = 1 - 2 / 3;
    a[a[0]] = 1 + 2 * 3;

    return 0;
  }

  public static void main(String[] args) {
    int a;
    int b;
    SomeClass c;
    SomeClass[0] = true;
    n = 0 + 1;
  }
}
