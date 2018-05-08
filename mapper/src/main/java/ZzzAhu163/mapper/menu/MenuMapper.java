package ZzzAhu163.mapper.menu;

import ZzzAhu163.BaseMapper;
import ZzzAhu163.base.menu.MenuItem;
import ZzzAhu163.base.menu.filter.MenuQueryFilter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Zzz_Ahu_163
 * **/
public interface MenuMapper extends BaseMapper {
    //query list count by filter
    int queryMenuItemListCountByFilter(MenuQueryFilter filter);

    //query List by filter
    List<MenuItem> queryMenuItemListByFilter(MenuQueryFilter filter);

    //insert menuItem
    int insertMenuItem(MenuItem menuItem);

    //delete menuItem by id
    int deleteMenuItemById(int id);

    //update menuItem
    int updateMenuItem(MenuItem menuItem);
}
