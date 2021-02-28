package com.catastima.authentification.service;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catastima.authentification.bean.Authentification;
import com.catastima.authentification.repository.AuthentificationRepository;
//import com.catastima.authentification.service.*;

@Service
@Transactional
public class AuthentificationService  implements ImplService<Authentification>  {
	 
		@Autowired
		private AuthentificationRepository authRepository;

		@Override
		public void delete(long elem_id) {
			// TODO Auto-generated method stub
			authRepository.deleteById(elem_id);
		}

		@Override
		public Authentification save(Authentification elem) {
			// TODO Auto-generated method stub
			elem.newToken();
			elem.newDate();
			return authRepository.save(elem);
		}

		@Override
		public boolean isPresent(Authentification ath) {
			// TODO Auto-generated method stub
			boolean to_return = false;
			int new_ath = authRepository.countnb(ath.getUsername(), ath.getPassword());
			if(new_ath == 1) {
				to_return = true;
			}
			System.out.println("new_ath: "+new_ath);
			return to_return;
		}
		
		@Override
		public boolean isConnected(Authentification ath) {
			// TODO Auto-generated method stub
			boolean to_return = false;
			
			Authentification new_ath = authRepository.findByUsername(ath.getUsername(), ath.getPassword());
			if(new_ath != null) {
				if( new_ath.isTimePassed()) {
					to_return = true;
				}
			}
			return to_return;
		}
		
		@Override
		public Authentification connect(Authentification ath) {
			// TODO Auto-generated method stub
			if(isPresent(ath)) {
			ath = authRepository.findByUsername(ath.getUsername(), ath.getPassword());
			ath.newAuth();
			authRepository.save(ath);
			}
			return ath;
		}
		
		@Override
		public void disconnect(Authentification ath) {
			ath.erraseToken();
			authRepository.save(ath);
		}
}