package com.beit_and_pear.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// パスワードの暗号化
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// セキュリティの対象外を設定
	@Override
	public void configure(WebSecurity web) throws Exception {
		// セキュリティを適用しない
		web.ignoring().antMatchers("/webjars/**").antMatchers("/css/**").antMatchers("/js/**")
				.antMatchers("/h2-console/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// ログイン不要ページの設定
		http.authorizeRequests().antMatchers("/login").permitAll() // 直リンクOK
				.antMatchers("/user/signup").permitAll() // 直リンクOK
				.anyRequest().authenticated(); // それ以外はNG

		// ログイン処理
		http.formLogin().loginProcessingUrl("/login") // ログイン処理パス
				.loginPage("/login") // ログインページの指定
				.failureUrl("/login?error") // ログイン失敗時の遷移先
				.usernameParameter("userId") // ログインページのユーザーID
				.passwordParameter("password") // ログインページのパスワード
				.defaultSuccessUrl("/list", true); // 成功時の遷移先

		// CSRF対策を向こうに設定（一時的）
		http.csrf().disable();

		// rememberMeの設定を忘れずに
	}

	// 認証の設定
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		PasswordEncoder encoder = passwordEncoder();
		// インメモリ認証
		auth.inMemoryAuthentication().withUser("user") // userを追加
				.password(encoder.encode("user")).roles("GEMERAL").and().withUser("admin") // adminを追加
				.password(encoder.encode("admin")).roles("ADMIN");
	}

}
