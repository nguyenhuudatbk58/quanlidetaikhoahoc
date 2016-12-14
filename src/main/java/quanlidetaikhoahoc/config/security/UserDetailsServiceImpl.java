package quanlidetaikhoahoc.config.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import quanlidetaikhoahoc.dao.NguoiDungDAO;
import quanlidetaikhoahoc.domain.NguoiDung;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private NguoiDungDAO nguoiDungDAO;

	public UserDetails loadUserByUsername(String tenTaiKhoan) throws UsernameNotFoundException {
		NguoiDung nguoiDung = nguoiDungDAO.getByMaTacGia(tenTaiKhoan);
		if(nguoiDung != null){
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(nguoiDung.getRole().getValue()));
			return new User(nguoiDung.getMaTacGia(), nguoiDung.getMatKhau(), authorities);
		}
		throw new UsernameNotFoundException("Không tìm thấy người dùng "+ tenTaiKhoan);
	}

}
