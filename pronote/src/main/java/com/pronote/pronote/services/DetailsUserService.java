package com.pronote.pronote.services;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import com.pronote.pronote.model.dto.DetailsUser;
import com.pronote.pronote.model.entity.User;
import com.pronote.pronote.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetailsUserService implements UserDetailsService {
	
	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username)
		throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));
		return new DetailsUser(user);
		
	}

}
