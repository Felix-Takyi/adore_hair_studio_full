package com.adorehairstudio.api.security;
import jakarta.servlet.*; import jakarta.servlet.http.*; import org.springframework.security.authentication.UsernamePasswordAuthenticationToken; import org.springframework.security.core.context.SecurityContextHolder; import org.springframework.stereotype.Component; import org.springframework.web.filter.OncePerRequestFilter; import java.io.IOException; import java.util.List;
@Component
public class JwtFilter extends OncePerRequestFilter {
 private final JwtService jwt; public JwtFilter(JwtService jwt){this.jwt=jwt;}
 @Override protected void doFilterInternal(HttpServletRequest r,HttpServletResponse s,FilterChain c)throws ServletException,IOException{ String h=r.getHeader("Authorization"); if(h!=null&&h.startsWith("Bearer ")){String sub=jwt.subject(h.substring(7)); if(sub!=null) SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(sub,null,List.of()));} c.doFilter(r,s); }
}
