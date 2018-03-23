package ZzzAhu163.base.user;

import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Alias("MyUserDetails")
@ToString
public class MyUserDetails implements UserDetails {
    private User user;

    // <? extends E> 上限通配符，泛型中元素只能是GrantedAuthority的子类或者它本身
    public MyUserDetails(User user, Collection<? extends  GrantedAuthority> authorities) {
      this.user = user;
      this.authorities = authorities;
    }

    private Collection<? extends  GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    /*********下面函数不用关心*********/
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
