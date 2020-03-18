package com.bridgelabz.fundoonotesapi.utility;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenUtility {
//	protected static SecureRandom random = new SecureRandom();
//	public String generateToken(String email) {
//		 long longToken = Math.abs( random.nextLong() );
//         String random = Long.toString( longToken, 16 );
//         return ( email + ":" + random );
// }

	// Algorithm
	SignatureAlgorithm alorithm = SignatureAlgorithm.HS256;
	// secret Key used by Algorithm
	String secretKey = "ankit";

	// Generate the Token
	public String generateToken(String email) {
		return Jwts.builder().setId(email).setIssuedAt(new Date(System.currentTimeMillis()))
				.signWith(alorithm, secretKey).compact();
	}

	// To decode Token
	public String getToken(String token) {
		Claims claim = null;
		try {
			claim = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			System.out.println("INVALID TOKEN");
		}
		return claim.getId();
	}

}
