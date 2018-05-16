package ZzzAhu163.service;

import ZzzAhu163.AbstractTest;
import ZzzAhu163.base.ContactGroup.*;
import ZzzAhu163.base.user.User;
import ZzzAhu163.service.ContactGroup.ContactGroupService;
import ZzzAhu163.service.user.UserService;
import ZzzAhu163.utils.CommonUtils.SharedStringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
public class ContactGrpupServiceTest extends AbstractTest {
    @Resource
    private ContactGroupService contactGroupService;
    @Resource
    private UserService userService;

    @Test
    public void insertTest() {
        ContactGroup contactGroup = new ContactGroup();
        contactGroup.setName(SharedStringUtil.getRandomString());
        contactGroup.setDescription("第1个联系人组");
        User user = userService.queryUserByName("赵子彰");
        contactGroup.addUserToList(UserListType.TO_LIST, user);
        contactGroup.addUserToList(UserListType.CC_LIST, user);
        contactGroup.addUserToList(UserListType.BCC_LIST, user);
        boolean result = contactGroupService.insertContactGroup(contactGroup);
        log.info("插入结果：{}", result);
    }

    @Test
    public void queryTest() {
        ContactGroupQueryFilter filter = new ContactGroupQueryFilter();
        filter.setId(18);
        filter.setName("20180516_100643_3e2b4e82");
        List<ContactGroup> list = contactGroupService.queryContactGroupList(filter);
        if (CollectionUtils.isNotEmpty(list)) {
            log.info("查询结果： {}", list.get(0).formatForLog());
        } else {
            log.info("未查询到");
        }
    }

    @Test
    public void queryById() {
        int id = 18;
        ContactGroup contactGroup = contactGroupService.queryContactGroupById(id);
        if (contactGroup != null) {
            log.info("查询结果 : {}", contactGroup.formatForLog());
        } else {
            log.info("未查询到");
        }
    }

    @Test
    public void deleteTest() {
        int id = 17;
        boolean result = contactGroupService.deleteContactGroup(id);
        log.info("删除结果：{}", result);
    }

    @Test
    public void updateContactGroup() {
        int id = 18;
        ContactGroup contactGroup = contactGroupService.queryContactGroupById(id);
        log.info("更新之前:{}", contactGroup.formatForLog());
        User user = userService.queryUserByName("赵子彰2");
        contactGroup.addUserToList(UserListType.BCC_LIST, user);
        boolean result = contactGroupService.updateContactGroup(contactGroup);
        log.info("更新结果: {} , 更新之后: {}", result, contactGroup.formatForLog());
    }
}
