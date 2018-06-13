package util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

public class Util {
  public static ImmutableList<Object> createList(String ... data) {
    Builder<Object> dataList = ImmutableList.builder();
    for (String dat : data) {
      dataList.add(dat);
    }
    return dataList.build().asList();
  }
}
