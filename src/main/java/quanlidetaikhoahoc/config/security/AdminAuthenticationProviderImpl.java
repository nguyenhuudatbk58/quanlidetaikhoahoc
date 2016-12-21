package quanlidetaikhoahoc.config.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import quanlidetaikhoahoc.dao.AdminDAO;
import quanlidetaikhoahoc.domain.Admin;

@Service(value = "adminAuthenticationProvider")
public class AdminAuthenticationProviderImpl implements AuthenticationProvider {

	@Autowired
	private AdminDAO adminDAO;

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		Admin admin = adminDAO.getByUsername(authentication.getName());
		if (admin != null) {
			String matKhau = authentication.getCredentials().toString();

			if (matKhau.equals(admin.getMatKhau())) {

				List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
				authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
				admin.setMatKhau(null);
				return new UsernamePasswordAuthenticationToken(admin, matKhau, authorities);
			} else {
				throw new BadCredentialsException("Sai thông tin tài khoản");
			}
		}
		throw new BadCredentialsException("Không tìm thấy người dùng: " + authentication.getName());

	}

	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}