package ZzzAhu163.base.baseObject;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author ZzzAhu163
 *查询后台的基本过滤条件
 **/
@Data
@Alias("BaseQueryFilter")
public class BaseQueryFilter {
  private int id;

  private String name;

  private String description;

  //keyWords表name和description都进行模糊查询
  private String keyWords;

  private long startTime;

  private long endTime;

  private int currentPage;

  private int pageSize;

  private int offSet;

  private int total;

  public BaseQueryFilter() {
    reset();
  }

  public BaseQueryFilter(int id) {
    reset();
    this.id = id;
  }

  public void reset() {
    this.id = 0;
    this.name = null;
    this.description = null;
    this.keyWords = null;
    this.startTime = 0;
    this.endTime = 0;
    this.currentPage = 1;
    this.pageSize = 12;
    this.offSet = 0;
    this.total = 0;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public void setTotal() {
    this.total = total;
    adjustPageQueryInfo();
  }

  private void adjustPageQueryInfo() {
    if (pageSize <= 0) {
      pageSize = 12;
    }
    int tempCurPage = Math.round(1.0f * (total + pageSize - 1) / pageSize);
    if (currentPage > tempCurPage) {
      currentPage = tempCurPage;
    }
    if (currentPage <= 0) {
      currentPage = 1;
    }
    calculateOffSet();
  }

  //计算查询偏移量
  private void calculateOffSet() {
    offSet = pageSize * (currentPage - 1);
  }

  //unix_timeStamp(DATETIME)是转化为秒级时间戳
  public void setStartTime(long startTime) {
    if (startTime > 1999999999) {
      startTime /= 1000;
    }
    this.startTime = startTime;
  }

  public void setEndTime(long endTime) {
    if (endTime > 1999999999) {
      endTime /= 1000;
    }
    this.endTime = endTime;
  }
}
