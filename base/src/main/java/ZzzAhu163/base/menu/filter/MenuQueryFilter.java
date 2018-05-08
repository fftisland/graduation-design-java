package ZzzAhu163.base.menu.filter;

import ZzzAhu163.base.baseObject.BaseQueryFilter;
import ZzzAhu163.base.menu.Menu;
import ZzzAhu163.base.menu.MenuItem;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Zzz_Ahu_163
 * **/
@Data
public class MenuQueryFilter extends BaseQueryFilter{
    //主要过滤条件是MenuItem
    private MenuItem menuItem;

    public MenuQueryFilter() {
        super();
    }

    public MenuQueryFilter(int id) {
        if (menuItem == null) {
            menuItem = new MenuItem(id);
        }
    }

    public MenuQueryFilter(MenuItem menuItem) {
        super();
        this.menuItem = menuItem;
    }

    public void reset() {
        super.reset();
        this.menuItem = null;
    }
}
