package ZzzAhu163.service;

import ZzzAhu163.AbstractTest;
import ZzzAhu163.base.ContactGroup.ContactGroup;
import ZzzAhu163.base.ContactGroup.EntityContactGroup;
import ZzzAhu163.base.ContactGroup.EntityType;
import ZzzAhu163.base.ContactGroup.UserListType;
import ZzzAhu163.base.ContactGroup.filter.EntityContactGroupQueryFilter;
import ZzzAhu163.base.user.User;
import ZzzAhu163.service.ContactGroup.EntityContactGroupService;
import ZzzAhu163.service.user.UserService;
import ZzzAhu163.utils.CommonUtils.SharedStringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import javax.annotation.Resource;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Slf4j
public class EntityContactGroupTest extends AbstractTest {
    @Resource
    private EntityContactGroupService entityContactGroupService;
    @Resource
    private UserService userService;

    @Test
    public void insertTest() {
        EntityContactGroup entityContactGroup = new EntityContactGroup();
        entityContactGroup.setId(1);
        entityContactGroup.setEntityType(EntityType.WORK_ORDER);

        ContactGroup contactGroup = new ContactGroup();
        contactGroup.setName(SharedStringUtil.getRandomString());
        contactGroup.setDescription("第一个工单联系人组");
        User user = userService.queryUserByName("赵子彰");
        contactGroup.addUserToList(UserListType.TO_LIST, user);
        contactGroup.addUserToList(UserListType.CC_LIST, user);
        contactGroup.addUserToList(UserListType.BCC_LIST, user);

        entityContactGroup.setContactGroup(contactGroup);
        boolean result = entityContactGroupService.insertEntityContactGroup(entityContactGroup);
        log.info("插入结果：{}", result);
    }

    @Test
    public void queryTest() {
        List<EntityContactGroup> list =
                entityContactGroupService.queryEntityContactGroupList(new EntityContactGroupQueryFilter(1, EntityType.WORK_ORDER));
        if (CollectionUtils.isEmpty(list)) {
            log.info("查询无果");
        } else {
            log.info("结果条数：{} 联系人组 : {}", list.size(), list.get(0).getContactGroup().formatForLog());
        }
    }

    @Test
    public void deleteTest() {
        boolean result = entityContactGroupService.deleteEntityContactGroup(1, EntityType.WORK_ORDER);
        log.info("删除结果 : {}", result);
    }

    @Test
    public void updateTest() {
        List<EntityContactGroup> list = entityContactGroupService.queryEntityContactGroupList(
                new EntityContactGroupQueryFilter(1, EntityType.WORK_ORDER)
        );
        EntityContactGroup contactGroup = list.get(0);
        User user = userService.queryUserByName("赵子彰1");
        contactGroup.addUserToList(UserListType.TO_LIST, user);
        boolean result = entityContactGroupService.updateEntityContactGroup(contactGroup);
        log.info("更新结果：{}", result);
    }
}
