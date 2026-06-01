package com.msedcl.main.customer.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component("auditAwareImpl")
public class AuditAware implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		//return Optional.empty();
		
		//Fetch currentlylogged-in user and set vlaue
		return Optional.of("CUSTOMER-MS");
		
	}
	
}
