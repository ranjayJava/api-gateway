package com.org.service;

import com.org.model.User;

public interface AuthenticationService {
	User signInAndReturnJWT(User signInRequest);
}
