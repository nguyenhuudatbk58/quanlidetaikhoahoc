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

import quanlidetaikhoahoc.Utils;
import quanlidetaikhoahoc.dao.NguoiDungDAO;
import quanlidetaikhoahoc.domain.NguoiDung;

@Service
public class AuthenticationProviderImpl implements AuthenticationProvider {

	@Autowired
	private NguoiDungDAO nguoiDungDAO;

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		NguoiDung nguoiDung = nguoiDungDAO.getByMaTacGia(authentication.getName());
		if (nguoiDung != null) {
			String matKhau = Utils.encryptMD5(nguoiDung.getToken(), authentication.getCredentials().toString());

			if (matKhau.equals(nguoiDung.getMatKhau())) {

				List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
				authorities.add(new SimpleGrantedAuthority("ROLE_"+nguoiDung.getRole().getValue()));
				return new UsernamePasswordAuthenticationToken(authentication.getName(), matKhau, authorities);
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
