package ZzzAhu163.base.firstentity.BeanValidationLearning;


import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, GroupB.class, GroupA.class})
public interface OrderdGroup {
}
