//package ZzzAhu163.test.BeanValidationTest;
//
//import ZzzAhu163.base.firstentity.BeanValidationLearning.*;
//import ZzzAhu163.test.AbstractTest;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.annotation.Order;
//
//import javax.validation.*;
//import java.util.Set;
//
///**
// * @author ZzzAhu163
// * **/
//@Slf4j
//public class BeanValidationTest extends AbstractTest{
//  //全局变量，validator
//  ValidationBean bean = new ValidationBean();
//  ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//  Validator validator = factory.getValidator();
//
//  public void BeanValidate(BeanNeedValidate bean) {
//    Set<ConstraintViolation<BeanNeedValidate>> set = validator.validate(bean);
//    for (ConstraintViolation<BeanNeedValidate> constraintViolation : set) {
//      log.error("违背约束：{}", constraintViolation.getMessage());
//    }
//  }
//
//  public void BeanValidateWithGroup(BeanNeedValidate bean, Class<?> group) {
//    Set<ConstraintViolation<BeanNeedValidate>> set = validator.validate(bean, group);
//    for (ConstraintViolation<BeanNeedValidate> constraintViolation : set) {
//      log.error("违背约束：{}", constraintViolation.getMessage());
//    }
//  }
//
//
//  /**1、验证器的基本使用方法**/
//  @Test
//  public void useTest() {
//    //使用validator对bean进行验证
//    Set<ConstraintViolation<ValidationBean>> set = validator.validate(bean);
//
//    //遍历是否有未被约束的message
//    for (ConstraintViolation<ValidationBean> constraintViolation : set) {
//      log.error("注解：{} 违背约束：{}", constraintViolation.getConstraintDescriptor().getAnnotation(), constraintViolation.getMessage());
//    }
//  }
//
//  /**2、多个注解约束同一个属性**/
//  @Test
//  public void multiAnnotation() {
//    ValidationBean bean = new ValidationBean();
//    //设置NotNull的属性，不验证他
//    bean.setNotNUll("NotNUll");
//    //不填充Email，验证@NotNull
//    BeanValidate(bean);
//    //设置Email，验证@Email
//    bean.setEmail("aaa");
//    BeanValidate(bean);
//  }
//
//  /**3、自定义注解和验证器
//   * 我们除了可以使用BeanValidation(JSR-303)和Hibernate提供的默认注解外，
//   * 我们同样可以实现自己的注解和注解相关的验证器
//   * **/
//  @Test
//  public void myConstraintAnnotation() {
//    StringNotEmptyBean bean = new StringNotEmptyBean();
//    BeanValidate(bean);
//  }
//
//  /**4、自定义注解不只可以使用自定义验证器，也可以使用现有的进行功能组合**/
//  @Test
//  public void NotNullButEmailTest() {
//    NotNullButEmailBean bean = new NotNullButEmailBean();
//    BeanValidate(bean);
//  }
//
//  /**5、多值约束：假如我们自定义了一个检测是否包含指定子字符串的注解，
//   * 但是对于一个属性，我们想同时检测两个，这个时候就需要多值约束来解决我们的问题了
//   * **/
//  @Test
//  public void MultipartValueTest() {
//    MultipartValueBean bean = new MultipartValueBean();
//    BeanValidate(bean);
//  }
//
//  /**6、分组约束：之前的约束检测，我们不难发现，Validator.validate会检测目标bean
//   * 所有的含有约束注解的属性，但是有的时候我们只想检测某些属性呢，就需要用到分组了**/
//  @Test
//  public void divideGroupTest() {
//    DivideGroupBean bean = new DivideGroupBean();
//    BeanValidate(bean); //不显示指定分组，默认使用的是Default分组
//    BeanValidateWithGroup(bean, GroupA.class); //使用GroupA分组
//    BeanValidateWithGroup(bean, GroupB.class); //使用GroupB分组
//  }
//
//  /**
//   * 7、本着程序员的懒惰天性，加入有一天，期望有一个验证器可以检测所有分组（其实也就是默认）的约束的同时，
//   * 还能保持分组约束的功能，真的是Fuck，还好隐式分组帮我们解决了这个问题，还是依靠接口来帮我们进行分组
//   * 而且约束需要加到get方法上，而不是直接加到属性上了
//   * **/
//  @Test
//  public void UnTypedDivideGroupTest() {
//    UntypedDivideGroupBean bean = new UntypedDivideGroupBean();
//    BeanValidate(bean); //会检测所有的注解约束
//    BeanValidateWithGroup(bean, GroupA.class); //只会检测继承GroupA中get方法的分组的约束
//    BeanValidateWithGroup(bean, GroupB.class); //只会检测继承GroupB中get方法的分组的约束
//  }
//
//  /**
//   * 8、级联约束检测，比如A中有个类型B的对象，则在Validator.validate(A())时，
//   * 默认是不会检测B的约束的。除非给B加上@valid注解
//   * **/
//  @Test
//  public void cascadeValidateTest() {
//    CascadeBean bean = new CascadeBean();
//    BeanValidate(bean);
//  }
//
//  /**
//   * 9、sb程序员又想按照某种特定顺序执行Validate了
//   * 当然依然有办法，BeanValidation给我们提供了组序列
//   * 这要靠接口加上@GroupSequence注解来实现
//   * 当序列中的某一个验证出错时，后面就不会再继续进行
//   * 可以说是肥肠好用了
//   *  **/
//  @Test
//  public void GroupSequenceTest() {
//    DivideGroupBean bean = new DivideGroupBean();
//    BeanValidateWithGroup(bean, OrderdGroup.class);
//    bean.setGroupDefault("Default");
//    BeanValidateWithGroup(bean, OrderdGroup.class);
//    bean.setGroupB("GroupB");
//    BeanValidateWithGroup(bean, OrderdGroup.class);
//  }
//
//}
