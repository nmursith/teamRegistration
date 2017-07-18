package com.virtusa.teamvirtusa.utils;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContextUtils {
	
	static final String ROLE_ADMIN = "ROLE_ADMIN";
	
/*	@Autowired
	private IPartyLoginRoleRepository partyLoginRoleRepository;
	
	@Autowired
	private IPartyLoginRepository partyLoginRepository;
	
	public boolean isAdmin(String username){
		List<PartyLoginRole> partyLoginRoles = partyLoginRoleRepository.findByPartyLoginUsername(username);
		for (PartyLoginRole partyLoginRole : partyLoginRoles) {
			String roleName = partyLoginRole.getRole().getRoleName();
			if (roleName.equals(ROLE_ADMIN)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isAdmin(){
		return isAdmin(getPartyLoginUsername());
	}
	
	public int getPartyId(){
        PartyLogin partyLogin = partyLoginRepository.findByUsername(getPartyLoginUsername());
		return partyLogin.getParty().getPartyId();
	}
	
	public int getPartyId(String partyLoginUsername){
        PartyLogin partyLogin = partyLoginRepository.findByUsername(partyLoginUsername);
		return partyLogin.getParty().getPartyId();
	}
	
	public String getPartyLoginUsername(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}

	public Party getParty(){
		PartyLogin partyLogin = partyLoginRepository.findByUsername(getPartyLoginUsername());
		return partyLogin.getParty();
	}
	*/
	
}
