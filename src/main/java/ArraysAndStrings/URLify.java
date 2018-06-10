package ArraysAndStrings;

import com.google.common.collect.ImmutableList;
import com.sun.deploy.util.StringUtils;
import java.util.List;
import java.util.Objects;

/**
 * The goal is to write a method to replace all spaces with %20
 */
public class URLify {
  public static void main(String[] args) {

    List<String> testData = ImmutableList.of(
        "this is a string with spaces",
        "nospaces",
        "my-name-is ryan",
        "space one",
        "nospace",
        ""
    );

    testData
        .stream()
        .map(URLify::URLify)
        .forEach(System.out::println);
  }

  /** Remove spaces */
  public static String URLify(String url) {
    if (url.equals(null) || url.equals("")) {
      return null;
    }
    return url.replace(" ", "%20");
  }
}
